package saborea.presentation;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import saborea.model.bussiness.DTO.ListaEmpleadosBE;
import saborea.model.bussiness.DTO.ListaProductosBE;

public final class TablaEmpleados {
	
public static void seeTable(JTable tabla, ArrayList<ListaEmpleadosBE> listaEmpleados,TableRowSorter<DefaultTableModel> sorter){
		
		System.out.println("listaProductos"+ listaEmpleados.size());
		tabla.setDefaultRenderer(Object.class, new RenderAgregarProdutos());
		
		DefaultTableModel model= new DefaultTableModel(){
			
			public boolean isCellEditable(int row, int column) {
				//if(column==4)return true;
				return false;
			}
			
		};		
		
		model.addColumn("ID_EMPLEADO");
		model.addColumn("DNI");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDOS");
		model.addColumn("TELÉFONO");
		model.addColumn("ESTADO CIVIL");
		model.addColumn("GÉNERO");
		model.addColumn("SUELDO");
		model.addColumn("NUM_HIJOS");
		model.addColumn("TIPO_CARGO");
		model.addColumn("ID_JEFE");
		tabla.setModel(model);
		
		tabla.setRowHeight(20);
		
		model.setRowCount(0);
		if(listaEmpleados!=null){
			//LLENAR MI TABLA
						
			for(int i=0;i<listaEmpleados.size();i++){
				Object [] fila = {
						listaEmpleados.get(i).getIdEmpleado(),
						listaEmpleados.get(i).getNum_DNI_empleado(),
						listaEmpleados.get(i).getNom_Empleado(),		
						listaEmpleados.get(i).getApe_Empleado(),
						listaEmpleados.get(i).getNum_Telf_empleado(),
						listaEmpleados.get(i).getEstadoCivil_empleado(),
						listaEmpleados.get(i).getGender_empleado(),
						listaEmpleados.get(i).getSueldo_base_empleado(),
						listaEmpleados.get(i).getNum_hijos_empleado(),
						listaEmpleados.get(i).getTipoCargo_empleado(),
						listaEmpleados.get(i).getIdJefe(),						
						
				};
				
				model.addRow(fila);				
			}
			
			tabla.setModel(model);			
		}
		
		tabla.setAutoCreateRowSorter(true);
		sorter= new TableRowSorter<>(model);
		tabla.setRowSorter(sorter);
		
		
		
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
