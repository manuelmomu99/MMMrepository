package main;

import java.sql.Date;
import java.time.LocalDate;



import dataAccess.FingerprintDAOJPAImpl;
import dataAccess.UserDAO;
import dataAccess.UserDAOJPAImpl;
import model.Fingerprint;
import model.User;

public class Main {

	public static void main(String[] args) {
		

		UserDAO userDao= new UserDAOJPAImpl();
		FingerprintDAOJPAImpl fingerDao = new FingerprintDAOJPAImpl();
		
//		User user = new User();
//		user.setEmail("maria@gmail.com");
//		user.setLast_access(Date.valueOf(LocalDate.now()));
//		user.setUser_name("Maria");
//		user.setUser_password("1234");
		
		
		User user = userDao.read(9);
		
		Fingerprint huella = new Fingerprint();
		huella.setFinger("Pulgar");
		huella.setImage("/a/a/a/d");
		huella.setScandate(Date.valueOf(LocalDate.now()));
		huella.setUser(user);
		
	
		user.setFingerprint(huella);
		userDao.update(user);
		fingerDao.create(huella);
		
		;
		//System.out.println(fingerDao.read(1).getFinger());

		
	}
}
