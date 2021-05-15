package saborea.model.entities;

import java.sql.Date;

public class Boleta {
		
	private int Cod_Boleta;
	private Empleado Objmozo;
	private Empleado Objcajero;
	private Date fecha;
	private Date hora;
	private double TotalPagar;	
	private Cliente Objcliente;
	private Mesa Objmesa;
	private Boolean pagado; //nos servirà para saber si el pedido fue cancelado o no por el comensal , lo harà la cajera
	public Boleta(int cod_Boleta, Empleado objmozo, Empleado objcajero, Date fecha, Date hora, double totalPagar,
			Cliente objcliente, Mesa objmesa, Boolean pagado) {
		Cod_Boleta = cod_Boleta;
		Objmozo = objmozo;
		Objcajero = objcajero;
		this.fecha = fecha;
		this.hora = hora;
		TotalPagar = totalPagar;
		Objcliente = objcliente;
		Objmesa = objmesa;
		this.pagado = pagado;
	}
	public int getCod_Boleta() {
		return Cod_Boleta;
	}
	public void setCod_Boleta(int cod_Boleta) {
		Cod_Boleta = cod_Boleta;
	}
	public Empleado getObjmozo() {
		return Objmozo;
	}
	public void setObjmozo(Empleado objmozo) {
		Objmozo = objmozo;
	}
	public Empleado getObjcajero() {
		return Objcajero;
	}
	public void setObjcajero(Empleado objcajero) {
		Objcajero = objcajero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public double getTotalPagar() {
		return TotalPagar;
	}
	public void setTotalPagar(double totalPagar) {
		TotalPagar = totalPagar;
	}
	public Cliente getObjcliente() {
		return Objcliente;
	}
	public void setObjcliente(Cliente objcliente) {
		Objcliente = objcliente;
	}
	public Mesa getObjmesa() {
		return Objmesa;
	}
	public void setObjmesa(Mesa objmesa) {
		Objmesa = objmesa;
	}
	public Boolean getPagado() {
		return pagado;
	}
	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}
	
	
	
	
	
	
	
}
