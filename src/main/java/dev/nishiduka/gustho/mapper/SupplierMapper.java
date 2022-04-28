package dev.nishiduka.gustho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.nishiduka.gustho.domain.Supplier;
import dev.nishiduka.gustho.requests.SupplierPostRequestBody;
import dev.nishiduka.gustho.requests.SupplierPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class SupplierMapper {
    public static final SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    public abstract Supplier toSupplier(SupplierPostRequestBody supplierPostRequestBody);
    
    public abstract Supplier toSupplier(SupplierPutRequestBody supplierPutRequestBody);

}
