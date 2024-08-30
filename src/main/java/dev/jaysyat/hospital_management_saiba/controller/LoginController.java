package dev.jaysyat.hospital_management_saiba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginSubmit(){
        return "/pages/auth-login";
    }

    @GetMapping("/hgrgoma")
    public String succesLoginGoma(){
        return "/pages/hgrgomadashpage";
    }
    @GetMapping("/healafricadashboard")
    public String succesLoginHealAfrica(){
        return "/pages/healafricadashpage";
    }
}