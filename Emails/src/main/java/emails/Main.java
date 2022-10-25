package emails;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

	
	// CONSTANTES
	static final int LOGIN = 1;
	static final int NEW_USER = 2;
	static final int EXIT = 3;
	static final int SEND = 1;
	static final int SHOW_RECEIVED_MAILS = 2;
	static final int SHOW_SENT_MAILS = 3;
	static final int CLOSE_SESSION = 4;
	
	
	
	// METODOS
	
	// Login
	public static void login() throws SQLException{
		String[] user_credentials = Menus.show_login_menu();
		String user_email = user_credentials[0];
		String user_password = user_credentials[1];
		
		Users user = UserService.get(user_email, user_password);
		if (user.getName() != null) {
			UserService.uptdateLastAccess(user.getEmail());
			execute_options(user);
		}
		
	}
	
	
	
	public static void execute_options(Users user) {
		boolean end = false;
		do {
			int option = Menus.show_user_incerface(user);
			switch (option) {
			case SEND:
				try {
					MailService.sendMail(user);
				} catch (SQLException e) {
					System.out.println("Error al abrir la base de datos.");
					e.printStackTrace();
				}
				break;
			case SHOW_RECEIVED_MAILS:
				break;
			case SHOW_SENT_MAILS:
				break;
			case CLOSE_SESSION:
				end = true;
				break;
			default:
				System.out.println("Opción no válida. Introduzca una opción válida. \n");
			}
		} while (end == false);
	}
	
	
	// Nuevo usuario
	public static void create_new_user() throws SQLException {
		// Pedimos nuevos credenciales
		String[] new_user_credentials = Menus.show_register_menu();
		String user_email = new_user_credentials[0];
		String user_password = new_user_credentials[1];

		// Vemos si ya existe el email
		boolean user_email_exists = UserService.exists(user_email);

		// Si ya existe, nada. Si no existe, lo creamos
		if (user_email_exists == true) {
			System.out.println("Este email ya existe. \n");
		} else {
			String[] name_surname = Menus.get_user_name();
			String user_name = name_surname[0];
			String user_surname = name_surname[1];
			Date user_lastAccess = Date.valueOf(LocalDate.now());

			Users new_user = new Users();
			new_user.setEmail(user_email);
			new_user.setPassword(user_password);
			new_user.setName(user_name);
			new_user.setSurname(user_surname);
			new_user.setLastAccess(user_lastAccess);
		
			UserService.create(new_user);
			System.out.println("");
		}
	}
	
	
	// MAIN
	public static void main(String[] args) {
		boolean end = false;
		
		do {
			int option = Menus.show_initial_menu();
			switch (option) {
			case LOGIN:
				try {
					login();
					} catch (SQLException e) {
						System.out.println("Error al abrir la base de datos.");
						e.printStackTrace();
					}
				break;
			case NEW_USER:
				try {
				create_new_user();
				} catch (SQLException e) {
					System.out.println("Error al abrir la base de datos.");
					e.printStackTrace();
				}
				break;
			case EXIT:
				end = true;
				break;
			default:
				System.out.println("Opción no válida. Introduzca una opción válida. \n");
			}
		} while (end == false);
		
		
		
	}

}
