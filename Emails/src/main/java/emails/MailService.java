package emails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import emails.BBDDUtil;

public class MailService {

	static Scanner scSTRING = new Scanner(System.in);
	
	public static boolean sendMail(Users user) throws SQLException{
		boolean successful_mail = false;
		System.out.println("Introduzca la dirección a la que quiere enviar el mensaje:");
		String email_receiver = scSTRING.nextLine();
		System.out.println("Introduzca el asunto del mensaje:");
		String subject = scSTRING.nextLine();
		System.out.println("Introduzca el mensaje:");
		String text = scSTRING.nextLine();
		
		System.out.println("");
		
		Mail mail = new Mail();
		mail.setEmailSender(user.getEmail());
		mail.setEmailReceiver(email_receiver);
		mail.setOpened(false);
		mail.setDate(Date.valueOf(LocalDate.now()));
		mail.setSubject(subject);
		mail.setText(text);
		
		// Abrimos conexion
		Connection con = BBDDUtil.openConnection();

		// Prepared statement
		String st = "INSERT INTO MAILS (MAIL_DATE, MAIL_SUBJECT, MAIL_TEXT, OPENED, MAIL_EMISSARY, MAIL_RECEPTOR) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(st.toString());
		pst.setDate(1, mail.getDate());
		pst.setString(2, mail.getSubject());
		pst.setString(3, mail.getText());
		pst.setBoolean(4, mail.isOpened());
		pst.setString(5, mail.getEmailSender());
		pst.setString(6, mail.getEmailReceiver());

		// Query
		try {
			pst.executeUpdate();
			System.out.println("Mensaje enviado correctamente. \n");
			successful_mail = true;
		} catch (SQLException e) {
			System.out.println("Error al enviar el usuario. \n");
			e.printStackTrace();
		}
		con.close();
		return successful_mail;
	};
	
	
	
//	public static List <Mail> getInBox (Users user) throws SQLException {
//		List <Mail> inBox = new ArrayList<Mail>();
//		
//		// Abrimos conexion
//		Connection con = BBDDUtil.openConnection();
//
//		// Prepared statement
//		String st = "SELECT * FROM MAILS WHERE MAIL_RECEPTOR LIKE ?";
//		PreparedStatement pst = con.prepareStatement(st.toString());
//		pst.setString(1, user.getEmail());
//		
//
//		
//		// Query
//
//		ResultSet mailList = pst.executeQuery();
//		while (mailList.next()) {
//			;
//		}
//		
//		
//		
//		con.close();
//		return inBox;
//	};
//	public static void List <Mail> getOutBox(){};

//	public static boolean openMail() {};
//	public static boolean deleteMail() {};
}
