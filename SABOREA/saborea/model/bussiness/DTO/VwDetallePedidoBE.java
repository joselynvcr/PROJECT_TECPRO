package saborea.model.bussiness.DTO;

public class VwDetallePedidoBE {
	
	private int codProducto;
	private String nombreProducto;	
	private int cantidad;
	private double precio;
	private double subtotal;
	
	public VwDetallePedidoBE(int codProducto, String nombreProducto, int cantidad, double precio, double subtotal) {
		this.codProducto = codProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
	}
	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
