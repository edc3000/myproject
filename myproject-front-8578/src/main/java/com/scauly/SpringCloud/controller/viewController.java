package com.scauly.SpringCloud.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class viewController {
    @RequestMapping(value = "/index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/register")
    public String getregister(){
        return "register";
    }

    @RequestMapping(value = "/login")
    public String getlogin(){
        return "login";
    }

    @RequestMapping(value = "/user")
    public String getuser(){
        return "user";
    }

    @RequestMapping(value = "/admin")
    public String getadmin(){ return "admin"; }

    @RequestMapping(value = "/company")
    public String getcompany(){ return "company"; }
}
