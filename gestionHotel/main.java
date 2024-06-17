import java.util.*;

import model.*;
import view.*;
import controller.*;


public class main {
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
    private Gerente gerente = new Gerente("Denis", "Balestri", "13264598", "118556575", "dbalestri@uade.edu.ar");
    private List<Habitacion> habitaciones = new ArrayList<Habitacion>();
    private List<Suite> suites = new ArrayList<Suite>();
    private List<Reserva> reservas = new ArrayList<Reserva>();
    private List<Huesped> huespedes = new ArrayList<Huesped>();
    private GestorDeNotificaciones gestorNotif = new GestorDeNotificaciones();
    private Auditoria auditoria = new Auditoria();
    
    private Interfaz_Login vista = new Interfaz_Login();
	
	public static void main(String[] args) {
		//crear controller		
	}

}
