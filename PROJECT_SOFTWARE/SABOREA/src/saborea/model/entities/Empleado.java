package saborea.model.entities;

public class Empleado {
	
	private int codEmpleado;
	private int num_DNI_empleado;
	private String nom_Empleado;
	private String ape_Empleado;
	private int num_Telf_empleado;	
	private String casado_empleado;
	private String gender_empleado;
	private Double sueldo_base_empleado;
	private int num_hijos_empleado;
	private String TipoCargo_empleado;
	
	public Empleado(int codEmpleado, int num_DNI_empleado, String nom_Empleado, String ape_Empleado,
			int num_Telf_empleado, String casado_empleado, String gender_empleado, Double sueldo_base_empleado,
			int num_hijos_empleado, String tipoCargo_empleado) {
		this.codEmpleado = codEmpleado;
		this.num_DNI_empleado = num_DNI_empleado;
		this.nom_Empleado = nom_Empleado;
		this.ape_Empleado = ape_Empleado;
		this.num_Telf_empleado = num_Telf_empleado;
		this.casado_empleado = casado_empleado;
		this.gender_empleado = gender_empleado;
		this.sueldo_base_empleado = sueldo_base_empleado;
		this.num_hijos_empleado = num_hijos_empleado;
		TipoCargo_empleado = tipoCargo_empleado;
	}
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
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
	public String getCasado_empleado() {
		return casado_empleado;
	}
	public void setCasado_empleado(String casado_empleado) {
		this.casado_empleado = casado_empleado;
	}
	public String getGender_empleado() {
		return gender_empleado;
	}
	public void setGender_empleado(String gender_empleado) {
		this.gender_empleado = gender_empleado;
	}
	public Double getSueldo_base_empleado() {
		return sueldo_base_empleado;
	}
	public void setSueldo_base_empleado(Double sueldo_base_empleado) {
		this.sueldo_base_empleado = sueldo_base_empleado;
	}
	public int getNum_hijos_empleado() {
		return num_hijos_empleado;
	}
	public void setNum_hijos_empleado(int num_hijos_empleado) {
		this.num_hijos_empleado = num_hijos_empleado;
	}
	public String getTipoCargo_empleado() {
		return TipoCargo_empleado;
	}
	public void setTipoCargo_empleado(String tipoCargo_empleado) {
		TipoCargo_empleado = tipoCargo_empleado;
	}	
	
	
	
	
	
	
	
	
}
