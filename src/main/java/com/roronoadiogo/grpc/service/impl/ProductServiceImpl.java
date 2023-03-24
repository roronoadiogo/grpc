package com.roronoadiogo.grpc.service.impl;

import com.roronoadiogo.grpc.dto.ProductInputDto;
import com.roronoadiogo.grpc.dto.ProductOutputDto;
import com.roronoadiogo.grpc.exceptions.BusinessException;
import com.roronoadiogo.grpc.repository.ProductRepository;
import com.roronoadiogo.grpc.service.IProductService;
import com.roronoadiogo.grpc.util.MapperProduct;
import jakarta.persistence.PersistenceException;
import jakarta.validation.Validation;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository repository) {
        this.productRepository = repository;
    }

    @Override
    public ProductOutputDto create(ProductInputDto inputDto) throws BusinessException {
        var validator = Validation.buildDefaultValidatorFactory().getValidator();
        var violations = validator.validate(inputDto);

        if (!violations.isEmpty()){
            throw new BusinessException("Invalid input: " + violations);
        }

        var productEntity = MapperProduct.INSTANCE.toEntity(inputDto);

        try{
            var productCreated = this.productRepository.save(productEntity);
            return MapperProduct.INSTANCE.toDto(productCreated);
        }catch (DataAccessException | PersistenceException e){
            throw new BusinessException("Error creating product: " + e.getMessage());
        }
    }

    @Override
    public ProductOutputDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) throws BusinessException {
        var product = this.productRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Product not found"));
        this.productRepository.delete(product);
    }

    @Override
    public List<ProductOutputDto> findAll() {
        return null;
    }
}
