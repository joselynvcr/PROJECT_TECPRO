package saborea.presentation;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import saborea.model.bussiness.DTO.VwListaEmpleadosBE;
import saborea.model.bussiness.DTO.VwListaProductosBE;

public final class TablaEmpleados {
	
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
public static DefaultTableModel seeTable(JTable tabla, ArrayList<VwListaEmpleadosBE> listaEmpleados,TableRowSorter<DefaultTableModel> sorter){
		
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
		
		tabla.setRowHeight(30);
		
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
		
		return model;
		
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
