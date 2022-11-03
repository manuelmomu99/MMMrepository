package dao;

import java.util.List;

import entities.Pokemon;

public interface PokemonDAO {

	
	public Pokemon findByPokedexNumber (int number);
	
	public List<Pokemon> findAll();
}