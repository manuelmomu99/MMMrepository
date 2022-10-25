package ejsClase06;

public class MMM_Cuenta {

	
	private MMM_Titular titular;
	private double cantidad;
	
	
	// CONSTRUCTORES
	
	public MMM_Cuenta (MMM_Titular titular, double Cantidad) {
		this.titular = titular;
		this.cantidad = Cantidad;
	};
	
	public MMM_Cuenta() {
		
	}
	
	
	// METODOS
	
	public void printCantidad() {
		System.out.println("El saldo actual es de " + this.cantidad + "€. \n");
	}
	
	
	
	
	
	// ################## GETTERS AND SETTERS #############
	
	// Cantidad
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	// Titular
	public MMM_Titular getTitular() {
		return titular;
	}
}
