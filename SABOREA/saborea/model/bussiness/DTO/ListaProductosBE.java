package saborea.model.bussiness.DTO;

import java.util.ArrayList;

import saborea.model.entities.Producto;

public class ListaProductosBE {
	
	private int Id;
	private String nombre;	
	private double precio;
	private int stock;
	private String category;
	
	
	public ListaProductosBE(int id, String nombre, double precio, int stock, String category) {
		Id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.category = category;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	
	
	
	
	
	
	
//	public void MostrarProductos(){
//		for(int i=0;i<listaProd.size();i++){
//			listaProd.
//			
//			
//		}
//	}
//	
	
	

}
