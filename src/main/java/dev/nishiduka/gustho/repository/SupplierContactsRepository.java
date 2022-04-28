package dev.nishiduka.gustho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nishiduka.gustho.domain.SupplierContacts;

public interface SupplierContactsRepository extends JpaRepository<SupplierContacts, Integer> {

}
