package com.example.api.validations;

import java.util.List;

import com.example.api.models.Vendedor;

public class VendaServiceValidation {
    
    public boolean vendedorValido(int idVendedor,  List<Vendedor> vendedores){
        if(vendedores.isEmpty()){
            return false;
        }

        for (Vendedor vendedor : vendedores) {
            if(vendedor.getId() == idVendedor){
                return true;
            }
        }

        return false;
    }
}
