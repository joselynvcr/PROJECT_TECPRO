package saborea.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import saborea.model.entities.Empleado;
import saborea.model.entities.login;

public class LoginDAO implements IDAO{
	
	/*what's import java.sql.Connection ->  Para conectarse a una base de datos necesita un objeto Connection .
	 El objeto Connection usa un DriverManager. DriverManager pasa su nombre de usuario de la base de datos, 
	 su contrase?a y la ubicaci?n de la base de datos*/
	
	//lo creo por default en null, cualquier objeto que se crea siempre se crea en nulo, PARA QUE NO OCUPE ESPACIO hasta que se use 
	private Connection con=null;		
	private ArrayList<login> lista=new ArrayList<>();
	private login Objlogin=null;
	
	/*PreparedStatement en Java le permite escribir una consulta parametrizada que ofrece un mejor rendimiento que la clase Statement en Java . 2. En el caso de PreparedStatement ,
	  la base de datos usa un plan de acceso ya compilado y definido, esto permite que la consulta de declaraci?n preparada se ejecute m?s r?pido que la consulta normal*/
	//ya es un atributo de la clase 
	PreparedStatement ps;
	//m?todo constructor
	public LoginDAO() {
		//vamos a conectar a la base de datos
		con= new ConnectionSaborea().getConnection();		
		
	}
	@Override	//La funci?n recien vamos a incluirle c?digo, es decir vamos a sobreescribir lo que ya conten?a, porque anteriormente estaba como prototipo
	public ArrayList<login> listar(boolean objsEmpleado) {//CONDITION =where ID=15
		//tratamiento de las excepciones
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "select * from login l join empleado E on e.empleado_Id=l.empleado_id";		
			//Va a preparar nuestra sentencia SSQL segura para su ejecuci?n 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			//ResulSet=conjunto de resultados, contiene los resultados de una consulta SQL
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()){				
				//FALSE
				if (!objsEmpleado){
					
					Objlogin=new login( 											
							rs.getInt("empleado_Id"),
							rs.getString("nom_User"), 
							rs.getString("Password"), 
							rs.getBoolean("estado"),
							null							
					);
						
				}
				else {
					//TRUE
					Objlogin=new login( 											
							rs.getInt("empleado_Id"),
							rs.getString("nom_User"), 
							rs.getString("Password"), 
							rs.getBoolean("estado"), 
							new Empleado(
								rs.getInt("empleado_Id"),
								rs.getString("num_DNI"),
								rs.getString("nom_empleado"),
								rs.getString("ape_empleado"),
								rs.getString("num_Telf"),
								rs.getString("EstadoCivil"),
								rs.getString("gender_empleado"),
								rs.getDouble("sueldoBase_empleado"),							
								rs.getInt("numHijos_empleado"),
								rs.getString("empleado_tipoCargo"),
								rs.getInt("idJefe"),
								null
								)							
							);			
				//necesito agregar este objeto a mi lista
								
				}
				lista.add(Objlogin);
		}	
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexi?n nos dar? aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			//e.printStackTrace();			
		}		
		return null;
				
	}
	@Override//recibimos un objeto de tipo Object para que mi insertar reconozca que ese object que envio es de tipo Usuario
	public void insertar(Object obj) {
		//tengo que hacer un tipo de cambio de base  "add. cast to usuario " que significa que forzosamente object se interprete como usuario y se cargue dentro de nuestro objeto que 
				//realmente es de tipo Usuario
				
				
				try {
					Objlogin=(login) obj; 
					//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
					String SSQL="INSERT INTO login (empleado_Id,nom_User,Password,estado) VALUES (?, ?, ?, ?)";
					ps=con.prepareStatement(SSQL);
					ps.setInt(1, Objlogin.getEmpleado_Id());
					ps.setString(2, Objlogin.getNom_User());
					ps.setString(3, Objlogin.getPassword_user());
					ps.setBoolean(4, Objlogin.getEstadoUsuario_user());
					//actualizaci?n de datos de las tablas ,devuelve el n?mero de filas afectadas por la instrucci?n
					ps.executeUpdate();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}	
	}
	@Override
	public void modificar(Object obj) {
		
		try {
			Objlogin=(login) obj; //() es en donde vamos a poner los campos, en realidad no necesitamos poner el ID PORQUE SE GENERA AUTOMATICAMENTE, SE CREA ASI MISMO 
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="UPDATE login SET nom_User=?,Password=?,estado=? WHERE usuario_Id=? ";
			ps=con.prepareStatement(SSQL);
			ps.setString(1, Objlogin.getNom_User());
			ps.setString(2, Objlogin.getPassword_user());
			ps.setBoolean(3, Objlogin.getEstadoUsuario_user());
			ps.setInt(4, Objlogin.getEmpleado_Id());
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
			String SSQL="DELETE FROM login WHERE usuario_Id=? ";
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
	public ArrayList<login> buscar(Object objFind, boolean objsEmpleado) {
		
		Objlogin=(login) objFind;		
		//lista=null;
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "select * from login l join empleado e on l.empleado_Id=e.empleado_Id";
			String condition=" ";
			int fEmpleado_Id=Objlogin.getEmpleado_Id();
			String fNom_User=Objlogin.getNom_User();
			String fPassword_user=Objlogin.getPassword_user();
			Boolean fEstadoUsuario_user=Objlogin.getEstadoUsuario_user();
			String ands=null;
			if(fEmpleado_Id!=-1){
					condition=" "+condition+"empleado_Id='"+fEmpleado_Id+"'";
					ands="and";
			}
			if(fEstadoUsuario_user!=null){
				if(ands!=null){
					condition=condition+" and "+"estado='"+fEstadoUsuario_user+"'";
				}else{
					condition=" "+condition+"estado='"+fEstadoUsuario_user+"'";
					ands="and";
				}
			}
			if(fNom_User!=null){
				if(ands!=null){
					condition= condition+" and "+"nom_User='"+fNom_User+"'";
				}else{
					condition=" " +condition+"nom_User='"+fNom_User+"'";
					ands="and";
				}
				
			}
			if(fPassword_user!=null){				
				if(ands!=null){				
					condition=condition+" and "+"Password='"+fPassword_user+"'";
				}else{
					condition=" "+condition+"Password='"+fPassword_user+"'";
				}
				
			}
			
			SSQL=SSQL+" where "+condition;
			//System.out.println("BUSCAR LOGIN:" +SSQL);
			
			//SSQL="select * from login l join empleado e on l.empleado_Id=e.empleado_Id where   nom_User='WASHI' and Password='321'";
			
			//Va a preparar nuestra sentencia SSQL segura para su ejecuci?n 
			ps=con.prepareStatement(SSQL);					
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();

			
			
			//mientras haya un registro todavia en resultset
	
			while(rs.next()) {	
				
				if (!objsEmpleado){
					//FALSE
					Objlogin=new login( 											
							rs.getInt("empleado_Id"),
							rs.getString("nom_User"), 
							rs.getString("Password"), 
							rs.getBoolean("estado"),
							null							
					);
				}else {					
					//TRUE
					Objlogin=new login( 											
							rs.getInt("empleado_Id"),
							rs.getString("nom_User"), 
							rs.getString("Password"), 
							rs.getBoolean("estado"), 
							new Empleado(
									rs.getInt("empleado_Id"),
									rs.getString("num_DNI"),
									rs.getString("nom_empleado"),
									rs.getString("ape_empleado"),
									rs.getString("num_Telf"),
									rs.getString("EstadoCivil"),
									rs.getString("gender_empleado"),
									rs.getDouble("sueldoBase_empleado"),							
									rs.getInt("numHijos_empleado"),
									rs.getString("empleado_tipoCargo"),
									rs.getInt("idJefe"),
									null
							)
					);					
				}
				
				//necesito agregar este objeto a mi lista				
				lista.add(Objlogin);
				
			}	
			
			if(lista.size()<1) lista=null;			
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexi?n nos dar? aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			//e.printStackTrace();			
		}
			
		return null;
	}
	
}
