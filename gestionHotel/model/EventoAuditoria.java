package model;

import java.util.*;

public class EventoAuditoria {
	
	private String idEvento;
	private Date Fecha;
	private String Titulo;
	private String Descripcion;
	
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	public String getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}
	
	public EventoAuditoria(String idEvento, Date fecha, String titulo, String descripcion) {
		super();
		this.idEvento = idEvento;
		Fecha = fecha;
		Titulo = titulo;
		Descripcion = descripcion;
	}
}
