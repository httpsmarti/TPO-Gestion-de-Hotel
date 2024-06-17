package controller;

import model.*;
import view.*;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private List<Cliente> clientes;
    private Gerente gerente;
    private List<Habitacion> habitaciones;
    private List<Suite> suites;
    private List<Reserva> reservas;
    private List<Huesped> huespedes;
    private GestorDeNotificaciones gestorNotif;
    private Auditoria auditoria;
    
    private Interfaz_Login vista;
    
    public Controller(List<Cliente> clientes, Gerente gerente, List<Habitacion> habitaciones, List<Suite> suites,
			List<Reserva> reservas, List<Huesped> huespedes, GestorDeNotificaciones gestorNotif, Auditoria auditoria, Interfaz_Login vista) {
		super();
		this.clientes = clientes;
		this.gerente = gerente;
		this.habitaciones = habitaciones;
		this.suites = suites;
		this.reservas = reservas;
		this.huespedes = huespedes;
		this.gestorNotif = gestorNotif;
		this.auditoria = auditoria;
		iniciarVista(vista);
	}
    
    


    private void iniciarVista(Interfaz_Login vista) {
        vista.setVisible(true);
    }

    private void iniciarControlador() {
        // Añadir aquí los listeners y la lógica del controlador
    }
}