package model;

import java.util.*;

import interfaces.PagoStrategy;

public class Reserva {
	private int idReserva;
	private Double precio;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaReserva;
	private List<AbstractHabitacion> habitaciones; //pasar a lista -- 
	private String DNIClienteReserva;
	private List<Huesped> huespedes;
	private PagoContexto pagoContexto;
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
	public List<AbstractHabitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitacion(List<AbstractHabitacion> habitaciones) {
		this.habitaciones = habitaciones;
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
	public PagoContexto getPagoContexto() {
		return pagoContexto;
	}
	public void setPagoContexto(PagoContexto pagoContexto) {
		this.pagoContexto = pagoContexto;
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
	public Double getPrecio() {
		return this.precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Reserva(int idReserva, Double precio, Date fechaInicio, Date fechaFin, Date fechaReserva, List<AbstractHabitacion> habitaciones,
			String DNIClienteReserva, List<Huesped> huespedes, PagoContexto pagoContexto, String estado) {
		super();
		this.idReserva = idReserva;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaReserva = fechaReserva;
		this.habitaciones = new ArrayList<AbstractHabitacion>();
		this.DNIClienteReserva = DNIClienteReserva;
		this.huespedes = huespedes;
		this.pagoContexto = pagoContexto;
		Estado = estado;
	}
}
