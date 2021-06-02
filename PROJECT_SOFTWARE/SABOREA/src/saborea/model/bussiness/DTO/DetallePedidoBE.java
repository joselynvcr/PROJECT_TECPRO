package saborea.model.bussiness.DTO;

public class DetallePedidoBE {
	
	private int codProducto;
	private int cantidad;
	
	public DetallePedidoBE(int codProducto, int cantidad) {
		this.codProducto = codProducto;
		this.cantidad = cantidad;
	}
	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
}
