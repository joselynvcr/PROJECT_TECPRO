package saborea.model.entities;


public class Producto {
	
	private int cod_produto;
	private String nom_producto;
	private double precio_producto;
	private int stock_producto;	
	private String category;
	
	public Producto(){
		this.cod_produto=-1;
		this.nom_producto=null;
		this.precio_producto=-1;
		this.stock_producto=-1;
		this.category=null;		
	}

	public Producto(int cod_produto, String nom_producto, double precio_producto, int stock_producto, String category) {
		this.cod_produto = cod_produto;
		this.nom_producto = nom_producto;
		this.precio_producto = precio_producto;
		this.stock_producto = stock_producto;
		this.category = category;
	}

	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public String getNom_producto() {
		return nom_producto;
	}

	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}

	public double getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(double precio_producto) {
		this.precio_producto = precio_producto;
	}

	public int getStock_producto() {
		return stock_producto;
	}

	public void setStock_producto(int stock_producto) {
		this.stock_producto = stock_producto;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
	
}
