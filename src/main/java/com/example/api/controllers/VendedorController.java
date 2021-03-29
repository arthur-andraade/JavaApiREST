package com.example.api.controllers;

import java.util.List;

import com.example.api.models.Vendedor;
import com.example.api.repository.VendedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class VendedorController {
    @Autowired
    private VendedorRepository vendedorRepository;

    @PostMapping(path = "/vendedor")
    public String criarVendedor(@RequestBody Vendedor vendedor) {
        vendedorRepository.save(vendedor);
        return "Vendedor cadastrados";
    }

    @GetMapping(path = "/vendedor")
    public List<Vendedor> consultarVendedores(){
        return vendedorRepository.findAll();
    }
}
