package ro.sda.java57.firstwebproject.controler;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.java57.firstwebproject.model.User;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorld(Model modelMap){
        modelMap.addAttribute("attributeName", "Hello2 message from ThymeLeaf!");
        return "helloWorld";
    }
    @GetMapping("/hello3")
    public String secondView(){
        return "userForm";
    }

    @GetMapping("/user")
    public String showUserForm(Model model){
        model.addAttribute("userObject", new User());
        return "userForm";
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute("userObject") @Valid User userObject, Errors errors,
                             Model model){
        if( errors.hasErrors()){
            return "userForm";
        }
        //Todo just to keep the same data
        model.addAttribute("userForm", userObject);
        System.out.println(userObject);
        return "userForm";
    }

}
