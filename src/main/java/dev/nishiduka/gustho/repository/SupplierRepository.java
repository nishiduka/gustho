package dev.nishiduka.gustho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nishiduka.gustho.domain.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
