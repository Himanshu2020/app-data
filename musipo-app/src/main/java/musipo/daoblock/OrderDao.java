package musipo.daoblock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import musipo.modelobj.orders;

@Repository
@Transactional
public class OrderDao {
	@PersistenceContext
	private EntityManager entityManager;

	public List<orders> getAll() {
		return entityManager.createQuery("from User").getResultList();

	}

	public orders createorder(orders order) {
		entityManager.persist(order);
		return order;

	}

}
