package dev.jaysyat.hospital_management_saiba.services;

import dev.jaysyat.hospital_management_saiba.entities.PatientHGRGoma;
import dev.jaysyat.hospital_management_saiba.entities.PatientHealAfrica;
import dev.jaysyat.hospital_management_saiba.repositories.PatientHGRGomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientHGRGomaService {

    @Autowired
    private PatientHGRGomaRepository patientHGRGomaRepository;

    public PatientHGRGoma savePatientHGRGoma(PatientHGRGoma patientHGRGoma){
        return patientHGRGomaRepository.save(patientHGRGoma);
    }

    public PatientHGRGoma findById(Long patientId){
        Optional<PatientHGRGoma> patientHGRGoma = patientHGRGomaRepository.findById(patientId);
        if (patientHGRGoma.isEmpty()){
            throw new RuntimeException("This Patient does not exist here");
        }
        return patientHGRGoma.get();
    }

    public List<PatientHGRGoma> patientHGRGomaList(){
        return patientHGRGomaRepository.findAll();
    }

    public void deletePatientHGRGoma(PatientHGRGoma patientHGRGoma){
        Optional<PatientHGRGoma> patientHGRGomadelete = patientHGRGomaRepository.findById(patientHGRGoma.getHgrGomaPatientId());
        if (patientHGRGomadelete.isEmpty()){
            throw new RuntimeException("This Patient does not exist here to delete");
        }
        patientHGRGomaRepository.delete(patientHGRGomadelete.get());
    }

    // work on update function

}
