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
		
	    Cliente cliente1 = new  Cliente("Joaco", "Jawer", "43567635", 21, "1122982884", "joacojota@gmail.com", "wpp", "wawer");
		Cliente cliente2 = new  Cliente("Maru", "Roitman", "44937806", 20, "1131517726", "roitmanmaru@gmail.com", "mail", "mawer");
		Cliente cliente3 = new  Cliente("Martis", "FedEx", "45325638", 20, "1144297384", "martis@gmail.com", "telefono", "marti");
		Cliente cliente4 = new 	Cliente("Caro", "Guevara", "45321876", 22, "1145781234", "caro@gmail.com", "wpp", "boni");
		Cliente cliente5 = new 	Cliente("Luis", "Gomez", "45213467", 30, "1145627890", "luis.gomez@gmail.com", "telefono", "hola");
		Cliente cliente6 = new 	Cliente("Laura", "Martinez", "45123456", 25, "1145783456", "laura.martinez@gmail.com", "wpp", "123");
		Cliente cliente7 = new 	Cliente("Carlos", "Lopez", "45321789", 28, "1145621234", "carlos.lopez@gmail.com", "mail", "123");
		Cliente cliente8 = new 	Cliente("Maria", "Garcia", "45345678", 24, "1145789876", "maria.garcia@gmail.com", "telefono", "123");
		Cliente cliente9 = new 	Cliente("Jose", "Rodriguez", "45432189", 32, "1145623456", "jose.rodriguez@gmail.com", "wpp", "123");
		Cliente cliente10 = new Cliente("Sofia", "Gonzalez", "45321654", 27, "1145785643", "sofia.gonzalez@gmail.com", "mail", "123");
		Cliente cliente11 = new Cliente("Miguel", "Fernandez", "45213478", 29, "1145626789", "miguel.fernandez@gmail.com", "telefono", "123");
		Cliente cliente12 = new Cliente("Julia", "Sanchez", "45123478", 26, "1145781235", "julia.sanchez@gmail.com", "wpp", "123");
		Cliente cliente13 = new Cliente("Pedro", "Ramirez", "45321765", 35, "1145622345", "pedro.ramirez@gmail.com", "mail", "123");
		Cliente cliente14 = new Cliente("Martina", "Diaz", "45321843", 23, "1145786789", "martina.diaz@gmail.com", "telefono", "123");
		Cliente cliente15 = new Cliente("Andres", "Cruz", "45213489", 31, "1145623457", "andres.cruz@gmail.com", "wpp", "123");
		Cliente cliente16 = new Cliente("Valeria", "Herrera", "45123498", 28, "1145782345", "valeria.herrera@gmail.com", "mail", "123");
		Cliente cliente17 = new Cliente("Diego", "Pereira", "45321776", 34, "1145624567", "diego.pereira@gmail.com", "telefono", "123");
		Cliente cliente18 = new Cliente("Lucia", "Ortiz", "45321865", 22, "1145783457", "lucia.ortiz@gmail.com", "wpp", "123");
		Cliente cliente19 = new Cliente("Roberto", "Ruiz", "45213456", 33, "1145625678", "roberto.ruiz@gmail.com", "mail", "123");
		Cliente cliente20 = new Cliente("Gabriela", "Mendoza", "45123456", 29, "1145784567", "gabriela.mendoza@gmail.com", "telefono", "123");
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		clientes.add(cliente6);
		clientes.add(cliente7);
		clientes.add(cliente8);
		clientes.add(cliente9);
		clientes.add(cliente10);
		clientes.add(cliente11);
		clientes.add(cliente12);
		clientes.add(cliente13);
		clientes.add(cliente14);
		clientes.add(cliente15);
		clientes.add(cliente16);
		clientes.add(cliente17);
		clientes.add(cliente18);
		clientes.add(cliente19);
		clientes.add(cliente20);
	    
		ArrayList<String> extras1 = new ArrayList<String>();
		extras1.add("Minibar");
		extras1.add("Servicio despertador");

		ArrayList<String> extras2 = new ArrayList<String>();
		extras2.add("TV");
		extras2.add("Internet");

		ArrayList<String> extras3 = new ArrayList<String>();
		extras3.add("Minibar");
		extras3.add("Internet");

		ArrayList<String> extras4 = new ArrayList<String>();
		extras4.add("TV");
		extras4.add("Servicio despertador");

		ArrayList<String> extras5 = new ArrayList<String>();
		extras5.add("TV");
		extras5.add("Minibar");

		ArrayList<String> extras6 = new ArrayList<String>();
		extras6.add("Servicio despertador");
		extras6.add("Internet");

		ArrayList<String> extras7 = new ArrayList<String>();
		extras7.add("Minibar");
		extras7.add("Servicio despertador");
		extras7.add("Internet");

		ArrayList<String> extras8 = new ArrayList<String>();
		extras8.add("TV");
		extras8.add("Minibar");
		extras8.add("Internet");

		ArrayList<String> extras9 = new ArrayList<String>();
		extras9.add("TV");
		extras9.add("Servicio despertador");
		extras9.add("Minibar");

		ArrayList<String> extras10 = new ArrayList<String>();
		extras10.add("Servicio despertador");

		ArrayList<String> extras11 = new ArrayList<String>();
		extras11.add("TV");
		extras11.add("Minibar");
		extras11.add("Servicio despertador");
		extras11.add("Internet");
		
		ArrayList<String> extras12 = new ArrayList<String>();
		extras12.add("Minibar");
		
		ArrayList<String> extras13 = new ArrayList<String>();
		extras13.add("TV");
		
		ArrayList<String> extras14 = new ArrayList<String>();
		extras14.add("Internet");

		Habitacion habitacion1 = new Habitacion("1", (double) 1500, 2, "Habitacion", extras1 , true);
		Suite suite1 = new Suite("2", (double) 3000, 1, "Suite", extras2 , true);
		
		Habitacion habitacion2 = new Habitacion("3", (double) 1350, 1, "Habitacion", extras2 , true);
		Suite suite2 = new Suite("4", (double) 4500, 4, "Suite", extras9  , true);
		
		Habitacion habitacion3 = new Habitacion("5", (double) 2000.0, 2, "Habitacion", extras3 , true);
		Suite suite3 = new Suite("7", (double)5000.0, 2, "Suite", extras7 , true);
		
		Habitacion habitacion4 = new Habitacion("6", (double) 1800.0, 1, "Habitacion", extras3, false);
		Suite suite4 = new Suite("8", (double) 4000.0, 3, "Suite", extras5, false);
		
		Habitacion habitacion5 = new Habitacion("9", (double) 1500.0, 2, "Habitacion", extras6, true);
		Suite suite5 = new Suite("11", (double) 4500.0, 1, "Suite", extras8, true);
		
		Habitacion habitacion6 = new Habitacion("10", 1700.0, 1, "Habitacion", extras7, false);
		Suite suite6 = new Suite("12", (double) 3500.0, 2, "Suite", extras9, false);
		
		Habitacion habitacion7 = new Habitacion("13", (double) 1600.0, 2, "Habitacion", extras10, true);
		Suite suite7 = new Suite("15", (double) 5500.0, 3, "Suite", extras2, true);
		
		Habitacion habitacion8 = new Habitacion("14", (double) 1400.0, 1, "Habitacion", extras11, false);
		Suite suite8 = new Suite("16", (double) 3000.0, 2, "Suite", extras3, false);
		
		Habitacion habitacion9 = new Habitacion("17", (double) 1900.0, 2, "Habitacion", extras4, true);
		Suite suite9 = new Suite("19", (double) 6000.0, 4, "Suite", extras6, true);
		
		Habitacion habitacion10 = new Habitacion("18", (double) 1200.0, 1, "Habitacion", extras5, true);
		Suite suite10 = new Suite("20", (double) 3200.0, 2, "Suite", extras7, false);
		
		Habitacion habitacion11 = new Habitacion("21", (double) 2000.0, 2, "Habitacion", extras8, true);
		Suite suite11 = new Suite("23", (double) 7000.0, 4, "Suite", extras10, true);
		
		Habitacion habitacion12 = new Habitacion("22", (double) 1600.0, 1, "Habitacion", extras9, false);
		Suite suite12 = new Suite("24", (double) 3400.0, 2, "Suite", extras11, false);

		Habitacion habitacion13 = new Habitacion("24", (double) 3000.0, 2, "Habitacion", extras9, true);
		Suite suite13 = new Suite("26", (double) 3400.0, 2, "Suite", extras11, true);
		
		Habitacion habitacion14 = new Habitacion("25", (double) 3000.0, 2, "Habitacion", extras12, true);
		Suite suite14 = new Suite("27", (double) 3400.0, 2, "Suite", extras12, true);
		
		Habitacion habitacion15 = new Habitacion("26", (double) 3000.0, 1, "Habitacion", extras13, true);
		Suite suite15 = new Suite("28", (double) 3400.0, 2, "Suite", extras13, true);
		
		Habitacion habitacion16 = new Habitacion("27", (double) 3000.0, 2, "Habitacion", extras14, true);
		Suite suite16 = new Suite("29", (double) 3400.0, 2, "Suite", extras14, true);
		

		habitaciones.add(habitacion1);
		habitaciones.add(suite1);
		habitaciones.add(habitacion2);
		habitaciones.add(suite2);
		habitaciones.add(habitacion3);
		habitaciones.add(habitacion4);
		habitaciones.add(suite3);
		habitaciones.add(suite4);
		habitaciones.add(habitacion5);
		habitaciones.add(habitacion6);
		habitaciones.add(suite5);
		habitaciones.add(suite6);
		habitaciones.add(habitacion7);
		habitaciones.add(habitacion8);
		habitaciones.add(suite7);
		habitaciones.add(suite8);
		habitaciones.add(habitacion9);
		habitaciones.add(habitacion10);
		habitaciones.add(suite9);
		habitaciones.add(suite10);
		habitaciones.add(habitacion11);
		habitaciones.add(habitacion12);
		habitaciones.add(suite11);
		habitaciones.add(suite12);
		habitaciones.add(suite13);
		habitaciones.add(habitacion13);
		habitaciones.add(suite14);
		habitaciones.add(habitacion14);
		habitaciones.add(suite15);
		habitaciones.add(habitacion15);
		habitaciones.add(suite16);
		habitaciones.add(habitacion16);
		
		Huesped huesped1 = new Huesped("Juan", "Perez", "12345678");
        Huesped huesped2 = new Huesped("Maria", "Gomez", "87654321");
        Huesped huesped3 = new Huesped("Carlos", "Lopez", "11223344");
        Huesped huesped4 = new Huesped("Ana", "Martinez", "44332211");
        Huesped huesped5 = new Huesped("Luis", "Garcia", "55667788");
        Huesped huesped6 = new Huesped("Sofia", "Fernandez", "99887766");
        Huesped huesped7 = new Huesped("Pedro", "Gonzalez", "88776655");
        
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
        
		Controller controller = new Controller(clientes, gerente, habitaciones, reservas, gestorNotif, auditoria, politicas, vista);
	}
}
