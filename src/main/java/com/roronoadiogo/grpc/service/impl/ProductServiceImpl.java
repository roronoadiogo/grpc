package com.roronoadiogo.grpc.service.impl;

import com.roronoadiogo.grpc.dto.ProductInputDto;
import com.roronoadiogo.grpc.dto.ProductOutputDto;
import com.roronoadiogo.grpc.repository.ProductRepository;
import com.roronoadiogo.grpc.service.IProductService;
import com.roronoadiogo.grpc.util.MapperProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository repository) {
        this.productRepository = repository;
    }

    @Override
    public ProductOutputDto create(ProductInputDto inputDto) {
        var productEntity = MapperProduct.INSTANCE.toEntity(inputDto);
        var productCreated = this.productRepository.save(productEntity);
        return MapperProduct.INSTANCE.toDto(productCreated);
    }

    @Override
    public ProductOutputDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductOutputDto> findAll() {
        return null;
    }
}
