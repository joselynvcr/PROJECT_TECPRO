package saborea.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import saborea.model.entities.Empleado;
import saborea.model.entities.login;

public class EmpleadoDAO implements IDAO{
	
	private Connection con=null;
	private ArrayList<Empleado> lista=new ArrayList<>();
	private Empleado ObjEmpleado;
	PreparedStatement ps;
	
	public EmpleadoDAO() {
		//vamos a conectar a la base de datos
		con= new ConnectionSaborea().getConnection();		
		
	}
	
	@Override
	public ArrayList listar(boolean join) {
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "SELECT * FROM empleado";		
			//Va a preparar nuestra sentencia SSQL segura para su ejecución 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()){				
				ObjEmpleado=new Empleado(
						rs.getInt("empleado_Id"),
						rs.getInt("num_DNI"),
						rs.getString("nom_empleado"),
						rs.getString("ape_empleado"),
						rs.getInt("num_Telf"),
						rs.getString("casado"),
						rs.getString("gender_empleado"),
						rs.getDouble("sueldoBase_empleado"),							
						rs.getInt("numHijos_empleado"),
						rs.getString("empleado_tipoCargo")
						);
				//necesito agregar este objeto a mi lista
						lista.add(ObjEmpleado);
				
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
			ObjEmpleado=(Empleado) obj; //() es en donde vamos a poner los campos, en realidad no necesitamos poner el ID PORQUE SE GENERA AUTOMATICAMENTE, SE CREA ASI MISMO 
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="INSERT INTO login (empleado_Id,num_DNI,nom_empleado,ape_empleado,"
					+ "num_Telf,empleado_tipoCargo,casado,gender_empleado,sueldoBase_empleado,"
					+ "numHijos_empleado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, ObjEmpleado.getCodEmpleado());
			ps.setInt(2, ObjEmpleado.getNum_DNI_empleado());
			ps.setString(3, ObjEmpleado.getNom_Empleado());
			ps.setString(4, ObjEmpleado.getApe_Empleado());
			ps.setInt(5, ObjEmpleado.getNum_Telf_empleado());
			ps.setString(6, ObjEmpleado.getTipoCargo_empleado());
			ps.setString(7, ObjEmpleado.getCasado_empleado());
			ps.setString(8, ObjEmpleado.getGender_empleado());
			ps.setDouble(9, ObjEmpleado.getSueldo_base_empleado());
			ps.setInt(10, ObjEmpleado.getNum_hijos_empleado());
			//actualizaciòn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		
	}

	@Override
	public void modificar(Object obj) {
		try {
			ObjEmpleado=(Empleado) obj; //() es en donde vamos a poner los campos, en realidad no necesitamos poner el ID PORQUE SE GENERA AUTOMATICAMENTE, SE CREA ASI MISMO 
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="UPDATE empleado SET num_DNI=?,nom_empleado=?,ape_empleado=?,"
					+ "num_Telf=?,empleado_tipoCargo=?,casado=?,gender_empleado=?,sueldoBase_empleado=?,"
					+ "numHijos_empleado=? WHERE empleado_Id=?";
			ps=con.prepareStatement(SSQL);
			
			ps.setInt(1, ObjEmpleado.getNum_DNI_empleado());
			ps.setString(2, ObjEmpleado.getNom_Empleado());
			ps.setString(3, ObjEmpleado.getApe_Empleado());
			ps.setInt(4, ObjEmpleado.getNum_Telf_empleado());
			ps.setString(5, ObjEmpleado.getTipoCargo_empleado());
			ps.setString(6, ObjEmpleado.getCasado_empleado());
			ps.setString(7, ObjEmpleado.getGender_empleado());
			ps.setDouble(8, ObjEmpleado.getSueldo_base_empleado());
			ps.setInt(9, ObjEmpleado.getNum_hijos_empleado());
			ps.setInt(10,  ObjEmpleado.getCodEmpleado());
			//actualizaciòn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		
	}

	@Override
	public void eliminar(int cod) {
		try {			
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="DELETE FROM Empleado WHERE usuario_Id=? ";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1,cod);
			//actualizaciòn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
		} catch (SQLException e) {
			//de esta manera vamos a mapear nuestro error, por si ocurre
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
	}

	@Override
	public ArrayList buscar(String condition,boolean join) {
		
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "SELECT * FROM login"+condition;		
			//Va a preparar nuestra sentencia SSQL segura para su ejecución 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()){				
					ObjEmpleado=new Empleado( 											
							rs.getInt("empleado_Id"),
							rs.getInt("num_DNI"),
							rs.getString("nom_empleado"),
							rs.getString("ape_empleado"),
							rs.getInt("num_Telf"),
							rs.getString("casado"),
							rs.getString("gender_empleado"),
							rs.getDouble("sueldoBase_empleado"),							
							rs.getInt("numHijos_empleado"),
							rs.getString("empleado_tipoCargo")
													
					);
				}	
				
				//necesito agregar este objeto a mi lista
				lista.add(ObjEmpleado);				
			
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexiòn nos darà aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		}
		
		return null;					
	}
	
	
	
	
	

}
