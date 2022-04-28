package dev.nishiduka.gustho.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nishiduka.gustho.domain.Client;
import dev.nishiduka.gustho.requests.ClientPostRequestBody;
import dev.nishiduka.gustho.requests.ClientPutRequestBody;
import dev.nishiduka.gustho.service.ClientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> list() {
        return ResponseEntity.ok(clientService.listAll());
	}
		
	@GetMapping(path = "/{id}")
	public ResponseEntity<Client> findOne(@PathVariable Integer id) {
		return ResponseEntity.ok(clientService.findByIdOrThrowBadRequestException(id));
	}
	
	@PostMapping
	public ResponseEntity<Client> newProduct(@RequestBody ClientPostRequestBody clientPostRequestBody) {
		return new ResponseEntity<>(clientService.save(clientPostRequestBody), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody ClientPutRequestBody clientPutRequestBody) {
		clientService.replace(clientPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> removeProduct(@PathVariable Integer id) {
		clientService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
