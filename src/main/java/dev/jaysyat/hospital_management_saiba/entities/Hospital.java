package dev.jaysyat.hospital_management_saiba.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hospital_details_table")
@Getter
@Setter
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalId;

    private String hospitalName;
    private String hospitalAddress;

    @OneToOne(mappedBy = "hospital", cascade = CascadeType.ALL)
    private UserAccount userAccount;
}
