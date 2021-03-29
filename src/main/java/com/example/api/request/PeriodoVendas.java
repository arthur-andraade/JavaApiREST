package com.example.api.request;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeriodoVendas {

    @JsonProperty("período_inicio")
    @Temporal(TemporalType.DATE)
    public Date inicio;

    @JsonProperty("periodo_final")
    @Temporal(TemporalType.DATE)
    public Date fim;
}
