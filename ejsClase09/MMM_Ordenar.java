package ejsClase09;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MMM_Ordenar {

	
	static MMM_Persona1 persona1 = new MMM_Persona1("Ana", 26, LocalDate.ofYearDay(2010, 1), "Vigo", true, false);
	static MMM_Persona1 persona2 = new MMM_Persona1("Alba", 21, LocalDate.ofYearDay(1988, 1), "Santander", false, true);
	static MMM_Persona1 persona3 = new MMM_Persona1("Ana", 26, LocalDate.ofYearDay(2009, 1), "Valencia", false, false);
	static MMM_Persona1 persona4 = new MMM_Persona1("Alba", 26, LocalDate.ofYearDay(2007, 1), "Oviedo", true, true);

	
	
	public static List <MMM_Persona1> iniciar_datos() {
		List <MMM_Persona1> personas = new ArrayList <MMM_Persona1>();
		
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		personas.add(persona4);
		return personas;
	}
	
	public static void imprimir_lista(List <MMM_Persona1> personas) {
		for(MMM_Persona1 i : personas) {
			System.out.printf("%-10s %-4d %-6tY %-13s %-13s %-13s \n", i.getNombre(), i.getEdad(), i.getFechaNacimiento(), 
					i.getCiudad(), i.isEstudia(), i.isTrabaja());
		}
	}
	
	
	public static void main(String[] args) {
		List <MMM_Persona1> personas = iniciar_datos(); 
		Collections.sort(personas);
		imprimir_lista(personas);
		
		
		
		
	}

}
