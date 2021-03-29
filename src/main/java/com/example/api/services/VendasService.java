package com.example.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.api.models.Venda;
import com.example.api.models.Vendedor;
import com.example.api.repository.VendaRepository;
// import com.example.api.response.VendasVendedor;
import com.example.api.repository.VendedorRepository;
import com.example.api.response.VendasVendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendasService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public String gerarVenda(Venda venda) {
        vendaRepository.save(venda);
        return "Venda registrada";
    }

    public List<Venda> consultarTodasVendas() {
        List<Venda> vendasCadastradas = vendaRepository.findAll();
        return vendasCadastradas;
    }

    public List<VendasVendedor> consultarVendasPorPeríodo(Date inicio, Date fim){
        List<Venda> vendas = vendaRepository.buscarVendasNoPerido(inicio, fim);
        List<Vendedor> vendedores = vendedorRepository.findAll();
        List<VendasVendedor> vendaPorVendedor = new ArrayList<VendasVendedor>();
        
        for (int index = 0; index < vendedores.size(); index++) {
            int idVendedor = vendedores.get(index).getId();
            int numeroTotalDeVendas = 0;
            double totalEmVendas = 0.0;

            for (Venda venda : vendas) {
                if(venda.getVendedor() == idVendedor){
                    numeroTotalDeVendas++;
                    totalEmVendas += venda.getValor();
                }
            }

            VendasVendedor vendasVendedor = new VendasVendedor(
                vendedores.get(index).getNome(), 
                totalEmVendas, 
                calcularMediaVendas(totalEmVendas, numeroTotalDeVendas)
            );

            vendaPorVendedor.add(vendasVendedor);
        }
        
        return vendaPorVendedor;
    }

    public double calcularMediaVendas(double totalVendas, int numeroTotalDeVenda){
        if(numeroTotalDeVenda == 0){
            return 0;
        }else{
            return totalVendas / numeroTotalDeVenda;
        }
    }
    
}
