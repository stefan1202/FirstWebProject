package ro.sda.java57.firstwebproject.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredController {

    @GetMapping
    public String hello(){
        return "Hello stranger!";
    }
}
