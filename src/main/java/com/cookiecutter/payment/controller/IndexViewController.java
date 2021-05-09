package com.cookiecutter.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A simple Controller for Spring to map the homepage
 * @author      Farzan Zubair
 */

@Controller
class IndexViewController {


    /**
     * Forwards to the accounts page
     * @return String
     */

    @RequestMapping({
            "/"
    })
    public String index() {
        return "forward:/accounts.xhtml";
    }
}