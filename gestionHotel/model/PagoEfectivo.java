package model;
import interfaces.PagoStrategy;
import java.util.*;

public class PagoEfectivo implements PagoStrategy {
    private boolean pagado;
    private Date fechaMaxima;
    private double tipoCambio;

    public PagoEfectivo(Date fechaMaxima, double tipoCambio) {
        this.fechaMaxima = fechaMaxima;
        this.tipoCambio = tipoCambio;
        this.pagado = false;
    }

    @Override
    public void pagar(double monto) {
        System.out.println("Pagado en efectivo: " + monto + ". Tipo de cambio: " + tipoCambio);
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

    public double getTipoCambio() {
        return tipoCambio;
    }
    
    public String getTipo() {
    	return "Efectivo";
    }
}