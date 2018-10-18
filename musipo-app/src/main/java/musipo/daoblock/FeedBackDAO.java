package musipo.daoblock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import musipo.modelobj.Feedback;

@Repository
@Transactional
public class FeedBackDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Feedback> getAllFeedback() {
		return entityManager.createQuery("from User").getResultList();

	}
	

}
