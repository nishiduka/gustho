package dev.nishiduka.gustho.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import dev.nishiduka.gustho.domain.Supplier;
import dev.nishiduka.gustho.requests.SupplierPostRequestBody;
import dev.nishiduka.gustho.requests.SupplierPutRequestBody;
import dev.nishiduka.gustho.service.SuppliersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SuppliersService suppliersService;

	@GetMapping
	public ResponseEntity<List<Supplier>> list() {
        return ResponseEntity.ok(suppliersService.listAll());
	}
		
	@GetMapping(path = "/{id}")
	public ResponseEntity<Supplier> findOne(@PathVariable Integer id) {
		return ResponseEntity.ok(suppliersService.findByIdOrThrowBadRequestException(id));
	}
	
	@PostMapping
	public ResponseEntity<Supplier> create(@RequestBody SupplierPostRequestBody productPostRequestBody) {
		return new ResponseEntity<>(suppliersService.save(productPostRequestBody), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> remove(@PathVariable Integer id) {
		suppliersService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody SupplierPutRequestBody productPutRequestBody) {
		suppliersService.replace(productPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
