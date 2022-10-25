package ejsClase05_MMM;

import java.time.LocalDate;

import java.util.Scanner;

public class SegundaMano {

	static Scanner sc = new Scanner(System.in);
	
	static Vehiculo Coche_1 = new Vehiculo("OPEL", "ASTRA", "Azul", "GASOLINA", 5, 
			LocalDate.ofYearDay(2006, 1), 4400, 
			"Torcuato Valderrama", "698 765 432");
	
	static Vehiculo Coche_2 = new Vehiculo("TOYOTA", "AYGO", "Rojo", "DIESEL", 7, 
			LocalDate.ofYearDay(2018, 1), 8900, 
			"Eugenio Robles", "612 345 678");
	
	static Vehiculo Coche_3 = new Vehiculo("KIA", "STONIC", "Rojo", "ELECTRICO", 2, 
			LocalDate.ofYearDay(2017, 1), 12500, 
			"Alejandra Torres", "612 345 678");

	static Vehiculo [] listaVehiculos = {Coche_1, Coche_2, Coche_3};
	
	
	
	public static int elegirVehiculos() {
		System.out.println("VENTA DE COCHES");
		for (int i = 0; i < listaVehiculos.length; i++) {
			Vehiculo coche_i = listaVehiculos[i];
			System.out.print("Coche " + (i+1) + " - ");
			coche_i.mensajeCorto();
		};
		
		System.out.println("Seleccione el coche del que desea conocer más detalles:");
		
		int opcion = sc.nextInt();
		System.out.println("");
		
		return opcion;
	};
	
	
	public static void mostrarDetalles(int opcion) {
		Vehiculo coche_elegido = listaVehiculos[opcion-1];
		System.out.print("Coche " + (opcion) + " - ");
		coche_elegido.mensajeLargo();
	};
	
	
	public static void main(String[] args) {
		
		
		int opcion = elegirVehiculos();
		mostrarDetalles(opcion);
	}

}
