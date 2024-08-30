package dev.jaysyat.hospital_management_saiba.controller;

import dev.jaysyat.hospital_management_saiba.entities.Hospital;
import dev.jaysyat.hospital_management_saiba.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegisterHospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/registerhospital")
    public String viewRegisterHospitalPage(Model model){
        model.addAttribute("hospital", new Hospital());
        model.addAttribute("method", "post");
        return "pages/register_hospital";
    }

    @PostMapping("/hospital/registration")
    public RedirectView saveHospital(@ModelAttribute Hospital hospital,Model model){
        hospitalService.saveHospital(hospital);
//        model.addAttribute("success", "data saved succeesssfullty");
        return new RedirectView("/registerhospital");
    }
}
