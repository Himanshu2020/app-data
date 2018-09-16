package musipo.service;

import musipo.constant.Constant;
import musipo.constant.Params;
import musipo.constant.RestEnum;
import musipo.dao.MessageDao;
import musipo.dao.UserDao;
import musipo.model.Messages;
import musipo.model.User;
import musipo.utils.PushNotification;
import musipo.utils.Utils;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by G510 on 26-03-2017.
 */
@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;

    @Autowired
    UserDao userDao;

    HashMap map;
    private String error;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Map sendMessage(Messages messages, String senderUserID,String receiverUserID) {

        //  JSONObject jsonPayload = new JSONObject();

        HashMap jsonPayload = new HashMap();


        User senderUser = userDao.getByUserID(senderUserID);
        User receiverUser = userDao.getByUserID(receiverUserID);

        messages = messageDao.sendMessage(messages);
        jsonPayload.put("chat_room_id", messages.getChatRoomId());
        jsonPayload.put("message", messages.getMessage());
        jsonPayload.put("sync_id", messages.getSyncId());
        jsonPayload.put("message_id", messages.getId());
        jsonPayload.put("created_at", Utils.getFromateDate(messages.getCreated()));
        jsonPayload.put("sender_user", senderUser);
        jsonPayload.put("receiver_user", receiverUser);

        //  JSONObject jsonObject = new JSONObject();
        HashMap jsonObject = new HashMap();
        jsonObject.put("title", "sendMessage");
        jsonObject.put("message", "Message sent");
        jsonObject.put("isBackground", "true");
        jsonObject.put("payload", jsonPayload);
        jsonObject.put("image", null);
        jsonObject.put("timestamp", "sendMessage");
        jsonObject.put(Params.FLAG.toString(), Constant.PUSH_TYPE_USER);

        try {
            PushNotification.pushFCMNotification(receiverUser.getFcmId(), jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map = new HashMap();

        try {
            if (messages.getId() != null) {

                map.put(RestEnum.MESSAGE, "message store and send.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put(RestEnum.DATA, jsonPayload);
            } else {
                map.put(RestEnum.MESSAGE, "message not store and send.");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }
        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map sendMessageToMultiUser(Messages messages) {
        messageDao.sendMessageToMultiUser(messages);
        return null;
    }
}
