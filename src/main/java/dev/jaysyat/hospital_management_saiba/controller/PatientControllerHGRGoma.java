package dev.jaysyat.hospital_management_saiba.controller;

import dev.jaysyat.hospital_management_saiba.entities.PatientHGRGoma;
import dev.jaysyat.hospital_management_saiba.services.PatientHGRGomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PatientControllerHGRGoma {
    @Autowired
    private PatientHGRGomaService patientHGRGomaService;

    @GetMapping("/registerpatienthgrgoma")
    public String showRegisterPatientHgrGoma(Model model){
        model.addAttribute("patientHGRGoma", new PatientHGRGoma());
        model.addAttribute("method", "post");
        return "pages/register_patient_hgrgoma";
    }

    @PostMapping("/hgrgoma")
    public RedirectView savePatientHGRGoma(@ModelAttribute PatientHGRGoma patientHGRGoma, Model model){
        patientHGRGomaService.savePatientHGRGoma(patientHGRGoma);
        listPatientsHgrGoma(model);
        return new RedirectView("/registerpatienthgrgoma");
    }

    @GetMapping("/patientsHgrGoma")
    public String listPatientsHgrGoma(Model model) {
        List<PatientHGRGoma> patients = patientHGRGomaService.patientHGRGomaList();
        System.out.println("the list of patients is here " + patients.size());
        model.addAttribute("patients", patients);
        return "pages/hgrgomadashboard";
    }

    @PostMapping("/hg/transfer/{patientId}")
    public ResponseEntity<String> transferPatientToHealAfrica(@PathVariable("patientId") long patientId) {
        try {
            boolean isTransferred = patientHGRGomaService.transferPatientToHealAfrica(patientId);
            if (isTransferred) {
                System.out.println("The patient that you transfered has ID " + patientId);
                return ResponseEntity.ok("Patient transferred successfully to HGR Goma");
            } else {
                return ResponseEntity.status(500).body("Failed to transfer the patient");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
