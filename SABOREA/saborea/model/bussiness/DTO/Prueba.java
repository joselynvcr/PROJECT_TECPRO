package saborea.model.bussiness.DTO;

public class Prueba {
	
	private int dni;
	private String nombres;
//	String apellidoPaterno;
//	String apellidoMaterno;
	public Prueba(int dni, String nombres) {
		super();
		this.dni = dni;
		this.nombres = nombres;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	@Override
	public String toString() {
		return "Prueba [dni=" + dni + ", nombres=" + nombres + "]";
	}
	
	
	
}
