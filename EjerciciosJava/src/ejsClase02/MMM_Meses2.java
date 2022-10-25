package ejsClase02;

public class MMM_Meses2 {

	public static void main(String[] args) {
		String [] meses = {"Enero", "Febrero", "Marzo", "Abril", 
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre", 
				"Octubre", "Noviembre", "Diciembre"};
		for (int i = 0; i<=meses.length-1; i++) {
			String dias;
			
			switch(meses[i]) {
			case "Febrero":
				dias = "28 o 29";
				break;
			case "Abril":
			case "Junio":
			case "Septiembre":
			case "Noviembre":
				dias = "30";
				break;
			default:
				dias = "31";
			}
				System.out.println("El "+ (i+1) +"º mes de ano es "+ meses[i]+ 
						" y tiene " +dias+ " dias.");
			}
		
			
			
		};

	}


