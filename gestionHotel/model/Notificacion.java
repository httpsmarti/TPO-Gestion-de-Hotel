package model;

public class Notificacion {
	private String idNotificacion;
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
	
	public String getIdNotificacion() {
		return idNotificacion;
	}
	
	public void setIdNotificacion(String idNotificacion) {
		this.idNotificacion = idNotificacion;
	}
	
	public Notificacion(String idNotificacion, String mensaje, AbstractCuenta destinatario, String medio) {
		super();
		this.idNotificacion = idNotificacion;
		this.mensaje = mensaje;
		this.destinatario = destinatario;
		this.medio = medio;
	}
}
