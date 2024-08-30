package dev.jaysyat.hospital_management_saiba.controller;

import dev.jaysyat.hospital_management_saiba.entities.Hospital;
import dev.jaysyat.hospital_management_saiba.entities.UserAccount;
import dev.jaysyat.hospital_management_saiba.services.HospitalService;
import dev.jaysyat.hospital_management_saiba.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/createaccount")
    public String viewCreateUserAccountPage(Model model){

        List<Hospital> hospitalList = hospitalService.listAllHospitals();
        model.addAttribute("listofhosptals", hospitalList);
        model.addAttribute("hospital", new Hospital());

        model.addAttribute("userAccount", new UserAccount());
        model.addAttribute("method", "post");
        return "/pages/createAccount";
    }

    @PostMapping("/useraccount/registration")
    public RedirectView saveUserAccount(@ModelAttribute UserAccount userAccount, Model model){
        userAccountService.saveUserAccount(userAccount);
        return new RedirectView("/createaccount");
    }
}
