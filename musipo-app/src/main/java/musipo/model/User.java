package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 25-03-2017.
 */

@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
@Table(name = "users")
public class User extends AbstractTimestampEntity{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", unique = true)
    private String id;

    private String name;
    private String email;
    private String mobile;

    @Column(name = "profile_pic")
    private String profilePic;

    @Column(name = "fcm_id")
    private String fcmId;

    public User(){
    }

    public User(String id,String fcmId){
        this.id = id;
        this.fcmId=fcmId;
    }


    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFcmId() {
        return fcmId;
    }

    public void setFcmId(String fcmId) {
        this.fcmId = fcmId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", fcmId='" + fcmId + '\'' +
                '}';
    }
}
