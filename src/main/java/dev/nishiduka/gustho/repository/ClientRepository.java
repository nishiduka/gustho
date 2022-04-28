package dev.nishiduka.gustho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nishiduka.gustho.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
