package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDDUtil {

	public static final String USER = "root";
	public static final String PASS = "1234";
	public static final String BBDD = "restaurante";
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String TIMEZONE = "?serverTimezone=UTC";
	public static final String BBDD_URL = URL+BBDD+TIMEZONE;
	
	public static Connection openConnection() throws SQLException {
		return DriverManager.getConnection(BBDD_URL, USER, PASS);
	}
	
}
