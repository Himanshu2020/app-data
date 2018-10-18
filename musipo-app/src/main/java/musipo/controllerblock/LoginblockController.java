package musipo.controllerblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import musipo.modelobj.User;
import musipo.service.ChatService;
import musipo.serviceblock.loginBlockService;

@Controller
public class LoginblockController {

	@Autowired
	loginBlockService lbs;

	@RequestMapping("/loginblock")
	@ResponseBody
	public User login(@RequestParam String username,@RequestParam String password) {
		// TODO Auto-generated method stub

		User user1 = lbs.loginUser(username,password);

		System.out.println(user1);

		return user1;
	}

}
