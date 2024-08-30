package dev.jaysyat.hospital_management_saiba.services;

import dev.jaysyat.hospital_management_saiba.entities.Hospital;
import dev.jaysyat.hospital_management_saiba.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital saveHospital(Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    public Hospital findById(Long hospitalId){
        Optional<Hospital> hospital = hospitalRepository.findById(hospitalId);
        if (hospital.isEmpty()){
            throw new RuntimeException("Hospital not found");
        }
        return hospital.get();
    }

    public List<Hospital> listAllHospitals(){
        return hospitalRepository.findAll();
    }

    public Hospital updateHospital(Hospital hospital){
        Optional<Hospital> hospitalUpdate = hospitalRepository.findById(hospital.getHospitalId());
        if (hospitalUpdate.isEmpty()){
            throw new RuntimeException("Hospital not found");
        }
        Hospital existingHospital = hospitalUpdate.get();
        existingHospital.setHospitalName(hospital.getHospitalName());
        // add for departments
        return hospitalRepository.save(hospital);
    }

    public void deleteHospital(Hospital hospital){
        Optional<Hospital> hospitalToDelete = hospitalRepository.findById(hospital.getHospitalId());
        if (hospitalToDelete.isEmpty()){
            throw new RuntimeException("Hospital not found");
        }
        hospitalRepository.delete(hospitalToDelete.get());
    }
}
