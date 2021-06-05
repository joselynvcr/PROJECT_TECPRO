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

public final class Tabla {
	
	public static void Exportar(JTable jtable) {
		//First Download Apache POI Library For Dealing with excel files.
        //Then add the library to the current project
		TableModel model=jtable.getModel(); 
        FileOutputStream excelFos = null;
        XSSFWorkbook excelJTableExport = null;
        BufferedOutputStream excelBos = null;
        try {
 
            //Choosing Saving Location
            //Set default location to C:\Users\Authentic\Desktop or your preferred location
            JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Authentic\\Desktop");
            //Dialog box title
            excelFileChooser.setDialogTitle("Save As ..");
            //Filter only xls, xlsx, xlsm files
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
            //Setting extension for selected file names
            excelFileChooser.setFileFilter(fnef);
            int chooser = excelFileChooser.showSaveDialog(null);
            //Check if save button has been clicked
            if (chooser == JFileChooser.APPROVE_OPTION) {
                //If button is clicked execute this code
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Jtable Export");
                //Loop through the jtable columns and rows to get its values
                for (int i = 0; i <model.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
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
