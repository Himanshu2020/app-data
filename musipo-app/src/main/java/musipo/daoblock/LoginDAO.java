package musipo.daoblock;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import musipo.modelobj.User;

@Repository
@Transactional
public class LoginDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	

	public User login(String username, String password) {
		String select = "FROM User WHERE email=:userName or mobile=:userName and password=:passWord";

		Query query = entityManager.createQuery(select);
		query.setParameter("userName", username);
		query.setParameter("passWord", password);

		User user = null;
		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException nre) {

		}
		return user;
	}
}
