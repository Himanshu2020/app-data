package musipo.service;

import musipo.constant.RestEnum;
import musipo.dao.UserDao;
import musipo.model.LastSeen;
import musipo.model.Otp;
import musipo.model.Status;
import musipo.model.User;
import musipo.utils.Utils;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by G510 on 25-03-2017.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    private String error;

    public Map login(User user) {

        HashMap map = new HashMap();
        User userObj = userDao.getByMobile(user.getMobile());
        if (userObj == null) {
            try {
                userDao.create(user);

                LastSeen lastSeen = new LastSeen();
                lastSeen.setUserId(user.getId());
                lastSeen.setSeenAt(Utils.getFromateDate(new Date()));
                userDao.createLastSeen(lastSeen);

                Status status = new Status();
                status.setStatusMsg("I am using musicPo");
                status.setUserId(user.getId());
                status =  userDao.createStatus(status);

                map.put(RestEnum.MESSAGE, "User created successfully.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put("DATA",user);

                JSONObject info = new JSONObject();
                info.put("title", user.getMobile()); // Notification title
                info.put("body", "Hi " + user.getName() + " You have register successfully"); // Notification body

               // PushNotification.pushFCMNotification(user.getGcmRegistrationId(), info);

            } catch (Exception ex) {
                error = "Error creating the user: " + ex.toString();
                map.put(RestEnum.ERROR, error);
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }
        } else {
             userObj.setFcmId(user.getFcmId());
            //userObj.setGcmRegistrationId("264234f2342dsr34r5tqqterhyj");
            if (userDao.updateFcm(userObj)) {
                map.put(RestEnum.MESSAGE, "GCM registration ID updated successfully");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put("DATA",userObj);
            } else {
                map.put(RestEnum.MESSAGE, "GCM registration ID not updated .");
                map.put(RestEnum.STATUS, RestEnum.FALSE);

            }
        }
        return map;
    }

    public Map delete(User user) {

        HashMap map = new HashMap();
        try {
            userDao.delete(user);
            map.put(RestEnum.MESSAGE, "User deleted successfully.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.DATA, RestEnum.TRUE);
        } catch (Exception ex) {
            error = "Error deleteing the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map update(User user) {
        HashMap map = new HashMap();
        try {
            userDao.update(user);
            map.put(RestEnum.MESSAGE, user.getId() + "User updated successfully.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map login(String username, String password) {

        HashMap map = new HashMap();
        User user = userDao.login(username, password);
        if (user != null) {
            map.put(RestEnum.MESSAGE, "User found.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put("user", user);
        } else {
            map.put(RestEnum.MESSAGE, "User not found.");
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map updateFcm(User user) {
        HashMap map = new HashMap();
        System.out.print(user);
        try {
            if (userDao.updateFcm(user)) {
                map.put(RestEnum.MESSAGE, user.getId() + "User updated successfully.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put(RestEnum.DATA, user);
            } else {
                map.put(RestEnum.MESSAGE, user.getId() + "User not updated.");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }
        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map updateProfilePic(User user) {
        HashMap map = new HashMap();
        try {
            if (userDao.updateProfilePic(user)) {
                map.put(RestEnum.MESSAGE, user.getId() + "ProfilePic updated successfully.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
            } else {
                map.put(RestEnum.MESSAGE, user.getId() + "ProfilePic not updated.");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }
        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }


    public Map validateMobile(String mobileNo) {
        HashMap map = new HashMap();

        Otp otp = new Otp(mobileNo, Utils.getOtpNumber(5));
        otp= userDao.createOTP(otp);
        try {
            map.put(RestEnum.MESSAGE, "OTP Create successfully.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.DATA, otp);

        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map validateOtp(String mobileNo) {
        HashMap map = new HashMap();

        try {
            map.put(RestEnum.MESSAGE, "OTP Create successfully.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.STATUS, RestEnum.TRUE);


        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map getUserbyid(String id) {

        HashMap map = new HashMap();
        User user =userDao.getByUserID(id);

        if(user!=null){
            map.put(RestEnum.MESSAGE, "User found.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.DATA, user);
        }else{
            map.put(RestEnum.MESSAGE, "User not found");
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map getUserList(String id) {

        HashMap map = new HashMap();
        List<User> userList =userDao.getAll();

        if(userList!=null){
            map.put(RestEnum.MESSAGE, "User found.");
            map.put(RestEnum.STATUS, RestEnum.TRUE);
            map.put(RestEnum.DATA, userList);
        }else{
            map.put(RestEnum.MESSAGE, "User not found");
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map updateLastSeen(String userID, String lastSeen) {
        HashMap map = new HashMap();
        try {
            if (userDao.updateLastSeen(userID,lastSeen)) {
                map.put(RestEnum.MESSAGE, userID + "updateLastSeen updated successfully.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
            } else {
                map.put(RestEnum.MESSAGE, userID + "updateLastSeen not updated.");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }
        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map getLastSeen(String userID) {

        HashMap map = new HashMap();
        try {
            LastSeen lastSeen = userDao.getUserLastSeen(userID);

            if(lastSeen!=null){
                map.put(RestEnum.MESSAGE, "LastSeen found.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put(RestEnum.DATA, lastSeen);
            }else{
                map.put(RestEnum.MESSAGE, "LastSeen not found");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }

        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map updateUserName(User user) {
        HashMap map = new HashMap();
        try {
            if (userDao.updateUserName(user)) {
                map.put(RestEnum.MESSAGE, user.getId() + "UserName updated successfully.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put(RestEnum.DATA, user);
            } else {
                map.put(RestEnum.MESSAGE, user.getId() + "UserName not updated.");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }
        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }
}
