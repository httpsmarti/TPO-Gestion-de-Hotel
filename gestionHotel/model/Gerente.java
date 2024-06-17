package model;

import java.util.List;

public class Gerente extends AbstractCuenta {

    public Gerente(String nombre, String apellido, String DNI, String telefono, String mail) {
        super(nombre, apellido, DNI, telefono, mail);
    }

    public Factura crearFactura(int idFactura, Reserva reserva) {
        return new Factura(idFactura, reserva);
    }

    public Habitacion crearHabitacion(String idHabitacion, Double precio, int cantPersonas, List<String> extras) {
    	return new Habitacion(idHabitacion, precio, cantPersonas, extras);
    }
    
    public Suite crearSuite(String idHabitacion, Double precio, int cantPersonas, List<String> extras) {
    	return new Suite(idHabitacion, precio, cantPersonas, extras);
    }

    public void modificarHabitacion(AbstractHabitacion habitacion, int nuevaCantPersonas, Double nuevoPrecioPorNoche, List<String> nuevosExtras) {
        habitacion.setCantPersonas(nuevaCantPersonas);
        habitacion.setPrecioPorNoche(nuevoPrecioPorNoche);
        habitacion.setExtras(nuevosExtras);
    }

    public void modificarPoliticas(PoliticasReserva politicas, int cantDiasTemprano, int cantDiasTarde, float dtoTemprano, float recragoTarde) {
        politicas.setCantDiasTemprano(cantDiasTemprano);
        politicas.setCantDiasTarde(cantDiasTarde);
        politicas.setDtoTemprano(dtoTemprano);
        politicas.setRecragoTarde(recragoTarde);
    }
}