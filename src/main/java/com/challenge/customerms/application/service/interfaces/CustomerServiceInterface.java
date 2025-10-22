package com.challenge.customerms.application.service.interfaces;

import com.challenge.customerms.domain.model.CustomerModel;

public interface CustomerServiceInterface {
    CustomerModel save(CustomerModel customerModel);
    CustomerModel findById(Long id);
    CustomerModel findByIdentificationNumber(String identificationNumber);
    void deleteById(Long id);
    void deleteByIdentificationNumber(String identificationNumber);
}
