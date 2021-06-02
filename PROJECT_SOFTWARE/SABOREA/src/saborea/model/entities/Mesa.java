package saborea.model.entities;

public class Mesa {

	private int nro_mesa;
	private Boolean disponibilidad_mesa ;
	private int capacidad_mesa;
	public Mesa(){
		this.nro_mesa=-1;
		this.disponibilidad_mesa=null;
		this.capacidad_mesa=0;
	}
	public Mesa(int nro_mesa, Boolean disponibilidad_mesa, int capacidad_mesa) {
		this.nro_mesa = nro_mesa;
		this.disponibilidad_mesa = disponibilidad_mesa;
		this.capacidad_mesa = capacidad_mesa;
	}
	public int getNro_mesa() {
		return nro_mesa;
	}
	public void setNro_mesa(int nro_mesa) {
		this.nro_mesa = nro_mesa;
	}
	public Boolean getDisponibilidad_mesa() {
		return disponibilidad_mesa;
	}
	public void setDisponibilidad_mesa(Boolean disponibilidad_mesa) {
		this.disponibilidad_mesa = disponibilidad_mesa;
	}
	public int getCapacidad_mesa() {
		return capacidad_mesa;
	}
	public void setCapacidad_mesa(int capacidad_mesa) {
		this.capacidad_mesa = capacidad_mesa;
	}

	
	
	
	
}
