package com.challenge.customerms.infrastructure.persistence.repository.impl;

import com.challenge.customerms.domain.interfaces.CustomerModelRepositoryInterface;
import com.challenge.customerms.domain.model.CustomerModel;
import com.challenge.customerms.infrastructure.mapper.CustomerMapper;
import com.challenge.customerms.infrastructure.persistence.repository.interfaces.CustomerEntityRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerModelRepositoryInterface {
    private final CustomerEntityRepositoryInterface customerEntityRepositoryInterface;
    private final CustomerMapper customerMapper;
    @Override
    public Optional<CustomerModel> save(CustomerModel customerModel) {
        CustomerModel customerModelSaved = this.customerMapper.toCustomerModel(
                this.customerEntityRepositoryInterface.save(
                        this.customerMapper.toCustomerEntity(customerModel)
                )
        );
        return Optional.ofNullable(customerModelSaved);
    }

    @Override
    public Optional<CustomerModel> findById(Long id) {
        CustomerModel customerModel = this.customerMapper.toCustomerModel(this.customerEntityRepositoryInterface.findById(id).orElse(null));
        return Optional.ofNullable(customerModel);
    }

    @Override
    public Optional<CustomerModel> findByIdentificationNumber(String identificationNumber) {
        CustomerModel customerModel = this.customerMapper.toCustomerModel(this.customerEntityRepositoryInterface.findByIdentificationNumber(identificationNumber).orElse(null));
        return Optional.ofNullable(customerModel);
    }

    @Override
    public void deleteById(Long id) {
        this.customerEntityRepositoryInterface.deleteById(id);
    }

    @Override
    public void deleteByIdentificationNumber(String identificationNumber) {
        this.customerEntityRepositoryInterface.deleteByIdentificationNumber(identificationNumber);
    }
}
