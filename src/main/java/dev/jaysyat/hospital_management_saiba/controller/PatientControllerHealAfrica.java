package dev.jaysyat.hospital_management_saiba.controller;

import dev.jaysyat.hospital_management_saiba.entities.PatientHealAfrica;
import dev.jaysyat.hospital_management_saiba.services.PatientHealAfricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PatientControllerHealAfrica {
    @Autowired
    private PatientHealAfricaService patientHealAfricaService;

    @GetMapping("/registerpatienthealafrica")
    public String showRegisterPatientPage(Model model){

        model.addAttribute("patienthealAfrica", new PatientHealAfrica());
        model.addAttribute("method", "post");
        return "pages/register_patient_healafrica";
    }

    @PostMapping("/registerpatient/healafrica")
    public RedirectView savePatient(@ModelAttribute PatientHealAfrica patientHealAfrica, Model model){
        patientHealAfricaService.savePatientHealAfrica(patientHealAfrica);
        return new RedirectView("/registerpatienthealafrica");
    }
}
