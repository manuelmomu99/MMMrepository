package ejsClase07;

public abstract class Animal {
	protected String nombre;
	protected double peso;
	protected double altura;
	
	protected Animal (String Nombre, int Peso, int Altura) {
		this.nombre = Nombre;
		this.peso = Peso;
		this.altura = Altura;
	}
	
	protected void olfatear () {
		System.out.println("Snifff snifff");
	}
	
	
	
	
}
