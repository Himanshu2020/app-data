package musipo.service;

import musipo.constant.RestEnum;
import musipo.dao.ChatDao;
import musipo.model.ChatRoom;
import musipo.model.Messages;
import musipo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by G510 on 26-03-2017.
 */
@Service
public class ChatService {

    @Autowired
    ChatDao chatDao;
    Map map;

    public Map getChatRooms(String userID) {
        map = new HashMap();
        List<ChatRoom> chatRooms = chatDao.getChatRooms(userID);
        if (chatRooms.size() > 0) {
            map.put(RestEnum.MESSAGE, "Chat rooms found.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.DATA, chatRooms);
        } else {
            map.put(RestEnum.MESSAGE, "Chat rooms not found");
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map getChatMessages(String userID) {
        map = new HashMap();
        List<Messages> messages = chatDao.getChatMessages(userID);
        if (messages.size() > 0) {
            map.put(RestEnum.MESSAGE, "User chat messsges  found.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.DATA, messages);
        } else {
            map.put(RestEnum.MESSAGE, "User chat messages not found");
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map createChatRoom(String chatName) {
        map = new HashMap();

        ChatRoom chatRoom = new ChatRoom(chatName);

        chatRoom = chatDao.createChatRoom(chatRoom);
        if (chatRoom.getId()!=null) {
            map.put(RestEnum.MESSAGE, "Char room created.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.DATA, chatRoom);
        } else {
            map.put(RestEnum.MESSAGE, "User chat messages not found");
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;

    }

    public Map createChatRoom(ChatRoom chatRoom) {
        map = new HashMap();
        // create the paise of chat rooms users
        chatRoom.setChatRoomUser(chatRoom.getUserId()+"||"+chatRoom.getAssociatedUserId());

        chatRoom = chatDao.createChatRoom(chatRoom);
        if (chatRoom.getId()!=null) {
            map.put(RestEnum.MESSAGE, "Char room created.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.DATA, chatRoom);
        } else {
            map.put(RestEnum.MESSAGE, "User chat messages not found");
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;

    }
}
