package com.siaproject.backend.dto;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String confirmPassword;
}
