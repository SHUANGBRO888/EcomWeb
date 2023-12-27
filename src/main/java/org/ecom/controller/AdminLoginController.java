package org.ecom.controller;

import org.ecom.entity.AdminUser;
import org.ecom.service.IAdminUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
@RequestMapping("/admin")
@Controller
public class AdminLoginController {
    @Resource
    private IAdminUserService usersService;

    @RequestMapping("login_show")
    public String login_show(){
        return "/admin/login";
    }

    @RequestMapping("/login_submit")
    public String login_submit(AdminUser adminUser, HttpSession session, Model model){
        // check username and password
        AdminUser u = usersService.adminLogin(adminUser);
        // if account is not existing
        if(u == null){
            model.addAttribute("error","Username or password is not correct");
            return "/admin/login";
        }

        // save account into session
        session.setAttribute("adminUser",u);
        return "/admin/index";
    }

}
