package model;

import java.util.*;

import interfaces.PagoStrategy;

public class PagoDebito implements PagoStrategy {
    private boolean pagado;
    private Date fechaMaxima;
    private String idDebito;
    private String banco;

    public PagoDebito(Date fechaMaxima, String idDebito, String banco) {
        this.fechaMaxima = fechaMaxima;
        this.idDebito = idDebito;
        this.banco = banco;
        this.pagado = false;
    }

    @Override
    public void pagar(double monto) {
        // Lógica para pagar con débito
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

    public String getIdDebito() {
        return idDebito;
    }

    public String getBanco() {
        return banco;
    }
    
    public String getTipo() {
    	return "Debito";
    }
}