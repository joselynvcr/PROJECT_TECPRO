package saborea.model.entities;

public class Cliente {

	private String num_dni;
	private String nom_cliente;
	private String ape_cliente;
	
	public Cliente(){
		
		this.num_dni=null;
		this.nom_cliente=null;
		this.ape_cliente=null;
	}

	public Cliente( String num_dni, String nom_cliente, String ape_cliente) {		
		this.num_dni = num_dni;
		this.nom_cliente = nom_cliente;
		this.ape_cliente = ape_cliente;
	}	
	public String getNum_dni() {
		return num_dni;
	}

	public void setNum_dni(String num_dni) {
		this.num_dni = num_dni;
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
