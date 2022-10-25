package ejsClase05_MMM;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;



public class MMM_Autoescuela {

	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	static MMM_Alumno Alejandro = new MMM_Alumno("Alejandro", LocalDate.of(2020, 11, 2), 5.0, 4.0);
	static MMM_Alumno Daniel = new MMM_Alumno("Daniel", LocalDate.of(2020, 11, 2), 6.0, 6.5);
	static MMM_Alumno Martin = new MMM_Alumno("Martín", LocalDate.of(2020, 11, 3), 6.5, 4.0);
	static MMM_Alumno Monica = new MMM_Alumno("Monica", LocalDate.of(2020, 11, 3), 2.0, 0.5);
	static MMM_Alumno Ernesto = new MMM_Alumno("Ernesto", LocalDate.of(2020, 11, 3), 8.0, 3.0);
	static MMM_Alumno Marta = new MMM_Alumno("Marta", LocalDate.of(2020, 11, 3), 8.0, 5.0);
	static MMM_Alumno Cristian = new MMM_Alumno("Cristian", LocalDate.of(2020, 11, 4), 4.5, 6.0);
	static MMM_Alumno Mirian = new MMM_Alumno("Mirian", LocalDate.of(2020, 11, 5), 2.5, 9.5);
	static MMM_Alumno Ivan = new MMM_Alumno("Ivan", LocalDate.of(2020, 11, 5), 6.5, 5.0);
	static MMM_Alumno Alberto = new MMM_Alumno("Alberto", LocalDate.of(2020, 11, 6), 2.0, 2.0);

	static MMM_Alumno[] alumnos = { Alejandro, Daniel, Martin, Monica, Ernesto, 
			Marta, Cristian, Mirian, Ivan, Alberto };

	
	public static String [] resultados () {
		
		String aprobados = "";
		String suspendidos = "";

		for (int i = 0; i < alumnos.length; i++) {
			MMM_Alumno alumno = alumnos[i];
			double NT = alumno.getNotaTeorico();
			double NP = alumno.getNotaPractico();
			
			
			
			if ((NT >= 5) && (NP >= 5)) {
				aprobados = aprobados + "- " + alumno.getNombre() + " (Nota: " + alumno.getMedia(NT, NP) + ") T:" + NT
						+ " / P:" + NP + ",";
				
			} else if ((NT >= 5) || (NP >= 5)) {
				suspendidos = suspendidos + "- " + alumno.getNombre() + " (Nota: " + alumno.getMedia(NT, NP) + ") T:" + NT
						+ " / P:" + NP + " > PC: " 
						+ alumno.getFechaExamen().plusDays(7).format(formato) + ",";
			
			} else {
				suspendidos = suspendidos + "- " + alumno.getNombre() + " (Nota: " + alumno.getMedia(NT, NP) + ") T:" + NT
						+ " / P:" + NP + " > PC: " 
						+ alumno.getFechaExamen().plusDays(14).format(formato) + ",";
			}
			

		}
		
		
		String [] output = {aprobados, suspendidos};
		
		return output;
	};
	
	
	public static void imprimir_resultados() {
		String [] result = resultados();
		String [] aprobados = result[0].split(",");
		String [] suspendidos = result[1].split(",");
	
		System.out.println("APTOS:");
		for (int i = 0; i <aprobados.length; i++) {
			System.out.println(aprobados[i]);
		};
		
		System.out.println("");
		System.out.println("NO APTOS:");
		for (int i = 0; i <suspendidos.length; i++) {
			System.out.println(suspendidos[i]);
		};
	}
	

	public static void main(String[] args) {
		imprimir_resultados();
		
		
		
		
		
		

		
	}

}
