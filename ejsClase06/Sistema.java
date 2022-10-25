package ejsClase06;

public class Sistema {
	
	private String nombre;
	private Planeta [] planetas;
	
	public Sistema (String Nombre, Planeta [] Planetas) {
		this.nombre = Nombre;
		this.planetas = Planetas;
	}
	
	
	public void printPlanetas() {
		for (int i = 0; i< planetas.length; i++) {
			System.out.println((i+1) + " - " + planetas[i].getNombre());
		}
	};
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Planeta[] getPlanetas() {
		return planetas;
	}
	public void setPlanetas(Planeta[] planetas) {
		this.planetas = planetas;
	}
	
}
