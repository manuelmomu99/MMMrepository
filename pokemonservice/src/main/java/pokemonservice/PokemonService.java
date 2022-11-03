package pokemonservice;

import java.util.List;

import dao.PokemonDAOJPAImpl;
import entities.Pokemon;

public class PokemonService {

	public static PokemonDAOJPAImpl pokeDAO = new PokemonDAOJPAImpl();
	
	public static Pokemon findPokemonById(int id) {
		return pokeDAO.findByPokedexNumber(id);
	}
	
	public void fight (Pokemon a, Pokemon b) {
	}
	
	public static List <Pokemon> findAll(){
		return pokeDAO.findAll();
	}
}
