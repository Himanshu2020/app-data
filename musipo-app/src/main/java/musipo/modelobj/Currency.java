package musipo.modelobj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance
@Table(name="Currency_block")
public class Currency {
	@Id
	@GeneratedValue(generator = "cuid")
	@GenericGenerator(name="cuid" , strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="cuid" , unique=true)
	private String cuid;
	private String uid;
	private String pid;
	private String earned_curr;
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getEarned_curr() {
		return earned_curr;
	}
	public void setEarned_curr(String earned_curr) {
		this.earned_curr = earned_curr;
	}
	@Override
	public String toString() {
		return "Currency [cuid=" + cuid + ", uid=" + uid + ", pid=" + pid + ", earned_curr=" + earned_curr + "]";
	}
	

}
