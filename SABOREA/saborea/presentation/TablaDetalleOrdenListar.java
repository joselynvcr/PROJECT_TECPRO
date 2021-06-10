package saborea.presentation;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;

public final class TablaDetalleOrdenListar {
	
	public static void seeTable(JTable tabla, ArrayList<VwDetallePedidoBE> listaDetalle_){
	System.out.println("ENTRE A SEE TABLE");
	//System.out.println("obj.getListaDetalle().size() :"+ obj.getListaDetalle().size());
	
	tabla.setDefaultRenderer(Object.class, new RendimensionarRegistrarProducto());
	
	DefaultTableModel model= new DefaultTableModel() {
		
		public boolean isCellEditable(int row, int column) {
//			if(column==2){
//				return true;
//			}else{
//				return false;
//			}
			return false;
		}
		
	};		
	model.addColumn("ID_PRODUCTO");
	model.addColumn("PRODUCTO");
	model.addColumn("CANTIDAD");
	model.addColumn("PRECIO.UNT");
	model.addColumn("SUBTOTAL");	
	tabla.setModel(model);	
	tabla.setRowHeight(25);
	
	
	if(listaDetalle_!=null){
		//System.out.println("ENTRE AL RECORRIDO PARA LLENAR LA TABLA");
		//LLENAR MI TABLA
		model.setRowCount(0);			
		for(int i=0;i<listaDetalle_.size();i++){
			Object [] fila = {
					listaDetalle_.get(i).getCodProducto(),
					listaDetalle_.get(i).getNombreProducto(),
					listaDetalle_.get(i).getCantidad(),
					listaDetalle_.get(i).getPrecio(),					
					"S/ "+listaDetalle_.get(i).getSubtotal()					
			};
			
			model.addRow(fila);				
		}
		
		tabla.setModel(model);
		
		}
	}
}
