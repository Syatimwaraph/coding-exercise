package dev.jaysyat.hospital_management_saiba.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class PatientHealAfrica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long healAfricaPatientId;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String patientGender;
    private String address;
    private String patientEmail;

}
