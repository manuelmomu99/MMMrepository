package ejClase8_1;

public class Campus {

	
	
	static final int NUMERO_ESTUDIANTES = 5;
	static final int LISTADO_ALUMNOS = 1;
	static final int LISTADO_PROFES = 2;
	static final int SALIR = 3;
	
	
	
	public static Estudiante [] estudiantes = generar_Estudiantes();
	public static Profesor [] profesores = generar_Profesores();
	
	
	
	
	
	public static Estudiante [] generar_Estudiantes() {
		Estudiante [] estudiantes = new Estudiante[5];


		for (int i = 0; i < estudiantes.length; i++) {
			estudiantes[i] = new Estudiante();
			
			String identificacion = Integer.toString(i + 1);
			double[] notas_i = { i, i + 1, i + 2, i + 3, i + 4 };
			
			Direccion direccion = new Direccion("Calle ".concat(identificacion), "Ciudad ".concat(identificacion),
					"CP".concat(identificacion), "Pais".concat(identificacion));
			
			estudiantes[i].setNombre("Estudiante ".concat(identificacion));
			estudiantes[i].setApellidos("Apellido ".concat(identificacion));
			estudiantes[i].setTelefono("Telf".concat(identificacion)); 
			estudiantes[i].setEmail(identificacion.concat("@hotmail.com"));
			estudiantes[i].setDireccion(direccion);
			estudiantes[i].setNumeroEstudiante(i+1);
			estudiantes[i].setNotas(notas_i);;

		};
		return estudiantes;
	}
	public static Profesor [] generar_Profesores() {
		Profesor [] profesores = new Profesor[5];


		for (int i = 0; i < profesores.length; i++) {
			profesores[i] = new Profesor();
			
			String identificacion = Integer.toString(i + 1);
			
			Direccion direccion = new Direccion("Calle ".concat(identificacion), "Ciudad ".concat(identificacion),
					"CP".concat(identificacion), "Pais".concat(identificacion));
			
			profesores[i].setNombre("Estudiante ".concat(identificacion));
			profesores[i].setApellidos("Apellido ".concat(identificacion));
			profesores[i].setTelefono("Telf".concat(identificacion)); 
			profesores[i].setEmail(identificacion.concat("@hotmail.com"));
			profesores[i].setDireccion(direccion);
			profesores[i].setSueldo(i + 1000);
			profesores[i].setAsignatura("Asignatura".concat(identificacion));

		};
		return profesores;
	}
	public static void imprimir_listado (Persona[] lista) {
		for (int i = 0; i<lista.length; i++) {
			System.out.printf("%d - %s %s \n", (i+1), lista[i].getNombre(), lista[i].getApellidos());
		}
		System.out.println("");
	}

	
	
	public static void main(String[] args) {
		boolean salir = false;
		
		do {
		int opcion = Menu.menuInicial();
		switch (opcion) {
		case LISTADO_ALUMNOS:
			imprimir_listado(estudiantes);
			break;
		case  LISTADO_PROFES:
			imprimir_listado(profesores);
			break;
		case SALIR:
			salir = true;
			break;
		default:
			System.out.println("Opción no válida.\n");
		
		}
		} while (salir == false);
		
		
		

	}

}
