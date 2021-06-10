package saborea.model.bussiness;

import java.util.ArrayList;

import saborea.model.bussiness.DTO.DetallePedidoBE;
import saborea.model.bussiness.DTO.ListaPedidosBE;
import saborea.model.bussiness.DTO.RegistroPedidoBE;
import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;
import saborea.model.dao.Detalle_PedidoDAO;
import saborea.model.dao.PedidoDAO;
import saborea.model.entities.Detalle_Pedido;
import saborea.model.entities.Pedido;
import saborea.model.entities.login;

public class PedidosBussiness {

	
	private PedidoDAO ObjPedido;
	private Detalle_PedidoDAO ObjDetalle;
	
	public PedidosBussiness(){
		ObjPedido=new PedidoDAO();
		ObjDetalle=new Detalle_PedidoDAO();
		
	}
	
	
//	public double GenerarTotalPagar(int codPedido){		
//		
//		Detalle_Pedido AuxDetallePedido= new Detalle_Pedido( codPedido, null, -1, -1, null, -1, -1);
//				
//		ArrayList<Detalle_Pedido> listaDetalle=ObjDetalle.buscar(AuxDetallePedido, true);
//		
//		return -1;
//	}
	public ArrayList<VwDetallePedidoBE> listaDetalle (int codPedido){
		
		Detalle_Pedido AuxDetallePedido= new Detalle_Pedido(codPedido, null, -1, -1, null, -1, -1);
		
		ArrayList<Detalle_Pedido> _listaDetalle=ObjDetalle.buscar(AuxDetallePedido, true);
		
		ArrayList<VwDetallePedidoBE> listaDetalle_= new ArrayList<>();//
		
		for(int i=0;i<_listaDetalle.size();i++) {
			
			listaDetalle_.add(new VwDetallePedidoBE(
					_listaDetalle.get(i).getCodProducto(), 
					_listaDetalle.get(i).getObjproducto().getNom_producto(),
					_listaDetalle.get(i).getCantidadProductos(),
					_listaDetalle.get(i).getPrecio(),					
					_listaDetalle.get(i).getTotal()//subtotal					
						
						)
					);
		}
		
		
		return listaDetalle_;
		
	}
	
	public ArrayList<ListaPedidosBE> listaPedidos() {
		
		ArrayList<Pedido> lista=ObjPedido.listar(true);	
		
		ArrayList<ListaPedidosBE> listaBE= new ArrayList<>();
		
		ArrayList<VwDetallePedidoBE> listaDetalle_= new ArrayList<>();		
		
		
		for(int i=0;i<lista.size();i++){
			
			listaDetalle_=listaDetalle(lista.get(i).getCod_Pedido());
			System.out.println("mozo : " +lista.get(i).getObjmozo().getNom_Empleado()+" "+lista.get(i).getObjmozo().getApe_Empleado());
			System.out.println("caja :"+lista.get(i).getObjcajero().getNom_Empleado()+" "+lista.get(i).getObjcajero().getApe_Empleado());
			
			listaBE.add(new ListaPedidosBE(
					lista.get(i).getCod_Pedido(),
					lista.get(i).getObjmozo().getNom_Empleado()+" "+lista.get(i).getObjmozo().getApe_Empleado(),
					lista.get(i).getObjcajero().getNom_Empleado()+" "+lista.get(i).getObjcajero().getApe_Empleado(),					
					lista.get(i).getFechaHora(),
					lista.get(i).getDniCliente(),
					lista.get(i).getObjcliente().getNom_cliente()+" " + lista.get(i).getObjcliente().getApe_cliente(), 
					lista.get(i).getObjmesa().getNro_mesa(), 
					lista.get(i).getPagado(), 
					lista.get(i).getTotalPagar(),					
					listaDetalle_					
					
					)					
				);
			
		}
		
		return listaBE;
	}
	
	
	
	
	
	
	public DetallePedidoBE BuscarOrdenPorMesa (int mesaId){
		
		//OBTENER TODOS LOS PEDIDOS (SOLO DEBERIA DE HABER 1 ACTIVO)  ESTADO DE PAGADO EN FALSE
		
		return null;
		
	}
	
	
	
	
	
	
	
	
}
