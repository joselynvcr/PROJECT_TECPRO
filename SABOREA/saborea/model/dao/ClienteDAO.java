package saborea.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import saborea.model.entities.Cliente;

public class ClienteDAO implements IDAO {

	private Connection con=null;
	private ArrayList<Cliente> lista= new ArrayList<>();
	private Cliente ObjCliente;
	PreparedStatement ps;
	
	
	@Override
	public ArrayList<Cliente> listar(boolean join) {
		
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "SELECT * FROM cliente";		
			//Va a preparar nuestra sentencia SSQL segura para su ejecución 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()){				
				ObjCliente=new Cliente(						
						rs.getString("num_dni"),
						rs.getString("nom_Cliente"),
						rs.getString("ape_Cliente")						
						);
				//necesito agregar este objeto a mi lista
						lista.add(ObjCliente);
				
			}
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexiòn nos darà aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			//e.printStackTrace();			
		}		
		return null;	
	}

	@Override
	public void insertar(Object obj) {
		try {
			ObjCliente=(Cliente) obj; //() es en donde vamos a poner los campos, en realidad no necesitamos poner el ID PORQUE SE GENERA AUTOMATICAMENTE, SE CREA ASI MISMO 
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="INSERT INTO login (num_dni,nom_Cliente,ape_Cliente) VALUES (?, ?, ?, ?)";
			ps=con.prepareStatement(SSQL);
			
			ps.setString(1, ObjCliente.getNum_dni());
			ps.setString(2, ObjCliente.getNom_cliente());
			ps.setString(3, ObjCliente.getApe_cliente());			
			//actualizaciòn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

	@Override
	public void modificar(Object obj) {
		try {
			ObjCliente=(Cliente) obj; //() es en donde vamos a poner los campos, en realidad no necesitamos poner el ID PORQUE SE GENERA AUTOMATICAMENTE, SE CREA ASI MISMO 
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="UPDATE login SET nom_Cliente=?,ape_Cliente=? WHERE dniCliente=? ";
			ps=con.prepareStatement(SSQL);
			
			ps.setString(1, ObjCliente.getNom_cliente());
			ps.setString(2, ObjCliente.getApe_cliente());
			ps.setString(3, ObjCliente.getNum_dni());
			//actualizaciòn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

	@Override
	public void eliminar(int cod,int Cod2) {
		try {			
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="DELETE FROM Cliente WHERE cliente_Id=? ";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, cod);
			//actualizaciòn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
		} catch (SQLException e) {
			//de esta manera vamos a mapear nuestro error, por si ocurre
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
		
		
	}	

	@Override
	public ArrayList<Cliente> buscar(Object objFind, boolean join) {
		ObjCliente=(Cliente) objFind;
		try {		
			String SSQL= "SELECT * FROM cliente";	
			
			String condition=" ";
			
			String fNum_dni_cliente=ObjCliente.getNum_dni();
			String fNom_cliente=ObjCliente.getNom_cliente();
			String fApe_cliente=ObjCliente.getApe_cliente();
			String ands=null;
			if(fNum_dni_cliente!=null){
					condition=" "+condition+"dniCliente='"+fNum_dni_cliente+"'";
					ands="and";
			}			
			if(fNom_cliente!=null){
				if(ands!=null){
					condition=" " +condition+"and"+"nom_Cliente='"+fNom_cliente+"'";
				}else{
					condition=" " +condition+"nom_Cliente='"+fNom_cliente+"'";
					ands="and";
				}
				
			}
			if(fApe_cliente!=null){
				if(ands!=null){
					condition=" "+condition+"and"+"ape_Cliente='"+fApe_cliente+"'";
				}else{
					condition=" "+condition+"ape_Cliente='"+fApe_cliente+"'";
				}
				
			}
			
			SSQL=SSQL+"where "+condition;
			
			ps=con.prepareStatement(SSQL);		
			ResultSet rs= ps.executeQuery();			
			while(rs.next()){				
					ObjCliente=new Cliente( 
							rs.getString("num_dni"),
							rs.getString("nom_Cliente"),
							rs.getString("ape_Cliente")			
													
					);
					lista.add(ObjCliente);	
				}	
				
				//necesito agregar este objeto a mi lista
							
			if(lista.size()<1) lista=null;		
			return lista;
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,e.getMessage());
					
		}
		
		return null;	
	}
	
	
}
