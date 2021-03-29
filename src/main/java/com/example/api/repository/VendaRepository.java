package com.example.api.repository;

import java.util.Date;
import java.util.List;

import com.example.api.models.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

    @Query(
        value = "SELECT * FROM venda WHERE data BETWEEN ?1 AND ?2",
        nativeQuery = true
    )
    List<Venda> buscarVendasNoPerido(Date inicio, Date fim);
}
