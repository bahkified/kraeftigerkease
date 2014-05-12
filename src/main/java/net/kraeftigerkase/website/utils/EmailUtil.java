package net.kraeftigerkase.website.utils;

import net.kraeftigerkase.website.dto.EmailDto;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailUtil {
    private static Logger log = LoggerFactory.getLogger(EmailUtil.class);

    // TODO move to config
    private static String user;
    private static String pass;

    private static Properties props;

    static {
        user = "kraeftiger.kaese@gmail.com";
        pass = "Craft.Cheese";

        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    public static void sendMessageToHome(final EmailDto email) throws MessagingException, UnsupportedEncodingException {
        log.debug("Sending mail: [{}]", ToStringBuilder.reflectionToString(email));
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(email.getEmailAddress()));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(user));
        message.addRecipient(Message.RecipientType.CC, new InternetAddress(email.getEmailAddress(), email.getName()));
        message.setReplyTo(InternetAddress.parse(email.getEmailAddress()));
        message.setSubject(email.getSubject());
        message.setText(email.getComments());

        log.debug(ToStringBuilder.reflectionToString(message));

        Transport.send(message);
    }

}
