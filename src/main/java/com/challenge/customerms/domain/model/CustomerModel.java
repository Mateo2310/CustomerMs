package com.challenge.customerms.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String identificationNumber;
    private IdentificationType identificationType;
    private String email;
    private String address;
    private String birthDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
