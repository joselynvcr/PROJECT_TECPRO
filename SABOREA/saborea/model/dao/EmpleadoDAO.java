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
						rs.getString("EstadoCivil"),
						rs.getString("gender_empleado"),
						rs.getDouble("sueldoBase_empleado"),							
						rs.getInt("numHijos_empleado"),
						rs.getString("empleado_tipoCargo"),
						rs.getInt("idJefe"),
						null
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
			String SSQL="INSERT INTO empleado (empleado_Id,num_DNI,nom_empleado,ape_empleado,"
					+ "num_Telf,EstadoCivil,gender_empleado,sueldoBase_empleado,"
					+ "numHijos_empleado,empleado_tipoCargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, ObjEmpleado.getIdEmpleado());
			ps.setInt(2, ObjEmpleado.getNum_DNI_empleado());
			ps.setString(3, ObjEmpleado.getNom_Empleado());
			ps.setString(4, ObjEmpleado.getApe_Empleado());
			ps.setInt(5, ObjEmpleado.getNum_Telf_empleado());			
			ps.setString(6, ObjEmpleado.getEstadoCivil_empleado());
			ps.setString(7, ObjEmpleado.getGender_empleado());
			ps.setDouble(8, ObjEmpleado.getSueldo_base_empleado());
			ps.setInt(9, ObjEmpleado.getNum_hijos_empleado());
			ps.setString(10, ObjEmpleado.getTipoCargo_empleado());
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
					+ "num_Telf=?,empleado_tipoCargo=?,EstadoCivil=?,gender_empleado=?,sueldoBase_empleado=?,"
					+ "numHijos_empleado=?,idJefe=? WHERE empleado_Id=?";
			ps=con.prepareStatement(SSQL);
			
			ps.setInt(1, ObjEmpleado.getNum_DNI_empleado());
			ps.setString(2, ObjEmpleado.getNom_Empleado());
			ps.setString(3, ObjEmpleado.getApe_Empleado());
			ps.setInt(4, ObjEmpleado.getNum_Telf_empleado());
			ps.setString(5, ObjEmpleado.getTipoCargo_empleado());
			ps.setString(6, ObjEmpleado.getEstadoCivil_empleado());
			ps.setString(7, ObjEmpleado.getGender_empleado());
			ps.setDouble(8, ObjEmpleado.getSueldo_base_empleado());
			ps.setInt(9, ObjEmpleado.getNum_hijos_empleado());
			ps.setInt(10, ObjEmpleado.getIdJefe());
			ps.setInt(11,  ObjEmpleado.getIdEmpleado());
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
	public ArrayList buscar(Object objFind, boolean objsEmpleado) {
		
		ObjEmpleado=(Empleado) objFind;
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "SELECT * FROM empleado";		
			String condition=" ";
			int fIdEmpleado=ObjEmpleado.getIdEmpleado();			
			int fNum_DNI_empleado=ObjEmpleado.getNum_DNI_empleado();			
			String fNom_Empleado=ObjEmpleado.getNom_Empleado();
			String fApe_Empleado=ObjEmpleado.getApe_Empleado();
			int fNum_Telf_empleado=ObjEmpleado.getNum_Telf_empleado();
			String fEstadoCivil_empleado=ObjEmpleado.getEstadoCivil_empleado();
			String fGender_empleado=ObjEmpleado.getGender_empleado();
			double fSueldo_base_empleado=ObjEmpleado.getSueldo_base_empleado();
			int fNum_hijos_empleado=ObjEmpleado.getNum_hijos_empleado();
			String fTipoCargo_empleado=ObjEmpleado.getTipoCargo_empleado();
			int fIdJefe=ObjEmpleado.getIdJefe();		
			
			String ands=null;
			if(fIdEmpleado!=-1){
					condition=" "+condition+"empleado_Id='"+fIdEmpleado+"'";
					ands="and";
			}
			if(fNum_DNI_empleado!=-1){
				if(ands!=null){
					condition=" "+condition+"and"+"num_DNI='"+fNum_DNI_empleado+"'";
				}else{
					condition=" "+condition+"num_DNI='"+fNum_DNI_empleado+"'";
					ands="and";
				}
			}
			if(fNom_Empleado!=null){
				if(ands!=null){
					condition=" " +condition+"and"+"nom_empleado='"+fNom_Empleado+"'";
				}else{
					condition=" " +condition+"nom_empleado='"+fNom_Empleado+"'";
					ands="and";
				}
				
			}
			if(fApe_Empleado!=null){
				if(ands!=null){
					condition="  "+condition+"and"+"ape_empleado='"+fApe_Empleado+"'";
				}else{
					condition=" "+condition+"ape_empleado='"+fApe_Empleado+"'";
					ands="and";
				}
				
			}
			if(fNum_Telf_empleado!=-1){
				if(ands!=null){
					condition="  "+condition+"and"+"num_Telf='"+fNum_Telf_empleado+"'";
				}else{
					condition=" "+condition+"num_Telf='"+fNum_Telf_empleado+"'";
					ands="and";
				}
				
			}if(fEstadoCivil_empleado!=null){
				if(ands!=null){
					condition="  "+condition+"and"+"EstadoCivil='"+fEstadoCivil_empleado+"'";
				}else{
					condition=" "+condition+"EstadoCivil='"+fEstadoCivil_empleado+"'";
					ands="and";
				}
				
			}if(fGender_empleado!=null){
				if(ands!=null){
					condition="  "+condition+"and"+"gender_empleado='"+fGender_empleado+"'";
				}else{
					condition=" "+condition+"gender_empleado='"+fGender_empleado+"'";
					ands="and";
				}
				
			}if(fSueldo_base_empleado!=-1){
				if(ands!=null){
					condition="  "+condition+"and"+"sueldoBase_empleado='"+fSueldo_base_empleado+"'";
				}else{
					condition=" "+condition+"sueldoBase_empleado='"+fSueldo_base_empleado+"'";
					ands="and";
				}
				
			}if(fNum_hijos_empleado!=-1){
				if(ands!=null){
					condition="  "+condition+"and"+"numHijos_empleado='"+fNum_hijos_empleado+"'";
				}else{
					condition=" "+condition+"numHijos_empleado='"+fNum_hijos_empleado+"'";
					ands="and";
				}
				
			}if(fTipoCargo_empleado!=null){
				if(ands!=null){
					condition="  "+condition+"and"+"empleado_tipoCargo='"+fTipoCargo_empleado+"'";
				}else{
					condition=" "+condition+"empleado_tipoCargo='"+fTipoCargo_empleado+"'";
					ands="and";
				}
				
			}
			if(fIdJefe!=-1){
				if(ands!=null){
					condition=" "+condition+"and"+"idJefe='"+fIdJefe+"'";
				}else{
					condition=" "+condition+"idJefe='"+fIdJefe+"'";
				}
				
			}			
			SSQL=SSQL+"where "+condition;
			
			
			
			
			//Va a preparar nuestra sentencia SSQL segura para su ejecución 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()) {				
					ObjEmpleado=new Empleado( 											
							rs.getInt("empleado_Id"),
							rs.getInt("num_DNI"),
							rs.getString("nom_empleado"),
							rs.getString("ape_empleado"),
							rs.getInt("num_Telf"),
							rs.getString("EstadoCivil"),
							rs.getString("gender_empleado"),
							rs.getDouble("sueldoBase_empleado"),							
							rs.getInt("numHijos_empleado"),
							rs.getString("empleado_tipoCargo"),
							rs.getInt("idJefe"),
							null
													
					);
					lista.add(ObjEmpleado);	
				}	
				
				//necesito agregar este objeto a mi lista
							
			if(lista.size()<1) lista=null;
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexiòn nos darà aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			
		}
		
		return null;					
	}
	
	
	
	
	

}
