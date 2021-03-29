package com.example.api.repository;

import com.example.api.models.Vendedor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
    
}
