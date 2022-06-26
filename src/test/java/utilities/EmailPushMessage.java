package utilities;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailPushMessage implements TestResultMessage {


    @Override
    public void pushTestResultMessage(String textMessage) throws Exception {

        String from = "frytestautomation@gmail.com";
        String pass = "Maltepe2362..";
        String to = "framazanyilmaz@gmail.com";
        String host = "smtp.gmail.com";


        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, pass);
                    }
                });

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.addRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));

        message.setSubject("Koinal Test Result...");

        message.setText(textMessage);

        Transport.send(message);


    }
}

