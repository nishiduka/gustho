package dev.nishiduka.gustho.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.nishiduka.gustho.domain.Client;
import dev.nishiduka.gustho.requests.ClientPostRequestBody;
import dev.nishiduka.gustho.requests.ClientPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    public abstract Client toClient(ClientPostRequestBody clientPostRequestBody);
    public abstract Client toClient(ClientPutRequestBody clientPutRequestBody);
}
