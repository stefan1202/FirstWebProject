package ro.sda.java57.firstwebproject.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("userForm", new User());
        return "userForm";
    }

    @PostMapping("/user")
    public String createUser(User userForm, Model model){
        //Todo just to keep the same data
        model.addAttribute("userForm", userForm);
        System.out.println(userForm);
        return "userForm";
    }

}
