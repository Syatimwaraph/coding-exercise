package dev.jaysyat.hospital_management_saiba.controller;

import dev.jaysyat.hospital_management_saiba.entities.PatientHGRGoma;
import dev.jaysyat.hospital_management_saiba.entities.PatientHealAfrica;
import dev.jaysyat.hospital_management_saiba.services.PatientHGRGomaService;
import dev.jaysyat.hospital_management_saiba.services.PatientHealAfricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private PatientHGRGomaService patientHGRGomaService;

    @Autowired
    private PatientHealAfricaService patientHealAfricaService;

    @GetMapping("/login")
    public String loginSubmit(){
        return "auth-login";
    }

    @GetMapping("/hgrgomadashboard")
    public String succesLoginGoma(Model model){
        List<PatientHGRGoma> patients = patientHGRGomaService.patientHGRGomaList();
        System.out.println("the list of patients is here " + patients.size());
        model.addAttribute("patients", patients);
        model.addAttribute("transfered", patientHealAfricaService.getTransfered());
        return "hDashboard";
    }
    @GetMapping("/healafricadashboard")
    public String succesLoginHealAfrica(Model model){
        List<PatientHealAfrica> patientHealAfricaList = patientHealAfricaService.patientHealAfricaList();
        System.out.println("the list of patients is here " + patientHealAfricaList.size());
        model.addAttribute("patientsHealAfrica", patientHealAfricaList);
        model.addAttribute("transfered",patientHGRGomaService.getTransfered());
        model.addAttribute("contentPage","pages/healafricadashpage::heal_content");
        return "healDashboard";
    }

//    @GetMapping("/patientsHgrGoma")
//    public String listPatientsHgrGoma(Model model) {
//        List<PatientHGRGoma> patients = patientHGRGomaService.patientHGRGomaList();
//        System.out.println("the list of patients is here " + patients);
//        model.addAttribute("patients", patients);
//        return "pages/hgrgomadashboard";
//    }
}

