package org.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/admin")

@Controller
public class AdminHomeController {

    @RequestMapping("/welcome")
    public String welcome(){
        return "/admin/welcome";
    }

    @RequestMapping("/logout")
    public String legout(HttpSession session){
        session.invalidate();
        return "/admin/login";
    }
}
