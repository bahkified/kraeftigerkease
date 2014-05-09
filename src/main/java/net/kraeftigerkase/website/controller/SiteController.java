package net.kraeftigerkase.website.controller;

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

    @RequestMapping("/")
    public String goHome() {
        log.debug("Home");
        return "layout";
    }

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
        model.addAttribute("message", "This was a triumph!");
        return "emailResp";
    }

}
