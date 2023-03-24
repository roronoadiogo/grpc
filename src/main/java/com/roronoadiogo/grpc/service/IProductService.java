package com.roronoadiogo.grpc.service;

import com.roronoadiogo.grpc.dto.ProductInputDto;
import com.roronoadiogo.grpc.dto.ProductOutputDto;
import com.roronoadiogo.grpc.exceptions.BusinessException;

import java.util.List;

public interface IProductService {

    ProductOutputDto create(ProductInputDto inputDto) throws BusinessException;
    ProductOutputDto findById(Long id) throws BusinessException;
    void delete(Long id) throws BusinessException;

    List<ProductOutputDto> findAll() throws BusinessException;

}
