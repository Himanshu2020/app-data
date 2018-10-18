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
@Table(name="Cart_block")
public class Cart {
	@Id
	@GeneratedValue(generator = "cid")
	@GenericGenerator(name="cid" , strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="cid" , unique=true)
	private String cid;
	private String uid;
	private String pid;
	private String totalprice;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
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
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", uid=" + uid + ", pid=" + pid + ", totalprice=" + totalprice + "]";
	}
	
	

}
