package saborea.model.dao;


public class Producto {
	
	private int cod_produto;
	private String Nombre;
	private double precio;
	private int Stock;
	private String Descripci�n;			
	
	public Producto(int cod_produto, String nombre, double precio, int stock, String descripci�n) {
		
		this.cod_produto = cod_produto;
		Nombre = nombre;
		this.precio = precio;
		Stock = stock;
		Descripci�n = descripci�n;
	}
	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getDescripci�n() {
		return Descripci�n;
	}
	public void setDescripci�n(String descripci�n) {
		Descripci�n = descripci�n;
	}

	void ListarProductos(){						
	}
	void BuscarPorID(){		
	}
	void RegistrarProducto(){
		
	}	
	
}