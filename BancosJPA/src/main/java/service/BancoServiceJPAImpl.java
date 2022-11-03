package service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entities.Banco;

public class BancoServiceJPAImpl implements BancoService{
private EntityManager manager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();
	
	
	
	@Override
	public void create (Banco banco) {
		manager.getTransaction().begin();
		manager.persist(banco);
		manager.getTransaction().commit();
	}

	@Override
	public Banco read(int id) {
		return manager.find(Banco.class, id);
	}

	@Override
	public Banco update (Banco banco) {
		manager.getTransaction().begin();
		manager.merge(banco);
		manager.getTransaction().commit();
		return banco;
	}

	@Override
	public void delete (int id) {
		manager.getTransaction().begin();
		manager.remove(read(id));
		manager.getTransaction().commit();
		
	}
}
