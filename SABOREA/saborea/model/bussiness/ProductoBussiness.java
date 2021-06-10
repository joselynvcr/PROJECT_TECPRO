package saborea.model.bussiness;

import java.util.ArrayList;

import saborea.model.bussiness.DTO.VwListaProductosBE;
import saborea.model.dao.ProductoDAO;
import saborea.model.entities.Producto;

public class ProductoBussiness {
	
	private ProductoDAO ObjProducto;
	
	public ProductoBussiness(){
		ObjProducto=new ProductoDAO();
	}

	
	// ArrayList<Producto> listaProd=new ArrayList<>();
	
	public ArrayList<VwListaProductosBE> ListaProductos(){
		
		
		ArrayList<Producto> lista=ObjProducto.listar(true);
		
		ArrayList<VwListaProductosBE> listaBE= new ArrayList<>();
		
		for(int i=0;i<lista.size();i++){
			listaBE.add(new VwListaProductosBE(
					lista.get(i).getCod_produto(), 
					lista.get(i).getNom_producto(),
					lista.get(i).getPrecio_producto(),
					lista.get(i).getStock_producto(), 
					lista.get(i).getCategory()
					)
					
					);
			
		}
		return listaBE;		
		
	}
	
	
	
	public ArrayList<VwListaProductosBE> FiltroProductosPorCategory( Producto ObjFind){
		
		ArrayList<Producto> lista=ObjProducto.buscar(ObjFind, false);
		
		ArrayList<VwListaProductosBE> listaBE= new ArrayList<>();
		
		if(lista==null)	return null;
		
		for(int i=0;i<lista.size();i++){
			listaBE.add(new VwListaProductosBE(
					lista.get(i).getCod_produto(), 
					lista.get(i).getNom_producto(),
					lista.get(i).getPrecio_producto(),
					lista.get(i).getStock_producto(), 
					lista.get(i).getCategory()
					)
					
					);
			
		}
		
		return listaBE;			
		
	}
	
	public void ModificarRegistroProducto(Producto prodActual){
		//el objeto que le estoy enviando debe contener al cod y al stock que deseo modificar		
		//Producto pro= new Producto(-1, null, -1, prodActual.getStock_producto(), null);		
		ObjProducto.modificar(prodActual);	
		
	}
	
	public int retornarStockActual(int idproducto){		
		
		ArrayList<Producto> Objpro=ObjProducto.buscar(new Producto(idproducto, null, 0, 0, null), false);		
		
		return Objpro.get(0).getStock_producto();
	}
	
	
	
	
	
}
