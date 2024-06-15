package model;

import java.util.*;

public class Suite extends AbstractHabitacion {
    public Suite(String idHabitacion, int cantPersonas, List<String> extras) {
        super(idHabitacion, cantPersonas, extras);
    }

    @Override
    protected String definirTipo() {
        return "suite";
    }
}