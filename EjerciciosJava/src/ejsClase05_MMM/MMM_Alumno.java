package ejsClase05_MMM;

import java.time.LocalDate;



public class MMM_Alumno {
	private String nombre;
	private LocalDate fechaExamen;
	private double notaTeorico;
	private double notaPractico;


	public MMM_Alumno(String Nombre, LocalDate FechaExamen, double NotaTeorico, double NotaPractico){
		this.nombre = Nombre;
		this.fechaExamen = FechaExamen;
		this.notaTeorico = NotaTeorico;
		this.notaPractico = NotaPractico;
	};
	
	
	public double getMedia (double NotaTeorico, double NotaPractico) {
		this.notaTeorico = NotaTeorico;
		this.notaPractico = NotaPractico;
		return (NotaTeorico + NotaPractico)/2;
		
	};
	
	// Nombre alumno
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Fecha examen
	public LocalDate getFechaExamen() {
		return fechaExamen;
	}
	public void setFechaExamen(LocalDate fechaExamen) {
		this.fechaExamen = fechaExamen;
	}
	
	// Nota teorico
	public double getNotaTeorico() {
		return notaTeorico;
	}
	public void setNotaTeorico(double notaTeorico) {
		this.notaTeorico = notaTeorico;
	}
	
	// Nota practico
	public double getNotaPractico() {
		return notaPractico;
	}
	public void setNotaPractico(double notaPractico) {
		this.notaPractico = notaPractico;
	}
	
}
