package saborea.model.entities;

public class Detalle_Pedido {
	
	private int CodPedido;
	private Pedido ObjPedido;	
	private int CantidadProductos;
	private int CodProducto;
	private Producto Objproducto;
	private double precio;
	private double total;
	
	public Detalle_Pedido(){
		
		this.CodPedido=-1;
		this.ObjPedido=null;
		this.CantidadProductos=-1;
		this.CodProducto=-1;
		this.Objproducto=null;
		this.precio=-1;
		this.total=-1;
	}

	public Detalle_Pedido(int codPedido, Pedido objPedido, int cantidadProductos, int codProducto, Producto objproducto,
			double precio, double total) {
		CodPedido = codPedido;
		ObjPedido = objPedido;
		CantidadProductos = cantidadProductos;
		CodProducto = codProducto;
		Objproducto = objproducto;
		this.precio = precio;
		this.total = total;
	}

	public int getCodPedido() {
		return CodPedido;
	}

	public void setCodPedido(int codPedido) {
		CodPedido = codPedido;
	}

	public Pedido getObjPedido() {
		return ObjPedido;
	}

	public void setObjPedido(Pedido objPedido) {
		ObjPedido = objPedido;
	}

	public int getCantidadProductos() {
		return CantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) {
		CantidadProductos = cantidadProductos;
	}

	public int getCodProducto() {
		return CodProducto;
	}

	public void setCodProducto(int codProducto) {
		CodProducto = codProducto;
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
