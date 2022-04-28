package dev.nishiduka.gustho.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.nishiduka.gustho.domain.Client;
import dev.nishiduka.gustho.mapper.ClientMapper;
import dev.nishiduka.gustho.repository.ClientRepository;
import dev.nishiduka.gustho.requests.ClientPostRequestBody;
import dev.nishiduka.gustho.requests.ClientPutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> listAll() {
        return clientRepository.findAll();
    }
    
    public Client findByIdOrThrowBadRequestException(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not Found"));
    }
    
    public Client save(ClientPostRequestBody clientPostRequestBody) {
        return clientRepository.save(ClientMapper.INSTANCE.toClient(clientPostRequestBody));
    }
    
    public void replace(ClientPutRequestBody clientPutRequestBody) {
    	Client clientSaved = findByIdOrThrowBadRequestException(clientPutRequestBody.getId());
    	Client client = ClientMapper.INSTANCE.toClient(clientPutRequestBody);
    	
    	client.setId(clientSaved.getId());
    	clientRepository.save(client);
    }
    
    public void delete(Integer id) {
    	clientRepository.delete(findByIdOrThrowBadRequestException(id));
    }
}
