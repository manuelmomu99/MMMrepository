package ejsClase09;

import java.time.LocalDate;

public class MMM_Persona2 implements Comparable < MMM_Persona2 > {

	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;
	private LocalDate fechaNacimiento;
	private String ciudad;
	private boolean trabaja;
	private boolean estudia;

	
	// CONSTRUCTORES
	public MMM_Persona2(String Nombre, String Apellidos, String dni, int Edad, LocalDate FechaNacimiento, 
			       String Ciudad, boolean Trabaja, boolean Estudia) {
		this.nombre = Nombre;
		this.apellidos = Apellidos;
		this.dni = dni;
		this.edad = Edad;
		this.fechaNacimiento = FechaNacimiento;
		this.ciudad = Ciudad;
		this.trabaja = Trabaja;
		this.estudia = Estudia;
	};

	
	
	
	public MMM_Persona2() {

	}




	// Metodos
	
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
	
	@Override
	public int compareTo(MMM_Persona2 persona) {
		int result = this.nombre.compareToIgnoreCase(persona.nombre);
		
		if (result == 0) {
			result = this.apellidos.compareToIgnoreCase(persona.apellidos);
			if (result == 0) {
				result = this.fechaNacimiento.compareTo(persona.fechaNacimiento);
			}
		}
		
		return result;
	}



	
	
	
	// GETTERS AND SETTERS
	
	
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

	// DNI
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
			salida = "Trabaja";
		} else {
			salida = "No trabaja";
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
			salida = "Estudia";
		} else {
			salida = "No estudia";
		}
		return salida;
	}
	public void setEstudia(boolean estudia) {
		this.estudia = estudia;
	}
}
