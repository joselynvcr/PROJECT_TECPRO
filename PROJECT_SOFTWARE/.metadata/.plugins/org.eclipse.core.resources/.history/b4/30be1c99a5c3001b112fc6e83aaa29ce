package saborea.model.bussiness.DTO;

import javax.swing.JOptionPane;

import saborea.presentation.vista.FormAdministrador;
import saborea.presentation.vista.FormCajero;
import saborea.presentation.vista.FormLogin;
import saborea.presentation.vista.FormMozo;

public class VentanaTipoCargoBE {	

//	
//	private String TipoCargo;
//
//	public VentanaTipoCargoBE(String tipoCargo) {
//		TipoCargo = tipoCargo;
//	}	
	
	public void TipoVentana(CredencialesBE Cred){		
		
		String TipoCargo=Cred.getTipoCargo();
		System.out.println("Cred.getTipoCargo() : "+Cred.getTipoCargo());
		if(TipoCargo.equals("cajero")){				
			FormCajero m= new FormCajero(Cred);		
			m.setVisible(true);
			
		}else if(TipoCargo.equals("mozo")){				
			FormMozo m= new FormMozo(Cred);				
			m.setVisible(true);
			
		}else if(TipoCargo.equals("administrador")){				
			FormAdministrador a= new FormAdministrador(Cred);		
			a.setVisible(true);
			
		}else{				
			JOptionPane.showMessageDialog(null, "NO SE ENCONTRÓ NINGUN TIPO DE CARGO ","ADVERTENCIA", JOptionPane.WARNING_MESSAGE);		
		}	
	
	}
	
	
}
