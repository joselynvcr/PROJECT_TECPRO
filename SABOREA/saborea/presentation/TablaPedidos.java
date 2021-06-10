package saborea.presentation;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import saborea.model.bussiness.DTO.ListaPedidosBE;
import saborea.model.bussiness.DTO.VwListaEmpleadosBE;

public final class TablaPedidos {

public static DefaultTableModel seeTable(JTable tabla, ArrayList<ListaPedidosBE> listaPedidos,TableRowSorter<DefaultTableModel> sorter){
		
		System.out.println("listaProductos"+ listaPedidos.size());
		
		tabla.setDefaultRenderer(Object.class, new RedimensionarListarPedido());
		
		
		
		JButton btn1= new JButton();
		btn1.setBorder(null);
		btn1.setBackground(new Color(0, 128, 128));
		btn1.setIcon(new ImageIcon(JDListarPedidos.class.getResource("/img/search_find_locate_icon_131498.png")));
		
		DefaultTableModel model= new DefaultTableModel(){
			
			public boolean isCellEditable(int row, int column) {
				//if(column==4)return true;
				return false;
			}
			
		};		
		
		
		
		model.addColumn("ID_PEDIDO");
		model.addColumn("MOZO");
		model.addColumn("CAJERO");
		model.addColumn("FECHA");
		model.addColumn("DNI_CLIENTE");
		model.addColumn("CLIENTE");
		model.addColumn("MESA");
		model.addColumn("PAGADO");
		model.addColumn("TOTAL PAGAR");
		model.addColumn("DETALLE_PEDIDO");
		
		tabla.setModel(model);
		
		tabla.setRowHeight(40);
		
		model.setRowCount(0);
		String pagado;
		if(listaPedidos!=null){
			//LLENAR MI TABLA
						
			for(int i=0;i<listaPedidos.size();i++){
				pagado=validar(listaPedidos.get(i).getPagado());
				Object [] fila = {
						listaPedidos.get(i).getIdpedido(),
						listaPedidos.get(i).getNomApeMozo(),
						listaPedidos.get(i).getNomApeCajero(),		
						listaPedidos.get(i).getFechaHora(),
						listaPedidos.get(i).getDni_Cliente(),
						listaPedidos.get(i).getNomApeCliente(),
						listaPedidos.get(i).getNroMesa(),
						pagado,
						listaPedidos.get(i).getTotalPagar(),						
						btn1					
						
				};
				
				model.addRow(fila);				
			}
			
			tabla.setModel(model);			
		}
		
		tabla.setAutoCreateRowSorter(true);
		sorter= new TableRowSorter<>(model);
		tabla.setRowSorter(sorter);
		
		return model;
		
	}

	static String validar(boolean b) {
		if (b==false) return "NO";
		else return "SÍ";
	
	}

}



