package ejsClase10;

public class MMM_Alumno implements Comparable <MMM_Alumno> {

	private String nombre;
	private int nota;

	
	
	

	
	
	// CONSTRUCTORES
	public MMM_Alumno(String nombre, int Nota) {
		super();
		this.nombre = nombre;
		this.nota = Nota;
	}
	

	
	
	
	



	public MMM_Alumno() {
		super();
	}


	// METODOS
	@Override
	public int compareTo(MMM_Alumno alumno) {
		if (alumno.getNota()>this.nota) {
			return 1;
		} else if (alumno.getNota()<this.nota) {
			return -1;
		} else {
			return this.nombre.compareToIgnoreCase(alumno.getNombre());
		}	
	}
	

	
	
	

	// GETTERS AND SETTERS
	
	// Nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Nota
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}

	// Calificacion	
	public String getCalificacion() {

		String calificacion = "";
		String notaStr = Integer.toString(this.nota);


		if (MMM_Calificacion.INSUFICIENTE.getNotas().contains(notaStr)) {
			calificacion = MMM_Calificacion.INSUFICIENTE.getName();
		} else if (MMM_Calificacion.SUFICIENTE.getNotas().contains(notaStr)) {
			calificacion = MMM_Calificacion.SUFICIENTE.getName();
		} else if (MMM_Calificacion.BIEN.getNotas().contains(notaStr)) {
			calificacion = MMM_Calificacion.BIEN.getName();
		}else if (MMM_Calificacion.NOTABLE.getNotas().contains(notaStr)) {
			calificacion = MMM_Calificacion.NOTABLE.getName();
		} else if (MMM_Calificacion.SOBRESALIENTE.getNotas().contains(notaStr)) {
			calificacion = MMM_Calificacion.SOBRESALIENTE.getName();
		}
		return calificacion;
	}
		
		
		

	
	
}
