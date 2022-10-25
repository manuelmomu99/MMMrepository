package ejsClase10;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class MMM_Notas {

	static Scanner scNum = new Scanner(System.in);
	static Scanner scString= new Scanner(System.in);

	final static int ANADIR = 1;
	final static int LISTA_GENERAL = 2;
	final static int CALIFICACIONES_ASCENDENTE = 3;
	final static int CALIFICACIONES_DESCENDENTE = 4;
	final static int SOBRESALIENTES = 5;
	final static int NOTABLES = 6;
	final static int BIENES = 7;
	final static int SUFICIENTES = 8;
	final static int INSUFICIENTES = 9;

	

	
	// MENUS
	public static int menu() {
		System.out.println("1 - Nueva Calificacion");
		System.out.println("2 - Listar Calificaciones");
		System.out.println("3 - Listar Calificaciones (Ordenado por calificación ascendente)");
		System.out.println("4 - Listar Calificaciones (Ordenado por calificación descendente)");
		System.out.println("5 - Listar Calificaciones SOBRESALIENTES");
		System.out.println("6 - Listar Calificaciones NOTABLES");
		System.out.println("7 - Listar Calificaciones BIENES");
		System.out.println("8 - Listar Calificaciones SUFICIENTES");
		System.out.println("9 - Listar Calificaciones INSUFICIENTES");
		System.out.println("Elija una opcion:");
		
		try {
		int option = scNum.nextInt();
		return option;
		} catch (Exception e) {
			return 0;
		}

		
	}

	
	// OPERATIONS
	public static void execute_options(List <MMM_Alumno> alumnos) {
		boolean end = false;
		do {
			int option = menu();
			switch (option) {
			case ANADIR:
				add_alumno(alumnos);
				break;
			case LISTA_GENERAL:
				list_notas(alumnos);
				break;
			case CALIFICACIONES_ASCENDENTE:
				Collections.sort(alumnos);
				list_notas(alumnos);
				break;
			case CALIFICACIONES_DESCENDENTE:
				Collections.sort(alumnos);
				Collections.reverse(alumnos);
				list_notas(alumnos);
				break;
			case SOBRESALIENTES:
				List <MMM_Alumno> sobresalientes = clasificar_notas(alumnos, SOBRESALIENTES);
				list_notas(sobresalientes);
				break;
			case NOTABLES:
				List <MMM_Alumno> notables = clasificar_notas(alumnos, NOTABLES);
				list_notas(notables);
				break;
			case BIENES:
				List <MMM_Alumno> bienes = clasificar_notas(alumnos, BIENES);
				list_notas(bienes);
				break;
			case SUFICIENTES:
				List <MMM_Alumno> suficientes = clasificar_notas(alumnos, SUFICIENTES);
				list_notas(suficientes);
				break;
			case INSUFICIENTES:
				List <MMM_Alumno> insuficientes = clasificar_notas(alumnos, INSUFICIENTES);
				list_notas(insuficientes);
				break;
			default:
				end = true;
				break;
			}
		} while (end == false);
	}

	
	public static void add_alumno(List <MMM_Alumno> alumnos) {
		
		
		System.out.println("Introduzca el nombre del alumno:");
		String new_nombre = scString.nextLine();
		
		
		System.out.println("Introduzca la calificacion del alumno:");
		int new_nota = 0;
		do {
		new_nota = scNum.nextInt();
		if (new_nota < 0 || new_nota > 10) {
			System.out.println("Valor incorrecto. Introduzca un valor entre el 0 y el 10:");
		} 
		} while(new_nota < 0 || new_nota > 10);
		System.out.println("");
	
		MMM_Alumno new_alumno = new MMM_Alumno();
		new_alumno.setNombre(new_nombre);
		new_alumno.setNota(new_nota);
		
		
		alumnos.add(new_alumno);
	}

	
	public static void list_notas(List <MMM_Alumno> alumnos) {

		for(MMM_Alumno i : alumnos) {
			System.out.printf("%-15s %-5s - %s \n", i.getCalificacion(), " ("+Integer.toString(i.getNota())+")"
			, i.getNombre());
		}
		System.out.println("");
	}
	
	
	public static List <MMM_Alumno> clasificar_notas (List <MMM_Alumno> alumnos, int opcion) {
		List <MMM_Alumno> sobresalientes = new ArrayList<MMM_Alumno>();
		List <MMM_Alumno> notables = new ArrayList<MMM_Alumno>();
		List <MMM_Alumno> bienes = new ArrayList<MMM_Alumno>();
		List <MMM_Alumno> suficientes = new ArrayList<MMM_Alumno>();
		List <MMM_Alumno> insuficientes = new ArrayList<MMM_Alumno>();
		
		
		for (MMM_Alumno i : alumnos) {
			String calificacion = i.getCalificacion();
			if (calificacion.equalsIgnoreCase(MMM_Calificacion.INSUFICIENTE.getName())) {
				insuficientes.add(i);
			} else if (calificacion.equalsIgnoreCase(MMM_Calificacion.SUFICIENTE.getName())) {
				suficientes.add(i);
			} else if (calificacion.equalsIgnoreCase(MMM_Calificacion.BIEN.getName())) {
				bienes.add(i);
			} else if (calificacion.equalsIgnoreCase(MMM_Calificacion.NOTABLE.getName())) {
				notables.add(i);
			} else if (calificacion.equalsIgnoreCase(MMM_Calificacion.SOBRESALIENTE.getName())) {
				sobresalientes.add(i);
			}
			
		}
		
		switch(opcion) {
		case SOBRESALIENTES:
			Collections.sort(sobresalientes);
			return sobresalientes;
		case NOTABLES:
			Collections.sort(notables);
			return notables;
		case BIENES:
			Collections.sort(bienes);
			return bienes;
		case SUFICIENTES:
			Collections.sort(suficientes);
			return suficientes;
		case INSUFICIENTES:
			Collections.sort(insuficientes);
			return insuficientes;
		default:
			return alumnos;
			
		
		}
		
		}
		
	
	
	
	// MAIN
	public static void main(String[] args) {
		List <MMM_Alumno> alumnos = new ArrayList<MMM_Alumno>();

		execute_options(alumnos);
		

	
		scNum.close();
		scString.close();
		
	}

}
