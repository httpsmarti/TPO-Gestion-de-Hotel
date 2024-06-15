package model;

import java.util.*;

public class Habitacion extends AbstractHabitacion {
    public Habitacion(String idHabitacion, int cantPersonas, List<String> extras) {
        super(idHabitacion, cantPersonas, extras);
    }

    @Override
    protected String definirTipo() {
        return "habitacion";
    }
}