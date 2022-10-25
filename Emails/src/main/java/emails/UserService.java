package emails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

public class UserService {
	
	public static boolean exists(String email) throws SQLException {
		// Abrimos conexion
		Connection con = BBDDUtil.openConnection();
		
		// Prepared statement
		String st = "SELECT * FROM USERS " + "WHERE EMAIL LIKE ?";
		PreparedStatement pst = con.prepareStatement(st.toString());
		pst.setString(1, email);

		// Query y resultados
		ResultSet listaEmails = pst.executeQuery();
		
		// Comprobamos si el email existe
		int num_users = 0;
		while (listaEmails.next()) {
			num_users++;
		}
		boolean email_exists = (num_users != 0);
		
		// Cerramos la conexion
		con.close();
		
		return email_exists;
	};
	
	public static boolean create(Users newUser) throws SQLException {

		boolean succesful_creation = false;

		// Recogemos los atributos del nuevo usuario
		String user_email = newUser.getEmail();
		String user_password = newUser.getPassword();
		String user_name = newUser.getName();
		String user_surname = newUser.getSurname();
		Date user_lastAccess = newUser.getLastAccess();


			// Abrimos conexion
			Connection con = BBDDUtil.openConnection();

			// Prepared statement
			String st = "INSERT INTO USERS (EMAIL, USER_NAME, SURNAME, USER_PASSWORD, LAST_ACCESS) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(st.toString());
			pst.setString(1, user_email);
			pst.setString(2, user_name);
			pst.setString(3, user_surname);
			pst.setString(4, user_password);
			pst.setDate(5, user_lastAccess);

			// Query
			try {
				pst.executeUpdate();
				System.out.println("Usuario añadido correctamente");
				succesful_creation = true;
			} catch (SQLException e) {
				System.out.println("Error al añadir el usuario");
				e.printStackTrace();
			}
			con.close();

		return succesful_creation;
	}
	
	public static Users get(String email, String password) throws SQLException {
		Users user = new Users();

		// Abrimos conexion
		Connection con = BBDDUtil.openConnection();

		// Prepared statement
		String st = "SELECT * FROM USERS WHERE EMAIL LIKE ? AND USER_PASSWORD LIKE ?";
		PreparedStatement pst = con.prepareStatement(st.toString());
		pst.setString(1, email);
		pst.setString(2, password);

		// Query
		try {
			ResultSet listaEmails = pst.executeQuery();
			while (listaEmails.next()) {
				user.setEmail(listaEmails.getString("EMAIL"));
				user.setPassword(listaEmails.getString("USER_PASSWORD"));
				user.setName(listaEmails.getString("USER_NAME"));
				user.setSurname(listaEmails.getString("SURNAME"));
				user.setLastAccess(listaEmails.getDate("LAST_ACCESS"));
			}
			// Comprobamos si el email existe
			if ((user.getName() == null) == true) {
				System.out.println("Este usuario no existe. \n");
			}
		} catch (SQLException e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
		con.close();
		return user;
	};

	public static boolean uptdateLastAccess(String email) throws SQLException{
		boolean successful_modification = false;
		
		// Abrimos conexion
		Connection con = BBDDUtil.openConnection();

		// Prepared statement
		String st = "UPDATE USERS SET LAST_ACCESS = ? WHERE EMAIL LIKE ?";
		PreparedStatement pst = con.prepareStatement(st.toString());
		pst.setDate(1, Date.valueOf(LocalDate.now()));
		pst.setString(2, email);
		// Query
		try {
			pst.executeUpdate();
			successful_modification = true;
		} catch (SQLException e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
		con.close();
		
		return successful_modification;
	}
	
}
