package model;

public class GestorDeNotificaciones {
	public void enviarNotificacion(AbstractCuenta destinatario, String mensaje, String medio) {
		System.out.println(destinatario.getNombre() + "Recibició una notificación: " + mensaje + ". El medio usado fue " + medio);
	}
}
