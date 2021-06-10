package saborea.model.bussiness.DTO;

import java.sql.Timestamp;
import java.util.ArrayList;

import saborea.model.entities.Detalle_Pedido;


public class ListaPedidosBE {
	
	private int Idpedido;
	private String nomApeMozo;
	private String nomApeCajero;		
	private Timestamp fechaHora;
	private String dni_Cliente;
	private String nomApeCliente;
	private int nroMesa;
	private Boolean pagado;
	private double TotalPagar;
	private ArrayList<VwDetallePedidoBE> listaDetalle;
	public ListaPedidosBE(int idpedido, String nomApeMozo, String nomApeCajero, Timestamp fechaHora, String dni_Cliente,
			String nomApeCliente, int nroMesa, Boolean pagado, double totalPagar,
			ArrayList<VwDetallePedidoBE> listaDetalle) {
		Idpedido = idpedido;
		this.nomApeMozo = nomApeMozo;
		this.nomApeCajero = nomApeCajero;
		this.fechaHora = fechaHora;
		this.dni_Cliente = dni_Cliente;
		this.nomApeCliente = nomApeCliente;
		this.nroMesa = nroMesa;
		this.pagado = pagado;
		TotalPagar = totalPagar;
		this.listaDetalle = listaDetalle;
	}
	public int getIdpedido() {
		return Idpedido;
	}
	public void setIdpedido(int idpedido) {
		Idpedido = idpedido;
	}
	public String getNomApeMozo() {
		return nomApeMozo;
	}
	public void setNomApeMozo(String nomApeMozo) {
		this.nomApeMozo = nomApeMozo;
	}
	public String getNomApeCajero() {
		return nomApeCajero;
	}
	public void setNomApeCajero(String nomApeCajero) {
		this.nomApeCajero = nomApeCajero;
	}
	public Timestamp getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getDni_Cliente() {
		return dni_Cliente;
	}
	public void setDni_Cliente(String dni_Cliente) {
		this.dni_Cliente = dni_Cliente;
	}
	public String getNomApeCliente() {
		return nomApeCliente;
	}
	public void setNomApeCliente(String nomApeCliente) {
		this.nomApeCliente = nomApeCliente;
	}
	public int getNroMesa() {
		return nroMesa;
	}
	public void setNroMesa(int nroMesa) {
		this.nroMesa = nroMesa;
	}
	public Boolean getPagado() {
		return pagado;
	}
	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}
	public double getTotalPagar() {
		return TotalPagar;
	}
	public void setTotalPagar(double totalPagar) {
		TotalPagar = totalPagar;
	}
	public ArrayList<VwDetallePedidoBE> getListaDetalle() {
		return listaDetalle;
	}
	public void setListaDetalle(ArrayList<VwDetallePedidoBE> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	
	
	

	
	
	
	
	
	
	
	

}
