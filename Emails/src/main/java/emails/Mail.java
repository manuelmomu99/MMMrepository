package emails;

import java.sql.Date;
import java.time.LocalDate;

public class Mail {
	private int ID;
	private Date date;
	private String subject;
	private String text;
	private boolean opened;
	private String emailSender;
	private String emailReceiver;





// CONSTRUCTORES
	public Mail(Date date, String subject, String text, boolean opened, String emailSender,
			String emailReceiver) {
		super();
		this.date = date;
		this.subject = subject;
		this.text = text;
		this.opened = opened;
		this.emailSender = emailSender;
		this.emailReceiver = emailReceiver;
	}

	

	public Mail() {

	}

	// GETTERS AND SETTERS
	
	// ID
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	// Date
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	// Subject
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	// Text
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	// Opened
	public boolean isOpened() {
		return opened;
	}
	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	// Sender
	public String getEmailSender() {
		return emailSender;
	}
	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}

	// Receiver
	public String getEmailReceiver() {
		return emailReceiver;
	}
	public void setEmailReceiver(String emailReceiver) {
		this.emailReceiver = emailReceiver;
	}




}
