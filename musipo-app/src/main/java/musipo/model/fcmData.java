package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 30-03-2017.
 */

@Entity
@Inheritance
@Table(name = "FCM_DATA")
public class fcmData extends AbstractTimestampEntity{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "gcm_registration_id", unique = true)
    private String gcmRegistrationId;

    private String userId;

    public String getGcmRegistrationId() {
        return gcmRegistrationId;
    }

    public void setGcmRegistrationId(String gcmRegistrationId) {
        this.gcmRegistrationId = gcmRegistrationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Gcm{" +
                "gcmRegistrationId='" + gcmRegistrationId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
