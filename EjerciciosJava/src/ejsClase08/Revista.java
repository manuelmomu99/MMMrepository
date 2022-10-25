package ejsClase08;

import java.time.LocalDate;

public class Revista extends Articulo {

	private String numero;
	
	
	
	// Constructores
	public Revista(String titulo, String codigo, LocalDate year, String numero) {
		super(titulo, codigo, year);
		this.numero = numero;
	}

		
	
	
	// GETTERS AND SETTERS
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
