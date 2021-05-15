package saborea.model.entities;

public class Detalle_Boleta {

	private Boleta Objboleta;
	private int CantidadProductos;
	private Producto Objproducto;
	private double precio;
	private double total;
	public Detalle_Boleta(Boleta objboleta, int cantidadProductos, Producto objproducto, double precio, double total) {
		Objboleta = objboleta;
		CantidadProductos = cantidadProductos;
		Objproducto = objproducto;
		this.precio = precio;
		this.total = total;
	}
	public Boleta getObjboleta() {
		return Objboleta;
	}
	public void setObjboleta(Boleta objboleta) {
		Objboleta = objboleta;
	}
	public int getCantidadProductos() {
		return CantidadProductos;
	}
	public void setCantidadProductos(int cantidadProductos) {
		CantidadProductos = cantidadProductos;
	}
	public Producto getObjproducto() {
		return Objproducto;
	}
	public void setObjproducto(Producto objproducto) {
		Objproducto = objproducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}