package model;

import java.util.*;

import interfaces.PagoStrategy;

public class PagoTransferencia implements PagoStrategy {
    private boolean pagado;
    private Date fechaMaxima;
    private String idTransferencia;
    private String alias;

    public PagoTransferencia(Date fechaMaxima, String idTransferencia, String alias) {
        this.fechaMaxima = fechaMaxima;
        this.idTransferencia = idTransferencia;
        this.alias = alias;
        this.pagado = false;
    }

    public void pagar(double monto) {
        System.out.println("Pagado mediante transferencia: " + monto + ". Alias: " + alias);
        this.pagado = true;
    }

    public boolean estaPagado() {
        return pagado;
    }

    public Date getFechaMaxima() {
        return fechaMaxima;
    }

    public String getIdTransferencia() {
        return idTransferencia;
    }

    public String getAlias() {
        return alias;
    }
    
    public String getTipo() {
    	return "Transferencia";
    }
}