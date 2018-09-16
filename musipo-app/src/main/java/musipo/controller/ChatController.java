package musipo.controller;

import musipo.model.ChatRoom;
import musipo.model.User;
import musipo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by G510 on 26-03-2017.
 */


@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService chatService;


    /* * *
 * fetching all chat rooms for perticukar user.
 */
    @RequestMapping(value = "/findUserChatrooms", method = RequestMethod.GET, produces = "application/json")
    public Map getChatRooms(@RequestParam String userID) {
        return chatService.getChatRooms(userID);

    }
    @RequestMapping(value = "/findUserChatMsg", method = RequestMethod.GET, produces = "application/json")
    public Map getChatUserCharMsg(@RequestParam String userID) {
        return chatService.getChatMessages(userID);
    }

    @RequestMapping(value = "/createChatRoom", method = RequestMethod.GET, produces = "application/json")
    public Map createChatRoom(@RequestParam String name,@RequestParam String userID,@RequestParam String associatedUserId) {
        ChatRoom chatRoom =  new ChatRoom();
        chatRoom.setName(name);
        chatRoom.setUserId(userID);
        chatRoom.setAssociatedUserId(associatedUserId);
        return chatService.createChatRoom(chatRoom);
    }
}
