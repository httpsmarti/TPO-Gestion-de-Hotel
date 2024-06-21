package model;

import java.util.*;

public class AbstractHabitacion {
    private String idHabitacion;
    private Double precioPorNoche;
    private int cantPersonas;
    private String tipo;
    private List<String> extras;
    private boolean disponible;

    public AbstractHabitacion(String idHabitacion, Double precioPorNoche, int cantPersonas, String tipo, List<String> extras, boolean disponible) {
        this.idHabitacion = idHabitacion;
        this.precioPorNoche = precioPorNoche;
        this.cantPersonas = cantPersonas;
        this.tipo = tipo;
        this.extras = extras;
        this.disponible = disponible;
    }

    public String getTipo() {
		return tipo;
	}
    
    public void setTipo(String tipo) {
    	this.tipo = tipo;
    }

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