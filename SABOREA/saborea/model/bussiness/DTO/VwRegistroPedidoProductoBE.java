package saborea.model.bussiness.DTO;

import java.util.ArrayList;

public class VwRegistroPedidoProductoBE {
	
	private int PedidoId;
	private String nombreMozo;
	private String apellidoMozo;
	private int codmozo;	
	private String dniCliente;	
	private int codMesa;	
	private ArrayList<VwDetallePedidoBE> listaDetalle;
	private boolean enable;
	private double total;
	
	public VwRegistroPedidoProductoBE(int pedidoId, String nombreMozo, String apellidoMozo, int codmozo,
			String dniCliente, int codMesa, ArrayList<VwDetallePedidoBE> listaDetalle, boolean enable, double total) {
		PedidoId = pedidoId;
		this.nombreMozo = nombreMozo;
		this.apellidoMozo = apellidoMozo;
		this.codmozo = codmozo;
		this.dniCliente = dniCliente;
		this.codMesa = codMesa;
		this.listaDetalle = listaDetalle;
		this.enable = enable;
		this.total = total;
	}
	public int getPedidoId() {
		return PedidoId;
	}
	public void setPedidoId(int pedidoId) {
		PedidoId = pedidoId;
	}
	public String getNombreMozo() {
		return nombreMozo;
	}
	public void setNombreMozo(String nombreMozo) {
		this.nombreMozo = nombreMozo;
	}
	public String getApellidoMozo() {
		return apellidoMozo;
	}
	public void setApellidoMozo(String apellidoMozo) {
		this.apellidoMozo = apellidoMozo;
	}
	public int getCodmozo() {
		return codmozo;
	}
	public void setCodmozo(int codmozo) {
		this.codmozo = codmozo;
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
	public ArrayList<VwDetallePedidoBE> getListaDetalle() {
		return listaDetalle;
	}
	public void setListaDetalle(ArrayList<VwDetallePedidoBE> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	
	
	
	
	
	
	
	

}
