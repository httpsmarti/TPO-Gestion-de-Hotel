package model;

import java.util.*;

import interfaces.PagoStrategy;

public class Reserva {
	int idReserva;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaReserva;
	private AbstractHabitacion habitacion;
	private String DNIClienteReserva;
	private List<Huesped> huespedes;
	private PagoStrategy medioDePago;
	private String Estado;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public AbstractHabitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(AbstractHabitacion habitacion) {
		this.habitacion = habitacion;
	}
	public String getDNIClienteReserva() {
		return DNIClienteReserva;
	}
	public void setDNIClienteReserva(String dNIClienteReserva) {
		DNIClienteReserva = dNIClienteReserva;
	}
	public List<Huesped> getHuespedes() {
		return huespedes;
	}
	public void setHuespedes(List<Huesped> huespedes) {
		this.huespedes = huespedes;
	}
	public PagoStrategy getMedioDePago() {
		return medioDePago;
	}
	public void setMedioDePago(PagoStrategy medioDePago) {
		this.medioDePago = medioDePago;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setEstado(int idReserva) {
		this.idReserva = idReserva;
	}

	public Reserva(int idReserva, Date fechaInicio, Date fechaFin, Date fechaReserva, AbstractHabitacion habitacion,
			String dNIClienteReserva, List<Huesped> huespedes, PagoStrategy medioDePago, String estado) {
		super();
		this.idReserva = idReserva;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaReserva = fechaReserva;
		this.habitacion = habitacion;
		DNIClienteReserva = dNIClienteReserva;
		this.huespedes = huespedes;
		this.medioDePago = medioDePago;
		Estado = estado;
	}
	
	
}
