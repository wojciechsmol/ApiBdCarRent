package com.smol.api.bd.car.rent.apibdcarrent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelpController {

    @RequestMapping("/help")
    public String getHelp(){
        return "help.html";
    }
}
