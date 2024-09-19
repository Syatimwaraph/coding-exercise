package dev.jaysyat.hospital_management_saiba.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatientHealAfrica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long healAfricaPatientId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String patientGender;
    private boolean istransferred;
    private String address;
    private String patientEmail;

}
