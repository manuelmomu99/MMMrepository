package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(schema = "persona", name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String user_name;

	@Column
	private String user_password;

	@Column
	private String email;

	@Column
	private Date last_access;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)  
	// Es decir, el usuario en el objeto fingerprint se llama user
	private Fingerprint fingerprint;
	
	
	
	
	
	
	
	
	// GETTERS AND SETTERS

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLast_access() {
		return last_access;
	}
	public void setLast_access(Date last_access) {
		this.last_access = last_access;
	}
	public Fingerprint getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(Fingerprint fingerprint) {
		this.fingerprint = fingerprint;
	}

}
