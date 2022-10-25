package gestionInstituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import gestionInstituto.BBDDUtil;

public class GestionInstituto {

	static Scanner scINT = new Scanner(System.in);
	static Scanner scSTRING = new Scanner(System.in);

	static final int MOSTRAR_LISTADO = 1;
	static final int BUSCAR_ALUMNO = 2;
	static final int CREAR_ALUMNO = 3;
	static final int MODIFICAR_ALUMNO = 4;
	static final int ELIMINAR_ALUMNO = 5;
	static final int SALIR = 0;

	// MENUS
	public static int menu() {

		System.out.println("GESTION INSTITUTO V1");
		System.out.println("---------------------");
		System.out.println("1 - Listado Alumnos");
		System.out.println("2 - Buscar Alumno (DNI)");
		System.out.println("3 - Crear Alumno");
		System.out.println("4 - Modificar Alumno");
		System.out.println("5 - Eliminar Alumno");
		System.out.println("0 - SALIR");
		System.out.println("--------------------");
		int option = scINT.nextInt();

		return option;
	}

	// FUNCIONES
	public static void ejecutar_opciones() {
		boolean end = false;

		do {
			int opcion = menu();
			System.out.println();

			switch (opcion) {
			case MOSTRAR_LISTADO:
				mostrar_listado();
				break;
			case BUSCAR_ALUMNO:
				buscar_alumno();
				break;
			case CREAR_ALUMNO:
				crear_alumno();
				break;
			case MODIFICAR_ALUMNO:
				modificar_alumno();
				break;
			case ELIMINAR_ALUMNO:
				eliminar_alumno();
				break;
			case SALIR:
				end = true;
				break;
			default:
				System.out.println("Opción no válida.");
			}
		} while (end == false);
	}

	public static void mostrar_listado() {
		try {
			// CONEXION CON LA BASE DE DATOS
			Connection conexion = BBDDUtil.openConnection();

			// Query
			Statement st = conexion.createStatement();
			ResultSet listaAlumnos = st.executeQuery("SELECT * FROM ALUMNO ORDER BY APELLIDOS ASC");

			// Resultado de la query
			System.out.printf("%-9s | %-15s | %-20s | %-3s \n", "DNI", "NOMBRE", "APELLIDOS", "EDAD");
			System.out.println("--------------------------------------------------------------------");
			while (listaAlumnos.next()) {
				String dni = listaAlumnos.getString("DNI");
				String nombre = listaAlumnos.getString("NOMBRE");
				String apellidos = listaAlumnos.getString("APELLIDOS");
				String edad = Integer.toString(listaAlumnos.getInt("EDAD"));

				System.out.printf("%-9s | %-15s | %-20s | %-3s \n", dni, nombre, apellidos, edad);
			}
			System.out.println("");
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		}
	}

	public static String buscar_alumno() {
		
		String dni_buscado = "0";
		try {
			// CONEXION CON LA BASE DE DATOS
			Connection conexion = BBDDUtil.openConnection();

			// EJECUCION
			System.out.println("Introduzca el DNI del alumno:");
			dni_buscado = scSTRING.nextLine();
			System.out.println(" ");

			// Prepared statement
			String st = "SELECT * FROM ALUMNO " + "WHERE DNI LIKE ?";
			PreparedStatement pst = conexion.prepareStatement(st.toString());
			pst.setString(1, dni_buscado);

			// Query
			ResultSet alumno = pst.executeQuery();

			// Resultado del Query
			System.out.printf("%-9s | %-15s | %-20s | %-3s \n", "DNI", "NOMBRE", "APELLIDOS", "EDAD");
			System.out.println("--------------------------------------------------------------------");
			while (alumno.next()) {
				String dni = alumno.getString("DNI");
				String nombre = alumno.getString("NOMBRE");
				String apellidos = alumno.getString("APELLIDOS");
				String edad = Integer.toString(alumno.getInt("EDAD"));

				System.out.printf("%-9s | %-15s | %-20s | %-3s \n", dni, nombre, apellidos, edad);
			}
			System.out.println("");
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		} 
		return dni_buscado;
	}

	public static void crear_alumno() {
		try {
			// CONEXION CON LA BASE DE DATOS
			Connection conexion = BBDDUtil.openConnection();

			
			
			
			// EJECUCION
			System.out.println("Introduzca el DNI del alumno:");
			String dni_nuevo = scSTRING.nextLine();
			System.out.println("Introduzca el nombre del alumno:");
			String nombre_nuevo = scSTRING.nextLine();
			System.out.println("Introduzca los apellidos del alumno:");
			String apellidos_nuevo = scSTRING.nextLine();
			System.out.println("Introduzca la edad del alumno:");
			int edad_nuevo = scINT.nextInt();
			System.out.println(" ");
	

			
			
			
			// Prepared statement
			String st = "INSERT INTO ALUMNO (DNI, NOMBRE, APELLIDOS, EDAD) "
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement pst = conexion.prepareStatement(st.toString());
			pst.setString(1, dni_nuevo);
			pst.setString(2, nombre_nuevo);
			pst.setString(3, apellidos_nuevo);
			pst.setInt(4, edad_nuevo);

			// Query
			try {
			pst.executeUpdate();
			System.out.println("Alumno añadido correctamente");
			} catch (SQLException e) {
				System.out.println("Error al añadir el alumno");
				e.printStackTrace();
			}

			
			System.out.println("");
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		}
	}
	
	public static void eliminar_alumno() {
		try {
			// CONEXION CON LA BASE DE DATOS
			Connection conexion = BBDDUtil.openConnection();

			// EJECUCION
			System.out.println("Introduzca el DNI del alumno que desea eliminar:");
			String dni_buscado = scSTRING.nextLine();
			System.out.println(" ");

			// Prepared statement
			String st = "DELETE FROM ALUMNO " + "WHERE DNI LIKE ?";
			PreparedStatement pst = conexion.prepareStatement(st.toString());
			pst.setString(1, dni_buscado);

			// Update
			try {
			pst.executeUpdate();
			System.out.println("Alumno eliminado correctamente");
			} catch (SQLException e) {
				System.out.println("Error al eliminar el alumno");
				e.printStackTrace();
			}

			
			System.out.println("");
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		}
	}
	
	public static void modificar_alumno() {
		try {
			// CONEXION CON LA BASE DE DATOS
			Connection conexion = BBDDUtil.openConnection();

			// EJECUCION
			String dni_buscado = buscar_alumno();

			// DNI
			dni_buscado = modificar_dni(dni_buscado, conexion);
			
			// NOMBRE
			modificar_nombre(dni_buscado, conexion);
			
			// NOMBRE
			modificar_apellidos(dni_buscado, conexion);
						
			// NOMBRE
			modificar_edad(dni_buscado, conexion);
			
		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		}

	}
	
	
	public static String modificar_dni(String dni_buscado, Connection conexion) {
		String dni_nuevo = "0";
		try {
			System.out.println("¿Desea modificar el DNI del alumno seleccionado? (s/n)");
			String respuesta = scSTRING.nextLine();
			if (respuesta.equalsIgnoreCase("s")) {
				System.out.println("Introduzca el nuevo DNI del alumno seleccionado:");
			    dni_nuevo = scSTRING.nextLine();

				// Prepared statement
				String st = "UPDATE ALUMNO SET DNI = ? WHERE DNI LIKE ?";
				PreparedStatement pst = conexion.prepareStatement(st.toString());
				pst.setString(1, dni_nuevo);
				pst.setString(2, dni_buscado);

				// Query
				try {
					pst.executeUpdate();
					System.out.println("Alumno modificado correctamente");
				} catch (SQLException e) {
					System.out.println("Error al modificar el alumno");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		}
		return dni_nuevo;
	}
	public static void modificar_nombre(String dni_buscado, Connection conexion) {
		try {
			System.out.println("¿Desea modificar el nombre del alumno seleccionado? (s/n)");
			String respuesta = scSTRING.nextLine();
			if (respuesta.equalsIgnoreCase("s")) {
				System.out.println("Introduzca el nuevo nombre del alumno seleccionado:");
				String nombre_nuevo = scSTRING.nextLine();
				
				// Prepared statement
				String st = "UPDATE ALUMNO SET NOMBRE = ? WHERE DNI LIKE ?";
				PreparedStatement pst = conexion.prepareStatement(st.toString());
				pst.setString(1, nombre_nuevo);
				pst.setString(2, dni_buscado);

				// Query
				try {
					pst.executeUpdate();
					System.out.println("Alumno modificado correctamente");
				} catch (SQLException e) {
					System.out.println("Error al modificar el alumno");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		}
	}
	public static void modificar_apellidos(String dni_buscado, Connection conexion) {
		try {
			System.out.println("¿Desea modificar los apellidos del alumno seleccionado? (s/n)");
			String respuesta = scSTRING.nextLine();
			if (respuesta.equalsIgnoreCase("s")) {
				System.out.println("Introduzca los nuevos apellidos del alumno seleccionado:");
				String apellidos_nuevos = scSTRING.nextLine();
				
				// Prepared statement
				String st = "UPDATE ALUMNO SET APELLIDOS = ? WHERE DNI LIKE ?";
				PreparedStatement pst = conexion.prepareStatement(st.toString());
				pst.setString(1, apellidos_nuevos);
				pst.setString(2, dni_buscado);

				// Query
				try {
					pst.executeUpdate();
					System.out.println("Alumno modificado correctamente");
				} catch (SQLException e) {
					System.out.println("Error al modificar el alumno");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		}
	}	
	public static void modificar_edad(String dni_buscado, Connection conexion) {
		try {
			System.out.println("¿Desea modificar la edad del alumno seleccionado? (s/n)");
			String respuesta = scSTRING.nextLine();
			if (respuesta.equalsIgnoreCase("s")) {
				System.out.println("Introduzca la nueva edad del alumno seleccionado:");
				int edad_nueva = scINT.nextInt();
				
				// Prepared statement
				String st = "UPDATE ALUMNO SET EDAD = ? WHERE DNI LIKE ?";
				PreparedStatement pst = conexion.prepareStatement(st.toString());
				pst.setInt(1, edad_nueva);
				pst.setString(2, dni_buscado);

				// Query
				try {
					pst.executeUpdate();
					System.out.println("Alumno modificado correctamente");
				} catch (SQLException e) {
					System.out.println("Error al modificar el alumno");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al abrir conexión a BBDD.");
			e.printStackTrace();
		}
	}	
	
	// MAIN
	public static void main(String[] args) {
		ejecutar_opciones();

		scINT.close();
		scSTRING.close();
	}

}
