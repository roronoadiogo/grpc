package com.roronoadiogo.grpc.util;

import com.roronoadiogo.grpc.domain.Product;
import com.roronoadiogo.grpc.dto.ProductInputDto;
import com.roronoadiogo.grpc.dto.ProductOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperProduct {

    MapperProduct INSTANCE = Mappers.getMapper(MapperProduct.class);
    ProductOutputDto toDto(Product product);

    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductInputDto productInputDto);

}
