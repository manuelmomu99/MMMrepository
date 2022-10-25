package ejsClase02;

public class MMM_Cuadrado {

	public static void main(String[] args) {
		
		int n [] = {3, 4, 10};
		char sym [] = {'#', '#', '@'};
		
		for (int k = 0; k <= n.length-1; k++) {
			System.out.println(n[k] + " x " + n[k]);
			for (int i = 1; i <= n[k]; i++) {
				for (int j = 1; j <= n[k]; j++) {
					System.out.print(sym[k]);
				};
				System.out.print("\n");

			};
			System.out.println();
		}
		
		/*
		byte [] rep = {3, 4};
		
		for (byte i : rep) {
			System.out.println(i + " x " + i);
			byte h = 1;
			while (h <i+1) {
				byte k = 1;
				while (k < i) {
					for (byte j = 1; j<=i; j++) {
							System.out.print("#");
							k++;	
							}
					System.out.println("");
				
			}
				h++;
		}
			System.out.println("");
		}
		
		byte h = 0;
		System.out.println(10 + " x " + 10);
		while (h <10) {
			byte k = 1;
			while (k < 10) {
				for (byte j = 1; j<=10; j++) {
						System.out.print("@");
						k++;	
						}
				System.out.println("");
			
		}
			h++;
			*/
	}

}
