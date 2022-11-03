package dataAccess;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Fingerprint;
import model.User;


public class FingerprintDAOJPAImpl implements FingerprintDAO {

	private EntityManager manager = Persistence.createEntityManagerFactory("BASEDEDATOSPRUEBA").createEntityManager();
	
	public void create(Fingerprint fingerprint) {
		manager.getTransaction().begin();
		manager.persist(fingerprint);
		manager.getTransaction().commit();
	}

	public Fingerprint read(int id) {
		return manager.find(Fingerprint.class, id);
	}

	public void update(Fingerprint fingerprint) {
		manager.getTransaction().begin();
		manager.merge(fingerprint);
		manager.getTransaction().commit();
	}

	public void delete(int id) {
		manager.getTransaction().begin();
		manager.remove(read(id));
		manager.getTransaction().commit();
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
