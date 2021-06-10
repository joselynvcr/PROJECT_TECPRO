package saborea.model.bussiness; //CAPA DE NEGOCIOS, TODA LA LÒGICA DE NEGOCIO VALIDAR LAS CREDENCIALES 

import java.util.ArrayList;
import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.bussiness.DTO.RegistroEmpleadoBE;
import saborea.model.bussiness.DTO.VwListaEmpleadosBE;
import saborea.model.dao.EmpleadoDAO;
import saborea.model.dao.LoginDAO;
import saborea.model.entities.Empleado;
import saborea.model.entities.login;

public class EmpleadoBussiness {
	//CREO UN OBJ TIPO LOGINDAO
	private LoginDAO objLogin;
	private EmpleadoDAO objEmpleado;
	
	//CONSTRUCTOR
	public EmpleadoBussiness(){
		objLogin=new LoginDAO();
		objEmpleado= new EmpleadoDAO();
	}
	//CREO UN MÈTODO QUE RETORNA UN ARRAYLIST TIPO CREDENCIALESBE 
	public ArrayList<CredencialesBE> ListarEmpleadosActivos(){
		//CREO UN ARRAYLIST TIPO LOGIN QUE RECIBE UNA LISTA DE LOGIN 
		 ArrayList<login> lista=objLogin.listar(true);
		//CREO UN ARRAYLIST TIPO CREDENCIALESBE QUE RECIBE UNA LISTA DE LOGIN
		 ArrayList<CredencialesBE> listaBE=new ArrayList<CredencialesBE>();
		for(int i=0;i<lista.size();i++){
			listaBE.add(new CredencialesBE(
					lista.get(i).getEmpleado_Id(),
					lista.get(i).getNom_User(),
					lista.get(i).getObjempleado().getNom_Empleado(),
					lista.get(i).getObjempleado().getApe_Empleado(),
					lista.get(i).getObjempleado().getTipoCargo_empleado()
					)); 
		}
		return listaBE;
	}
	
	
	public CredencialesBE ValidarCredenciales(String user, String pass) {		
		
		
		login auxLogin=new login(-1, user, pass, null, null);
		
		ArrayList<login> lista= objLogin.buscar(auxLogin, true);
		if(lista==null){		
										
			return null;		
		}else{		
			CredencialesBE cred= new CredencialesBE(
					lista.get(0).getEmpleado_Id(), 
					lista.get(0).getNom_User(), 
					lista.get(0).getObjempleado().getNom_Empleado(), 
					lista.get(0).getObjempleado().getApe_Empleado(),
					lista.get(0).getObjempleado().getTipoCargo_empleado()
					);
			return cred;
			//return null;
			
					
		}
		
		
		
	}
	
	public ArrayList<VwListaEmpleadosBE> ListarEmpleados(){
		
		 ArrayList<login> lista=objLogin.listar(true);
		
		 ArrayList<VwListaEmpleadosBE> listaBE=new ArrayList<VwListaEmpleadosBE>();
		for(int i=0;i<lista.size();i++){
			listaBE.add(new VwListaEmpleadosBE(
					lista.get(i).getEmpleado_Id(),
					lista.get(i).getObjempleado().getNum_DNI_empleado(),
					lista.get(i).getObjempleado().getNom_Empleado(),
					lista.get(i).getObjempleado().getApe_Empleado(),
					lista.get(i).getObjempleado().getNum_Telf_empleado(),
					lista.get(i).getObjempleado().getEstadoCivil_empleado(),
					lista.get(i).getObjempleado().getGender_empleado(),
					lista.get(i).getObjempleado().getSueldo_base_empleado(),
					lista.get(i).getObjempleado().getNum_hijos_empleado(),
					lista.get(i).getObjempleado().getTipoCargo_empleado(),
					lista.get(i).getObjempleado().getIdJefe()
					)
					); 
		}
		return listaBE;
	}
	
	public void RegistrarEmpleado(RegistroEmpleadoBE objE) {		
		//Empleado ObjEmpleado= new Empleado(0, null, null, null, 0, null, null, 0, 0, null, 0, null);
		
		Empleado ObjEmpleado= new Empleado(
				-1, objE.getE_num_DNI(),
				objE.getE_nom_Empleado(), 
				objE.getE_ape_Empleado(),
				objE.getE_num_Telf(), 
				objE.getE_estadoCivil(),
				objE.getE_gender(),
				objE.getE_sueldo(),
				objE.getE_num_hijos(),
				objE.getE_tipoCargo(),				
				-1,				
				null
				);
		Empleado ObjEmpleado2= new Empleado(
				-1,
				objE.getE_num_DNI(),
				null, 
				null,
				null, 
				null,
				null,
				-1,
				-1,
				null,								
				-1,				
				null
				);
		//ObjEmpleado=(Empleado) objE;
		objEmpleado.insertar(ObjEmpleado);	
		ArrayList<Empleado> ArrObjEmpleado=objEmpleado.buscar(ObjEmpleado2, false);
		
		login objLog= new login(ArrObjEmpleado.get(0).getIdEmpleado(),
				objE.getUsername(), objE.getPassword(), true, null);
		
		objLogin.insertar(objLog);	
		
	}
	
	//Buscar dni
	public boolean ValidarDNI (String dniAbuscar) {
		
		Empleado ObjEmpleado2= new Empleado(
				-1,
				dniAbuscar,
				null, 
				null,
				null, 
				null,
				null,
				-1,
				-1,
				null,								
				-1,				
				null
				);
		
		ArrayList<Empleado> ArrObjEmpleado=	objEmpleado.buscar(ObjEmpleado2, false);
		
		if(ArrObjEmpleado!=null) {
			//si existe un registro con el dni buscado en BD
			return false;
		}else {
			//no existe un registro con el dni buscado en BD
			return true;
		}
			
		
	}
	
	
	
}
	
	
	
	
	
	

