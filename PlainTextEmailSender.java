package net.codejava.mail;

import java.util.Date;
import java.util.Properties;

import java.mail.Authenticator;
import java.mail.Message;
import java.mail.MessagingException;
import java.mail.PasswordAuthentication;
import java.mail.Session;
import java.mail.Transport;
import java.mail.internet.AddressException;
import java.mail.internet.InternetAddress;
import java.mail.internet.MimeMessage;

public class PlainTextEmailSender {

	public void sendPlainTextEmail(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message) throws AddressException,
			MessagingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		// set plain text message
		msg.setText(message);

		// sends the e-mail
		Transport.send(msg);

	}

	/**
	 * Test the send e-mail method
	 *
	 */
	public static void main(String[] args) {
		// SMTP server information
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "user_email";
		String password = "email_pass";

		// outgoing message information
		String mailTo = "hainatu@gmail.com";
		String subject = "Hello my friend";
		String message = "Hi guy, Hope you are doing well. Duke.";

		PlainTextEmailSender mailer = new PlainTextEmailSender();

		try {
			mailer.sendPlainTextEmail(host, port, mailFrom, password, mailTo,
					subject, message);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Failed to sent email.");
			ex.printStackTrace();
		}
	}
}