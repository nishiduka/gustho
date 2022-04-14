package dev.nishiduka.gustho.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import dev.nishiduka.gustho.domain.Product;
import dev.nishiduka.gustho.requests.ProductPostRequestBody;
import dev.nishiduka.gustho.service.ProductsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

	@GetMapping
	public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(productsService.listAll());
	}
		
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> findOne(@PathVariable Integer id) {
		return ResponseEntity.ok(productsService.findByIdOrThrowBadRequestException(id));
	}
	
	@PostMapping
	public ResponseEntity<Product> newProduct(@RequestBody ProductPostRequestBody productPostRequestBody) {
		return new ResponseEntity<>(productsService.save(productPostRequestBody), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> removeProduct(@PathVariable Integer id) {
		productsService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
