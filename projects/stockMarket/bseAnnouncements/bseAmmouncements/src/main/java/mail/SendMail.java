package mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import config.Config;

import static constants.Constants.*;

public class SendMail {

	public static void sendData(String mail,String subject) {
		sendData(mail,null,subject);
	}

	public static void sendData(String mail,String attachment,String subject) {    
		final String fromEmail = Config.getConfig(EMAIL_FROM_ADD); //requires valid gmail id
		final String password = Config.getConfig(EMAIL_FROM_DATA); // correct password for gmail id
		final String toEmail = Config.getConfig(EMAIL_TO_ADD); // can be any email id 

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

		//create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		if(attachment !=null) {
			sendEmailWithScreenshot(session, toEmail,subject, mail,fromEmail,attachment);
		}else {
			sendEmail(session, toEmail,subject, mail,fromEmail);
		}
	}
	public static void sendEmail(Session session, String toEmail, String subject, String body,String fromEmail){
		try
		{
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromEmail, "Notification"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setContent(body, "text/HTML");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);  

			System.out.println("EMail Sent Successfully!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendEmailWithScreenshot(Session session, String toEmail, String subject, String body,String fromEmail, String attachment){
		try
		{
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromEmail, "Buyback Notification"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);

			BodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source = new FileDataSource(attachment);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(attachment); 

			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart2);
			
			msg.setContent(multipart);

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);  

			System.out.println("EMail Sent Successfully!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}




