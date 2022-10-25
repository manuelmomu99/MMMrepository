package ejClase8_1;

public class Estudiante extends Persona{

	private int numeroEstudiante;
	private double [] notas;
	
	
	

	// Constructores
	public Estudiante() {
		super();
	}	
	public Estudiante(String nombre, String apellidos, String telefono, 
			String email, Direccion direccion, int numeroEstudiante, double [] notas) {
		super(nombre, apellidos, telefono, email, direccion);
		this.numeroEstudiante = numeroEstudiante;
		this.notas = notas;
	}


	
	// Metodos
	public double calcularMedia() {
		double suma = 0;
		int elementos = 0;
		
		for(int i = 0; i<this.notas.length; i++) {
			suma = suma + notas[i];
			elementos++;
		}
		
		if (elementos == 0) {
			return 0;
		} else {
			return suma/notas.length;
		}
	}

	public double calcularMatricula() {
		double matricula = 0;
		int aprobadas = 0;
		
		for (int i = 0; i<this.notas.length; i++) {
			if (notas[i]>=5) {
				aprobadas++;
			}
		}
		matricula = aprobadas*100 + (notas.length-aprobadas)*200;
		return matricula;
	}
	
	
	
	// GETTERS AND SETTERS
	
	public int getNumeroEstudiante() {
		return numeroEstudiante;
	}

	
	public void setNumeroEstudiante(int numeroEstudiante) {
		this.numeroEstudiante = numeroEstudiante;
	}



	public double[] getNotas() {
		return notas;
	}

	
	public void setNotas(double[] notas) {
		this.notas = notas;
	}



}
