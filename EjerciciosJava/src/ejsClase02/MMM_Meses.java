package ejsClase02;

public class MMM_Meses {

	public static void main(String[] args) {
		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		for (int i = 1; i <= 12; i++) {
			System.out.println("El " + i + "º mes de ano es " + meses[i - 1]);
		}
		;

	}

}
