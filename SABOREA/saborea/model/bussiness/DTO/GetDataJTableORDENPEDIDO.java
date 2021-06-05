package saborea.model.bussiness.DTO;

public class GetDataJTableORDENPEDIDO {
	
	private int id;
	private String nombre;
	private double precio;
	private  int cantidadSeleccionada;
	public GetDataJTableORDENPEDIDO(int id, String nombre, double precio, int cantidadSeleccionada) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadSeleccionada = cantidadSeleccionada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidadSeleccionada() {
		return cantidadSeleccionada;
	}
	public void setCantidadSeleccionada(int cantidadSeleccionada) {
		this.cantidadSeleccionada = cantidadSeleccionada;
	}
	
	
	
	
	
	

}
