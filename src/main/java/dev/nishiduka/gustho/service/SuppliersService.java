package dev.nishiduka.gustho.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.nishiduka.gustho.domain.Supplier;
import dev.nishiduka.gustho.domain.SupplierContacts;
import dev.nishiduka.gustho.mapper.SupplierMapper;
import dev.nishiduka.gustho.repository.SupplierContactsRepository;
import dev.nishiduka.gustho.repository.SupplierRepository;
import dev.nishiduka.gustho.requests.SupplierPostRequestBody;
import dev.nishiduka.gustho.requests.SupplierPutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SuppliersService {
    private final SupplierRepository supplierRepository;
    private final SupplierContactsRepository supplierContactsRepository ;

    public List<Supplier> listAll() {
        return supplierRepository.findAll();
    }
    
    public Supplier findByIdOrThrowBadRequestException(Integer id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not Found"));
    }
    
    @Transactional
    public Supplier save(SupplierPostRequestBody supplierBodyPost) {
        Supplier supplier = supplierRepository.save(SupplierMapper.INSTANCE.toSupplier(supplierBodyPost));
        
        supplier = saveContacts(supplier);

        return supplier;
    }
    
    public void replace(SupplierPutRequestBody supplierPutRequestBody) {
    	Supplier savedSupplier = findByIdOrThrowBadRequestException(supplierPutRequestBody.getId());
    	Supplier supplier = SupplierMapper.INSTANCE.toSupplier(supplierPutRequestBody);
    	
    	supplier = saveContacts(supplier);
    	
    	supplier.setId(savedSupplier.getId());
    	supplierRepository.save(supplier);
    }

    
    public void delete(Integer id) {
    	supplierRepository.delete(findByIdOrThrowBadRequestException(id));
    }
    
    private Supplier saveContacts(Supplier supplier) {
        for( SupplierContacts item : supplier.getContacts() ) {        	
    		item.setSupplier(supplier);
        	
        	supplierContactsRepository.save(item);
        }
        
        return supplier;
    }
}
