package musipo.modelobj;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance
@Table(name="users_block")
public class User  {
	@Id
	@GeneratedValue(generator = "uid")
	@GenericGenerator(name="uid" , strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="uid" , unique=true)
	private String uid;
	private String username;
	private String Password;
	private String email;
	private String name;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", Password=" + Password + ", email=" + email + ", name="
				+ name + "]";
	}

	
}
