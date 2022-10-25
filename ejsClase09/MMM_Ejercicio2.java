package ejsClase09;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MMM_Ejercicio2 {

	static Scanner scNum = new Scanner(System.in);
	static Scanner scStr = new Scanner(System.in);
	 
	
	static final int ADD = 1;
	static final int SHOW_LIST = 2;
	static final int SEARCH = 3;
	static final int EXIT = 4;
	
	
	static MMM_Persona2 persona1 = new MMM_Persona2("Alba", "Miralles Pascual", "45558763S", 26,
			LocalDate.ofYearDay(1996, 1), "Jaca", true, false);
	static MMM_Persona2 persona2 = new MMM_Persona2("Alba", "Torres Albaladejo", "24568745E", 22,
			LocalDate.ofYearDay(2000, 1), "Valencia", true, true);
	static MMM_Persona2 persona3 = new MMM_Persona2("Ana", "Barroso Monllor", "32115694D", 19,		
			LocalDate.ofYearDay(2003, 1), "Elda", false, true);
	static MMM_Persona2 persona4 = new MMM_Persona2("Alba", "Miralles Pina", "12225467B", 40,
			LocalDate.ofYearDay(1982, 1), "Alicante", true, false);
	static MMM_Persona2 persona5 = new MMM_Persona2("Ana", "Blanco Castro", "74845134X", 25,
			LocalDate.ofYearDay(1997, 1), "Sevilla", true, true);
	
	
	// INICIALIZACION DE LISTAS Y MAPAS
	public static List <MMM_Persona2> set_initial_List() {
		List <MMM_Persona2> personas = new ArrayList <MMM_Persona2>();
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		personas.add(persona4);
		personas.add(persona5);
		
		return personas;
	}
	
	
	public static Map <String, MMM_Persona2> set_initial_Map(){
		Map <String, MMM_Persona2> DNIpersona = new HashMap<String, MMM_Persona2>();
		DNIpersona.put(persona1.getDni(), persona1);
		DNIpersona.put(persona2.getDni(), persona2);
		DNIpersona.put(persona3.getDni(), persona3);
		DNIpersona.put(persona4.getDni(), persona4);
		DNIpersona.put(persona5.getDni(), persona5);
		
		return DNIpersona;
	}

	
	// MENUS
 	public static int show_menu() {
		System.out.println("1 - Nueva Persona");
		System.out.println("2 - Listado Personas");
		System.out.println("3 - Buscar por NIF");
		System.out.println("4 - SALIR");
		System.out.println("Elija una opción:");
		
		int option = scNum.nextInt();
		
		System.out.println("");
		return option;
	}
	
 	
 	// OPERACIONES
	public static void execute_options (List<MMM_Persona2> personas, Map <String, MMM_Persona2> DNIpersonas) {
		boolean end = false;
		
		do {
		Collections.sort(personas);
		int option = show_menu();
		
		switch (option) {
		case ADD:
			add_persona(personas, DNIpersonas);
			break;
		case SHOW_LIST:
			show_list(personas);
			break;
		case SEARCH:
			search_persona(DNIpersonas);
			break;
		case EXIT:
			end = true;
			break;
		default:
			System.out.println("Opción no válida.");
		}
		} while (end == false);
	}
	
	
	public static void add_persona(List<MMM_Persona2> personas, Map <String, MMM_Persona2> DNIpersonas) {
		
		System.out.println("Introduzca el nombre:");
		String new_nombre = scStr.nextLine();
	
		
		System.out.println("Introduzca los apellidos:");
		String new_apellidos = scStr.nextLine(); 

		
		System.out.println("Introduzca el DNI:");
		String new_dni = scStr.nextLine(); 

		
		System.out.println("Introduzca la edad:");
		int new_edad = scNum.nextInt(); 
		LocalDate new_Date = LocalDate.now().minusYears(new_edad);

		
		System.out.println("Introduzca la ciudad donde vive:");
		String new_ciudad = scStr.nextLine(); 

		
		System.out.println("¿Trabaja (s/n)?:");
		boolean trabaja = false;
		String new_trabaja = scStr.nextLine(); 
		if (new_trabaja.equalsIgnoreCase("s")) {
			trabaja = true;
		}

		
		System.out.println("¿Estudia (s/n)?:");
		boolean estudia = false;
		String new_estudia = scStr.nextLine(); 
		if (new_estudia.equalsIgnoreCase("s")) {
			estudia = true;
		}
		System.out.println(" ");
		
		
		MMM_Persona2 new_persona = new MMM_Persona2(new_nombre, new_apellidos, new_dni, new_edad, 
				new_Date, new_ciudad, trabaja, estudia);
		
		personas.add(new_persona);
		DNIpersonas.put(new_persona.getDni(), new_persona);
		
	}
	
	
 	public static void show_list(List<MMM_Persona2> personas) {
		System.out.printf("%-8s | %-20s | %-4s \n","NOMBRE", "APELLIDOS", "DNI");
		for (MMM_Persona2 i : personas) {
			System.out.printf("%-8s | %-20s | %-4s \n", i.getNombre(), 
					i.getApellidos(), i.getDni());
		}
		System.out.println("");
	}
	
	
 	public static void search_persona (Map <String, MMM_Persona2> DNIpersonas) {
 		System.out.println("Introduzca el NIF:");
 
 		String searched_nif = scStr.nextLine(); 
 		
 		boolean found = false;
 		
 		for (String i : DNIpersonas.keySet() ) {
 			if (i.compareTo(searched_nif) == 0) {
 				MMM_Persona2 persona_found = DNIpersonas.get(searched_nif);
 				
 				System.out.printf("%-8s | %-17s | %-9s | %-4s | %-19s | %-8s | %-10s | %-10s  \n",
 						"NOMBRE", "APELLIDOS", "DNI", "EDAD", "FECHA DE NACIMIENTO", "CIUDAD", "ESTUDIA", "TRABAJA");
 				System.out.printf("%-8s | %-17s | %-9s | %-4d | %-19tY | %-8s | %-10s | %-10s \n", 
 						persona_found.getNombre(), persona_found.getApellidos(), persona_found.getDni(), 
 						persona_found.getEdad(), persona_found.getFechaNacimiento(), persona_found.getCiudad(), 
 						persona_found.isEstudia(), persona_found.isTrabaja());
 				System.out.println("");
 				
 				found = true;
 				break;
 			} 
 		}
 		
 		if (found == false) {
 			System.out.println("El NIF introducido no pertenece a ninguna persona del sistema.");
 			System.out.println("");
 		}
 	}
 	
 	
 	
 	
 	
 	// MAIN
	public static void main(String[] args) {
		List <MMM_Persona2> personas = set_initial_List();
		Map <String, MMM_Persona2> DNIpersonas = set_initial_Map();
		execute_options(personas, DNIpersonas);
		
		scStr.close();
		scNum.close();
	}

	
	
}
