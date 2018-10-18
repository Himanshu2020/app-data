package musipo.daoblock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import musipo.modelobj.Product;
import musipo.modelobj.User;

@Repository
@Transactional
public class ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;

	

	public List<Product> getAllProduct() {

		/*User user = new User();

		user.setUsername("himasnhu");
		user.setEmail("himanshu.b@gmail.com");
		user.setName("hiamhu");
		user.setPassword("12345");
		create(user);*/

		return entityManager.createQuery("from User").getResultList();

	}
    public Product createproduct(Product product) {
    	 entityManager.persist(product);
		return product;
    }
}
