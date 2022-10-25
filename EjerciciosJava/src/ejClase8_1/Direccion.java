package ejClase8_1;

public class Direccion {

	private String calle;
	private String ciudad;
	private String codigoPostal;
	private String pais;
	
	
	
	
	
	// Constructores
	public Direccion(String calle, String ciudad, String codigoPostal, String pais) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
	}
	
	
	// Metodos
	public void imprimirDireccion () {
		System.out.printf("Calle %s, %s (%s). Código postal %s .\n", 
				this.calle, this.ciudad, this.pais, this.codigoPostal);
	}
	
	
	
}
