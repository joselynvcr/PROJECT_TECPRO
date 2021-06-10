package saborea.model.bussiness.DTO;

public class RegistroEmpleadoBE {
	
	private String E_num_DNI;
	private String E_nom_Empleado;
	private String E_ape_Empleado;
	private String E_num_Telf;	
	private String E_estadoCivil;
	private String E_gender;
	private double E_sueldo;
	private int E_num_hijos;
	private String E_tipoCargo;
	private String Username;
	private String password;
	public RegistroEmpleadoBE(String e_num_DNI, String e_nom_Empleado, String e_ape_Empleado, String e_num_Telf,
			String e_estadoCivil, String e_gender, double e_sueldo, int e_num_hijos, String e_tipoCargo,
			String username, String password) {
		E_num_DNI = e_num_DNI;
		E_nom_Empleado = e_nom_Empleado;
		E_ape_Empleado = e_ape_Empleado;
		E_num_Telf = e_num_Telf;
		E_estadoCivil = e_estadoCivil;
		E_gender = e_gender;
		E_sueldo = e_sueldo;
		E_num_hijos = e_num_hijos;
		E_tipoCargo = e_tipoCargo;
		Username = username;
		this.password = password;
	}
	public String getE_num_DNI() {
		return E_num_DNI;
	}
	public void setE_num_DNI(String e_num_DNI) {
		E_num_DNI = e_num_DNI;
	}
	public String getE_nom_Empleado() {
		return E_nom_Empleado;
	}
	public void setE_nom_Empleado(String e_nom_Empleado) {
		E_nom_Empleado = e_nom_Empleado;
	}
	public String getE_ape_Empleado() {
		return E_ape_Empleado;
	}
	public void setE_ape_Empleado(String e_ape_Empleado) {
		E_ape_Empleado = e_ape_Empleado;
	}
	public String getE_num_Telf() {
		return E_num_Telf;
	}
	public void setE_num_Telf(String e_num_Telf) {
		E_num_Telf = e_num_Telf;
	}
	public String getE_estadoCivil() {
		return E_estadoCivil;
	}
	public void setE_estadoCivil(String e_estadoCivil) {
		E_estadoCivil = e_estadoCivil;
	}
	public String getE_gender() {
		return E_gender;
	}
	public void setE_gender(String e_gender) {
		E_gender = e_gender;
	}
	public double getE_sueldo() {
		return E_sueldo;
	}
	public void setE_sueldo(double e_sueldo) {
		E_sueldo = e_sueldo;
	}
	public int getE_num_hijos() {
		return E_num_hijos;
	}
	public void setE_num_hijos(int e_num_hijos) {
		E_num_hijos = e_num_hijos;
	}
	public String getE_tipoCargo() {
		return E_tipoCargo;
	}
	public void setE_tipoCargo(String e_tipoCargo) {
		E_tipoCargo = e_tipoCargo;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
	
	
}
