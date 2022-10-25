package ejsClase06;

public class Galaxia {

	public static void main(String[] args) {
		
		Planeta Mercurio = new Planeta("Mercurio");
		Planeta Venus = new Planeta("Venus");
		Planeta Tierra = new Planeta("Tierra");
		Planeta Marte = new Planeta("Marte");
		Planeta Jupiter = new Planeta("Júpiter");
		Planeta Saturno = new Planeta("Saturno");
		Planeta Urano = new Planeta("Urano");
		Planeta Neptuno = new Planeta("Neptuno");
		
		Planeta [] planetasSS = {Mercurio, Venus, Tierra, Marte, Jupiter, Saturno, Urano, Neptuno};
		
		Sistema Solar = new Sistema("Solar", planetasSS);

		Solar.printPlanetas();
		
	}

}
