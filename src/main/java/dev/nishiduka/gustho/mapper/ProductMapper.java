package dev.nishiduka.gustho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.nishiduka.gustho.domain.Product;
import dev.nishiduka.gustho.requests.ProductPostRequestBody;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public abstract Product toProduct(ProductPostRequestBody productPosRequestBody);

}
