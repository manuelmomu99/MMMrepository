package service;

import entities.Cliente;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class ClienteServiceJPAImpl implements ClienteService {

	private EntityManager manager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();
	
	
	
	@Override
	public void create(Cliente cliente) {
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}

	@Override
	public Cliente read(String dni) {
		return manager.find(Cliente.class, dni);
	}

	@Override
	public Cliente update(Cliente cliente) {
		manager.getTransaction().begin();
		manager.merge(cliente);
		manager.getTransaction().commit();
		return cliente;
	}

	@Override
	public void delete(String dni) {
		manager.getTransaction().begin();
		manager.remove(read(dni));
		manager.getTransaction().commit();
		
	}

}
