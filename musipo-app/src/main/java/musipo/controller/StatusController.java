package musipo.controller;

import musipo.model.PlayingStatus;
import musipo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by G510 on 31-03-2017.
 */

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusService statusService;

    @RequestMapping(value = "/getUserStatus", method = RequestMethod.GET, produces = "application/json")
    public Map getUserStatus(@RequestParam String userID) {
        return statusService.getUserStatus(userID);

    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.GET, produces = "application/json")
    public Map updateStatus(@RequestParam String userID, @RequestParam String status) {
        return statusService.updateStatus(userID, status);
    }

    @RequestMapping(value = "/createStatus", method = RequestMethod.GET, produces = "application/json")
    public Map createStatus(@RequestParam String userID, @RequestParam String message) {
        return statusService.createStatus(userID);
    }

    @RequestMapping(value = "/updatePlayingStatus", method = RequestMethod.GET, produces = "application/json")
    public Map updatePlayingStatus(@RequestParam String userID,
                                   @RequestParam String playingSrc,
                                   @RequestParam String playingInfo,
                                   @RequestParam String status) {

        PlayingStatus playingStatus = new PlayingStatus();

        playingStatus.setUserId(userID);
        playingStatus.setStatus(status);
        playingStatus.setPlayingSrc(playingSrc);
        playingStatus.setPlayingInfo(playingInfo);

        return statusService.updatePlayingStatus(playingStatus);
    }
    @RequestMapping(value = "/getPlayingStatus", method = RequestMethod.GET, produces = "application/json")
    public Map getUserPlayingStatus(@RequestParam String userID) {
        return statusService.getUserPlayingStatus(userID);

    }



}
