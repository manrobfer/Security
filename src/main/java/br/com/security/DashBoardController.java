package br.com.security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashBoardController {

    @GetMapping("/")
    public String Mainpage(){
        return "welcome dashboard";
    }
}
