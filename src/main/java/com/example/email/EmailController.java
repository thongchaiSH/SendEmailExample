package com.example.email;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.Message;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {
    @RequestMapping(value = "/sendemail")
    public String sendEmail() throws IOException, MessagingException {
        sendmail();
        return "Email sent successfully";
    }

    private void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "*");


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("thongchai.sh@gmail.com", "0487682596");
            }
        });
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("thongchai.sh@gmail.com", false));

        msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse("thongchai_s@softsquaregroup.com"));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email", "text/html");
        msg.setSentDate(new Date());
        
        Transport.send(msg);
    }
}
