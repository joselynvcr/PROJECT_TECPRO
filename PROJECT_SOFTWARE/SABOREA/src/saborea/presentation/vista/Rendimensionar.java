package saborea.presentation.vista;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Rendimensionar extends DefaultTableCellRenderer {


	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		//nos servir� para mostrar bototnes en la tabla, puede ser un jlabel o jcombo
		if(value instanceof JButton){
			JButton btn=(JButton) value;
			return btn;
		}
		
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		
		
		
		
	}
	
	
	
	
	
	
}
