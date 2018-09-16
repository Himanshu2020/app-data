package musipo.dao;

import musipo.model.LastSeen;
import musipo.model.Otp;
import musipo.model.PlayingStatus;
import musipo.model.Status;
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

/**
 * Created by G510 on 31-03-2017.
 */

@Repository
@Transactional
public class StatusDao {
    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean updateStatus(String userID, String message) {
        Query query = entityManager.createNativeQuery("UPDATE Status SET status_msg=:status_msg WHERE user_id =:id");
        //  query.setParameter("gcm_registration_id", user.getGcmRegistrationId());
        query.setParameter("id", userID);
        query.setParameter("status_msg", message);
        try {
            if (query.executeUpdate() == 1) {
                logger.info(userID + "::status updasted successfully");
                return true;
            } else {
                logger.error("status not updated ");
            }
        } catch (NoResultException nre) {

        }
        return false;
    }

    public Status getUserStatus(String id) {

        String select = "FROM Status WHERE  user_id=:id";
        Query query = entityManager.createQuery(select);
        query.setParameter("id", id);
        Status status = null;
        try {
            status = (Status) query.getSingleResult();
        } catch (NoResultException nre) {

        }
        return status;
    }

    public PlayingStatus getUserPlayingStatus(String id) {

        String select = "FROM PlayingStatus WHERE  user_id=:id";
        Query query = entityManager.createQuery(select);
        query.setParameter("id", id);
        PlayingStatus playingStatus = null;
        try {
            playingStatus = (PlayingStatus) query.getSingleResult();
        } catch (NoResultException nre) {

        }
        return playingStatus;
    }

    public void createStatus(String userID) {

    }

    public PlayingStatus updatePlayingStatus(PlayingStatus playingStatus) {

        PlayingStatus playingObj = getPlayingStatus(playingStatus.getUserId());
        if (playingObj != null) {
            updatePlayStatus(playingObj);
        } else {
            playingObj = createPlayingStatus(playingStatus);
        }
        return playingObj;
    }

    public PlayingStatus getPlayingStatus(String id) {

        String select = "FROM PlayingStatus WHERE  user_id=:id";
        Query query = entityManager.createQuery(select);
        query.setParameter("id", id);
        PlayingStatus playingStatus = null;
        try {
            playingStatus = (PlayingStatus) query.getSingleResult();
        } catch (NoResultException nre) {
        }
        return playingStatus;
    }


    public PlayingStatus createPlayingStatus(PlayingStatus playingStatus) {
        entityManager.persist(playingStatus);
        return playingStatus;
    }

    public boolean updatePlayStatus(PlayingStatus playingStatus) {
        Query query = entityManager.createNativeQuery("UPDATE playing_status " +
                "SET playing_src=:playingSrc , " +
                "status=:status ," +
                "playing_info=:playingInfo" +
                " WHERE playing_id =:playId");
        //  query.setParameter("gcm_registration_id", user.getGcmRegi`strationId());
        query.setParameter("playId", playingStatus.getId());
        query.setParameter("status", playingStatus.getStatus());
        query.setParameter("playingSrc", playingStatus.getPlayingSrc());
        query.setParameter("playingInfo", playingStatus.getPlayingInfo());
        try {
            if (query.executeUpdate() == 1) {
                logger.info(playingStatus + "::Playing status updated successfully");
                return true;
            } else {
                logger.error("status not updated ");
            }
        } catch (NoResultException nre) {

        }
        return false;
    }


}
