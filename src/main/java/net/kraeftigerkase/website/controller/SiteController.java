package net.kraeftigerkase.website.controller;

import net.kraeftigerkase.website.dto.EmailDto;
import net.kraeftigerkase.website.utils.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SiteController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/index")
    public String getWelcomeScreen() {
        log.debug("Index!");
        return "index";
    }

    @RequestMapping(value = "/contactUs", method = RequestMethod.GET)
    public String getContactUsPage() {
        log.debug("Contact Us page!");
        return "email";
    }

    @RequestMapping(value = "/contactUs", method = RequestMethod.POST)
    public String sendContactEmail(HttpServletRequest request, Model model) {
        EmailDto dto = new EmailDto();
        dto.setName(request.getParameter("name"));
        dto.setSubject(request.getParameter("subject"));
        dto.setPhoneNumber(request.getParameter("phone"));
        dto.setComments(request.getParameter("comments"));
        dto.setEmailAddress(request.getParameter("email"));

        try {
            EmailUtil.sendMessageToHome(dto);
            model.addAttribute("message", "Thank you for message!");
        } catch(Exception e) {
            log.debug("Unable to send email!", e);
            model.addAttribute("message", "We were currently experiencing technical difficulties and were unable"
                    + " to send your message. Please try again later.");
        }

        return "emailResp";
    }

}
