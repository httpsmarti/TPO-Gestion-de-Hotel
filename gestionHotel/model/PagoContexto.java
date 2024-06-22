package model;

import java.util.*;

import interfaces.PagoStrategy;

public class PagoContexto {
    private PagoStrategy estrategia;

    public void setEstrategia(PagoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void pagar(double monto) {
        if (estrategia != null) {
            estrategia.pagar(monto);
        }
    }

    public boolean estaPagado() {
        return estrategia != null && estrategia.estaPagado();
    }

    public Date getFechaMaxima() {
        return estrategia != null ? estrategia.getFechaMaxima() : null; //si estrategia es null, devuelve null, sino devuelve fechaMaxima
    }
    
    public String getTipo() {
    	return estrategia.getTipo();
    }
}
