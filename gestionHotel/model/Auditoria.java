package model;

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
	}
	
	public void agregarEvento(EventoAuditoria evento) {
		eventos.add(evento);
	}
	
	public EventoAuditoria obtenerEventoPorId(String idEvento) {
		return null;
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
}
