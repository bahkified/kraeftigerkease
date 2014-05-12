package net.kraeftigerkase.website.service;

import net.kraeftigerkase.website.dto.EmailDto;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Service
public class EmailService {
    private static Logger log = LoggerFactory.getLogger(EmailService.class);

    @Resource(name = "contactProperties")
    private Properties contactProperties;

    public EmailService() {  }

    /**
     * Constructor for testing.
     *
     * @param contactProperties
     */
    public EmailService(Properties contactProperties) {
        this.contactProperties = contactProperties;
    }

    /**
     * <p>
     *     From the contents of an HTTP request, gather the information necessary to form an email. This includes the
     *     sender's name and email address, the email subject, the email body content.
     * </p>
     *
     * @param request
     * @return
     */
    public EmailDto adaptRequest(HttpServletRequest request) {
        EmailDto dto = new EmailDto();

        // TODO sanitize inputs!
        dto.setName(request.getParameter("name"));
        dto.setSubject(request.getParameter("subject"));
        dto.setPhoneNumber(request.getParameter("phone"));
        dto.setComments(request.getParameter("comments"));
        dto.setEmailAddress(request.getParameter("email"));

        return dto;
    }

    /**
     * <p>
     *     From an email dto, construct and send an email to those who can respond. CC the client as well.
     * </p>
     *
     * @param email Information to form the email including replyTo address, message content, message subject, etc.
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public void sendMessageToHome(final EmailDto email) throws MessagingException, UnsupportedEncodingException {
        log.debug("Sending mail: [{}]", ToStringBuilder.reflectionToString(email));

        final String user = contactProperties.getProperty("contact.username");
        final String pass = contactProperties.getProperty("contact.password");

        Properties props = new Properties();
        initProps(props);

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

    private void initProps(Properties props) {
        props.put(contactProperties.getProperty("smtp.prop.host.name"),
                contactProperties.getProperty("smtp.prop.host.value"));
        props.put(contactProperties.getProperty("smtp.prop.port.name"),
                contactProperties.getProperty("smtp.prop.port.value"));
        props.put(contactProperties.getProperty("smtp.prop.class.name"),
                contactProperties.getProperty("smtp.prop.class.value"));
        props.put(contactProperties.getProperty("smtp.prop.auth.name"),
                contactProperties.getProperty("smtp.prop.auth.value"));
        props.put(contactProperties.getProperty("smtp.port.name"),
                contactProperties.getProperty("smtp.port.value"));
    }

}
