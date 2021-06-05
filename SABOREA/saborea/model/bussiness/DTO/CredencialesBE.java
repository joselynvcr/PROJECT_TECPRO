
package saborea.model.bussiness.DTO;

//CREDENCIADES BUSSINESS ENTITIE //CREDENCIALES DE ENTIDAD DE NEGOCIO//DTO= DATA TRANSFERECE OBJECT = PARA TRANSFERIR INFORMACIÒN A LA VISTA MEDIANTE OBJETOS
public class CredencialesBE {
	
	private int EmpleadoId;
	private String Username;
	private String NombreEmpleado;
	private String ApellidoEmpleado;
	private String TipoCargo;
	
	public CredencialesBE(int empleadoId, String username, String nombreEmpleado, String apellidoEmpleado,
			String tipoCargo) {
		EmpleadoId = empleadoId;
		Username = username;
		NombreEmpleado = nombreEmpleado;
		ApellidoEmpleado = apellidoEmpleado;
		TipoCargo = tipoCargo;
	}
	
	public int getEmpleadoId() {
		return EmpleadoId;
	}
	public void setEmpleadoId(int empleadoId) {
		EmpleadoId = empleadoId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getNombreEmpleado() {
		return NombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		NombreEmpleado = nombreEmpleado;
	}
	public String getApellidoEmpleado() {
		return ApellidoEmpleado;
	}
	public void setApellidoEmpleado(String apellidoEmpleado) {
		ApellidoEmpleado = apellidoEmpleado;
	}
	public String getTipoCargo() {
		return TipoCargo;
	}
	public void setTipoCargo(String tipoCargo) {
		TipoCargo = tipoCargo;
	}
	
	
	

}
