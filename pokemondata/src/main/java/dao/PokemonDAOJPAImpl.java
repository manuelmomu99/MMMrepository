package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Pokemon;

public class PokemonDAOJPAImpl implements PokemonDAO {
	private EntityManager manager = Persistence.createEntityManagerFactory("POKEMON_DB").createEntityManager();
	
	public Pokemon findByPokedexNumber (int number) {
		return manager.find(Pokemon.class, number);
	}

	@Override
	public List<Pokemon> findAll() {
		Query query=manager.createQuery("from Pokemon");

		

		return query.getResultList();

	}
	
	
	
}
