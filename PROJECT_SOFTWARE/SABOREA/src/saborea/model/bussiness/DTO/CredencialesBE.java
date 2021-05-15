package saborea.model.bussiness.DTO;

//CREDENCIADES BUSSINESS ENTITIE //CREDENCIALES DE ENTIDAD DE NEGOCIO
public class CredencialesBE {
	private int EmpleadoId;
	private String Username;
	private String NombreEmpleado;
	private String ApellidoEmpleado;
	public CredencialesBE(int empleadoId, String username, String nombreEmpleado, String apellidoEmpleado) {
		EmpleadoId = empleadoId;
		Username = username;
		NombreEmpleado = nombreEmpleado;
		ApellidoEmpleado = apellidoEmpleado;
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
	

}
