package dataAccess;


import java.sql.SQLException;

import model.User;

public interface UserDAO {
	// Hibernate gestiona las excepciones, asi que no hay que poner throws
	public void create(User user);

	public User read(int id);

	
	public void delete(int id);

	public void update(User user); 
	
}
