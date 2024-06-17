package model;

import java.util.*;

public class Habitacion extends AbstractHabitacion {
    public Habitacion(String idHabitacion, Double precioPorNoche, int cantPersonas, List<String> extras) {
        super(idHabitacion, precioPorNoche, cantPersonas, extras);
    }

    @Override
    protected String definirTipo() {
        return "habitacion";
    }
}