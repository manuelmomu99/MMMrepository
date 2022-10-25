package ejsClase05_MMM;

import java.time.LocalDate;

public class MMM_Persona {

	private String nombre;
	private String apellidos;
	private int edad;
	private LocalDate fechaNacimiento;
	private String ciudad;
	private boolean trabaja;
	private boolean estudia;

	
	// Constructor con todos los argumentos
	public MMM_Persona(String Nombre, String Apellidos, int Edad, LocalDate FechaNacimiento, 
			       String Ciudad, boolean Trabaja, boolean Estudia) {
		this.nombre = Nombre;
		this.apellidos = Apellidos;
		this.edad = Edad;
		this.fechaNacimiento = FechaNacimiento;
		this.ciudad = Ciudad;
		this.trabaja = Trabaja;
		this.estudia = Estudia;
	};

	
	
	public void saludar () {	
		
		String Estudia = "";
		String Trabaja = "";
		
		if (trabaja == true) {
			 Trabaja = "estoy trabajando";
		} else {
			 Trabaja = "no estoy trabajando";
		}
		
		if (estudia == true) {
			 Estudia = "estoy estudiando";
		} else {
			 Estudia = "no estoy estudiando";
		}
		
		System.out.printf("Hola me llamo %s %s y tengo %d años.\n", nombre, apellidos, edad);
		System.out.printf("Nací el %tD y vivo en %s.\n", fechaNacimiento, ciudad);
		System.out.printf("Actualmente %s y %s.\n", Trabaja, Estudia);
		System.out.println("");
	};
	
	
	// Nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Apellidos
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	// Edad
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// Fecha de nacimiento
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	// Ciudad
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	// Trabaja
	public String isTrabaja() {
		String salida = "";
		if (trabaja == true) {
			salida = "estoy trabajando";
		} else {
			salida = "no estoy trabajando";
		}
		
		return salida;
	}

	public void setTrabaja(boolean trabaja) {
		this.trabaja = trabaja;
	}

	// Estudia
	public String isEstudia() {
		String salida = "";
		if (estudia == true) {
			salida = "estoy estudiando";
		} else {
			salida = "no estoy estudiando";
		}
		return salida;
	}

	public void setEstudia(boolean estudia) {
		this.estudia = estudia;
	}

}
