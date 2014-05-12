package net.kraeftigerkase.website.service;

import net.kraeftigerkase.website.dto.EmailDto;
import org.junit.Before;
import org.junit.Ignore;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Properties;

import static org.mockito.Mockito.when;

public class EmailUtilsIntegrationTest {

    private EmailService emailService;

    @Mock
    private Properties props;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(props.getProperty("smtp.prop.host.name")).thenReturn("mail.smtp.host");
        when(props.getProperty("smtp.prop.host.value")).thenReturn("smtp.gmail.com");
        when(props.getProperty("smtp.prop.port.name")).thenReturn("mail.smtp.socketFactory.port");
        when(props.getProperty("smtp.prop.port.value")).thenReturn("465");
        when(props.getProperty("smtp.prop.class.name")).thenReturn("mail.smtp.socketFactory.class");
        when(props.getProperty("smtp.prop.class.value")).thenReturn("javax.net.ssl.SSLSocketFactory");
        when(props.getProperty("smtp.prop.auth.name")).thenReturn("mail.smtp.auth");
        when(props.getProperty("smtp.prop.auth.value")).thenReturn("true");
        when(props.getProperty("smtp.port.name")).thenReturn("mail.smtp.port");
        when(props.getProperty("smtp.port.value")).thenReturn("465");

        when(props.getProperty("contact.username")).thenReturn("kraeftiger.kaese@gmail.com");
        when(props.getProperty("contact.password")).thenReturn("Craft.Cheese");

        this.emailService = new EmailService(props);
    }

    @Ignore
    public void shouldSendEmailWithCompleteInfo() throws Exception {

        EmailDto dto = new EmailDto();
        dto.setName("Freeman Lo (hey i can change your name too!)");
        dto.setEmailAddress("aschenbach@gmail.com");
        dto.setSubject("This is a test....subject");
        dto.setComments("Yo! I am using Javamail to connect to the gmail smtp servers in order to send this email!");

        emailService.sendMessageToHome(dto);

    }

}
