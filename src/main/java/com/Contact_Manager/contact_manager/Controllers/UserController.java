package com.Contact_Manager.contact_manager.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/dashboard")
    public String userDashboard() {
        System.out.println("User dashboard");
        return "user/dashboard";
    }

    @GetMapping("/profile")
    public String userProfile(){
        return "user/profile";
    }



}