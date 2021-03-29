package com.example.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendasVendedor {

    @JsonProperty("vendedor")
    private String nomeVendedor;

    @JsonProperty("total em vendas")
    private double totalVendas;

    @JsonProperty("média de vendas")
    private double mediaVendas;

    public VendasVendedor(String nomeVendedor, Double totalVendas, double mediaVendas) {
        this.nomeVendedor = nomeVendedor;
        this.totalVendas = totalVendas;
        this.mediaVendas = mediaVendas;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public double getMediaVendas() {
        return mediaVendas;
    }

    public void setNomeVendedor(String nome) {
        nomeVendedor = nome;
    }

    public void setTotalVendas(double total) {
        totalVendas = total;
    }

    public void  setMediaVendas(double media) {
        mediaVendas = media;
    }
}
