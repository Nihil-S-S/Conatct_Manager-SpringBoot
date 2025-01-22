package com.Contact_Manager.contact_manager.Controllers;

import com.Contact_Manager.contact_manager.entities.Contact;
import com.Contact_Manager.contact_manager.forms.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Pagecontroller {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("home handler page");
        model.addAttribute("name","Substring Tech");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(){
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage(){
        return "services";
    }

    @GetMapping("/contact")
    public String contactPage(){
        return "contact";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        UserForm userForm = new UserForm();
        userForm.setName("nihil");
        model.addAttribute("userForm",userForm);
        return "register";
    }

//    processing register
    @PostMapping(value = "/register")
    public String processorRegister(@ModelAttribute UserForm userForm){
        System.out.println(userForm);
        return "redirect:/register";

    }


}
