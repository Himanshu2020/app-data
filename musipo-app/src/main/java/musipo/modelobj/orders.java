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
@Table(name="orders_block")
public class orders {
	@Id
	@GeneratedValue(generator = "oid")
	@GenericGenerator(name="oid" , strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="oid" , unique=true)
	private String oid;
	private String uid;
	private String pid;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
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
	@Override
	public String toString() {
		return "orders [oid=" + oid + ", uid=" + uid + ", pid=" + pid + "]";
	}
	
}
