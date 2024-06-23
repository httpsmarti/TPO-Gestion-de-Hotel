package model;

import java.time.LocalDate;
import java.util.*;

public class Auditoria {
	private List<EventoAuditoria> eventos;

	public Auditoria(List<EventoAuditoria> eventos) {
		super();
		this.eventos = eventos;
	}

	public Auditoria() {
		super();
		this.eventos = new ArrayList<EventoAuditoria>();
		EventoAuditoria evento = new EventoAuditoria("0", new Date() , "Inicialización", "Se inició el sistema.");
		eventos.add(evento);
	}
	
	public void agregarEvento(Date fecha, String titulo, String descripcion) {
		eventos.add(new EventoAuditoria(generarIdEvento(), fecha, titulo, descripcion));
	}
	
	public EventoAuditoria obtenerEventoPorId(String idEvento) {
		EventoAuditoria e = null;
		for (int i = 0; i < eventos.size(); i++) {
		    EventoAuditoria eventoActual = eventos.get(i);
		    String idEventoActual = eventoActual.getIdEvento();
		    if (idEventoActual.equals(idEvento)) {
		      e = eventos.get(i);
		      break;
		    }
		}
		return e;
	}
	
	public void eliminarEventoPorId(String idEvento) {
		for (int i = 0; i < eventos.size(); i++) {
		    EventoAuditoria eventoActual = eventos.get(i);
		    String idEventoActual = eventoActual.getIdEvento();
		    if (idEventoActual.equals(idEvento)) {
		      eventos.remove(i);
		      break;
		    }
		}
	}
	
	public String generarIdEvento() {
		return String.valueOf(Integer.parseInt(eventos.get(eventos.size()-1).getIdEvento()) + 1);
		
	}
	
	public void mostrarLogs() {
		for (EventoAuditoria e : eventos) {
			System.out.println("Titutlo: " + e.getTitulo() + ". Descripcion: " + e.getDescripcion() + ". Fecha: " + e.getFecha());
		}
	}
}