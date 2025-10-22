package com.challenge.customerms.domain.interfaces;

import com.challenge.customerms.domain.model.CustomerModel;

import java.util.Optional;

public interface CustomerModelRepositoryInterface {
    Optional<CustomerModel> save(CustomerModel customerModel);
    Optional<CustomerModel> findById(Long id);
    Optional<CustomerModel> findByIdentificationNumber(String identificationNumber);
    void deleteById(Long id);
    void deleteByIdentificationNumber(String identificationNumber);
}
