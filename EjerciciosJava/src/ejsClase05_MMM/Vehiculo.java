package ejsClase05_MMM;

import java.time.LocalDate;

public class Vehiculo {

	private String marca;
	private String modelo;
	private String color;
	private String motor;
	private int plazas;
	private LocalDate fechaMatriculacion;
	private int precio;
	private String nombreVendedor;
	private String tfnoVendedor;
	
	
	
	// Constructor con todos los argumentos
	public Vehiculo (String Marca, String Modelo, String Color, String Motor, int Plazas, 
					 LocalDate FechaMatriculacion, int Precio, String NombreVendedor, 
					 String TfnoVendedor) {
		this.marca = Marca;
		this.modelo = Modelo;
		this.color = Color;
		this.motor = Motor;
		this.plazas = Plazas;
		this.fechaMatriculacion = FechaMatriculacion;
		this.precio = Precio;
		this.nombreVendedor = NombreVendedor;
		this.tfnoVendedor = TfnoVendedor;
	};


	// Constructor con 4 argumentos
	public Vehiculo (String Marca, String Modelo, LocalDate FechaMatriculacion, 
					int Precio) {
		this.marca = Marca;
		this.modelo = Modelo;
		this.fechaMatriculacion = FechaMatriculacion;
		this.precio = Precio;
	};
	
	
	
	// Metodos
	
	public void mensajeCorto () {
		System.out.printf("%s %s %d - %d € \n", this.marca, this.modelo,
				this.fechaMatriculacion.getYear(), this.getPrecio());
	};

	public void mensajeLargo() {
		System.out.printf("%s %s %d - %d € (%s) - %d plazas\n", this.marca, 
				this.modelo, this.fechaMatriculacion.getYear(), 
				this.precio, this.motor, this.plazas);
		System.out.println("Color " + this.color + ".");
		System.out.printf("Vendedor: %s - %s", this.nombreVendedor, this.tfnoVendedor);
	};
	
	
	
	// ############### GETTERS AND SETTERS #############
	// Marca
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	// Modelo
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	// Color
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	// Motor
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	
	// Plazas
	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
	
	// Fecha de matriculacion
	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}
	public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}
	
	// Precio
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	// Nombre del vendedor
	public String getNombreVendedor() {
		return nombreVendedor;
	}
	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}
	
	// Telefono del vendedor
	public String getTfnoVendedor() {
		return tfnoVendedor;
	}
	public void setTfnoVendedor(String tfnoVendedor) {
		this.tfnoVendedor = tfnoVendedor;
	}
	
	
}
