package ejsClase07;

public abstract class FiguraGeometrica {

	
	protected int altura;
	protected int anchura;
	protected char symbol;
	
	
	
	
	public FiguraGeometrica(int altura, int anchura, char symbol) {
		this.altura = altura;
		this.anchura = anchura;
		this.symbol = symbol;
		
	}
	
	
	public void dibujar(){
		for (int i = 0; i<altura; i++) {
			for (int j = 0; j<anchura; j++) {
				System.out.print(symbol);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
}
