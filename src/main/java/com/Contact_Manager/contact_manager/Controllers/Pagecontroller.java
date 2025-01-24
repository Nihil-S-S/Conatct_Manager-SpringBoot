package com.Contact_Manager.contact_manager.Controllers;

import com.Contact_Manager.contact_manager.Services.UserServices;
import com.Contact_Manager.contact_manager.entities.Contact;
import com.Contact_Manager.contact_manager.entities.User;
import com.Contact_Manager.contact_manager.forms.UserForm;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@AllArgsConstructor
@Controller
public class Pagecontroller {

    private UserServices userServices;

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
//        userForm.setName("nihil");
        model.addAttribute("userForm",userForm);
        return "register";
    }

//    processing register
    @PostMapping(value = "/do-register")
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session){

        boolean existingUser = userServices.isUserExistByEmailId(userForm.getEmail());
        if (existingUser) {
            // Handle duplicate email scenario, return error or show message
            return "redirect:/register?error=emailExists";
        }
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.freepik.com/premium-vector/avatar-flat-style-person-social-media-teenager-male-female-face_94362221.htm#fromView=keyword&page=1&position=22&uuid=0a4e8d2a-fac4-419c-9506-b492f84ed3d0&query=Default+User");

        userServices.saveUser(user);

        System.out.println("user saved :");

        session.setAttribute("message","Registration Successfull");
        return "redirect:/register";

    }


}
