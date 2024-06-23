package model;

public class GestorDeNotificaciones {
	
	public void enviarNotificacion(AbstractCuenta destinatario, String mensaje, String medio) {
		System.out.println(destinatario.getNombre() + " recibició una notificación: " + mensaje + ". El medio usado fue " + medio);
	}
}
