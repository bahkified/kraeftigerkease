package net.kraeftigerkase.website.controller;

import net.kraeftigerkase.website.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SiteController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmailService emailService;

    @RequestMapping("/index")
    public String getWelcomeScreen() {
        log.debug("Index!");
        return "index";
    }

    @RequestMapping("/news")
    public String getNewsScreen() {
        return "news";
    }

    @RequestMapping("/projects")
    public String getProjectsScreen() {
        return "projects";
    }

    @RequestMapping("/downloads")
    public String getDownloadsScreen() {
        return "downloads";
    }

    @RequestMapping("/spyware")
    public String getSpywareScreen() {
        return "spyware";
    }

    @RequestMapping("openSSL")
    public String getOpenSSLScreen() {
        return "openSSL";
    }

    @RequestMapping(value = "/contactUs", method = RequestMethod.GET)
    public String getContactUsPage() {
        log.debug("Contact Us page!");
        return "email";
    }

    @RequestMapping(value = "/contactUs", method = RequestMethod.POST)
    public String sendContactEmail(HttpServletRequest request, Model model) {
        try {
            emailService.sendMessageToHome(emailService.adaptRequest(request));
            model.addAttribute("message", "Thank you for message!");
        } catch(Exception e) {
            log.debug("Unable to send email!", e);
            model.addAttribute("message", "We were currently experiencing technical difficulties and were unable"
                    + " to send your message. Please try again later.");
        }

        return "emailResp";
    }

}
