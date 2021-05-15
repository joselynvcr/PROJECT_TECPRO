package saborea.model.bussiness;

import java.util.ArrayList;

import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.dao.EmpleadoDAO;
import saborea.model.dao.LoginDAO;
import saborea.model.entities.login;

public class EmpleadoBussiness {
	//CREO UN OBJ TIPO LOGINDAO
	private LoginDAO objLogin;
	
	//CONSTRUCTOR
	public EmpleadoBussiness(){
		objLogin=new LoginDAO();		
	}
	//CREO UN M�TODO QUE RETORNA UN ARRAYLIST TIPO CREDENCIALESBE 
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
					lista.get(i).getObjempleado().getApe_Empleado()	
					)); 
		}
		return listaBE;
	}
	
	
	public CredencialesBE ValidarCredenciales(String user, String pass){		
		
		String condition="where nom_User='"+ user + "' and Password='" + pass+"'";
		
		ArrayList<login> lista= objLogin.buscar(condition, true);
		
		if(lista==null){
			return null;		
		}else{
			CredencialesBE cred= new CredencialesBE(
					lista.get(0).getEmpleado_Id(), 
					lista.get(0).getNom_User(), 
					lista.get(0).getObjempleado().getNom_Empleado(), 
					lista.get(0).getObjempleado().getApe_Empleado()
					);
			
			return cred;		
		}
		
		
		
	}
	
	
	
	
}
/*else{
			ArrayList<CredencialesBE> listaBE=new ArrayList<CredencialesBE>();
			
			for(int i=0;i<lista.size();i++){
				listaBE.add(new CredencialesBE(
						lista.get(i).getEmpleado_Id(), 
						lista.get(i).getNom_User(), 
						lista.get(i).getObjempleado().getNom_Empleado(), 
						lista.get(i).getObjempleado().getApe_Empleado()
												)
							);
			}
			return listaBE;
		}*/