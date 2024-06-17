package model;

import java.util.*;

public abstract class AbstractHabitacion {
    private String idHabitacion;
    private Double precioPorNoche;
    private int cantPersonas;
    private List<String> extras;
    private boolean disponible;

    public AbstractHabitacion(String idHabitacion, Double precioPorNoche, int cantPersonas, List<String> extras) {
        this.idHabitacion = idHabitacion;
        this.precioPorNoche = precioPorNoche;
        this.cantPersonas = cantPersonas;
        this.extras = extras;
        this.disponible = true; // Por defecto, la habitación está disponible
    }

    protected abstract String definirTipo();

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public Double getPrecioPorNoche() {
    	return precioPorNoche;
    }
    
    public void setPrecioPorNoche(Double precioPorNoche) {
    	this.precioPorNoche = precioPorNoche;
    }
    
    
    public int getCantPersonas() {
        return cantPersonas;
    }
    
    public void setCantPersonas(int cantPeronas) {
    	this.cantPersonas = cantPeronas;
    }

    public List<String> getExtras() {
        return extras;
    }
    
    public void setExtras(List<String> extras) {
        this.extras = extras;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}