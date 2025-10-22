package com.challenge.customerms.application.service.impl;

import com.challenge.customerms.application.service.interfaces.CustomerServiceInterface;
import com.challenge.customerms.domain.exception.BusinessException;
import com.challenge.customerms.domain.exception.DatabaseUnavailableException;
import com.challenge.customerms.domain.interfaces.CustomerModelRepositoryInterface;
import com.challenge.customerms.domain.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerServiceInterface {
    private final CustomerModelRepositoryInterface customerModelRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public CustomerModel save(CustomerModel customerModel) {
        try {
            return this.customerModelRepository.save(customerModel).orElseThrow(() -> new BusinessException("No se pudo guardar el titular"));
        } catch (DataIntegrityViolationException e) {
            this.logger.error("Error de tipo DataIntegrityViolationException al intentar guardar un titular: {}", e.getMessage());
            throw new BusinessException("Violación de integridad al guardar la titular");
        } catch (CannotCreateTransactionException cctex) {
            this.logger.error("Error de tipo CannotCreateTransactionException  al intentar guardar un titular: {}", cctex.getMessage());
            throw new DatabaseUnavailableException("No se pudo conectar con la base de datos");
        }
    }

    @Override
    public CustomerModel findById(Long id) {
        try {
            return this.customerModelRepository.findById(id).orElseThrow(() -> new BusinessException("No se encontro el registro"));
        } catch (DataIntegrityViolationException e) {
            this.logger.error("Error de tipo DataIntegrityViolationException al intentar obtener un titular: {}", e.getMessage());
            throw new BusinessException("Violación de integridad al obtener titular");
        } catch (CannotCreateTransactionException cctex) {
            this.logger.error("Error de tipo CannotCreateTransactionException  al intentar obtener un titular: {}", cctex.getMessage());
            throw new DatabaseUnavailableException("No se pudo conectar con la base de datos");
        }
    }

    @Override
    public CustomerModel findByIdentificationNumber(String identificationNumber) {
        try {
            return this.customerModelRepository.findByIdentificationNumber(identificationNumber).orElseThrow(() -> new BusinessException("No se encontro el registro"));
        } catch (DataIntegrityViolationException e) {
            this.logger.error("Error de tipo DataIntegrityViolationException al intentar obtener un titular: {}", e.getMessage());
            throw new BusinessException("Violación de integridad al obtener titular");
        } catch (CannotCreateTransactionException cctex) {
            this.logger.error("Error de tipo CannotCreateTransactionException  al intentar obtener un titular: {}", cctex.getMessage());
            throw new DatabaseUnavailableException("No se pudo conectar con la base de datos");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            this.customerModelRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            this.logger.error("Error de tipo DataIntegrityViolationException al intentar eliminar un titular: {}", e.getMessage());
            throw new BusinessException("Violación de integridad al eliminar titular");
        } catch (CannotCreateTransactionException cctex) {
            this.logger.error("Error de tipo CannotCreateTransactionException  al intentar eliminar un titular: {}", cctex.getMessage());
            throw new DatabaseUnavailableException("No se pudo conectar con la base de datos");
        }
    }

    @Override
    public void deleteByIdentificationNumber(String identificationNumber) {
        try {
            this.customerModelRepository.deleteByIdentificationNumber(identificationNumber);
        } catch (DataIntegrityViolationException e) {
            this.logger.error("Error de tipo DataIntegrityViolationException al eliminar guardar un titular: {}", e.getMessage());
            throw new BusinessException("Violación de integridad al eliminar titular");
        } catch (CannotCreateTransactionException cctex) {
            this.logger.error("Error de tipo CannotCreateTransactionException  al eliminar guardar un titular: {}", cctex.getMessage());
            throw new DatabaseUnavailableException("No se pudo conectar con la base de datos");
        }
    }
}
