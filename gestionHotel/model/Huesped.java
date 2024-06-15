package model;

public class Huesped {
	private int idHuesped;
	private int nombre;
	private int apellido;
	private int DNI;
	
	public int getIdHuesped() {
		return idHuesped;
	}
	public void setIdHuesped(int idHuesped) {
		this.idHuesped = idHuesped;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getApellido() {
		return apellido;
	}
	public void setApellido(int apellido) {
		this.apellido = apellido;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	
	public Huesped(int idHuesped, int nombre, int apellido, int dNI) {
		super();
		this.idHuesped = idHuesped;
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
	}
	
	
}
