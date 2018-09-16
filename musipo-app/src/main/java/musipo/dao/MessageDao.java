package musipo.dao;

import musipo.model.Messages;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by G510 on 26-03-2017.
 */
@Repository
@Transactional
public class MessageDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Messages sendMessage(Messages messages) {
        entityManager.persist(messages);
        return messages;
    }
    public void sendMessageToMultiUser(Messages messages) {

    }
}
