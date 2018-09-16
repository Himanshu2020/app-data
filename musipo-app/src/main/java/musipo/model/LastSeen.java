package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 30-03-2017.
 */

@Entity
@Inheritance
@Table(name = "last_seen")
public class LastSeen extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ls_id", unique = true)
    private String id;
    @Column(name = "user_id")
    private String userId;

    @Column(name = "seen_at")
    private String seenAt;

    public String getSeenAt() {
        return seenAt;
    }

    public void setSeenAt(String seenAt) {
        this.seenAt = seenAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LastSeen{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
