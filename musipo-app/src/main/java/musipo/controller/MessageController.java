package musipo.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import musipo.model.Messages;
import musipo.model.User;
import musipo.service.ChatService;
import musipo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by G510 on 26-03-2017.
 */


@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Sending push notification to a single user
     * We use user's gcm registration id to send the message
     * *
     */
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces = "application/json")
    public Map sendMessage(@RequestParam String receiverUserID,@RequestParam String senderUserID, @RequestParam String message, @RequestParam String chatRoomID, @RequestParam String syncID) {

        Messages messages = new Messages();
        messages.setChatRoomId(chatRoomID);
        messages.setMessage(message);
        messages.setUserId(receiverUserID);
        messages.setSyncId(syncID);
        System.out.print("senderUserID"+senderUserID);
        System.out.print("receiverUserID"+receiverUserID);

        return messageService.sendMessage(messages,senderUserID,receiverUserID);

       // return  null;
    }

    @RequestMapping(value = "/sendMessageMultiUser", method = RequestMethod.POST, produces = "application/json")
    public Map sendMessageToMultiUser(@RequestHeader String userID, @RequestHeader String message) {
        Messages messages = new Messages();
        messages.setId(userID);
        messages.setMessage(message);

        return messageService.sendMessageToMultiUser(messages);
    }


}
