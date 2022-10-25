package model;

public class Ingrediente {
	
	private String nombre;
	
	private double calorias;
	
	private double precio;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Ingrediente(String nombre, double calorias, double precio) {
		super();
		this.nombre = nombre;
		this.calorias = calorias;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", calorias=" + calorias + ", precio=" + precio + "]";
	}
	
	

}
