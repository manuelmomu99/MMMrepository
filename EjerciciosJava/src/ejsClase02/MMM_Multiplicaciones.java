package ejsClase02;

public class MMM_Multiplicaciones {

	public static void main(String[] args) {

		int n = 7;

		for (int i = 1; i <= n; i++) {
			System.out.println("TABLA DEL " + i);
			for (int j = 1; j <= 10; j++) {
				if (i < 10 && j < 10) {
					System.out.println("0" + i + " x 0" + j + " = " + (i * j));
				} else if (i < 10) {
					System.out.println("0" + i + " x " + j + " = " + (i * j));
				} else if (j < 10) {
					System.out.println(i + " x " + "0"+j + " = " + (i * j));
				} else {
					System.out.println(i + " x " + j + " = " + (i * j));
				};
				
				
			}
			System.out.println("");
		}

	}
}
