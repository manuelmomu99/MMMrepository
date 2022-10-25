package model;

import java.util.List;

public class Restaurante {

	private String nombre;
	
	private String direccion;
	
	private String telefono;
	
	private String codigoPostal;
	
	private List<Receta> recetas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public Restaurante(String nombre, String direccion, String telefono, String codigoPostal, List<Receta> recetas) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigoPostal = codigoPostal;
		this.recetas = recetas;
	}

	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", codigoPostal=" + codigoPostal + ", recetas=" + recetas + "]";
	}
	
	
}
