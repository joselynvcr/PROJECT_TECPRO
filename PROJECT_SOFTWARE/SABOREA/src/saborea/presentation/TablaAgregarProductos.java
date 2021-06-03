package saborea.presentation;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import saborea.model.bussiness.DTO.ListaProductosBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;

public final class TablaAgregarProductos {
	
public static void seeTable(JTable tabla, ArrayList<ListaProductosBE> listaProductos){
		
		System.out.println("listaProductos"+ listaProductos.size());
		tabla.setDefaultRenderer(Object.class, new RenderAgregarProdutos());
		
//		JTextField txt= new JTextField();
//		txt.setName("CANT");
//		txt.setText("0");
//		
		
//		JButton btnADD= new JButton("ADD");
//		btnADD.setName("ADICIONAR");
		
		DefaultTableModel model= new DefaultTableModel(){
			
			public boolean isCellEditable(int row, int column) {
				//if(column==4)return true;
				return false;
			}
			
		};		
		
		model.addColumn("ID PRODUCTO");
		model.addColumn("NOMBRE");
		model.addColumn("PRECIO");
		model.addColumn("STOCK");
		model.addColumn("CATEGOR�A");
//		model.addColumn("CANTIDAD");
//		model.addColumn("AGREGAR");
		
		tabla.setModel(model);
		
		tabla.setRowHeight(30);
		
		model.setRowCount(0);
		if(listaProductos!=null){
			//LLENAR MI TABLA
						
			for(int i=0;i<listaProductos.size();i++){
				Object [] fila = {
						listaProductos.get(i).getId(),
						listaProductos.get(i).getNombre(),
						listaProductos.get(i).getPrecio(),		
						listaProductos.get(i).getStock(),
						listaProductos.get(i).getCategory(),	
						
						
				};
				
				model.addRow(fila);				
			}
			
			tabla.setModel(model);			
		}
		
		
}
	
	
	
	public static void ClearTable(JTable tabla){
		
		tabla.setDefaultRenderer(Object.class, new RenderAgregarProdutos());
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
		
		model.addColumn("ID PRODUCTO");
		model.addColumn("NOMBRE");
		model.addColumn("PRECIO");
		model.addColumn("STOCK");		
		
		tabla.setModel(model);
		
		tabla.setRowHeight(30);
		
		model.getDataVector().removeAllElements();
		tabla.updateUI();
		
	}

	
	

}