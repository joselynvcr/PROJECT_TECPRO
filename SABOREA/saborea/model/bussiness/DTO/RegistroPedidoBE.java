package saborea.model.bussiness.DTO;


import java.util.ArrayList;
public class RegistroPedidoBE {

	
	private int codmozo;	
	private int codCajero;		
	private String dniCliente;	
	private int codMesa;	
	private ArrayList<DetallePedidoBE> listaDetalle;
	
	
	
	public RegistroPedidoBE(int codmozo, int codCajero, String dniCliente, int codMesa,
			ArrayList<DetallePedidoBE> listaDetalle) {
		this.codmozo = codmozo;
		this.codCajero = codCajero;
		this.dniCliente = dniCliente;
		this.codMesa = codMesa;
		this.listaDetalle = listaDetalle;
	}
	public int getCodmozo() {
		return codmozo;
	}
	public void setCodmozo(int codmozo) {
		this.codmozo = codmozo;
	}
	public int getCodCajero() {
		return codCajero;
	}
	public void setCodCajero(int codCajero) {
		this.codCajero = codCajero;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public int getCodMesa() {
		return codMesa;
	}
	public void setCodMesa(int codMesa) {
		this.codMesa = codMesa;
	}
	public ArrayList<DetallePedidoBE> getListaDetalle() {
		return listaDetalle;
	}
	public void setListaDetalle(ArrayList<DetallePedidoBE> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
