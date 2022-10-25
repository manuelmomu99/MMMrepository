package ejsClase02;

public class MMM_TipoDatos2 {

	public static void main(String[] args) {

		String[] nombres = { "Ana", "Beatriz", "Carlos", "Diana", "Fernando", "Gracia", "Helena", "Ivan", "Juan",
				"Kevin" };
		String[] apellidos = { "Abad", "Baeza", "Candela", "Duarte", "Fajardo", "Gallardo", "Hernandez", "Ibarra",
				"Jimenez", "King" };
		short[] edad = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		String[] fechaN = { "1/1/2012", "2/2/2002", "3/3/1992", "4/4/1982", "5/5/1972", "6/6/1962", "7/7/1952",
				"8/8/1942", "9/9/1932", "10/10/1922" };
		String[] ciudad = { "Alicante", "Bilbao", "Cuenca", "Denia", "Ferrol", "Granada", "Huesca", "Igualada", "Jaen",
				"Kingstone" };
		boolean[] trabaja = { false, true, true, true, true, true, false, false, false, false };
		boolean[] estudia = { true, true, false, false, false, true, false, false, false, true };

		
		String[] trab = new String[10];
		for (byte i = 0; i <= nombres.length - 1; i++) {
			trab[i] = trabaja[i] ? "estoy trabajando" : "no estoy trabajando";
		};

		String[] est = new String[10];
		for (byte i = 0; i <= nombres.length - 1; i++) {
			est[i] = estudia[i] ? "estoy estudiando" : "no estoy estudiando";
		};

		for (byte i = 0; i <= 9; i++) {
			System.out.println("Hola me llamo " + nombres[i] + " " + apellidos[i] + " y tengo " + edad[i] + " anos");
			System.out.println("Naci el " + fechaN[i] + " y vivo en " + ciudad[i]);
			System.out.println("Actualmente " + trab[i] + " y " + est[i]);
			System.out.println(" ");
			
		}
		
		
		
		
		
		
		
		
	};

	

}

