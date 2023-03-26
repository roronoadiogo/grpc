package com.roronoadiogo.grpc.service;

import com.roronoadiogo.grpc.dto.ProductInputDto;
import com.roronoadiogo.grpc.dto.ProductOutputDto;
import com.roronoadiogo.grpc.exceptions.BusinessBaseException;

import java.util.List;

public interface IProductService {

    ProductOutputDto create(ProductInputDto inputDto) throws BusinessBaseException;
    ProductOutputDto findById(Long id) throws BusinessBaseException;
    void delete(Long id) throws BusinessBaseException;
    List<ProductOutputDto> findAll() throws BusinessBaseException;

}
