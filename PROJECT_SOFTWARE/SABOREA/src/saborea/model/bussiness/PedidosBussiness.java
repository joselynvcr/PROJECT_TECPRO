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
	
	
	public double GenerarTotalPagar(int codPedido){		
		
		Detalle_Pedido AuxDetallePedido= new Detalle_Pedido( codPedido, null, -1, -1, null, -1, -1);
				
		ArrayList<Detalle_Pedido> listaDetalle=ObjDetalle.buscar(AuxDetallePedido, false);
		
		return -1;
	}
//	
//	public ArrayList<ListaPedidosBE> listaPedidos(){
//		
//		ArrayList<Pedido> lista=ObjPedido.listar(true);
//		
//		ArrayList<ListaPedidosBE> listaBE= new ArrayList<>();
//		Detalle_Pedido AuxDetallePedido= new Detalle_Pedido(-1, lista, null, -1, -1, null, -1, -1);
//		ArrayList<Detalle_Pedido> listaDetalle=ObjDetalle.buscar(AuxDetallePedido, false);
//		
//		for(int i=0;i<lista.size();i++){
//			listaBE.add(new ListaPedidosBE(
//					lista.get(i).getCod_Pedido(),
//					lista.get(i).getObjcajero().getNom_Empleado()+" "+lista.get(i).getObjcajero().getApe_Empleado(),
//					lista.get(i).getObjmozo().getNom_Empleado()+" "+lista.get(i).getObjmozo().getApe_Empleado(),
//					lista.get(i).getFechaHora(), 					 
//					lista.get(i).getObjcliente().getNom_cliente()+" " + lista.get(i).getObjcliente().getApe_cliente(), 
//					lista.get(i).getObjmesa().getNro_mesa(), 
//					lista.get(i).getPagado(), 
//					lista.get(i).getTotalPagar(),					
//					null
//					
//					
//					)
//					
//					);
//		}
//		
//		return null;
//	}
//	
	
	public RegistroPedidoBE  SavePedidotoBD( VwRegistroPedidoProductoBE Obj) {		
		
		/*
	private int codmozo;	
	private int codCajero;		
	private String dniCliente;	
	private int codMesa;	
	private ArrayList<DetallePedidoBE> listaDetalle;*/
		
		/*private int PedidoId;
	private String nombreMozo;
	private String apellidoMozo;
	private int codmozo;	
	private String dniCliente;	
	private int codMesa;	
	private ArrayList<VwDetallePedidoBE> listaDetalle;
	private boolean enable;
	private double total;*/
		
//		DetallePedidoBE DetallePed= new DetallePedidoBE(codProducto, cantidad);
//															//codProducto, nombreProducto, cantidad, precio, subtotal
//		VwDetallePedidoBE DetallePedi= new VwDetallePedidoBE(Obj.getListaDetalle().get(0), nombreProducto, cantidad, precio, subtotal);
//		
//		
//		
//	
//		RegistroPedidoBE adicionar= new RegistroPedidoBE(
//				
//				Obj.getCodmozo(), 
//				Obj.getCodmozo(), 
//				Obj.getDniCliente(),
//				Obj.getCodMesa(),
//				
//				
//				
//				
//		);
//				
//				
//			
//		
			
		
		
		
		
		return null;		
	}
	
	
	
	public DetallePedidoBE BuscarOrdenPorMesa (int mesaId){
		
		//OBTENER TODOS LOS PEDIDOS (SOLO DEBERIA DE HABER 1 ACTIVO)  ESTADO DE PAGADO EN FALSE
		
		return null;
		
	}
	
	
	
	
	
	
	
	
}