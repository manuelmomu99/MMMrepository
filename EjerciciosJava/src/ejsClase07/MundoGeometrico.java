package ejsClase07;

public class MundoGeometrico {

	public static void main(String[] args) {
		
		Cuadrado [] cuadrados = new Cuadrado[5];
		Rectangulo [] rectangulos = new Rectangulo[5];
		
		for (int i = 0; i<5; i++) {
			cuadrados [i] = new Cuadrado(i + 2, i + 2, '#' );
			rectangulos [i] = new Rectangulo(i + 2, (i + 2)*2, '@' );
		}

		for (int i = 0; i<5; i++) {
			System.out.printf("Cuadrado %d x %d \n", cuadrados[i].altura, cuadrados[i].anchura);
			cuadrados [i].dibujar(); 
			System.out.printf("Rectangulo %d x %d \n", rectangulos[i].altura, rectangulos[i].anchura);
			rectangulos [i].dibujar(); 
		}
		
	}

}
