package ejsClase06;

public class MMM_Titular {

	private String nombre;
	private String usuario;
	private String contrasena;
	
	
	
	public  MMM_Titular(){
		
	}
	
	public MMM_Titular (String Nombre, String Usuario, String Contrasena) {
		this.nombre = Nombre;
		this.usuario = Usuario;
		this.contrasena = Contrasena;
	}
	
	
	
	
	// ########## GETTERS Y SETTERS ################
	
	// Nombre
	public String getNombre() {
		return nombre;
	}
	
	// Usuario
	public String getUsuario() {
		return usuario;
	}
	
	// Contraseña
	public String getContrasena() {
		return contrasena;
	}
	
	
	
	
}
