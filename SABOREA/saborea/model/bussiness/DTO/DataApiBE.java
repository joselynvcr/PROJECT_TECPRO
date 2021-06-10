package saborea.model.bussiness.DTO;

public class DataApiBE {

	private int dni;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	public DataApiBE() {
		
	}
	public DataApiBE(int dni, String nombres, String apellidoPaterno, String apellidoMaterno) {
		super();
		this.dni = dni;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
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
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	@Override
	public String toString() {
		return "DataApiBE [dni=" + dni + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + "]";
	}

	
	
	
	
	
	
	
}
