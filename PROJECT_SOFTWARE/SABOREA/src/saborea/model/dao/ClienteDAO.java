package saborea.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import saborea.model.entities.Cliente;
import saborea.model.entities.Empleado;
import saborea.model.entities.login;

public class ClienteDAO implements IDAO {

	private Connection con=null;
	private ArrayList<Cliente> lista= new ArrayList<>();
	private Cliente ObjCliente;
	PreparedStatement ps;
	
	
	@Override
	public ArrayList listar(boolean join) {
		
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "SELECT * FROM cliente";		
			//Va a preparar nuestra sentencia SSQL segura para su ejecuci�n 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()){				
				ObjCliente=new Cliente(
						rs.getInt("cliente_Id"),
						rs.getInt("num_dni"),
						rs.getString("nom_Cliente"),
						rs.getString("ape_Cliente")						
						);
				//necesito agregar este objeto a mi lista
						lista.add(ObjCliente);
				
			}
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexi�n nos dar� aviso
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
			String SSQL="INSERT INTO login (cliente_Id,num_dni,nom_Cliente,ape_Cliente) VALUES (?, ?, ?, ?)";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, ObjCliente.getCod_cliente());
			ps.setInt(2, ObjCliente.getNum_dni_cliente());
			ps.setString(3, ObjCliente.getNom_cliente());
			ps.setString(4, ObjCliente.getApe_cliente());			
			//actualizaci�n de datos de las tablas ,devuelve el n�mero de filas afectadas por la instrucci�n
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
			String SSQL="UPDATE login SET num_dni=?,nom_Cliente=?,ape_Cliente=? WHERE cliente_Id=? ";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, ObjCliente.getNum_dni_cliente());
			ps.setString(2, ObjCliente.getNom_cliente());
			ps.setString(3, ObjCliente.getApe_cliente());
			ps.setInt(4, ObjCliente.getCod_cliente());
			//actualizaci�n de datos de las tablas ,devuelve el n�mero de filas afectadas por la instrucci�n
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

	@Override
	public void eliminar(int cod) {
		try {			
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="DELETE FROM Cliente WHERE cliente_Id=? ";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, cod);
			//actualizaci�n de datos de las tablas ,devuelve el n�mero de filas afectadas por la instrucci�n
			ps.executeUpdate();
		} catch (SQLException e) {
			//de esta manera vamos a mapear nuestro error, por si ocurre
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
		
		
	}

	@Override
	public ArrayList buscar(String condition, boolean join) {
		try {		
			String SSQL= "SELECT * FROM cliente"+condition;			
			ps=con.prepareStatement(SSQL);		
			ResultSet rs= ps.executeQuery();			
			while(rs.next()){				
					ObjCliente=new Cliente( 											
							rs.getInt("cliente_Id"),
							rs.getInt("num_dni"),
							rs.getString("nom_Cliente"),
							rs.getString("ape_Cliente")			
													
					);
				}	
				
				//necesito agregar este objeto a mi lista
				lista.add(ObjCliente);				
			
			return lista;
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,e.getMessage());
					
		}
		
		return null;	
	
	}
	
	
}
