package emails;

import java.util.Scanner;

public class Menus {

	static Scanner scINT = new Scanner(System.in);
	static Scanner scSTRING = new Scanner(System.in);
	
	
	// Menu inicial
	public static int show_initial_menu() {
		System.out.println("BIENVENIDO A SUPERMAIL");
		System.out.println("1 - LOGIN");
		System.out.println("2 - NUEVO USUARIO");
		System.out.println("3 - SALIR");
		System.out.println("Elija una opción:");
		
		// Meter try-catch por si el valor introducido no es un int
		int option = scINT.nextInt();

		System.out.println("");
		return option;
	}

	
	// MENUS DE REGISTRO
	// Menu de resgistro
	public static String [] show_register_menu() {
		System.out.println("BIENVENIDO A SUPERMAIL");
		System.out.println("Introduzca su email:");
		String user_email = scSTRING.nextLine();
		System.out.println("Introduzca su contraseña:");
		String user_password = scSTRING.nextLine();
		
		String [] output = {user_email, user_password};
		
		return output;
	}
	
	// Menu de completar datos (nombre y apellidos)
	public static String [] get_user_name(){
		System.out.println("Introduzca su nombre:");
		String user_name = scSTRING.nextLine();
		System.out.println("Introduzca su apellido:");
		String user_surname = scSTRING.nextLine();
		
		String [] output = {user_name, user_surname};
		return output;
	}
	
	
	
	// MENUS DE LOGIN
	// Menu de login
	public static String [] show_login_menu() {
		System.out.println("BIENVENIDO A SUPERMAIL");
		System.out.println("Introduzca su email:");
		String user_email = scSTRING.nextLine();
		System.out.println("Introduzca su contraseña:");
		String user_password = scSTRING.nextLine();
		
		String [] output = {user_email, user_password};
		
		System.out.println("");
		
		return output;
	}
	
	
	// Menu de bandeja
	public static int show_user_incerface(Users user) {
		System.out.printf("BIENVENIDO A SUPERMAIL %s %s \n", user.getName(), user.getSurname());
		System.out.println("1 - ENVIAR MAIL");
		System.out.println("2 - BANDEJA DE ENTRADA");
		System.out.println("3 - BANDEJA DE SALIDA");
		System.out.println("4 - CERRAR SESIÓN");
		System.out.println("Elija una opción:");
		
		int option = scINT.nextInt();
		
		System.out.println("");
		return option;
	}
	
	
	
}
