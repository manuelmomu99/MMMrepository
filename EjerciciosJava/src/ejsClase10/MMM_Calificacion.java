package ejsClase10;


public enum MMM_Calificacion {
INSUFICIENTE ("0, 1, 2, 3, 4",  "INSUFICIENTE"), 
SUFICIENTE ("5", "SUFICIENTE"), 
BIEN ("6", "BIEN"),
NOTABLE ("7, 8", "NOTABLE"), 
SOBRESALIENTE ("9, 10", "SOBRESALIENTE");
	
	
	private String name;
	private String notas;
	
	
	

	


	

	
	
	// CONSTRUCTORES
	private MMM_Calificacion(String notas, String name) {
		this.name = name;
		this.notas = notas;
	}

	



	// GETTERS
	
	public String getName() {
		return name;
	}


	public String getNotas() {
		return notas;
	}


	
		
	

	
	
}
