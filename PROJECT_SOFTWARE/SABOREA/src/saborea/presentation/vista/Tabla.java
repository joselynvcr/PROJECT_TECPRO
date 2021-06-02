package saborea.presentation.vista;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;

public final class Tabla {

	public static void seeTable(JTable tabla, VwRegistroPedidoProductoBE obj){
		System.out.println("ENTRE A SEE TABLE");
		System.out.println("obj.getListaDetalle().size() :"+ obj.getListaDetalle().size());
		
		tabla.setDefaultRenderer(Object.class, new Rendimensionar());
		
		JButton btn1= new JButton("MODIFICAR");
		btn1.setName("m");
		JButton btn2= new JButton("ELIMINAR");
		btn2.setName("e");
		
		
		DefaultTableModel model= new DefaultTableModel() {
			
			public boolean isCellEditable(int row, int column) {
//				if(column==2){
//					return true;
//				}else{
//					return false;
//				}
				return false;
			}
			
		};		
		model.addColumn("ID");
		model.addColumn("NOMBRE");
		model.addColumn("PRECIO");
		model.addColumn("CANTIDAD");
		model.addColumn("SUBTOTAL");
		model.addColumn("MODIFICAR");
		model.addColumn("ELIMINAR");
		
		tabla.setModel(model);
		
		tabla.setRowHeight(25);
		
		
		if(obj!=null){
			//System.out.println("ENTRE AL RECORRIDO PARA LLENAR LA TABLA");
			//LLENAR MI TABLA
			model.setRowCount(0);			
			for(int i=0;i<obj.getListaDetalle().size();i++){
				Object [] fila = {
						obj.getListaDetalle().get(i).getCodProducto(),
						obj.getListaDetalle().get(i).getNombreProducto(),
						obj.getListaDetalle().get(i).getPrecio(),
						obj.getListaDetalle().get(i).getCantidad(),
						"S/ "+obj.getListaDetalle().get(i).getPrecio()*obj.getListaDetalle().get(i).getCantidad(),
						btn1,
						btn2
				};
				
				model.addRow(fila);				
			}
			
			tabla.setModel(model);
			
		}else{
			
			ClearTable(tabla,obj);
			
		}
		
		
	}
	
	
	
	public static void ClearTable(JTable tabla, VwRegistroPedidoProductoBE obj){
		
		tabla.setDefaultRenderer(Object.class, new Rendimensionar());
		DefaultTableModel model= new DefaultTableModel(){
			
			public boolean isCellEditable(int row, int column) {
//				if(column==2){
//					return true;
//				}else{
//					return false;
//				}
				return false;
			}
			
		};		
		
		model.addColumn("ID");
		model.addColumn("NOMBRE");
		model.addColumn("PRECIO");
		model.addColumn("CANTIDAD");
		model.addColumn("SUBTOTAL");
		model.addColumn("MODIFICAR");
		model.addColumn("ELIMINAR");
		
		tabla.setModel(model);
		
		tabla.setRowHeight(30);
		
		model.getDataVector().removeAllElements();
		tabla.updateUI();
		
	}
	
	
	
	
}
