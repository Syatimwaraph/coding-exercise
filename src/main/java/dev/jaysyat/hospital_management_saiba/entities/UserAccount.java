package dev.jaysyat.hospital_management_saiba.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_account_details_table")
@Getter
@Setter
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userFirstName;
    private String userLastName;

    // Used as the username to login
    private String userEmail;
    private String userPassword;

    @OneToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Transient
    private Hospital selectedHospital; // For the selected hospital after login
}
