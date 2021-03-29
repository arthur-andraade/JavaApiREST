package com.example.api.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "venda")
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double valor;
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @JoinColumn(
        table = "vendedor",
        referencedColumnName = "id"
    )
    private int vendedor;

    public int getId(){
        return id;
    }

    public double getValor(){
        return valor;
    }

    public Date getData(){
        return data;
    }

    public int getVendedor(){
        return vendedor;
    }
}
