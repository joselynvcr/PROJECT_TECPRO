package saborea.model.bussiness;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.bussiness.DTO.RegistroPedidoBE;
import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;
import saborea.model.dao.Detalle_PedidoDAO;
import saborea.model.dao.PedidoDAO;
import saborea.model.entities.Detalle_Pedido;
import saborea.model.entities.Pedido;

public class RegistroPedidoProductoBussiness {
	
	
	private PedidoDAO Objpedido;
	private Detalle_PedidoDAO detallepedido;
	
	
	public RegistroPedidoProductoBussiness() {
		Objpedido=new PedidoDAO();	
		detallepedido=new Detalle_PedidoDAO();
	}
	
	
	
	public ArrayList<VwDetallePedidoBE> findDetallePedidos(ArrayList<Pedido> listaa){
		
		
		
		Detalle_Pedido dp= new Detalle_Pedido(listaa.get(0).getCod_Pedido(),null, -1,-1,null,-1,-1);
		
		ArrayList<Detalle_Pedido> listaDetalle=detallepedido.buscar(dp, true);		
		
		if(listaDetalle==null) return null;		
		
		ArrayList<VwDetallePedidoBE> listaDetallePedidosVW= new ArrayList<VwDetallePedidoBE>();
		
		for(int i=0;i<listaDetalle.size();i++){

			listaDetallePedidosVW.add(new VwDetallePedidoBE(
					listaDetalle.get(i).getCodProducto(), 
					listaDetalle.get(i).getObjproducto().getNom_producto(),						
					listaDetalle.get(i).getCantidadProductos(), 
					listaDetalle.get(i).getPrecio(),
					listaDetalle.get(i).getTotal()
					//listaDetalle.get(i).getPrecio()*listaDetalle.get(i).getCantidadProductos()
					
						)	
					
					);	
			//totalPagar+=listaDetalle.get(i).getPrecio()*listaDetalle.get(i).getCantidadProductos();
			
		}
		
		//setTotal(totalPagar);
		
		return listaDetallePedidosVW;
		
			
		}
		
	
	
	
	
	//encontrar pedidos desde la BD
	public VwRegistroPedidoProductoBE findPedidos(CredencialesBE Cred, int mesa) {		
		
		double totalPagar=0.0;
		
		//if(ObjAgregarProdutoalPedido==null){
		Pedido p=new Pedido(-1,	-1,null,-1,null,null,	-1,	null,null, 	mesa,	null, false, false);
		
		//busqueda desde BD
		ArrayList<Pedido> lista=Objpedido.buscar(p, true);
		VwRegistroPedidoProductoBE PedidoRegistradoVW;
		
		System.out.println("totalPagar  : "+totalPagar);
		
		if(lista==null){//lista viene vacía, registro nuevo
			return null; 
		}else if(Cred.getEmpleadoId()==lista.get(0).getCodmozo()){//todos los permisos
			ArrayList<VwDetallePedidoBE> listaDetallePedidosRegistradosVW= findDetallePedidos(lista);
			
			
			for(int i=0;i<listaDetallePedidosRegistradosVW.size();i++){
				totalPagar+=listaDetallePedidosRegistradosVW.get(i).getSubtotal();
				}
			PedidoRegistradoVW = new VwRegistroPedidoProductoBE(
					lista.get(0).getCod_Pedido(),
					lista.get(0).getObjmozo().getNom_Empleado(),
					lista.get(0).getObjmozo().getApe_Empleado(),
					lista.get(0).getCodmozo(),
					lista.get(0).getDniCliente(),
					mesa,
					listaDetallePedidosRegistradosVW,
					true,
					totalPagar
					);
			return PedidoRegistradoVW;
		}else{
			ArrayList<VwDetallePedidoBE> listaDetallePedidosRegistradosVW= findDetallePedidos(lista);			
			
			for(int i=0;i<listaDetallePedidosRegistradosVW.size();i++){
				totalPagar+=listaDetallePedidosRegistradosVW.get(i).getSubtotal();
				}
			PedidoRegistradoVW = new VwRegistroPedidoProductoBE( //si el empleado no atiende esa mesa
					lista.get(0).getCod_Pedido(),
					lista.get(0).getObjmozo().getNom_Empleado(),
					lista.get(0).getObjmozo().getApe_Empleado(),
					lista.get(0).getCodmozo(),
					lista.get(0).getDniCliente(),
					mesa,
					listaDetallePedidosRegistradosVW,
					false,
					totalPagar
					);
			return PedidoRegistradoVW;
		}
		
		
	}
	
	
	public void  SavePedidotoBD(VwRegistroPedidoProductoBE Obj)  {	
		double totalPagar=0.0;
		System.out.println("size objeto recien entrando : "+Obj.getListaDetalle().size());
		System.out.println("PEDIDO_ID : "+Obj.getPedidoId());
		
		//SI EL OBJ PEDIDO ENCONTRÓ ENTONCES YA ESTA REGISTRADO EL PEDIDO EN BD, Y QUIERO GUARDAR CAMBIOS 
		//OTRO CASO ES QUE NO ENCUENTRE EL PEDIDO EN BD Y SEA NULL Y QUIERO REGISTRARLO POR PRIMERA VEZ 
		ArrayList<Pedido> Objped = Objpedido.buscar(new Pedido(
		    	Obj.getPedidoId(),-1,null,1,null,null,-1,null,null, -1,null,false,false),
				false);
		
		//System.out.println("Objped.size() : "+Objped.size());
			
		if(Objped!=null) {			
			System.out.println("ENTRO AL PEDIDO QUE YA HA SIDO REGISTRADO EN BD "
					+ "PARA REGISTRAR LOS DETAILS PORQUE EL PEDIDO YA ESTA EN BD");
			/*this.IdDetalle_Pedido=-1;
			this.CodPedido=-1;
			this.ObjPedido=null;
			this.CantidadProductos=-1;
			this.CodProducto=-1;
			this.Objproducto=null;
			this.precio=-1;
			this.total=-1;*/				
			
			ArrayList<Detalle_Pedido> details=new ArrayList<>() ;
			ArrayList<Detalle_Pedido> details2=new ArrayList<>() ;
			ArrayList<Detalle_Pedido> details3=new ArrayList<>() ;
			System.out.println("Obj.getListaDetalle().size() : "+Obj.getListaDetalle().size());
			
			for(int i=0;i<Obj.getListaDetalle().size();i++) {
				
				//quiero encontrar al producto una sola vez y si no esta el producto en el pedido, ingresarlo 
				details=detallepedido.buscar(new Detalle_Pedido(Obj.getPedidoId(), null, -1, Obj.getListaDetalle().get(i).getCodProducto(), null, -1, -1), false);				
				details2=detallepedido.buscar(new Detalle_Pedido(Obj.getPedidoId(), null,  Obj.getListaDetalle().get(i).getCantidad(), Obj.getListaDetalle().get(i).getCodProducto(), null, -1, -1), false);	
				details3=detallepedido.buscar(new Detalle_Pedido(Obj.getPedidoId(), null,  -1, -1, null, -1, -1), false);
				if(details==null){//no encontró un registro igual
					Detalle_Pedido Dp=new Detalle_Pedido (						
							Obj.getPedidoId(),
							null, 
							Obj.getListaDetalle().get(i).getCantidad(), 
							Obj.getListaDetalle().get(i).getCodProducto(),
							null,
							Obj.getListaDetalle().get(i).getPrecio(),
							Obj.getListaDetalle().get(i).getCantidad()*Obj.getListaDetalle().get(i).getPrecio()
						);
					
					System.out.println("INSERTO UN DETALLE DE PEDIDO");					
					detallepedido.insertar(Dp);
//					
				}
				if(details2==null){
					Detalle_Pedido Dp=new Detalle_Pedido (						
							Obj.getPedidoId(),
							null, 
							Obj.getListaDetalle().get(i).getCantidad(), 
							Obj.getListaDetalle().get(i).getCodProducto(),
							null,
							Obj.getListaDetalle().get(i).getPrecio(),
							Obj.getListaDetalle().get(i).getCantidad()*Obj.getListaDetalle().get(i).getPrecio()
						);
					
					System.out.println("update a UN DETALLE DE PEDIDO");
					
					detallepedido.modificar(Dp);
				}		
				
				
				
			}
			
			//buscare la lista grande de base de datos  en el obj actualizado
			int band=-0;
			for(int i=0;i<details3.size();i++){
				band=0;
				for(int x=0;x<Obj.getListaDetalle().size();x++){					
					if(details3.get(i).getCodProducto()==Obj.getListaDetalle().get(x).getCodProducto()){					
							 band=1;
					}
				}
				
				if(band==0){
					System.out.println("ELIMINAR : "+ Obj.getPedidoId()+" _" +details3.get(i).getCodProducto());
					detallepedido.eliminar(Obj.getPedidoId(), details3.get(i).getCodProducto());
				}
				
			}	
			
			for(int i=0;i<Obj.getListaDetalle().size();i++){
				totalPagar+=Obj.getListaDetalle().get(i).getSubtotal();
				}
			Obj.setTotal(totalPagar);
			
			System.out.println("TOTAL PAGAR: " + totalPagar);
			Objpedido.modificar(new Pedido (
			    	Obj.getPedidoId(),-1,null,-1,null,null,totalPagar,null,null, -1,null,false,false
			    	));
				
			JOptionPane.showMessageDialog(null, "CAMBIOS GUARDADOS SATISFACTORIAMENTE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);	
			
		} else {	
			
			System.out.println("ENTRO AL PEDIDO QUE NO HA SIDO REGISTRADO EN BD "
				+ "PARA REGISTRAR EL PEDIDO Y LOS DETAILS PORQUE EL PEDIDO NO ESTA EN BD");
			
			Pedido ped= new Pedido(
					-1, Obj.getCodmozo(),null, 1, null, null, Obj.getTotal(), Obj.getDniCliente(),
					null, Obj.getCodMesa(), null, false, false);	
			
			Objpedido.insertar(ped);		
			
			for(int i=0;i<Obj.getListaDetalle().size();i++) {
				
				Detalle_Pedido Dp=new Detalle_Pedido (						
						Obj.getPedidoId(),
						null, 
						Obj.getListaDetalle().get(i).getCantidad(), 
						Obj.getListaDetalle().get(i).getCodProducto(),
						null,
						Obj.getListaDetalle().get(i).getPrecio(),
						Obj.getListaDetalle().get(i).getCantidad()*Obj.getListaDetalle().get(i).getPrecio()				
					);
				
				detallepedido.insertar(Dp);
				
			}
			
			JOptionPane.showMessageDialog(null, "PEDIDO REGISTRADO SATISFACTORIAMENTE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);	
			//JOptionPane.showMessageDialog(null, "El pedido ya fue registrado","WARNING",JOptionPane.WARNING_MESSAGE);			
		}
		
		
		
	}
	
	
	public void UpdateDetallePedido(Detalle_Pedido obj){		
		
		detallepedido.modificar(new Detalle_Pedido(obj.getCodPedido(), null,obj.getCantidadProductos(),obj.getCodProducto() , null, -1, -1));
		
		
	}
	
	
	
	
	
	
	
		
	
	
	
	
	
}
