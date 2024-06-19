package model;

public class Huesped {
	private String idHuesped;
	private String nombre;
	private String apellido;
	private String DNI;
	
	public String getIdHuesped() {
		return idHuesped;
	}
	public void setIdHuesped(String idHuesped) {
		this.idHuesped = idHuesped;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public Huesped(String idHuesped, String nombre, String apellido, String dNI) {
		super();
		this.idHuesped = idHuesped;
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
	}
	
	
}
