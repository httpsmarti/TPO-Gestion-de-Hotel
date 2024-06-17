package model;

import java.util.*;

public class Suite extends AbstractHabitacion {
    public Suite(String idHabitacion, Double precioPorNoche, int cantPersonas, List<String> extras) {
        super(idHabitacion, precioPorNoche, cantPersonas, extras);
    }

    @Override
    protected String definirTipo() {
        return "suite";
    }
}