package dev.nishiduka.gustho.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.nishiduka.gustho.domain.Product;
import dev.nishiduka.gustho.mapper.ProductMapper;
import dev.nishiduka.gustho.repository.ProductRepository;
import dev.nishiduka.gustho.requests.ProductPostRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }
    
    public Product findByIdOrThrowBadRequestException(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not Found"));
    }
    
    public Product save(ProductPostRequestBody productBodyPost) {
        return productRepository.save(ProductMapper.INSTANCE.toProduct(productBodyPost));
    }
    
    public void delete(Integer id) {
    	productRepository.delete(findByIdOrThrowBadRequestException(id));
    }
}
