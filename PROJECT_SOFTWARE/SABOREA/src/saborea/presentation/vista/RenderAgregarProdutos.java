package saborea.presentation.vista;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class RenderAgregarProdutos extends DefaultTableCellRenderer{
	


public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		//nos servir� para mostrar bototnes en la tabla, puede ser un jlabel o jcombo
		if(value instanceof JButton){
			JButton btn=(JButton) value;
			return btn;
		}
//		if(value instanceof JTextField){
//			JTextField JSpinn=(JTextField) value;
//			return JSpinn;
//		}
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
	
	}


//	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//		//JSpinner JSpinn=(JSpinner) value;
//		JSpinn.setValue(value);
//		return JSpinn;
//		
//	}



	
	
}



