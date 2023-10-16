package utility;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	public static void sendEmail(Session session, String toEmail, String subject, String body) throws MessagingException {

		MimeMessage msg = new MimeMessage(session);
		msg.addHeader("Content-type", "text/html; charset=UTF-8");
		msg.addHeader("format", "flowed");
		msg.addHeader("Content-Transfer-Encoding", "8-bit");

		msg.setSubject(subject, "UTF-8");

		msg.setText(body, "UTF-8");

		msg.setSentDate(new Date());

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		System.out.println("Message is ready");
		Transport.send(msg);

		System.out.println("EMail Sent Successfully!!");

	}
}
