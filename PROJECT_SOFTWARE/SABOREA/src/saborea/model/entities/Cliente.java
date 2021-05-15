package saborea.model.entities;

public class Cliente {

	private int cod_cliente;
	private int num_dni;
	private String nom_cliente;
	private String ape_cliente;
	public Cliente(int cod_cliente, int num_dni_cliente, String nom_cliente, String ape_cliente) {
		this.cod_cliente = cod_cliente;
		this.num_dni = num_dni_cliente;
		this.nom_cliente = nom_cliente;
		this.ape_cliente = ape_cliente;
	}
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public int getNum_dni_cliente() {
		return num_dni;
	}
	public void setNum_dni_cliente(int num_dni_cliente) {
		this.num_dni = num_dni_cliente;
	}
	public String getNom_cliente() {
		return nom_cliente;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	public String getApe_cliente() {
		return ape_cliente;
	}
	public void setApe_cliente(String ape_cliente) {
		this.ape_cliente = ape_cliente;
	}
	
	
	
	
	
}
