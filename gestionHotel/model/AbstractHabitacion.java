package model;

import java.util.*;

public abstract class AbstractHabitacion {
    private String idHabitacion;
    private int cantPersonas;
    private String tipo;
    private List<String> extras;
    private boolean disponible;

    public AbstractHabitacion(String idHabitacion, int cantPersonas, List<String> extras) {
        this.idHabitacion = idHabitacion;
        this.cantPersonas = cantPersonas;
        this.extras = extras;
        this.disponible = true; // Por defecto, la habitación está disponible
        this.tipo = definirTipo();
        validarTipo();
    }

    protected abstract String definirTipo();

    private void validarTipo() {
        if (!tipo.equals("habitacion") && !tipo.equals("suite")) {
            throw new IllegalArgumentException("El tipo de habitación debe ser 'habitacion' o 'suite'");
        }
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public String getTipo() {
        return tipo;
    }

    public List<String> getExtras() {
        return extras;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "idHabitacion='" + idHabitacion + '\'' +
                ", cantPersonas=" + cantPersonas +
                ", tipo='" + tipo + '\'' +
                ", extras=" + extras +
                ", disponible=" + disponible +
                '}';
    }
}