package DataController;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {
    public static final int Signupmail = 0, Loginmail = 1, SMSMail = 2, RecieptMail = 3;

    public static void SendEmail(String recepient, String Title, String Text) {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "HAT.Sender.Service@gmail.com";
        String password = "HAT_Logo_Ghost_VLB_80_81_81";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(Title);
            message.reply(false);

            message.setText(Text);

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
