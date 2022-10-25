package ejsClase07;

public class AnimalesDomesticos {

	
	static Perro perro1 = new Perro("Alma", 90, 60);
	static Perro perro2 = new Perro("Juan", 20, 20);
	static Perro perro3 = new Perro("Gordo", 90, 40);
	static Perro perro4 = new Perro("Oliver", 80, 50);
	static Perro perro5 = new Perro("Indiana", 75, 60);
	
	static Perro [] perros = {perro1, perro2, perro3, perro4, perro5};
	
	static Gato gato1 = new Gato("Iris", 20, 20);
	static Gato gato2 = new Gato("Rubio", 5, 5);
	static Gato gato3 = new Gato("Jimmy", 30, 20);
	static Gato gato4 = new Gato("Floppa", 40, 50);
	static Gato gato5 = new Gato("Electra", 20, 25);
	
	static Gato [] gatos = {gato1, gato2, gato3, gato4, gato5};
    
	static Raton raton1 = new Raton("Rata", 7, 10);
	static Raton raton2 = new Raton("Ratilla", 5, 5);
	static Raton raton3 = new Raton("Rat Queen", 15, 20);
	static Raton raton4 = new Raton("Rat King", 25, 30);
	static Raton raton5 = new Raton("Hamster", 5, 15);
    
	static Raton [] ratones = {raton1, raton2, raton3, raton4, raton5};
	
	static Animal [][] animales = {perros, gatos, ratones};
	
	
	
	final static String PERRO = perro1.getClass().toString();
	final static String GATO = gato1.getClass().toString();
	final static String RATON = raton1.getClass().toString();
	
	
	public static void main(String[] args) {
	
		
		for (Animal [] lista: animales) {
			for(Animal i : lista) {
				System.out.println(i.nombre + " es un " + i.getClass().getSimpleName()  + ", pesa " 
				+ i.peso + " kg y mide " + i.altura + " cm.");
			}
		}
	
	}

}
