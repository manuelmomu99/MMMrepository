package dataAccess;


import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.User;

public class UserDAOJPAImpl implements UserDAO {

	private EntityManager manager = Persistence.createEntityManagerFactory("BASEDEDATOSPRUEBA").createEntityManager();
	
	@Override
	public void create(User user){
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
	}

	@Override
	public User read(int id){
		User userRead = manager.find(User.class, id);
		return userRead;
	}

	@Override
	public void delete(int id){
		manager.getTransaction().begin();
		manager.remove(read(id));	
		manager.getTransaction().commit();
	}

	@Override
	public void update(User user){
		manager.getTransaction().begin();
		manager.merge(user);
		manager.getTransaction().commit();
	}

}
