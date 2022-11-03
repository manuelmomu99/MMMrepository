package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "persona", name = "fingerprint")
public class Fingerprint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String finger;

	@Column
	private Date scandate;

	@Column
	private String image;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id", referencedColumnName = "id")
	private User user;


	
	
	// GETTERS AND SETTERS

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFinger() {
		return finger;
	}
	public void setFinger(String finger) {
		this.finger = finger;
	}
	public Date getScandate() {
		return scandate;
	}
	public void setScandate(Date scandate) {
		this.scandate = scandate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	

}
