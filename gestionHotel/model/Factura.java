package model;

public class Factura {
	
	private int idFactura;
	private Reserva reserva;
	
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public Factura(int idFactura, Reserva reserva) {
		super();
		this.idFactura = idFactura;
		this.reserva = reserva;
	}	
}
