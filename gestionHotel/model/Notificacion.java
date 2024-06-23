package model;

public class Notificacion {
	private String mensaje;
	private AbstractCuenta destinatario;
	private String medio;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public AbstractCuenta getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(AbstractCuenta destinatario) {
		this.destinatario = destinatario;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}
	
	
	
	public Notificacion(String mensaje, AbstractCuenta destinatario, String medio) {
		super();
		this.mensaje = mensaje;
		this.destinatario = destinatario;
		this.medio = medio;
	}
}
