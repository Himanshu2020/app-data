package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 01-09-2017.
 */

@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
@Table(name = "login_session")
public class loginSession extends AbstractTimestampEntity {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "session_id", unique = true)
    private String id;

    private String mobile;

    @Column(name = "imie_number")
    private String imieNumber;

    @Column(name = "device_id")
    private String deviceId;

    public String getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImieNumber() {
        return imieNumber;
    }

    public void setImieNumber(String imieNumber) {
        this.imieNumber = imieNumber;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id='" + id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", imieNumber='" + imieNumber + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }

}
