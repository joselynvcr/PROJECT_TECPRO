package saborea.model.dao;

import java.sql.Date;

public class Boleta {		
	private int Cod_Boleta;
	private EmpleadoDAO mozo;
	private EmpleadoDAO cajero;
	private Date fecha;
	private Date hora;
	private double TotalPagar;
	private double VueltoPagar;
	private double dinero;
	private ClienteDAO cliente;
	private MesaDAO mesa;
	private Boolean pagado;	
}
