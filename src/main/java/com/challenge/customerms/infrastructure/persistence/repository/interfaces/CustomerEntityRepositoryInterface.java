package com.challenge.customerms.infrastructure.persistence.repository.interfaces;

import com.challenge.customerms.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerEntityRepositoryInterface extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByIdentificationNumber(String identificationNumber);
    void deleteByIdentificationNumber(String identificationNumber);
}
