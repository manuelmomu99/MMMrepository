package ejsClase08;

import java.time.LocalDate;

public abstract class Articulo {
	
	protected String titulo;
	protected String codigo;
	protected LocalDate year;
	
	
	
	
	
	
	// Constructores

	public Articulo(String titulo, String codigo, LocalDate year) {
		
		this.titulo = titulo;
		this.codigo = codigo;
		this.year = year;
	}
	
	
	
	// GETTERS AND SETTERS
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDate getYear() {
		return year;
	}
	public void setYear(LocalDate year) {
		this.year = year;
	}
}
