package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "pokemon", name = "pokemon")
public class Pokemon {

	@Id
	private int numero_pokedex;
	
	@Column (name = "NOMBRE")
	private String name;
	
	@Column (name = "PESO")
	private double weight;
	
	@Column (name = "ALTURA")
	private double height;



	public int getNumero_pokedex() {
		return numero_pokedex;
	}

	public void setNumero_pokedex(int numero_pokedex) {
		this.numero_pokedex = numero_pokedex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
}
