package model;

import java.util.List;

public class Receta {

	private String nombre;
	
	private List<Ingrediente> ingredientes;
	
	private String descripcion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Receta(String nombre, List<Ingrediente> ingredientes, String descripcion) {
		super();
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Receta [nombre=" + nombre + ", ingredientes=" + ingredientes + ", descripcion=" + descripcion + "]";
	}
		
	
}
