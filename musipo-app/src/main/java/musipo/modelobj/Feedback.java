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
@Table(name="Feedback_block")
public class Feedback {
	@Id
	@GeneratedValue(generator = "fid")
	@GenericGenerator(name="fid" , strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="fid" , unique=true)
	private String fid; 
	private String uid;
	private String oid;
	private String pid;
	private boolean feedback;
	private int rating;
	private String fdescr;
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public boolean isFeedback() {
		return feedback;
	}
	public void setFeedback(boolean feedback) {
		this.feedback = feedback;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFdescr() {
		return fdescr;
	}
	public void setFdescr(String fdescr) {
		this.fdescr = fdescr;
	}
	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", uid=" + uid + ", oid=" + oid + ", pid=" + pid + ", feedback=" + feedback
				+ ", rating=" + rating + ", fdescr=" + fdescr + "]";
	}
	

}
