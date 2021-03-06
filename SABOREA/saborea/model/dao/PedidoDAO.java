package saborea.model.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import saborea.model.entities.Cliente;
import saborea.model.entities.Empleado;
import saborea.model.entities.Mesa;
import saborea.model.entities.Pedido;
import saborea.model.entities.login;


public class PedidoDAO implements IDAO{			
	
	private Connection con= null;
	private ArrayList<Pedido> lista= new ArrayList<>();
	private Pedido ObjPedido=null;

	PreparedStatement ps;
	
	public PedidoDAO(){
		con= new ConnectionSaborea().getConnection();
		
	}

	@Override
	public ArrayList<Pedido> listar(boolean join) {
		System.out.println("ENTRO A LISTAR EN ORDEN");
		lista=new ArrayList<>();
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			//String SSQL="";
			
//			String SSQL= " SELECT * FROM pedido p join empleado e on e.empleado_Id=p.cempleadoc_Id "
//					+ " join empleado e2 on e2.empleado_Id=p.mempleado_Id join cliente c  "
//					+ " on c.dniCliente=p.dniCliente join mesa m on m.mesa_Id=p.mesa_Id ";	
//			
			String SSQL="SELECT * FROM VWPEDIDOS";
			
			System.out.println(SSQL);
			//Va a preparar nuestra sentencia SSQL segura para su ejecución 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			//ResulSet=conjunto de resultados, contiene los resultados de una consulta SQL
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			
			while(rs.next()){	
				
				if (!join){		
					System.out.println(join);
					System.out.println("ENTRO A LISTAR EN ORDEN 1");
					ObjPedido=new Pedido( 	
							rs.getInt("IDPEDIDO"),
							rs.getInt("IDMOZO"),
							null,
							rs.getInt("IDCAJERO"),
							null,
							rs.getTimestamp("FECHA_HORA"),
							rs.getDouble("TOTALPAGAR"),
							rs.getString("DNICLIENTE"),
							null,
							rs.getInt("NRO_MESA"),
							null,
							rs.getBoolean("PAGADO"),
							rs.getBoolean("ENVIADO")
					
					);
					
				}else{
					System.out.println("ENTRO A LISTAR EN ORDEN 2");
					ObjPedido=new Pedido( 											
							rs.getInt("IDPEDIDO"),
							rs.getInt("IDMOZO"),
							new Empleado(
									rs.getInt("ID_EMP_MOZO"),
									rs.getString("EMP_MOZO_DNI"),
									rs.getString("NOMBREMOZO"),
									rs.getString("APELLIDOMOZO"),
									rs.getString("EMP_MOZO_TELF"),
									rs.getString("EMP_MOZO_EC"),
									rs.getString("EMP_MOZO_GENDER"),
									rs.getDouble("EMP_MOZO_SUELDO"),							
									rs.getInt("EMP_MOZO_NHIJOS"),
									rs.getString("CARGOMOZO"),
									rs.getInt("IDJEFE_M"),
									null
								),
							rs.getInt("IDCAJERO"),
							new Empleado(
									rs.getInt("ID_EMP_CAJERO"),
									rs.getString("EMP_CAJERO_DNI"),
									rs.getString("NOMBRECAJERO"),
									rs.getString("APELLIDOCAJERO"),
									rs.getString("EMP_CAJERO_TELF"),
									rs.getString("EMP_CAJERO_EC"),
									rs.getString("EMP_CAJERO_GENDER"),
									rs.getDouble("EMP_CAJERO_SUELDO"),							
									rs.getInt("EMP_CAJERO_NHIJOS"),
									rs.getString("CARGOCAJERO"),
									rs.getInt("IDJEFE_C"),
									null
								),
							rs.getTimestamp("FECHA_HORA"),
							rs.getDouble("TOTALPAGAR"),
							rs.getString("DNICLIENTE"),
							new Cliente(									
									rs.getString("DNI_CLIENTE"),
									rs.getString("NOM_CLIENTE"),
									rs.getString("APE_CLIENTE")		
									),
							rs.getInt("NRO_MESA"),
							new Mesa( 											
									rs.getInt("MESA_ID"),
									rs.getBoolean("DISPONIBLE"),
									rs.getInt("CAPACIDAD")
									),
							rs.getBoolean("PAGADO"),
							rs.getBoolean("ENVIADO")
														
					);
			
				}
				//necesito agregar este objeto a mi lista
				lista.add(ObjPedido);
				
			}
			System.out.println("mozo : " +lista.get(0).getObjmozo().getNom_Empleado()+" "+lista.get(0).getObjmozo().getApe_Empleado());
			System.out.println("caja :"+lista.get(0).getObjcajero().getNom_Empleado()+" "+lista.get(0).getObjcajero().getApe_Empleado());
		
			if(lista.size()<1) lista=null;			
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexiňn nos darŕ aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			//e.printStackTrace();			
		}		
		return null;
	}

	@Override
	public void insertar(Object obj) {
		//tengo que hacer un tipo de cambio de base  "add. cast to usuario " que significa que forzosamente object se interprete como usuario y se cargue dentro de nuestro objeto que 
		//realmente es de tipo Usuario			
		
		try {
			ObjPedido=(Pedido) obj;  
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
		
			String SSQL="INSERT INTO pedido (mempleado_Id,cempleadoc_Id,totalpagar_Pedido,dniCliente,mesa_Id,pagado,enviado)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			System.out.println("SSQL"+SSQL);
			ps=con.prepareStatement(SSQL);			
			ps.setInt(1, ObjPedido.getCodmozo());
			ps.setInt(2, ObjPedido.getCodCajero());			
			ps.setDouble(3, ObjPedido.getTotalPagar());
			ps.setString(4, ObjPedido.getDniCliente());
			ps.setInt(5, ObjPedido.getCodMesa());
			ps.setBoolean(6, ObjPedido.getPagado());
			ps.setBoolean(7, ObjPedido.getEnviado());
			//actualizaciňn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		
	}

	@Override
	public void modificar(Object obj) {
		ObjPedido=(Pedido) obj;
		//mempleado_Id=?,cempleadoc_Id=?,fechaHora=?,totalPagar_PObjedido=?WHERE pedido_Id=? ";
		try {
			
			String SSQL="UPDATE pedido SET ";
			String condition=" " ;			
			int fObjmozo=ObjPedido.getCodmozo();
			int Objcajero=ObjPedido.getCodCajero();
			Timestamp fFechaHora=ObjPedido.getFechaHora();
			double fTotalPagar=ObjPedido.getTotalPagar();
			String fObjcliente=ObjPedido.getDniCliente();
			int fObjmesa=ObjPedido.getCodMesa();
			Boolean fPagado=ObjPedido.getPagado();
			String coma=null;
			
		//SSQL=Funcion("update","pedido",new ArrayList<String>{"mempleado_Id","cempleadoc_Id"},ObjPedido);
				
		if(fObjmozo!=-1){			
				condition=" "+condition+" mempleado_Id='"+fObjmozo+"'";		
				coma="and";
		}
		if(Objcajero!=-1){
			if(coma!=null){
				condition=" " +condition+","+" cempleadoc_Id='"+Objcajero+"'";
			}else{
				condition=" " +condition+" cempleadoc_Id='"+Objcajero+"'";
				coma="and";
			}
			
		}
		if(fFechaHora!=null){
			if(coma!=null){
				condition="  "+condition+","+" fechaHora='"+fFechaHora+"'";
			}else{
				condition=" "+condition+" fechaHora='"+fFechaHora+"'";
				coma="and";
			}
			
		}
		if(fTotalPagar!=-1){
			if(coma!=null){
				condition="  "+condition+","+" totalPagar_Pedido='"+fTotalPagar+"'";
			}else{
				condition=" "+condition+" totalPagar_Pedido='"+fTotalPagar+"'";
				coma="and";
			}
			
		}
		if(fObjcliente!=null){
			if(coma!=null){
				condition="  "+condition+","+" dniCliente='"+fObjcliente+"'";
			}else{
				condition=" "+condition+" dniCliente='"+fObjcliente+"'";
				coma="and";
			}
			
		}
		if(fObjmesa!=-1){
			if(coma!=null){
				condition="  "+condition+","+" mesa_Id='"+fObjmesa+"'";
			}else{
				condition=" "+condition+" mesa_Id='"+fObjmesa+"'";
				coma="and";
			}
			
		}
		if(fPagado!=null){
			if(coma!=null){
				condition=" "+condition+","+" pagado='"+fPagado+"'";
			}else{
				condition=" "+condition+" pagado='"+fPagado+"'";
				
			}
			
		}
			
			
		SSQL=SSQL+condition+" where pedido_Id="+ ObjPedido.getCod_Pedido();
		System.out.println("SSQL SSQLmodificar : " + SSQL);
			ps=con.prepareStatement(SSQL);			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	@Override
	public void eliminar(int cod,int Cod2) {
		
		try {			
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="DELETE FROM pedido WHERE usuario_Id=? ";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, cod);
			//actualizaciňn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
		} catch (SQLException e) {
			//de esta manera vamos a mapear nuestro error, por si ocurre
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
	}

	

	@Override
	public ArrayList<Pedido> buscar(Object objFind, boolean join) {
		
		ObjPedido=(Pedido) objFind;
		try {
			//vamos a definir una sentencia SQL , sentencia SQL

			
			String SSQL="SELECT * FROM VWPEDIDOS ";
			
			String condition=" ";
			int fCod_Pedido=ObjPedido.getCod_Pedido();			
			int fCodmozo=ObjPedido.getCodmozo();
			int fCodCajero=ObjPedido.getCodCajero();
			Timestamp fFechaHora=ObjPedido.getFechaHora();
			double fTotalPagar=ObjPedido.getTotalPagar();
			String fDniCliente=ObjPedido.getDniCliente();
			int fCodMesa=ObjPedido.getCodMesa();
			Boolean fPagado=ObjPedido.getPagado();
			Boolean fenviado=ObjPedido.getEnviado();
			
			String ands=null;
			if(fCod_Pedido!=-1){
					condition=" "+condition+" IDPEDIDO='"+fCod_Pedido+"'";
					ands="and";
			}
			if(fCodmozo!=-1){
				if(ands!=null){
					condition=" "+condition+" and "+" IDMOZO='"+fCodmozo+"'";
					
				}else{
					condition=" "+condition+"IDMOZO='"+fCodmozo+"'";
					ands="and";
				}
			}
			if(fCodCajero!=-1){
				if(ands!=null){
					condition=" " +condition+" and "+" IDCAJERO='"+fCodCajero+"'";
					
				}else{
					condition=" " +condition+"IDCAJERO='"+fCodCajero+"'";
					ands="and";
				}
				
			}
			if(fFechaHora!=null){
				if(ands!=null){
					condition="  "+condition+" and "+" FECHA_HORA='"+fFechaHora+"'";
					
				}else{
					condition=" "+condition+"FECHA_HORA='"+fFechaHora+"'";
					ands="and";
				}
				
			}
			if(fTotalPagar!=-1){
				if(ands!=null){
					condition="  "+condition+" and "+" TOTALPAGAR='"+fTotalPagar+"'";
					
				}else{
					condition=" "+condition+"TOTALPAGAR='"+fTotalPagar+"'";
					ands="and";
				}
				
			}
			if(fDniCliente!=null){
				if(ands!=null){
					condition=" "+condition+" and "+" DNICLIENTE='"+fDniCliente+"'";
					
				}else{
					condition=" "+condition+"DNICLIENTE='"+fDniCliente+"'";
					ands="and";
				}
				
			}
			if(fCodMesa!=-1){
				
				if(ands!=null){
					condition="  "+condition+" and "+" MESA_ID='"+fCodMesa+"'";
					
				}else{
					condition=" "+condition+"MESA_ID='"+fCodMesa+"'";
					ands="and";
				}
				
			}
			if(fenviado!=null){
				
				if(ands!=null){
					condition="  "+condition+" and "+" ENVIADO='"+fenviado+"'";
					
				}else{
					condition=" "+condition+"ENVIADO='"+fenviado+"'";
					ands="and";
				}
				
			}
			if(fPagado!=null){
				if(ands!=null){
					condition=" "+condition+" and "+" PAGADO='"+fPagado+"'";
				}else{
					condition=" "+condition+" PAGADO='"+fPagado+"'";
				}
				
			}
			
			SSQL=SSQL+"where "+condition;
			System.out.println("CONSULTA BUSCA PEDIDO DAO en BD  :  "+SSQL);
			//Va a preparar nuestra sentencia SSQL segura para su ejecución 
			ps=con.prepareStatement(SSQL);					
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			if(rs==null)
				return null;					
			//mientras haya un registro todavia en resultset
			while(rs.next()){							
				if (!join){					
					ObjPedido=new Pedido( 	
					rs.getInt("IDPEDIDO"),
					rs.getInt("IDMOZO"),
					null,
					rs.getInt("IDCAJERO"),
					null,
					rs.getTimestamp("FECHA_HORA"),
					rs.getDouble("TOTALPAGAR"),
					rs.getString("DNICLIENTE"),
					null,
					rs.getInt("NRO_MESA"),
					null,
					rs.getBoolean("PAGADO"),
					rs.getBoolean("ENVIADO")
					
					);
					
				}else{					
					ObjPedido=new Pedido( 											
							rs.getInt("IDPEDIDO"),
							rs.getInt("IDMOZO"),
							new Empleado(
									rs.getInt("ID_EMP_MOZO"),
									rs.getString("EMP_MOZO_DNI"),
									rs.getString("NOMBREMOZO"),
									rs.getString("APELLIDOMOZO"),
									rs.getString("EMP_MOZO_TELF"),
									rs.getString("EMP_MOZO_EC"),
									rs.getString("EMP_MOZO_GENDER"),
									rs.getDouble("EMP_MOZO_SUELDO"),							
									rs.getInt("EMP_MOZO_NHIJOS"),
									rs.getString("CARGOMOZO"),
									rs.getInt("IDJEFE_M"),
									null
								),
							rs.getInt("IDCAJERO"),
							new Empleado(
									rs.getInt("ID_EMP_CAJERO"),
									rs.getString("EMP_CAJERO_DNI"),
									rs.getString("NOMBRECAJERO"),
									rs.getString("APELLIDOCAJERO"),
									rs.getString("EMP_CAJERO_TELF"),
									rs.getString("EMP_CAJERO_EC"),
									rs.getString("EMP_CAJERO_GENDER"),
									rs.getDouble("EMP_CAJERO_SUELDO"),							
									rs.getInt("EMP_CAJERO_NHIJOS"),
									rs.getString("CARGOCAJERO"),
									rs.getInt("IDJEFE_C"),
									null
								),
							rs.getTimestamp("FECHA_HORA"),
							rs.getDouble("TOTALPAGAR"),
							rs.getString("DNICLIENTE"),
							new Cliente(									
									rs.getString("DNI_CLIENTE"),
									rs.getString("NOM_CLIENTE"),
									rs.getString("APE_CLIENTE")		
									),
							rs.getInt("NRO_MESA"),
							new Mesa( 											
									rs.getInt("MESA_ID"),
									rs.getBoolean("DISPONIBLE"),
									rs.getInt("CAPACIDAD")
									),
							rs.getBoolean("PAGADO"),
							rs.getBoolean("ENVIADO")
														
					);
				}
				
				//necesito agregar este objeto a mi lista
				lista.add(ObjPedido);
				
			}	
			
			if(lista.size()<1) lista=null;
			//System.out.println(lista.get(0).getCod_Pedido());
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexiňn nos darŕ aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			//e.printStackTrace();			
		}
			
		return null;
	
		
		
		
	}

	@Override
	public String toString() {
		return "PedidoDAO [con=" + con + ", lista=" + lista + ", ObjPedido=" + ObjPedido + ", ps=" + ps + "]";
	}
	
	
	
	
	
	
	
	
}
