import java.util.*;

import model.*;
import view.*;
import controller.*;
import interfaces.*;


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
		
	    Cliente cliente1 = new  Cliente("Joaco", "Jawer", "43567635", 21, "1122982884", "joacojota@gmail.com", "wpp");
		Cliente cliente2 = new  Cliente("Maru", "Roitman", "44937806", 20, "1131517726", "roitmanmaru@gmail.com", "mail");
		Cliente cliente3 = new  Cliente("Martis", "FedEx", "44123456", 20, "1144297384", "martis@gmail.com", "telefono");
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
	    
		AbstractHabitacion habitacion1 = new Habitacion("1", (double) 1500, 2, "Habitacion", new ArrayList<String>());
		AbstractHabitacion suite1 = new Suite("2", (double) 3000, 3, "Suite", new ArrayList<String>());
		AbstractHabitacion habitacion2 = new Habitacion("3", (double) 1350, 1, "Habitacion", new ArrayList<String>());
		AbstractHabitacion suite2 = new Suite("4", (double) 4500, 4, "Suite", new ArrayList<String>());
		
		habitaciones.add(habitacion1);
		habitaciones.add(suite1);
		habitaciones.add(habitacion2);
		habitaciones.add(suite2);
		
		Huesped huesped1 = new Huesped("1", "Juan", "Perez", "12345678");
        Huesped huesped2 = new Huesped("2", "Maria", "Gomez", "87654321");
        Huesped huesped3 = new Huesped("3", "Carlos", "Lopez", "11223344");
        Huesped huesped4 = new Huesped("4", "Ana", "Martinez", "44332211");
        Huesped huesped5 = new Huesped("5", "Luis", "Garcia", "55667788");
        Huesped huesped6 = new Huesped("6", "Sofia", "Fernandez", "99887766");
        Huesped huesped7 = new Huesped("7", "Pedro", "Gonzalez", "88776655");
        
        huespedes.add(huesped1);
        huespedes.add(huesped2);
        huespedes.add(huesped3);
        huespedes.add(huesped4);
        huespedes.add(huesped5);
        huespedes.add(huesped6);
        huespedes.add(huesped7);
        
        Date fechaActual = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date fechaNueva = calendar.getTime();
        List<AbstractHabitacion> habs = new ArrayList<AbstractHabitacion>();
        habs.add(suite1);
        habs.add(habitacion1);
        List<Huesped> hues = new ArrayList<Huesped>();
        hues.add(huesped1);
        hues.add(huesped2);
        hues.add(huesped3);
        hues.add(huesped4);
        PagoContexto pc = new PagoContexto();
        PagoStrategy ePago = new PagoEfectivo(fechaNueva, 1);
        pc.setEstrategia(ePago);
        Reserva reserva1 = new Reserva("1", (double) 13500, new Date(), fechaNueva, new Date(), habs, cliente1.getDNI(), hues, pc, "Pendiente de pago");
		
        reservas.add(reserva1);
        
        PoliticasReserva politicas = new PoliticasReserva(7, 7, 10, 20);
        
		Controller controller = new Controller(clientes, gerente, habitaciones, reservas, huespedes, gestorNotif, auditoria, politicas, vista);
	}
}
