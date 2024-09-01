package dev.jaysyat.hospital_management_saiba.controller;

import dev.jaysyat.hospital_management_saiba.entities.PatientHGRGoma;
import dev.jaysyat.hospital_management_saiba.services.PatientHGRGomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private PatientHGRGomaService patientHGRGomaService;

    @GetMapping("/login")
    public String loginSubmit(){
        return "auth-login";
    }

    @GetMapping("/hgrgomadashboard")
    public String succesLoginGoma(){
        return "pages/hgrgomadashpage";
    }
    @GetMapping("/healafricadashboard")
    public String succesLoginHealAfrica(){
        return "pages/healafricadashpage";
    }

    @GetMapping("/patientsHgrGoma")
    public String listPatientsHgrGoma(Model model) {
        List<PatientHGRGoma> patients = patientHGRGomaService.patientHGRGomaList();
        System.out.println("the list of patients is here " + patients);
        model.addAttribute("patients", patients);
        return "pages/hgrgomadashboard";
    }
}

