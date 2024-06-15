package model;

import java.util.*;

import interfaces.PagoStrategy;

public abstract class AbstractCuenta {
    private String nombre;
    private String apellido;
    private String DNI;
    private String telefono;
    private String mail;

    public AbstractCuenta(String nombre, String apellido, String DNI, String telefono, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.telefono = telefono;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public void crearReserva(AbstractHabitacion habitacion, Date fechaInicio, Date fechaFin, Date fechaReserva, List<Huesped> huespedes, PagoStrategy medioDePago) {
        PagoContexto contexto = new PagoContexto();
        contexto.setEstrategia(medioDePago);
        // contexto.pagar(monto);
        // Lógica de creación de reserva
    }

    public void cancelarReserva(int idReserva) {
        // Implementar lógica de cancelación de reserva
    }
}