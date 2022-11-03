package service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entities.Cuenta;

public class CuentaServiceJPAImpl implements CuentaService {

	private EntityManager manager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();
	
	
	@Override
	public void create(Cuenta cuenta) {
		manager.getTransaction().begin();
		manager.persist(cuenta);
		manager.getTransaction().commit();
		
	}

	@Override
	public Cuenta read(int id) {
		return manager.find(Cuenta.class, id);
	}

	@Override
	public Cuenta update(Cuenta cuenta) {
		manager.getTransaction().begin();
		manager.merge(cuenta);
		manager.getTransaction().commit();
		return cuenta;
	}

	@Override
	public void delete(int id) {
		manager.getTransaction().begin();
		manager.remove(read(id));
		manager.getTransaction().commit();
	}

	
}
