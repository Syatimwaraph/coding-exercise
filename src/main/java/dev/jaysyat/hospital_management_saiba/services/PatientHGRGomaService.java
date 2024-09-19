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
public class PatientHGRGomaService {

    @Autowired
    private PatientHGRGomaRepository patientHGRGomaRepository;
    @Autowired
    private PatientHealAfricaRepository patientHealAfricaRepository;

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
        return patientHGRGomaRepository.findAllByIstransferredIsFalse();
    }

    public boolean transferPatientToHealAfrica(long patientHGRGomaID){
        Optional<PatientHGRGoma> patientHGRGoma = patientHGRGomaRepository.findById(patientHGRGomaID);

        if (patientHGRGoma.isEmpty()){
          return false;
        }
        patientHGRGoma.get().setIstransferred(true);
        patientHGRGomaRepository.save(patientHGRGoma.get());
//        patientHGRGoma.get().setIstransferred(false);
        System.out.println("The Patient is ... " + patientHGRGoma.get().getPatientEmail() );
        return true;
    }


    public List<PatientHGRGoma> getTransfered(){
      return  patientHGRGomaRepository.findAllByIstransferredIsTrue();
    }



//    public boolean transferPatientToHealAfrica(long patientHDomaId) {
//        Optional<PatientHGRGoma> patientFromHGoma = patientHGRGomaRepository.findById(patientHDomaId);
//        if (patientFromHGoma.isEmpty()) {
//            throw new RuntimeException("This Patient does not exist here");
//        }
//        patientFromHGoma.get().setIstransfered(true);
//        patientHealAfricaRepository.save(patientFrom)
//        patientHGRGomaRepository.save(patientFromHGoma.get());
//        return true;
//    }
//
//    public void deletePatientHGRGoma(PatientHGRGoma patientHGRGoma){
//        Optional<PatientHGRGoma> patientHGRGomadelete = patientHGRGomaRepository.findById(patientHGRGoma.getHgrGomaPatientId());
//        if (patientHGRGomadelete.isEmpty()){
//            throw new RuntimeException("This Patient does not exist here to delete");
//        }
//        patientHGRGomaRepository.delete(patientHGRGomadelete.get());
//    }
    // work on update function

}
