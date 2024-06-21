package model;

import java.util.*;

public class Habitacion extends AbstractHabitacion {
    public Habitacion(String idHabitacion, Double precioPorNoche, int cantPersonas, String tipo, List<String> extras, boolean disponible) {
        super(idHabitacion, precioPorNoche, cantPersonas, tipo, extras, disponible);
    }
}