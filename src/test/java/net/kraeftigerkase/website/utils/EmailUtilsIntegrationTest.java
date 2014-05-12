package net.kraeftigerkase.website.utils;

import net.kraeftigerkase.website.dto.EmailDto;
import org.junit.Ignore;

public class EmailUtilsIntegrationTest {

    @Ignore
    public void shouldSendEmailWithCompleteInfo() throws Exception {

        EmailDto dto = new EmailDto();
        dto.setName("Freeman Lo (hey i can change your name too!)");
        dto.setEmailAddress("aschenbach@gmail.com");
        dto.setSubject("This is a test....subject");
        dto.setComments("Yo! I am using Javamail to connect to the gmail smtp servers in order to send this email!");

        EmailUtil.sendMessageToHome(dto);

    }

}
