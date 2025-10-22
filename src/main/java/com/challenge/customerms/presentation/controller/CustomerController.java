package com.challenge.customerms.presentation.controller;

import com.challenge.customerms.application.service.interfaces.CustomerServiceInterface;
import com.challenge.customerms.domain.model.CustomerModel;
import com.challenge.customerms.infrastructure.mapper.CustomerMapper;
import com.challenge.customerms.presentation.dto.CustomerRequestDTO;
import com.challenge.customerms.presentation.dto.ResponseGeneric;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceInterface customerServiceInterface;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<?> createBankAccount(@RequestBody @Valid CustomerRequestDTO requestDTO) {
        CustomerModel customerModel = this.customerMapper.toCustomerModel(requestDTO);
        CustomerModel customerSaved = this.customerServiceInterface.save(customerModel);
        return ResponseEntity.ok().body(new ResponseGeneric<>("success", "Customer created", "Identification number: " + customerSaved.getIdentificationNumber()));
    }

    @GetMapping
    public ResponseEntity<?> findAllCustomers() {}
}
