package com.roronoadiogo.grpc.service;

import com.roronoadiogo.grpc.dto.ProductInputDto;
import com.roronoadiogo.grpc.dto.ProductOutputDto;

import java.util.List;

public interface IProductService {

    ProductOutputDto create(ProductInputDto inputDto);
    ProductOutputDto findById(Long id);
    void delete(Long id);

    List<ProductOutputDto> findAll();

}
