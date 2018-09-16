package musipo.model;

import musipo.entity.AbstractTimestampEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by G510 on 30-03-2017.
 */

@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
@Table(name = "otp")
public class Otp extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "otp_id", unique = true)
    private String id;
    private String mobileNo;
    private String otp;

    public Otp(){

    }
    public Otp(String mobileNo,String otp){
        this.mobileNo = mobileNo;
        this.otp=otp;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Otp{" +
                "id='" + id + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
