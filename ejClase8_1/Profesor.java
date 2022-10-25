package ejClase8_1;

public class Profesor extends Persona{

	
	private double sueldo;
	private String asignatura;
	
	// Constructores
	public Profesor() {
		super();
	}
	public Profesor(String nombre, String apellidos, String telefono, 
			String email, Direccion direccion, double sueldo, String asignatura) {
		super(nombre, apellidos, telefono, email, direccion);
		this.sueldo = sueldo;
		this.asignatura = asignatura;
	}
	
	
	// GETTERS AND SETTERS
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	
	
}
