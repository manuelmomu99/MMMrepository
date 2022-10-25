package ejsClase06;

import java.util.Scanner;

public class MMM_CajeroAutomatico {

	
	final static int INGRESAR = 1;
	final static int SACAR = 2;
	final static int CONSULTAR = 3;
	final static int SALIR = 4;
	

	
	
	static Scanner sc = new Scanner(System.in);
	
	static MMM_Titular Antonio = new MMM_Titular("Antonio Morales Redondo", "anmore", "antonio62");
	static MMM_Titular Sandra = new MMM_Titular("Sandra Vico Abad", "saviad", "sandra95");
	static MMM_Titular Diana = new MMM_Titular("Diana Ortega Leal", "diorle", "diana89");
	
	static MMM_Cuenta CuentaAntonio = new MMM_Cuenta(Antonio, 4000.00);
	static MMM_Cuenta CuentaSandra= new MMM_Cuenta(Sandra, 421.87);
	static MMM_Cuenta CuentaDiana= new MMM_Cuenta(Diana, 1300.00);
	
	static MMM_Titular [] titulares = {Antonio, Sandra, Diana};
	static MMM_Cuenta [] cuentas = {CuentaAntonio, CuentaSandra, CuentaDiana};
	
	
	
	public static MMM_Titular usuarioYcontrasena() {
		
		boolean end = false;
		MMM_Titular output = new MMM_Titular();
		
		
		do {
			System.out.println("Usuario: ");
			String usuario = sc.nextLine();
			System.out.println("Contraseña: ");
			String contrasena = sc.nextLine();
			
			for (MMM_Titular i : titulares) {
				if (i.getUsuario().equals(usuario) && i.getContrasena().equals(contrasena)) {
					output = i;
					end = true;
					System.out.println("");
					break;
				}	
			}
			
			if (end == false ) {
				System.out.println("Los datos introducidos son incorrectos. \n");
			}
	
		} while (end == false);
			 
		return output;
	}
	
	
	public static MMM_Cuenta recuperar_cuenta(MMM_Titular titular) {

		MMM_Cuenta output = new MMM_Cuenta();

		for (MMM_Cuenta i : cuentas) {
			if (i.getTitular().equals(titular)) {
				output = i;
				break;
			}
		}
		
		return output;
	}
	
	
	public static int menu_cajero() {
		System.out.println("1 – Ingresar dinero");
		System.out.println("2 – Sacar dinero");
		System.out.println("3 – Consultar saldo");
		System.out.println("4 - SALIR");
		System.out.println("Elija una opción:");
		
		int option = sc.nextInt();
		return option;
	}
	
	
	public static double ingresar_dinero(MMM_Cuenta cuenta) {
		double cantidad = cuenta.getCantidad();
		int cantidad_ingresada = 0;

		System.out.println("Introduzca la cantidad a ingresar: ");
		do {
			cantidad_ingresada = sc.nextInt();
			if (cantidad_ingresada < 0 || cantidad_ingresada%5 != 0) {
				System.out.println("Cantidad no válida. Seleccione un valor positivo multiplo de 5: ");
			}
		} while (cantidad_ingresada < 0 || cantidad_ingresada%5 != 0);

		cantidad = cantidad + cantidad_ingresada;

		System.out.println("El ingreso se ha realizado correctamente. \n");
		cuenta.setCantidad(cantidad);
		return cantidad;
	};
	
	
	public static void sacar_dinero (MMM_Cuenta cuenta) {
		double cantidad_cuenta = cuenta.getCantidad();
		int cantidad_retirada = 0;

		System.out.println("Introduzca la cantidad a retirar: ");
		
		do {
			cantidad_retirada = sc.nextInt();
			if (cantidad_retirada < 0 || cantidad_retirada%5 != 0) {
				System.out.println("Cantidad no válida. Seleccione un valor positivo multiplo de 5: ");
			} else if (cantidad_retirada > cantidad_cuenta){
				System.out.println("No puede retirar más dinero del que tiene en la cuenta.");
				System.out.println("Seleccione un valor correcto: ");
			}
		} while (cantidad_retirada < 0 || cantidad_retirada%5 != 0 || cantidad_retirada > cantidad_cuenta);

			
			System.out.println("Importe: " + cantidad_retirada + "€.");
			cuantos_billetes(cantidad_retirada);
	

		cantidad_cuenta = cantidad_cuenta - cantidad_retirada;
		cuenta.setCantidad(cantidad_cuenta);
		
	}
	
	
	public static void cuantos_billetes(int cantidad_retirada) {
		
		String salidaBilletes = "";
		String salidaValorBilletes = "";
		
		int billetes500 = 0;
		int billetes200 = 0;
		int billetes100 = 0;
		int billetes50 = 0;
		int billetes20 = 0;
		int billetes10 = 0;
		int billetes5 = 0;
		
		
		int [] billetes = {billetes500, billetes200, billetes100, billetes50, billetes20, 
				billetes10, billetes5};
		int [] valor_billetes = {500, 200, 100, 50, 20, 10, 5};
		
		
		for (int i = 0; i<billetes.length; i++) {
			while ((cantidad_retirada - valor_billetes[i]) >= 0) {
				cantidad_retirada = cantidad_retirada - valor_billetes[i];
				billetes[i]++;
			}
			if (billetes[i] != 0) {
				salidaBilletes = salidaBilletes + Integer.toString(billetes[i]) + ",";
				salidaValorBilletes = salidaValorBilletes + Integer.toString(valor_billetes[i]) + ",";
			}
		}
		
		String [] numBilletes = salidaBilletes.split(",");
		String [] tipoBilletes = salidaValorBilletes.split(",");
		
		
	
		for(int i = 0; i<numBilletes.length; i++) {
			System.out.printf("%s x %s \n", tipoBilletes[i], numBilletes[i]);
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		boolean end = false;
		
		
		MMM_Titular titular = usuarioYcontrasena();
		MMM_Cuenta cuenta = recuperar_cuenta(titular);

		do {
			int option = menu_cajero();
			switch (option) {
			case INGRESAR:
				ingresar_dinero(cuenta);
				break;
			case SACAR:
				sacar_dinero(cuenta);
				break;
			case CONSULTAR:
				cuenta.printCantidad();
				break;
			case SALIR:
				end = true;
				break;
			default:
				System.out.println("Opción no válida. \n");
				break;
			}
		} while (end == false);
		
		sc.close();
	}

}
