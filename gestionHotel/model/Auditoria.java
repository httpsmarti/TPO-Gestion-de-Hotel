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
		//logica
	}
	
}
