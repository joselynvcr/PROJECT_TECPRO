package saborea.presentation;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;

public final class TablaDetalleOrdenrRegistrar {
	
	public static void Exportar(JTable jtable) {
		// Primero descargue la biblioteca de puntos de interés de Apache para tratar con archivos de Excel.
        // Luego agrega la biblioteca al proyecto actual
		TableModel model=jtable.getModel(); 
        FileOutputStream excelFos = null;
        XSSFWorkbook excelJTableExport = null;
        BufferedOutputStream excelBos = null;
        try { 
        	// Elección de la ubicación para guardar
            // Establezca la ubicación predeterminada en C: \ Users \ Authentic \ Desktop o su ubicación preferida
            JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Authentic\\Desktop");
         // Título del cuadro de diálogo
            excelFileChooser.setDialogTitle("Save As ..");
            //Filter only xls, xlsx, xlsm files
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
         // Filtrar solo archivos xls, xlsx, xlsm
            excelFileChooser.setFileFilter(fnef);
            int chooser = excelFileChooser.showSaveDialog(null);
         // Compruebe si se ha hecho clic en el botón Guardar
            if (chooser == JFileChooser.APPROVE_OPTION) {
            	// Si se hace clic en el botón, ejecute este código
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Jtable Export");
             // Recorre las columnas y filas de jtable para obtener sus valores
                
                XSSFRow ExcelRow = excelSheet.createRow(0);
                XSSFCell ExcelCell = ExcelRow.createCell(0); 
                ExcelCell.setCellValue("ID");
                
                for (int i = 0; i <model.getRowCount(); i++) {    
                	
                    XSSFRow excelRow = excelSheet.createRow(i+1);
                    
                    for (int j = 0; j < model.getColumnCount()-2; j++) {
                    	
                        XSSFCell excelCell = excelRow.createCell(j); 
                        
                        excelCell.setCellValue(model.getValueAt(i, j).toString());                      
                    }
                }
                excelFos = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBos = new BufferedOutputStream(excelFos);
                excelJTableExport.write(excelBos);
                JOptionPane.showMessageDialog(null, "Exportado correctamente");
            }
 
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                if (excelFos != null) {
                    excelFos.close();
                }
                if (excelBos != null) {
                    excelBos.close();
                }
                if (excelJTableExport != null) {
                    excelJTableExport.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
} 
	
	

	public static void seeTable(JTable tabla, VwRegistroPedidoProductoBE obj){
		System.out.println("ENTRE A SEE TABLE");
		System.out.println("obj.getListaDetalle().size() :"+ obj.getListaDetalle().size());
		
		tabla.setDefaultRenderer(Object.class, new RendimensionarRegistrarProducto());
		
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
			
		}
		
		
	}
	
	
	
	public static void ClearTable(JTable tabla, VwRegistroPedidoProductoBE obj){
		
		tabla.setDefaultRenderer(Object.class, new RendimensionarRegistrarProducto());
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
