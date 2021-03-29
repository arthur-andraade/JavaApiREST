package com.example.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.api.models.Venda;
import com.example.api.request.PeriodoVendas;
import com.example.api.response.VendasVendedor;
import com.example.api.services.VendasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class VendaController {

    @Autowired
    private VendasService vendasService;

    @PostMapping(path = "/vendas")
    public String criarVenda(@RequestBody Venda venda) {
        String resposta = vendasService.gerarVenda(venda);
        return resposta;
    }

    @GetMapping(path = "/vendas")
    public List<Venda> consultarVendas() {
        return vendasService.consultarTodasVendas();
    }

    @GetMapping(path = "/vendas-vendedor")
    public List<VendasVendedor> consultarVendasPorVendedor(@RequestBody PeriodoVendas periodoVendas) {
        return vendasService.consultarVendasPorPeríodo(periodoVendas.inicio, periodoVendas.fim);
    }
}
