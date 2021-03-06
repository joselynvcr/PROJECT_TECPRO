package saborea.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//import saborea.model.entities.Cliente;
import saborea.model.entities.Mesa;

public class MesaDAO implements IDAO{

	
	private Connection con=null;
	private ArrayList<Mesa> lista= new ArrayList<>();
	private Mesa ObjMesa;
	PreparedStatement ps;
	
	@Override
	public ArrayList listar(boolean join) {
		
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "SELECT * FROM mesa";		
			//Va a preparar nuestra sentencia SSQL segura para su ejecuci?n 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()){				
				ObjMesa=new Mesa(
						rs.getInt("mesa_Id"),
						rs.getBoolean("disponibilidad"),
						rs.getInt("Capacidad_Mesa")							
						);
				//necesito agregar este objeto a mi lista
						lista.add(ObjMesa);
				
			}
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexi?n nos dar? aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			//e.printStackTrace();			
		}		
		return null;	
	}
	@Override
	public void insertar(Object obj) {
		try {
			ObjMesa=(Mesa) obj; //() es en donde vamos a poner los campos, en realidad no necesitamos poner el ID PORQUE SE GENERA AUTOMATICAMENTE, SE CREA ASI MISMO 
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="INSERT INTO mesa (mesa_Id,disponibilidad,Capacidad_Mesa) VALUES (?, ?, ?)";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, ObjMesa.getNro_mesa());
			ps.setBoolean(2, ObjMesa.getDisponibilidad_mesa());
			ps.setInt(3, ObjMesa.getCapacidad_mesa());						
			//actualizaci?n de datos de las tablas ,devuelve el n?mero de filas afectadas por la instrucci?n
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
	}
	@Override
	public void modificar(Object obj) {
		try{
		ObjMesa=(Mesa) obj; 
		//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
		String SSQL="UPDATE login SET disponibilidad=?,Capacidad_Mesa=? WHERE mesa_Id=? ";
		ps=con.prepareStatement(SSQL);
		ps.setBoolean(1, ObjMesa.getDisponibilidad_mesa());
		ps.setInt(2, ObjMesa.getCapacidad_mesa());
		ps.setInt(3, ObjMesa.getNro_mesa());		
		//actualizaci?n de datos de las tablas ,devuelve el n?mero de filas afectadas por la instrucci?n
		ps.executeUpdate();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
	
}
	
	@Override
	public void eliminar(int cod,int Cod2) {
		try {			
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="DELETE FROM Cliente WHERE mesa_Id=? ";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, cod);
			//actualizaci?n de datos de las tablas ,devuelve el n?mero de filas afectadas por la instrucci?n
			ps.executeUpdate();
		} catch (SQLException e) {
			//de esta manera vamos a mapear nuestro error, por si ocurre
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
		
	}
	
	@Override
	public ArrayList buscar(Object objFind, boolean join) {
		//castear to objeto mesa
		ObjMesa=(Mesa) objFind;
		
		try {		
			String SSQL= "SELECT * FROM mesa";	
			String condition=" ";
			int fNro_mesa=ObjMesa.getNro_mesa();
			Boolean fDisponibilidad_mesa=ObjMesa.getDisponibilidad_mesa();
			int fCapacidad_mesa=ObjMesa.getCapacidad_mesa();
						
			String ands=null;
			
			if(fNro_mesa!=-1){
				condition=" "+condition+"mesa_Id='"+fNro_mesa+"'";
				ands="and";
		}
		if(fDisponibilidad_mesa!=null){
			if(ands!=null){
				condition=" "+condition+"and"+"estado='"+fDisponibilidad_mesa+"'";
			}else{
				condition=" "+condition+"estado='"+fDisponibilidad_mesa+"'";
				ands="and";
			}
		}
		if(fCapacidad_mesa!=0){
			if(ands!=null){
				condition=" " +condition+"and"+"nom_User='"+fCapacidad_mesa+"'";
			}else{
				condition=" " +condition+"nom_User='"+fCapacidad_mesa+"'";
				ands="and";
			}			
		}		
		
		SSQL=SSQL+"where "+condition;
			
			ps=con.prepareStatement(SSQL);		
			ResultSet rs= ps.executeQuery();			
			while(rs.next()){				
				ObjMesa=new Mesa( 											
						rs.getInt("mesa_Id"),
						rs.getBoolean("disponibilidad"),
						rs.getInt("Capacidad_Mesa")												
					);
					lista.add(ObjMesa);
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
