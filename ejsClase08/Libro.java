package ejsClase08;

import java.time.LocalDate;

public class Libro extends Articulo implements Prestable{
	
	private boolean prestado;

	// Constructores
	
	public Libro(String titulo, String codigo, LocalDate year) {
		super(titulo, codigo, year);
		this.prestado = false;           // Por defecto, el libro NO esta prestado
	}


	
	
	// Metodos implementados
	@Override
	public void prestar() {
		if (this.prestado == false) {
			this.prestado = true;
			System.out.println("El libro ha sido prestado correctamente. \n");
		} else {
			System.out.println("El libro no se puede prestar porque ya fue prestado. \n");
		}
		
	}
	@Override
	public void devolver() {
		if (this.prestado == false) {
			System.out.println("El libro no se puede devolver ya que no fue prestado. \n");
		} else {
			this.prestado = false;
			System.out.println("El libro ha sido devuelto correctamente. \n");
		}
		
	}
	@Override
	public String prestado() {
		if (this.prestado == false) {
			return "Disponible";
		} else {
			return "Prestado";
		}
	}


	// GETTERS AND SETTERS
	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
}
