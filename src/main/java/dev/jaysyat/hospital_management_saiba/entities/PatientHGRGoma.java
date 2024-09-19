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
public class PatientHGRGoma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hgrGomaPatientId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean istransferred;
    private String patientGender;
    private String address;
    private String patientEmail;
}
