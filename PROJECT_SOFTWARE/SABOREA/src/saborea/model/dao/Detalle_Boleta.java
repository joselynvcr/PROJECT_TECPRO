package saborea.model.dao;

public class Detalle_Boleta {

	private Boleta _Boleta;
	private int CantidadProductos;
	private Producto _Productos;
	private double precio;
	private double total;
	public Detalle_Boleta(Boleta _Boleta, int cantidadProductos, Producto _Productos, double precio, double total) {
		this._Boleta = _Boleta;
		CantidadProductos = cantidadProductos;
		this._Productos = _Productos;
		this.precio = precio;
		this.total = total;
	}
	public Boleta get_Boleta() {
		return _Boleta;
	}
	public void set_Boleta(Boleta _Boleta) {
		this._Boleta = _Boleta;
	}
	public int getCantidadProductos() {
		return CantidadProductos;
	}
	public void setCantidadProductos(int cantidadProductos) {
		CantidadProductos = cantidadProductos;
	}
	public Producto get_Productos() {
		return _Productos;
	}
	public void set_Productos(Producto _Productos) {
		this._Productos = _Productos;
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