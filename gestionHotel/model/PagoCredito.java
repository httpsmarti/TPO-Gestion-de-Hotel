package model;

import java.util.*;

import interfaces.PagoStrategy;

public class PagoCredito implements PagoStrategy {
    private boolean pagado;
    private Date fechaMaxima;
    private String idCredito;
    private String banco;

    public PagoCredito(Date fechaMaxima, String idCredito, String banco) {
        this.fechaMaxima = fechaMaxima;
        this.idCredito = idCredito;
        this.banco = banco;
        this.pagado = false;
    }

    @Override
    public void pagar(double monto) {
        // Lógica para pagar con crédito
        this.pagado = true;
    }

    @Override
    public boolean estaPagado() {
        return pagado;
    }

    @Override
    public Date getFechaMaxima() {
        return fechaMaxima;
    }

    public String getIdCredito() {
        return idCredito;
    }

    public String getBanco() {
        return banco;
    }
    
    public String getTipo() {
    	return "Credito";
    }
}