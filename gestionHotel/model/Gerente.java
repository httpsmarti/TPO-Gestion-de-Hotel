package model;

import java.util.List;

public class Gerente extends AbstractCuenta {

    public Gerente(String nombre, String apellido, String DNI, String telefono, String mail) {
        super(nombre, apellido, DNI, telefono, mail);
    }

    public void crearFactura(int idReserva, double monto) {
        // Implementar lógica para crear una factura
        System.out.println("Factura creada para la reserva ID: " + idReserva + " con monto: " + monto);
    }

    public void crearHabitacion(String idHabitacion, int cantPersonas, String tipo, List<String> extras) {
        // Implementar lógica para crear una habitación
    }

    public void modificarHabitacion(String idHabitacion, int nuevaCantPersonas, List<String> nuevosExtras) {
        // Implementar lógica para modificar una habitación existente
    }

    public void modificarPoliticas(String nuevasPoliticas) {
        // Implementar lógica para modificar políticas del hotel
    }
}