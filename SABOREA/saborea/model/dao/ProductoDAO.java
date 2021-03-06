package saborea.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import saborea.model.entities.Mesa;
import saborea.model.entities.Producto;


public class ProductoDAO implements IDAO{
	
	private Connection con=null;
	private ArrayList<Producto> lista= new ArrayList<>();
	private Producto ObjProd;
	private PreparedStatement ps;
	
	public  ProductoDAO() {
		con=new ConnectionSaborea().getConnection();
	}
	@Override
	public ArrayList listar(boolean join) {
		try {
			//vamos a definir una sentencia SQL , sentencia SQL
			String SSQL= "SELECT * FROM producto";		
			//Va a preparar nuestra sentencia SSQL segura para su ejecuci?n 
			ps=con.prepareStatement(SSQL);
			//dentro de rs ya tengo todos los registros de mi tabla, necesito recorrer para cargar dentro de un objeto y posteriormente cargar cada objeto dentro de una lista
			//y por ultimo enviar un arraylist de todos los registros de la tabla 
			ResultSet rs= ps.executeQuery();
			//mientras haya un registro todavia en resultset
			while(rs.next()){				
				ObjProd=new Producto(
						rs.getInt("producto_Id"),					
						rs.getString("nom_Producto"),
						rs.getDouble("precio_Producto"),
						rs.getInt("stock_Producto"),
						rs.getString("category")
						);
				//necesito agregar este objeto a mi lista
						lista.add(ObjProd);
				
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
			ObjProd= (Producto) obj; //castear a obj producto
			//(? ? ?) EN VEZ DE DIGITAR CADA CAMPO, VAMOS A PONER (?) POR CADA UNO DE LOS CAMPOS QUE NECESITEMOS, PARA QUE EL PREPARESTAMENT REALICE UNA INSERCCION SEGURA
			String SSQL="INSERT INTO producto (producto_Id,nom_Producto,precio_Producto,stock_Producto,category) VALUES (?, ?, ?, ?, ?)";
			ps=con.prepareStatement(SSQL);
			ps.setInt(1, ObjProd.getCod_produto());
			ps.setString(2, ObjProd.getNom_producto());
			ps.setDouble(3, ObjProd.getPrecio_producto());
			ps.setInt(4, ObjProd.getStock_producto());
			ps.setString(5, ObjProd.getCategory());
			//actualizaci?n de datos de las tablas ,devuelve el n?mero de filas afectadas por la instrucci?n
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
		
	}
	@Override
	public void modificar(Object obj) {
		try{
			ObjProd=(Producto) obj; 
			//String SSQL="UPDATE producto SET nom_Producto=?,precio_Producto=?, stock_Producto=?,category=? WHERE producto_Id=? ";
			
			String SSQL=" UPDATE producto SET ";			
			String condition="";			
			//int fCod_produto=ObjProd.getCod_produto();
			int fStock_producto=ObjProd.getStock_producto();
			String fCategory=ObjProd.getCategory();
			double fPrecio_producto=ObjProd.getPrecio_producto();
			String fNom_producto=ObjProd.getNom_producto();
			String comas=null;
			
		//SSQL=Funcion("update","pedido",new ArrayList<String>{"mempleado_Id","cempleadoc_Id"},ObjPedido);
				
//		if(fCod_produto!=-1){			
//				condition=" "+condition+"producto_Id='"+fCod_produto+"'";			
//		}
			
		if(fStock_producto!=-1){			
				condition=" " +condition+"stock_Producto='"+fStock_producto+"'";	
			comas=",";
		}
		if(fCategory!=null){
			if(comas!=null){
				condition="  "+condition+","+"category='"+fCategory+"'";
			}else{
				condition=" "+condition+"category='"+fCategory+"'";
				comas=",";
			}
			
		}
		if(fPrecio_producto!=-1){
			if(comas!=null){
				condition="  "+condition+","+" precio_Producto= '"+fPrecio_producto+"'";
			}else{
				condition=" "+condition+" precio_Producto= '"+fPrecio_producto+"'";
				comas=",";
			}
			
		}
		if(fNom_producto!=null){
			if(comas!=null){
				condition="  "+condition+","+"nom_Producto='"+fNom_producto+"'";
			}else{
				condition=" "+condition+"nom_Producto='"+fNom_producto+"'";
				
			}
			
		}
		
			
		SSQL= SSQL+ condition +" where producto_Id="+ ObjProd.getCod_produto();			
		//System.out.println(" SSQL "+ SSQL);	
			//
			ps=con.prepareStatement(SSQL);			
//			ps.setString(1, ObjProd.getNom_producto());
//			ps.setDouble(2, ObjProd.getPrecio_producto());
//			ps.setInt(3, ObjProd.getStock_producto());
//			ps.setString(4, ObjProd.getCategory());
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
			String SSQL="DELETE FROM producto WHERE producto_Id=? ";
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
	public ArrayList<Producto> buscar (Object ObjFind, boolean objsProducto) {
		
		lista= new ArrayList<>();
		ObjProd=(Producto) ObjFind;
		
		try {		
			String SSQL= "SELECT * FROM producto ";	
			String condition=" ";
			int fCod_produto=ObjProd.getCod_produto();
			String fNom_producto=ObjProd.getNom_producto();
			double fPrecio_producto=ObjProd.getPrecio_producto();
			int fStock_producto=ObjProd.getStock_producto();
			String fDesc_producto=ObjProd.getCategory();						
			String ands=null;
			
			if(fCod_produto!=-1){
				condition=" "+condition+" producto_Id='"+fCod_produto+"'";
				ands="and";
			}
		if(fNom_producto!=null){
			if(ands!=null){
				condition=" "+condition+"and "+" nom_Producto='"+fNom_producto+"'";
			}else{
				condition=" "+condition+"nom_Producto='"+fNom_producto+"'";
				ands="and";
			}
		}
		if(fPrecio_producto!=-1){
			if(ands!=null){
				condition=" " +condition+"and "+" precio_Producto='"+fPrecio_producto+"'";
			}else{
				condition=" " +condition+"precio_Producto='"+fPrecio_producto+"'";
				ands="and";
			}
			
		}
		if(fStock_producto!=-1){
			if(ands!=null){
				condition=" "+condition+"and "+" stock_Producto='"+fStock_producto+"'";
			}else{
				condition=" "+condition+"stock_Producto='"+fStock_producto+"'";
				ands="and";
			}
			
		}
		if(fDesc_producto!=null){
			if(ands!=null){
				condition=" "+condition+"and "+" category='"+fDesc_producto+"'";
			}else{
				condition=" "+condition+" category='"+fDesc_producto+"'";
			}
			
		}
		
		SSQL=SSQL+"where "+condition;	
		System.out.println("SSQL : " + SSQL);
			ps=con.prepareStatement(SSQL);		
			ResultSet rs= ps.executeQuery();			
			while(rs.next()){				
				ObjProd=new Producto( 											
						rs.getInt("producto_Id"),					
						rs.getString("nom_Producto"),
						rs.getDouble("precio_Producto"),
						rs.getInt("stock_Producto"),
						rs.getString("category")								
					);
				lista.add(ObjProd);		
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
