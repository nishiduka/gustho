package dev.nishiduka.gustho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nishiduka.gustho.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
