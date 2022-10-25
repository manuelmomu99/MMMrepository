package ejsClase05_MMM;


import java.time.LocalDate;



public class Clase {

	

	public static void main(String[] args) {
		MMM_Persona Ana = new MMM_Persona ("Ana", "Carbajo Manrique", 10, LocalDate.of(2012, 12, 1), 
				"Almería", false, true);
		MMM_Persona Belen = new MMM_Persona ("Belén", "Aguado Martín", 20, LocalDate.of(2002, 11, 2), 
				"Barcelona", true, true);
		MMM_Persona Cristian = new MMM_Persona ("Cristian", "Espejo Ortega", 30, LocalDate.of(1992, 10, 3), 
				"Cuenca", false, true);
		MMM_Persona Diana = new MMM_Persona ("Diana", "Montabán Ramírez", 40, LocalDate.of(1982, 9, 4), 
				"Denia", false, true);
		MMM_Persona Elena = new MMM_Persona ("Elena", "Real Peinado", 50, LocalDate.of(1972, 8, 5), 
				"Denia", true, true);
		MMM_Persona Fernando = new MMM_Persona ("Fernando", "Ariño Miñambres", 60, LocalDate.of(1962, 7, 6), 
				"Ferrol", true, true);
		MMM_Persona Gracia = new MMM_Persona ("Gracia", "Segura Llorens", 70, LocalDate.of(1952, 6, 7), 
				"Ferrol", false, false);
		MMM_Persona Hector = new MMM_Persona ("Héctor", "del Mar Palmer", 80, LocalDate.of(1942, 5, 8), 
				"Ferrol", false, false);
		MMM_Persona Inmaculada = new MMM_Persona ("Inmaculada", "Diez Pascual", 90, LocalDate.of(1932, 4, 9), 
				"Ferrol", false, false);
		MMM_Persona Jacinto = new MMM_Persona ("Jacinto", "Robles Martos", 100, LocalDate.of(1922, 3, 10), 
				"Ferrol", false, true);
		
		MMM_Persona [] lista = {Ana, Belen, Cristian, Diana, Elena, 
				Fernando, Gracia, Hector, Inmaculada, Jacinto};
		
		for(MMM_Persona i : lista) {
			i.saludar();;
		};
		
	}

}
