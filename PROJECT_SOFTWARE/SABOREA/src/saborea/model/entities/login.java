package saborea.model.entities;

public class login {
	
	private Empleado Objempleado;	
	private int empleado_Id;
	private String nom_User;
	private String password_user;
	private Boolean estadoUsuario_user;
	//nos servir� para saber si el usuario est� activo o no, el usuario estar� activo
	//siempre en cuando el empleado siga trabajando, de lo contrario el usuario estara en modo inactivo.
		
	public login(int empleado_Id, String nom_User, String password_user,
			Boolean estadoUsuario_user,Empleado objempleado) {		
		this.empleado_Id = empleado_Id;
		this.nom_User = nom_User;
		this.password_user = password_user;
		this.estadoUsuario_user = estadoUsuario_user;		
		Objempleado = objempleado;
	}
	public Empleado getObjempleado() {
		return Objempleado;
	}
	public void setObjempleado(Empleado objempleado) {
		Objempleado = objempleado;
	}
	public int getEmpleado_Id() {
		return empleado_Id;
	}
	public void setEmpleado_Id(int empleado_Id) {
		this.empleado_Id = empleado_Id;
	}
	public String getNom_User() {
		return nom_User;
	}
	public void setNom_User(String nom_User) {
		this.nom_User = nom_User;
	}
	public String getPassword_user() {
		return password_user;
	}
	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}
	public Boolean getEstadoUsuario_user() {
		return estadoUsuario_user;
	}
	public void setEstadoUsuario_user(Boolean estadoUsuario_user) {
		this.estadoUsuario_user = estadoUsuario_user;
	}
	
	
	
	
		
	
	
	
	
	
	
	
	
}
