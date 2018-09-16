package musipo.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import musipo.model.LastSeen;
import musipo.model.User;
import musipo.service.UserService;
import musipo.utils.PushNotification;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by G510 on 25-03-2017.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private User user;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public Map login(@RequestParam String rest_data) {
        logger.debug(rest_data.toString());
        System.out.println(rest_data);
/*
        JSONObject info = new JSONObject();
        info.put("title", user.getMobileNo()); // Notification title
        info.put("body", "Hi " + user.getName() + " You have register successfully"); // Notification body

        try {
            PushNotification.pushFCMNotification(user.getGcmRegistrationId(), info);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(rest_data, new TypeToken<Map<String, Object>>(){}.getType());
        User user = new User();
        user.setName(map.get("name").toString());
        user.setMobile(map.get("mobile_no").toString());
        return userService.login(user);

    }

    @RequestMapping(value = "/updatefcm", method = RequestMethod.GET, produces = "application/json")
    public Map updatefcm(@RequestParam String userID,@RequestParam String fcmRegistrationID) {
        return userService.updateFcm(new User(userID,fcmRegistrationID));
    }

    @RequestMapping(value = "/updateProfilepic", method = RequestMethod.POST, produces = "application/json")
    public Map updateProfilePic(@RequestParam String userID,@RequestParam String profilePic) {
        User user= new User();
        user.setId(userID);
        user.setProfilePic(profilePic);
        logger.debug(user.toString());
        return userService.updateProfilePic(user);
    }

    @RequestMapping(value = "/updatelastseen", method = RequestMethod.GET, produces = "application/json")
    public Map updateLastSeen(@RequestParam String userID,@RequestParam String lastSeen) {
        return userService.updateLastSeen(userID, lastSeen);
    }

    @RequestMapping(value = "/getlastseen", method = RequestMethod.GET, produces = "application/json")
    public Map getLastSeen(@RequestParam String userID) {
        return userService.getLastSeen(userID);
    }

    @RequestMapping(value = "/verifymobile", method = RequestMethod.GET, produces = "application/json")
    public Map validatemobile(@RequestParam String rest_data) {
        System.out.println(rest_data);
         Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(rest_data, new TypeToken<Map<String, Object>>(){}.getType());
        return userService.validateMobile(map.get("mobile_no").toString());
    }

    @RequestMapping(value = "/validateotp", method = RequestMethod.GET, produces = "application/json")
    public Map validateOtp(@RequestParam String otp) {
        return userService.validateOtp(otp);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = "application/json")
    public Map getUserByID(@RequestParam String userID) {
        return userService.getUserbyid(userID);
    }


    @RequestMapping(value = "/getUserList", method = RequestMethod.GET, produces = "application/json")
    public Map getUserList(@RequestParam String userID) {
        return userService.getUserList(userID);
    }

    @RequestMapping(value = "/updateName", method = RequestMethod.GET, produces = "application/json")
    public Map updateUserName(@RequestParam String userID,@RequestParam String name) {
        user= new User();
        user.setId(userID);
        user.setName(name);
        return userService.updateUserName(user);
    }
}
