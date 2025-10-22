package com.challenge.customerms.presentation.dto;

import com.challenge.customerms.domain.model.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String identificationNumber;
    private IdentificationType identificationType;
    private String email;
    private String address;
    private String birthDate;
}
