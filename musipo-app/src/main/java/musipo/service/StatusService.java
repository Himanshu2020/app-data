package musipo.service;

import musipo.constant.RestEnum;
import musipo.dao.StatusDao;
import musipo.model.LastSeen;
import musipo.model.PlayingStatus;
import musipo.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by G510 on 31-03-2017.
 */

@Service
public class StatusService {
    @Autowired
    StatusDao statusDao;
    private String error;
    private HashMap map;

    public Map getUserStatus(String userID) {

        HashMap map = new HashMap();
        try {
            Status status = statusDao.getUserStatus(userID);

            if (status != null) {
                map.put(RestEnum.MESSAGE, "status found.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put(RestEnum.DATA, status);
            } else {
                map.put(RestEnum.MESSAGE, "status not found");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }

        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

        public Map updateStatus(String userID, String message) {
        map = new HashMap();
        try {
            if (statusDao.updateStatus(userID, message)) {
                map.put(RestEnum.MESSAGE, "User status updated successfully.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put(RestEnum.DATA, userID);
            } else {
                map.put(RestEnum.MESSAGE, userID + "User status not updated.");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }
        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map createStatus(String userID) {
        statusDao.createStatus(userID);
        return null;
    }

    public Map updatePlayingStatus(PlayingStatus playingStatus) {
        map = new HashMap();
        PlayingStatus playObj = statusDao.updatePlayingStatus(playingStatus);
        try {
            if (playObj!=null) {
                map.put(RestEnum.MESSAGE, "Playing status updated successfully.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put(RestEnum.DATA, playObj);
            } else {
                map.put(RestEnum.MESSAGE, playingStatus + "User status not updated.");
                map.put(RestEnum.STATUS, RestEnum.FALSE);
            }
        } catch (Exception ex) {
            error = "Error updating the user: " + ex.toString();
            map.put(RestEnum.ERROR, error);
            map.put(RestEnum.STATUS, RestEnum.FALSE);
        }
        return map;
    }

    public Map getUserPlayingStatus(String userID) {

        HashMap map = new HashMap();
        try {
            PlayingStatus status = statusDao.getUserPlayingStatus(userID);

            if (status != null) {
                map.put(RestEnum.MESSAGE, "Playing status found.");
                map.put(RestEnum.STATUS, RestEnum.TRUE);
                map.put(RestEnum.DATA, status);
            } else {
                map.put(RestEnum.MESSAGE, "Playing status not found");
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
