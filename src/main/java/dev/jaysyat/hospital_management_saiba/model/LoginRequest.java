package dev.jaysyat.hospital_management_saiba.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String userEmail;
    private String password;
    private Long hospitalId; // ID of the hospital selected by the user
}
