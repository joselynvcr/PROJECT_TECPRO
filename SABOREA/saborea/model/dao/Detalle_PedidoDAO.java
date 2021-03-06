package saborea.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import saborea.model.entities.Cliente;
import saborea.model.entities.Detalle_Pedido;
import saborea.model.entities.Empleado;
import saborea.model.entities.Mesa;
import saborea.model.entities.Pedido;
import saborea.model.entities.Producto;
import saborea.model.entities.login;

public class Detalle_PedidoDAO implements IDAO {	
	private Connection con=null;		
	private ArrayList<Detalle_Pedido> lista=new ArrayList<>();
	private Detalle_Pedido ObjDetallePedido=null;
	PreparedStatement ps;
	 public Detalle_PedidoDAO() {
		//vamos a conectar a la base de datos
		con= new ConnectionSaborea().getConnection();		
		//lista=null;
	}
	
	@Override
	public ArrayList<Detalle_Pedido> listar(boolean join) {		
		
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "SELECT * FROM detalle_pedido dp join pedido p "
					+ "on p.pedido_Id=dp.pedido_Id"
					+ "join producto pro"
					+ "on pro.producto_Id=dp.producto_Id";		
			//Va a preparar nuestra sentencia SSQL segura para su ejecución 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			//ResulSet=conjunto de resultados, contiene los resultados de una consulta SQL
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()){
				
				//FALSE
				if (!join){					
					ObjDetallePedido=new Detalle_Pedido(								
							
							rs.getInt("pedido_Id"), 
							null,
							rs.getInt("cant_Productos"), 
							rs.getInt("producto_Id"),
							null,
							rs.getDouble("precio"),
							rs.getDouble("Total")
					);
				}
				else {
					//TRUE
					ObjDetallePedido=new Detalle_Pedido( 											
							
							rs.getInt("pedido_Id"), 
							new Pedido(
									rs.getInt("pedido_Id"),
									rs.getInt("mempleado_Id"),
									null,
									rs.getInt("cempleadoc_Id"),
									null,
									rs.getTimestamp("FechaHora"),
									rs.getDouble("totalpagar_Pedido"),
									rs.getString("dniCliente"),
									null,
									rs.getInt("mesa_Id"),
									null,
									rs.getBoolean("pagado"),
									rs.getBoolean("enviado")
									),									
							rs.getInt("cant_Productos"), 
							rs.getInt("producto_Id"),
							new Producto(
									rs.getInt("producto_Id"),					
									rs.getString("nom_Producto"),
									rs.getDouble("precio_Producto"),
									rs.getInt("stock_Producto"),
									rs.getString("descr_Producto")
									),
							rs.getDouble("precio"),
							rs.getDouble("Total")
					);
				//necesito agregar este objeto a mi lista
				lista.add(ObjDetallePedido);				
				}
		}	
			
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
		System.out.println("INSERTAR A BD DETAILS");
		try {
			ObjDetallePedido= (Detalle_Pedido) obj; 
			
			String SSQL="INSERT INTO detalle_pedido "
					+ "( pedido_Id,producto_Id,cant_Productos,Total,precio) "
					+ "VALUES (?, ?, ?, ?, ?)";
			System.out.println("SSQL"+SSQL);
			ps=con.prepareStatement(SSQL);	
			
			System.out.println(ObjDetallePedido.getCodPedido());
			System.out.println(ObjDetallePedido.getCodProducto());
			System.out.println(ObjDetallePedido.getCantidadProductos());
			System.out.println(ObjDetallePedido.getTotal());
			System.out.println(ObjDetallePedido.getPrecio());
			
			System.out.println("BD DETAILS");
			ps.setInt(1, ObjDetallePedido.getCodPedido());
			ps.setDouble(2, ObjDetallePedido.getCodProducto());
			ps.setInt(3, ObjDetallePedido.getCantidadProductos());
			ps.setDouble(4, ObjDetallePedido.getTotal());
			ps.setDouble(5, ObjDetallePedido.getPrecio());
			//actualizaciňn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
		
	}

	@Override
	public void modificar(Object obj) {
		
		
		
		try{
			ObjDetallePedido= (Detalle_Pedido) obj; 
			String SSQL=" UPDATE detalle_pedido SET "
					+ " cant_Productos=? , total=?  WHERE  pedido_Id =? and producto_Id=?  ";
			
			ps=con.prepareStatement(SSQL);
			
			ps.setInt(1, ObjDetallePedido.getCantidadProductos());
			ps.setDouble(2, ObjDetallePedido.getTotal());
			ps.setInt(3, ObjDetallePedido.getCodPedido());
			ps.setInt(4, ObjDetallePedido.getCodProducto());	
			
			//actualizaciňn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			ps.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		
		
	}

	@Override
	public void eliminar(int cod,int cod2 ) {
		try {			
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="DELETE FROM detalle_pedido WHERE pedido_Id=? and producto_Id=?";			
			
			ps=con.prepareStatement(SSQL);
			
			ps.setInt(1, cod);
			ps.setInt(2, cod2);
			//actualizaciňn de datos de las tablas ,devuelve el número de filas afectadas por la instrucción
			System.out.println("SSQL ELIMINAR DETALLE "+SSQL);
			ps.executeUpdate();
		} catch (SQLException e) {
			//de esta manera vamos a mapear nuestro error, por si ocurre
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
	}

	@Override
	public ArrayList<Detalle_Pedido> buscar(Object objFind, boolean join) {
		System.out.println("ENTRO A BUSCAR EN EL DETALLE DE ORDEN");
		lista=new ArrayList<>();
		ObjDetallePedido=(Detalle_Pedido) objFind;
		
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			//lista=null;
			
			String SSQL=" SELECT * FROM VWDETALLEPEDIDO  ";
			String condition=" ";
			//int fIdDetalle_Pedido=ObjDetallePedido.getIdDetalle_Pedido();
			int fCodPedido=ObjDetallePedido.getCodPedido();
			//System.out.println("cod pedido : "+fCodPedido);
			int fCantidadProductos=ObjDetallePedido.getCantidadProductos();
			int fCodProducto=ObjDetallePedido.getCodProducto();
			double fPrecio=ObjDetallePedido.getPrecio();
			double fTotal=ObjDetallePedido.getTotal();			
			
			String ands=null;
			

			if(fCodPedido!=-1){
				//System.out.println("condition detalle 1: "+condition);
				
					condition=" "+condition+" DETALLE_ID_PEDIDO='"+fCodPedido+"'";
					ands="and";
					//System.out.println("condition detalle 2: "+condition);
				
			}
			if(fCantidadProductos!=-1){
				if(ands!=null){
					condition=" " +condition+"and "+" DETALLE_CANT_PRODUCTOS='"+fCantidadProductos+"'";
				}else{
					condition=" " +condition+"DETALLE_CANT_PRODUCTOS='"+fCantidadProductos+"'";
					ands="and";
				}
				
			}
			if(fCodProducto!=-1){
				if(ands!=null){
					condition="  "+condition+"and "+" DETALLE_ID_PRODUCTO='"+fCodProducto+"'";
				}else{
					condition=" "+condition+"DETALLE_ID_PRODUCTO='"+fCodProducto+"'";
					ands="and";
				}
				
			}
			if(fPrecio!=-1){
				if(ands!=null){
					condition="  "+condition+"and "+" DETALLE_PRECIO='"+fPrecio+"'";
				}else{
					condition=" "+condition+"DETALLE_PRECIO='"+fPrecio+"'";
					ands="and";
					
				}
				
			}
			if(fTotal!=-1){
				if(ands!=null){
					condition=" "+condition+"and "+" SUBTOTAL='"+fTotal+"'";
				}else{
					condition=" "+condition+" SUBTOTAL='"+fTotal+"'";
					ands="and";
				}
				
			}
			
			//System.out.println("condition detalle 3: "+condition);
			
			SSQL=SSQL+" where "+condition;		
			
			System.out.println("detalle DAO DESDE LA BD : "+SSQL);
			//Va a preparar nuestra sentencia SSQL segura para su ejecución 
			ps=con.prepareStatement(SSQL);					
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			
			if(rs==null)
				return null;					
			//mientras haya un registro todavia en resultset
			//lista=null;
			while(rs.next()){							
				if (!join){
					System.out.println("ENTRO AL JOIN DETAILS !JOIN ");
					ObjDetallePedido=new Detalle_Pedido(											
							
							rs.getInt("DETALLE_ID_PEDIDO"), 
							null,
							rs.getInt("DETALLE_CANT_PRODUCTOS"), 
							rs.getInt("DETALLE_ID_PRODUCTO"),
							null,
							rs.getDouble("DETALLE_PRECIO"),
							rs.getDouble("SUBTOTAL")
					);
					
				}else{
					ObjDetallePedido=new Detalle_Pedido( 											
							
							rs.getInt("DETALLE_ID_PEDIDO"), 
							new Pedido(
									rs.getInt("PEDIDO_ID"),
									rs.getInt("PEDIDO_ID_MOZO"),
									null,
									rs.getInt("PEDIDO_ID_CAJERO"),
									null,
									rs.getTimestamp("FECHA"),
									rs.getDouble("PEDIDO_TOTALPAGAR"),
									rs.getString("PEDIDO_DNI_CLIENTE"),
									null,
									rs.getInt("ID_MESA"),
									null,
									rs.getBoolean("PAGADO"),
									rs.getBoolean("ENVIADO")
									),									
							rs.getInt("DETALLE_CANT_PRODUCTOS"), 
							rs.getInt("DETALLE_ID_PRODUCTO"),
							new Producto(
									rs.getInt("PRODUCTO_ID"),					
									rs.getString("PRODUCTO_NOMBRE"),
									rs.getDouble("PRODUCTO_PRECIO"),
									rs.getInt("PRODUCTO_STOCK"),
									rs.getString("PRODUCTO_CATEGORY")
									),
							rs.getDouble("DETALLE_PRECIO"),
							rs.getDouble("SUBTOTAL")
					);
				}
				
				//necesito agregar este objeto a mi lista
				lista.add(ObjDetallePedido);
				
			}		
			System.out.println("Elista.size() :"+lista.size());
			
			if(lista.size()<1) lista=null;
			return lista;
			
		} catch (SQLException e) {
			//si hay un error en SSQL o en la conexiňn nos darŕ aviso
			JOptionPane.showMessageDialog(null,e.getMessage());
			//e.printStackTrace();			
		}
			
		return null;
	
		
	}

}
