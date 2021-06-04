package saborea.model.bussiness.DTO;

import saborea.model.entities.Empleado;

public class ListaEmpleadosBE {

	
	private int idEmpleado;
	private int num_DNI_empleado;
	private String nom_Empleado;
	private String ape_Empleado;
	private int num_Telf_empleado;	
	private String estadoCivil_empleado;
	private String gender_empleado;
	private double sueldo_base_empleado;
	private int num_hijos_empleado;
	private String tipoCargo_empleado;
	private int idJefe;
	
	public ListaEmpleadosBE(int idEmpleado, int num_DNI_empleado, String nom_Empleado, String ape_Empleado,
			int num_Telf_empleado, String estadoCivil_empleado, String gender_empleado, double sueldo_base_empleado,
			int num_hijos_empleado, String tipoCargo_empleado, int idJefe) {
		this.idEmpleado = idEmpleado;
		this.num_DNI_empleado = num_DNI_empleado;
		this.nom_Empleado = nom_Empleado;
		this.ape_Empleado = ape_Empleado;
		this.num_Telf_empleado = num_Telf_empleado;
		this.estadoCivil_empleado = estadoCivil_empleado;
		this.gender_empleado = gender_empleado;
		this.sueldo_base_empleado = sueldo_base_empleado;
		this.num_hijos_empleado = num_hijos_empleado;
		this.tipoCargo_empleado = tipoCargo_empleado;
		this.idJefe = idJefe;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getNum_DNI_empleado() {
		return num_DNI_empleado;
	}
	public void setNum_DNI_empleado(int num_DNI_empleado) {
		this.num_DNI_empleado = num_DNI_empleado;
	}
	public String getNom_Empleado() {
		return nom_Empleado;
	}
	public void setNom_Empleado(String nom_Empleado) {
		this.nom_Empleado = nom_Empleado;
	}
	public String getApe_Empleado() {
		return ape_Empleado;
	}
	public void setApe_Empleado(String ape_Empleado) {
		this.ape_Empleado = ape_Empleado;
	}
	public int getNum_Telf_empleado() {
		return num_Telf_empleado;
	}
	public void setNum_Telf_empleado(int num_Telf_empleado) {
		this.num_Telf_empleado = num_Telf_empleado;
	}
	public String getEstadoCivil_empleado() {
		return estadoCivil_empleado;
	}
	public void setEstadoCivil_empleado(String estadoCivil_empleado) {
		this.estadoCivil_empleado = estadoCivil_empleado;
	}
	public String getGender_empleado() {
		return gender_empleado;
	}
	public void setGender_empleado(String gender_empleado) {
		this.gender_empleado = gender_empleado;
	}
	public double getSueldo_base_empleado() {
		return sueldo_base_empleado;
	}
	public void setSueldo_base_empleado(double sueldo_base_empleado) {
		this.sueldo_base_empleado = sueldo_base_empleado;
	}
	public int getNum_hijos_empleado() {
		return num_hijos_empleado;
	}
	public void setNum_hijos_empleado(int num_hijos_empleado) {
		this.num_hijos_empleado = num_hijos_empleado;
	}
	public String getTipoCargo_empleado() {
		return tipoCargo_empleado;
	}
	public void setTipoCargo_empleado(String tipoCargo_empleado) {
		this.tipoCargo_empleado = tipoCargo_empleado;
	}
	public int getIdJefe() {
		return idJefe;
	}
	public void setIdJefe(int idJefe) {
		this.idJefe = idJefe;
	}
	
	
	
	
	
	
}