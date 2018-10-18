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
@Table(name="Product_block")
public class Product {
	@Id
	@GeneratedValue(generator = "pid")
	@GenericGenerator(name="pid" , strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="pid" , unique=true)
	private String pid;
	private String pname;
	private String pdesc;
	private String Price;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", Price=" + Price + "]";
	}
	
	
	
	

}
