package net.kraeftigerkase.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {

    @RequestMapping("index")
    public String getWelcomeScreen() {
        return "index";
    }

}
