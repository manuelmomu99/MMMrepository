package ejsClase04;


import java.util.Scanner;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.lang.Math;

public class MMM_SupermercadoCovid {

	static Scanner sc = new Scanner(System.in);
	
	final static int SUPERREDUCIDO = 1;
	final static int REDUCIDO = 2;
	final static int GENERAL = 3;
	final static int COBRAR = 4;
	final static int LIMITE_PRODUCTOS = 5;
	
	
	public static int imprimir_menu () {
		System.out.println("SUPERMERCADO COVID");
		System.out.println("1 – Comprar producto (IVA Superreducido 4%)");
		System.out.println("2 – Comprar producto (IVA Reducido 10%)");
		System.out.println("3 – Comprar producto (IVA General 21%)");
		System.out.println("4 - Cobrar");
		System.out.println("Elija una opción:");
		
		int option = sc.nextInt();

		return option;
	};
	
	
	public static int contar_productos (int numero_productos) {
		boolean end = false;
		int cantidad = 0;
		
		do {
			System.out.println("¿Cuantas unidades? Pulse 0 para anular");
			cantidad = sc.nextInt();
			
			if (numero_productos+cantidad > LIMITE_PRODUCTOS) {
				System.out.println("Límite superado");
			} else {
				end = true;
			};
		} while (end == false);
		
		return cantidad;
	}
		
	
	
	public static String [] elegir_productos(int option, int numero_productos) {
		
		//###### LISTA DE PRODUCTOS ############
		
		// Productos con el iva superreducido
		String [] productos_SR = {"Manzana", "Huevos (6 uds)", "Botella de leche (1 L)", 
				"Barra de pan", "Periódico"};
		String [] precios_SR = {"0.50", "2.60", "1.05", "1.00", "2.00"};
		
		// Productos con el iva reducido
		
		String [] productos_R = {"Botella de agua (1 L)", "Yogur (4 uds)", "Jamón (100 g)", 
				"Tableta de chocolate", "Zumo de manzana (1 L)"};
		String [] precios_R = {"0.60", "1.40", "3.00", "0.90", "2.30"};
		
		// Productos con el iva general
		
		
		String [] productos_G = {"Camiseta", "Pantalón", "Calcetines", 
				"Tabaco", "Ginebra (1 L)"};
		String [] precios_G = {"5.00", "10.00", "3.00", "5.00", "13.00"};
		
		
		String [][] todos_los_productos = {productos_SR, productos_R, productos_G};
		String [][] todos_los_precios = {precios_SR, precios_R, precios_G};
		
		// ##### ELECCION DE PRODUCTOS #########
		
		
		// Mostramos los productos
		
		String producto_elegido  = "";
		String precio_elegido = "";
		String cantidad_elegido = "";
		String tipo_elegido = "";
		
		int choice = 0;
		int cantidad = 0;
		
		
		// Imprime los productos
		for (int i = 0; i <= todos_los_productos[option-1].length - 1; i++) {
			System.out.println((i + 1) + " - " + todos_los_productos[option-1][i]);
		};
		System.out.println((todos_los_productos[option-1].length + 1) + " - Volver");

		// Que producto elegimos?
		System.out.println("Elija una opción:");
		choice = sc.nextInt();

		if (choice > 0 && choice <= todos_los_productos[option-1].length) {
			// Qué cantidad?
			cantidad = contar_productos(numero_productos);

			if (cantidad != 0) {
				producto_elegido = todos_los_productos[option-1][choice - 1] + ",";
				precio_elegido = todos_los_precios[option-1][choice - 1] + ",";
				cantidad_elegido = Integer.toString(cantidad) + ",";
				tipo_elegido = "1,";
			};

			numero_productos = numero_productos + cantidad;
			System.out.println("Ha seleccionado " + numero_productos + " productos");

		} else if (choice == todos_los_productos[option-1].length + 1) {
			producto_elegido = "";
		} else {
			System.out.println("Opción no valida");
		};
	
		String numero_productos_string = Integer.toString(numero_productos);
		String [] output = {producto_elegido, precio_elegido, cantidad_elegido, tipo_elegido, numero_productos_string}; 
		
		return output;
	};

	
	public static void cobrar (String productos, String precios, String cantidad, String tipo) {
		
		
		String [] prod = productos.split(",");
		String [] prec = precios.split(",");
		String [] cant = cantidad.split(",");
		String [] tip = tipo.split(",");
		
		double [] iva = {0.04, 0.1, 0.21};
		
		
		LocalDate ld = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("");
		System.out.println("SUPERMERCADO COVID - " + ld.format(formato));
		
		double total = 0;
		
		for (int i = 0; i<=prod.length-1;i++) {
			double precio = Double.valueOf(prec[i]);
			double tipo_iva = iva[Integer.valueOf(tip[i])-1];
			int cantidad_producto = Integer.valueOf(cant[i]);
			
			String producto_y_precio = prod[i] + " (" + prec[i]+ "€)";
			double iva_total = (Math.round((precio*tipo_iva)*100))*0.01*cantidad_producto;
			
			
			System.out.printf("%d - %-40s x%s - %s%n",  (i + 1),
					producto_y_precio, cant[i], precio*cantidad_producto + "€ - IVA " +
					 tipo_iva*100 + "% (" + iva_total+ ")");
	
			//System.out.println((i + 1) + " - " + prod[i] + " (" + prec[i]+ "€)");
			total = Math.round((total + precio*(1+ tipo_iva)*cantidad_producto)*100)*0.01;
		};
		
		System.out.println("TOTAL + IVA: " + total +"€");
		
	};
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero_productos = 0;
		boolean end = false;
		
		String productos = "";
		String precios = "";
		String cantidad = "";
		String tipo = "";
		

		do {
			int option = imprimir_menu();
			switch (option) {
			
			case SUPERREDUCIDO:
			case REDUCIDO:
			case GENERAL:	
				if (numero_productos<5) {
				String [] salida = elegir_productos(option, numero_productos);
				productos = productos + salida[0];
				precios = precios + salida[1];
				cantidad = cantidad + salida[2];
				tipo = tipo + salida[3];
				numero_productos = Integer.valueOf(salida[4]);
				
				System.out.println("Productos seleccionados: " + productos);
				System.out.println("Cantidad seleccionada: " + cantidad);

				} else {
					System.out.println("Límite de productos superados. Pulse 4 para cobrar");
				};
				
				break;
			
			case COBRAR:
				cobrar(productos, precios, cantidad, tipo);
				
				end = true;
				break;
			default:
				System.out.println("Opción no válida");
			};
			System.out.println("");	
		} while (end == false);
		
		
		sc.close();
	}

}
