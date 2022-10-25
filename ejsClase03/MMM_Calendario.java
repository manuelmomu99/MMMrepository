package ejsClase03;

import java.time.LocalDate;

public class MMM_Calendario {

	

	public static void main(String[] args) {

		String[] week = { "LU", "MA", "MI", "JU", "VI", "SA", "DO" };

		// Busco el primer y el ultimo dia del mes
		LocalDate ld = LocalDate.now();
		ld = ld.withDayOfMonth(1);
		//ld = ld.withMonth(2);
		
		
		int firstDay = ld.getDayOfWeek().getValue();
		int lastDay = ld.lengthOfMonth();
		
		//##### IMPRIMIMOS EL CALENDARIO #########
		
		// Mes
		System.out.println(ld.getMonth());  
		
		// Dias de la semana
		for (int i = 0; i <= week.length - 1; i++) {  
			System.out.print(week[i] + " ");		  
		};
		
		System.out.println("");
		
		// Huecos del principio del mes
		for (int i = 1; i<=firstDay-1;i++) {
			System.out.print("   ");
		};
		
		// Dias del mes
		int day = 1;

		int weekCount = firstDay;
		while (day <= lastDay) {
			while (weekCount <= 7) {
				if (day<10){
					System.out.print("0"+day+" ");
				}else{
					System.out.print(day+" ");
				};
				weekCount++;
				day++;
				if(day > lastDay) {
					break;
				};		
			};
			System.out.println("");
			weekCount = 1;
		};
		
	}

}
