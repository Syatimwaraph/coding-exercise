package dev.jaysyat.hospital_management_saiba.services;

import dev.jaysyat.hospital_management_saiba.entities.PatientHGRGoma;
import dev.jaysyat.hospital_management_saiba.entities.PatientHealAfrica;
import dev.jaysyat.hospital_management_saiba.repositories.PatientHGRGomaRepository;
import dev.jaysyat.hospital_management_saiba.repositories.PatientHealAfricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientHealAfricaService {

    @Autowired
    private PatientHealAfricaRepository healAfricaPatientRepository;

    @Autowired
    private PatientHGRGomaRepository patientHGRGomaRepository;

    public PatientHealAfrica savePatientHealAfrica(PatientHealAfrica patientHealAfrica){
        return healAfricaPatientRepository.save(patientHealAfrica);
    }

    public PatientHealAfrica findById(Long patientId){
        Optional<PatientHealAfrica> patientHealAfrica = healAfricaPatientRepository.findById(patientId);
        if (patientHealAfrica.isEmpty()){
            throw new RuntimeException("This Patient does not exist here");
        }
        return patientHealAfrica.get();
    }

    public List<PatientHealAfrica> patientHealAfricaList(){
        return healAfricaPatientRepository.findAllByIstransferredIsFalse();
    }

    public void deleteHealAfricaPatient(PatientHealAfrica patientHealAfrica){
        Optional<PatientHealAfrica> healAfricaPatientDelete = healAfricaPatientRepository.findById(patientHealAfrica.getHealAfricaPatientId());
        if (healAfricaPatientDelete.isEmpty()){
            throw new RuntimeException("This Patient does not exist here to delete");
        }
        healAfricaPatientRepository.delete(healAfricaPatientDelete.get());
    }

    public boolean transferPatientToHGRGoma(long patientHealAfricaID){
        Optional<PatientHealAfrica> patientHealAfrica = healAfricaPatientRepository.findById(patientHealAfricaID);

        if (patientHealAfrica.isEmpty()){
            return false;
        }
        patientHealAfrica.get().setIstransferred(true);
        healAfricaPatientRepository.save(patientHealAfrica.get());

        System.out.println("The Patient is ... " + patientHealAfrica);

        return true;
    }
    public List<PatientHealAfrica> getTransfered(){
        return healAfricaPatientRepository.findAllByIstransferredIsTrue();
    }

    // work on update function
}

