package emails;

import java.sql.Date;


public class Users {

	private String name;
	private String surname;
	private String email;
	private String password;
	private Date lastAccess;
	
	// CONSTRUCTORES
	public Users (String name, String surname, String email, String password, Date lastAccess) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.lastAccess = lastAccess;
	}
	
	public Users () {
	}
	
	
	// GETTERS AND SETTERS
	// Nombre

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	// Apellidos
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	// Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	// Contrasena
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	// Ultima fecha de acceso
	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}
}
