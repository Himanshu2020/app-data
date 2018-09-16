package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 31-03-2017.
 */

@Entity
@Inheritance
@Table(name = "Status")
public class Status extends AbstractTimestampEntity{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "status_id", unique = true)
    private String id;

    @Column(name = "status_msg")
    private String statusMsg;

    @Column(name = "user_id")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id='" + id + '\'' +
                ", statusMsg='" + statusMsg + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
