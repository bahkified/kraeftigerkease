package net.kraeftigerkase.website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("index")
    public String getWelcomeScreen() {
        log.debug("Index!");
        return "index";
    }

    @RequestMapping("contactUs")
    public String getContactUsPage() {
        log.debug("Contact Us page!");
        return "email";
    }

}
