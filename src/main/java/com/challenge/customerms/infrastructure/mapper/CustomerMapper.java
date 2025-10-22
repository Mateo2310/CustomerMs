package com.challenge.customerms.infrastructure.mapper;

import com.challenge.customerms.domain.model.CustomerModel;
import com.challenge.customerms.infrastructure.persistence.entity.CustomerEntity;
import com.challenge.customerms.presentation.dto.CustomerRequestDTO;
import com.challenge.customerms.presentation.dto.CustomerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {
    CustomerModel toCustomerModel(CustomerEntity customerEntity);
    CustomerEntity toCustomerEntity(CustomerModel customerModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CustomerModel toCustomerModel(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO toCustomerResponseDTO(CustomerModel customerModel);
}
