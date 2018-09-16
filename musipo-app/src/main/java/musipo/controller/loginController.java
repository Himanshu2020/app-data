package musipo.controller;

import musipo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by G510 on 01-09-2017.
 */


@RestController
@RequestMapping("/login")
public class loginController {


    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/crateSession", method = RequestMethod.GET, produces = "application/json")
    public Map getUserPlayingStatus(@RequestParam String userID) {
        return loginService.createLoginSession(userID);
    }
}
