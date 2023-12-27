package org.ecom.controller;

import org.ecom.entity.WebUser;
import org.ecom.service.IWebUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class WebUserController {

    @Resource
    private IWebUserService iWebUserService;
    // Resource
    @RequestMapping("login_show")
    public String login_show(){
        return "/user/login";
    }

    @RequestMapping("/login_submit")
    public String login_submit(WebUser webUser, HttpSession session, Model model){
        // check username and password
        WebUser u = iWebUserService.webUserLogin(webUser);
        // if account is not existing
        if(u == null){
            model.addAttribute("error","Username or password is not correct");
            return "/user/login";
        }

        // save account into session
        session.setAttribute("webUser",u);
        return "/front/index";
    }

    // Sign Up
    @RequestMapping("/signUp_show")
    public String signUp_show(){
        return "/user/signUp";
    }

    @RequestMapping("/signUp_submit")
    public String signUp_submit(WebUser webUser, Model model) {
        try {
            WebUser existingUser = iWebUserService.findByUserName(webUser.getUserName());
            if (existingUser != null) {
                model.addAttribute("error", "Username already exists");
                return "user/signUp";
            }
            iWebUserService.webUserSignUp(webUser);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred during sign up");
            return "user/signUp";
        }
        return "/front/index";
    }

}
