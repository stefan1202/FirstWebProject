package ro.sda.java57.firstwebproject.controler;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.java57.firstwebproject.entities.UserEntity;
import ro.sda.java57.firstwebproject.model.User;
import ro.sda.java57.firstwebproject.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class HelloWorldController {

    private static List<User> users = new ArrayList<User>();
    private final UserRepository userRepository;
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
        UserEntity entity = new UserEntity();
        entity.setAge(userObject.getAge());
        entity.setName(userObject.getName());
        entity.setEmail(userObject.getEmail());
        userRepository.save(entity);
        var result = userRepository.findAllByNameAndAgeGreaterThan("Stefan",45);
//        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("userList", result);

        return "userList";
    }

}
