package musipo.dao;


import musipo.model.LastSeen;
import musipo.model.Otp;
import musipo.model.Status;
import musipo.model.User;
import musipo.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * This class is used to access data for the User netgloo.entity.
 * Repository annotation allows the component scanning support to find and
 * configure the DAO wihtout any XML configuration and also provide the Spring
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UserDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * Save the user in the database.
     */
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    /**
     * Delete the user from the database.
     */
    public void delete(User user) {
        if (entityManager.contains(user))
            entityManager.remove(user);
        else
            entityManager.remove(entityManager.merge(user));
        return;
    }

    /**
     * Return all the users stored in the database.
     */
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    /**
     * Return the user having the passed email.
     */
    public User getByEmail(String email) {
        return (User) entityManager.createQuery(
                "from User where email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

   /* public User getByMobile(String mobile) {
        return (User) entityManager.createQuery(
                "from User where mobile = :mobile")
                .setParameter("mobile", mobile)
                .getSingleResult();
    }*/

    public User getByMobile(String mobile) {

        String select = "FROM User WHERE  mobile=:mobile";

        Query query = entityManager.createQuery(select);
        query.setParameter("mobile", mobile);

        User user = null;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException nre) {

        }
        return user;
    }

    public User getByUserID(String id) {

        String select = "FROM User WHERE  id=:id";

        Query query = entityManager.createQuery(select);
        query.setParameter("id", id);

        User user = null;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException nre) {

        }
        return user;
    }


    /**
     * Return the user having the passed id.
     */
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Update the passed user in the database.
     */
    public void update(User user) {
        entityManager.merge(user);
        return;

    }

    public void validateMobile(User user) {
        entityManager.persist(user);
        return;

    }
    public boolean updateFcm(User user) {

        Query query = entityManager.createNativeQuery("UPDATE users SET fcm_id=:fcm_id WHERE user_id =:id");
        query.setParameter("fcm_id", user.getFcmId());
        query.setParameter("id", user.getId());
        try {
            if (query.executeUpdate() == 1) {
                logger.info(user.getId()+ "::FCM registration ID updated successfully");
                return true;
            } else {
                logger.error("gcm not updated ");
            }
        } catch (NoResultException nre) {

        }
        return false;
    }

    public boolean updateLastSeen(String userID, String lastSeen) {

        Query query = entityManager.createNativeQuery("UPDATE last_seen SET updated_date=:last_seen , seen_at=:seet_at WHERE user_id =:id");
        //  query.setParameter("gcm_registration_id", user.getGcmRegistrationId());
        query.setParameter("id", userID);
        query.setParameter("last_seen", Utils.getFromateDate(new Date()));
        query.setParameter("seet_at", Utils.getFromateDate(new Date()));
        try {
            if (query.executeUpdate() == 1) {
                logger.info(userID+ "::last seen updated successfully");
                return true;
            } else {
                logger.error("last seen not updated "+lastSeen);
            }
        } catch (NoResultException nre) {

        }
        return false;
    }

    public boolean updateProfilePic(User user) {

        Query query = entityManager.createNativeQuery("UPDATE users SET profile_pic=:profile_pic WHERE user_id =:id");
        query.setParameter("profile_pic", user.getProfilePic());
        query.setParameter("id", user.getId());

        try {
            if (query.executeUpdate() == 1) {
                logger.info(user.getId()+ "::Profile pic updated successfully");
                return true;
            } else {
                logger.error("Profile not updated ");
            }
        } catch (NoResultException nre) {

        }
        return false;

    }


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

    public Otp createOTP(Otp otp) {
        entityManager.persist(otp);
        return otp;
    }

    public LastSeen createLastSeen(LastSeen lastSeen) {
        entityManager.persist(lastSeen);
        return lastSeen;
    }

    public Status createStatus(Status status) {
        entityManager.persist(status);
        return status;
    }

    public LastSeen getUserLastSeen(String id) {

        String select = "FROM LastSeen WHERE  user_id=:id";
        Query query = entityManager.createQuery(select);
        query.setParameter("id", id);
        LastSeen lastSeen = null;

        try {
            lastSeen = (LastSeen) query.getSingleResult();
        } catch (NoResultException nre) {

        }
        return lastSeen;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;


    public boolean updateUserName(User user) {
        Query query = entityManager.createNativeQuery("UPDATE users SET name=:name WHERE user_id =:id");
        query.setParameter("name", user.getName());
        query.setParameter("id", user.getId());

        try {
            if (query.executeUpdate() == 1) {
                logger.info(user.getId()+ "::user name updated successfully");
                return true;
            } else {
                logger.error("user name not updated ");
            }
        } catch (NoResultException nre) {

        }
        return false;
    }
} // class UserDao
