package ejsClase03;

public class MMM_Poema {

	public static void main(String[] args) {


		String cadena = "No entres dócilmente en esa buena noche."
				+ "La vejez debería delirar y arder cuando se acaba el día."
				+ "Rabia, rabia, contra la luz que se esconde."
				+ "Aunque el sabio cerca del fin a la tiniebla no haga reproche,"
				+ "dado que a su verbo ningún rayo ha confiado vigor,"
				+ "no entra dócilmente en esa buena noche."
				+ "Rabia, rabia, contra la luz que se esconde.";
		
		cadena = cadena.toLowerCase();
		cadena = cadena.replace("a", "á");
		cadena = cadena.replace("e", "é");
		cadena = cadena.replace("i", "í");
		cadena = cadena.replace("o", "ó");
		cadena = cadena.replace("u", "ú");
		
		char carray[] = cadena.toCharArray();

		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		for (char k : carray) {
			switch (k) {

			case 'a':	a++;  break;
			case 'e':	e++;  break;
			case 'i':	i++;  break;
			case 'o':   o++;  break;
			case 'u':   u++;  break;
			};
		}
		
		
		System.out.println("Número de letras 'a': "+a);
		System.out.println("Número de letras 'e': "+e);
		System.out.println("Número de letras 'i': "+i);
		System.out.println("Número de letras 'o': "+o);
		System.out.println("Número de letras 'u': "+u);
		System.out.println("Número total de caracteres: "+ cadena.length());
		
		
		
	}
}
