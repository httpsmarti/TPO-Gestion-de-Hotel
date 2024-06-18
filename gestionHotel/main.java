import java.util.*;

import model.*;
import view.*;
import controller.*;


public class main {	
	public static void main(String[] args) {
		//inicializar modelo base
		List<Cliente> clientes = new ArrayList<Cliente>();
	    Gerente gerente = new Gerente("Denis", "Balestri", "13264598", "118556575", "dbalestri@uade.edu.ar");
	    List<AbstractHabitacion> habitaciones = new ArrayList<AbstractHabitacion>();
	    List<Reserva> reservas = new ArrayList<Reserva>();
	    List<Huesped> huespedes = new ArrayList<Huesped>();
	    GestorDeNotificaciones gestorNotif = new GestorDeNotificaciones();
	    Auditoria auditoria = new Auditoria();
	    
	    Interfaz_Login vista = new Interfaz_Login();
		//ejemplo de habitaciones
		AbstractHabitacion habitacion1 = new Habitacion("1", (double) 1500, 2, "Habitacion", new ArrayList<String>());
		AbstractHabitacion suite1 = new Suite("2", (double) 3000, 3, "Suite", new ArrayList<String>());
		
		habitaciones.add(habitacion1);
		habitaciones.add(suite1);
		
		//crear controller
		
	}

}
