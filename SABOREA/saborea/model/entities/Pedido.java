package saborea.model.entities;

import java.sql.Timestamp;

public class Pedido {
		
	

	private int Cod_Pedido;
	private int codmozo;
	private Empleado Objmozo;
	private int codCajero;
	private Empleado Objcajero;
	private Timestamp FechaHora;	
	private double TotalPagar;	
	private String dniCliente;
	private Cliente Objcliente;
	private int codMesa;
	private Mesa Objmesa;
	private Boolean pagado; //nos servir? para saber si el pedido fue cancelado o no por el comensal , lo har? la cajera
	private Boolean enviado;
	
	public Pedido(){
		this.Cod_Pedido=-1;
		this.codmozo=-1;
		this.Objmozo=null;
		this.codCajero=-1;
		this.Objcajero=null;
		this.FechaHora=null;
		this.TotalPagar=-1;
		this.dniCliente=null;
		this.Objcliente=null;
		this.codMesa=-1;
		this.Objmesa=null;
		this.pagado=null;	
		this.enviado=null;
	}

	public Pedido(int cod_Pedido, int codmozo, Empleado objmozo, int codCajero, Empleado objcajero, Timestamp fechaHora,
			double totalPagar, String dniCliente, Cliente objcliente, int codMesa, Mesa objmesa, Boolean pagado,
			Boolean enviado) {
		this.Cod_Pedido = cod_Pedido;
		this.codmozo = codmozo;
		this.Objmozo = objmozo;
		this.codCajero = codCajero;
		this.Objcajero = objcajero;
		this.FechaHora = fechaHora;
		this.TotalPagar = totalPagar;
		this.dniCliente = dniCliente;
		this.Objcliente = objcliente;
		this.codMesa = codMesa;
		this.Objmesa = objmesa;
		this.pagado = pagado;
		this.enviado = enviado;
	}

	public int getCod_Pedido() {
		return Cod_Pedido;
	}

	public void setCod_Pedido(int cod_Pedido) {
		Cod_Pedido = cod_Pedido;
	}

	public int getCodmozo() {
		return codmozo;
	}

	public void setCodmozo(int codmozo) {
		this.codmozo = codmozo;
	}

	public Empleado getObjmozo() {
		return Objmozo;
	}

	public void setObjmozo(Empleado objmozo) {
		Objmozo = objmozo;
	}

	public int getCodCajero() {
		return codCajero;
	}

	public void setCodCajero(int codCajero) {
		this.codCajero = codCajero;
	}

	public Empleado getObjcajero() {
		return Objcajero;
	}

	public void setObjcajero(Empleado objcajero) {
		Objcajero = objcajero;
	}

	public Timestamp getFechaHora() {
		return FechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		FechaHora = fechaHora;
	}

	public double getTotalPagar() {
		return TotalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		TotalPagar = totalPagar;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public Cliente getObjcliente() {
		return Objcliente;
	}

	public void setObjcliente(Cliente objcliente) {
		Objcliente = objcliente;
	}

	public int getCodMesa() {
		return codMesa;
	}

	public void setCodMesa(int codMesa) {
		this.codMesa = codMesa;
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

	public Boolean getEnviado() {
		return enviado;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}

	@Override
	public String toString() {
		return "Pedido [Cod_Pedido=" + Cod_Pedido + ", codmozo=" + codmozo + ", Objmozo=" + Objmozo + ", codCajero="
				+ codCajero + ", Objcajero=" + Objcajero + ", FechaHora=" + FechaHora + ", TotalPagar=" + TotalPagar
				+ ", dniCliente=" + dniCliente + ", Objcliente=" + Objcliente + ", codMesa=" + codMesa + ", Objmesa="
				+ Objmesa + ", pagado=" + pagado + ", enviado=" + enviado + "]";
	}
	
	

	
	
	
	
	
	
}
