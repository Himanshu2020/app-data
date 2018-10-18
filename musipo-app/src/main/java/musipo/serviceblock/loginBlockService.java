package musipo.serviceblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musipo.daoblock.LoginDAO;
import musipo.modelobj.User;

@Service
public class loginBlockService {

	@Autowired
	LoginDAO dao;
	
	
	public User loginUser(String username,String password) {

		User user1 =dao.login(username, password);
		return user1;
		
		
	}
	
	
}
