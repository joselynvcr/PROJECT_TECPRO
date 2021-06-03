package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import saborea.model.bussiness.ProductoBussiness;
import saborea.model.bussiness.RegistroPedidoProductoBussiness;
import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.bussiness.DTO.GetDataJTableORDENPEDIDO;
import saborea.model.bussiness.DTO.ListaProductosBE;
import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;
import saborea.model.entities.Detalle_Pedido;
import saborea.model.entities.Producto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VENTANA_MODIFICAR extends javax.swing.JDialog implements ActionListener {
	private JButton btnCancel;
	private JButton btnOk;
	private JTextField txtCant_VModificar;
	private JLabel lblIngreseLaCantidad;
	ArrayList<ListaProductosBE> _listaProductosBE;
	private VwRegistroPedidoProductoBE objeto;	
	DefaultTableModel m;
	private JTable table;
	private GetDataJTableORDENPEDIDO ObjDat;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			VENTANA_MODIFICAR dialog = new VENTANA_MODIFICAR();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public void RefreshWindow(VwRegistroPedidoProductoBE obj){
		
		Tabla.seeTable(table, obj);			
		//lblTotalPagar.setText(obj.getTotal()+ "");
		
	}
	public VENTANA_MODIFICAR( java.awt.Frame parent, boolean modal,JTable tabla, VwRegistroPedidoProductoBE obj, GetDataJTableORDENPEDIDO ObjData) {
		
		super(parent,modal);
		//_listaProductosBE=listaProductosBE;
		table=tabla;		
		objeto=obj;
		ObjDat=ObjData;
		System.out.println("ENTTRO AL JDIALOG MODIFICAR");
		 setTitle("VENTANA MODIFICAR CANTIDAD");
		setBounds(100, 100, 556, 234);
		getContentPane().setLayout(null);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(427, 149, 89, 35);
		getContentPane().add(btnCancel);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		btnOk.setBounds(328, 149, 89, 35);
		getContentPane().add(btnOk);
		
		txtCant_VModificar = new JTextField();
		txtCant_VModificar.setText("1");
		txtCant_VModificar.setBounds(222, 55, 103, 35);
		getContentPane().add(txtCant_VModificar);
		txtCant_VModificar.setColumns(10);
		
		lblIngreseLaCantidad = new JLabel("INGRESE LA CANTIDAD ");
		lblIngreseLaCantidad.setBounds(76, 60, 136, 25);
		getContentPane().add(lblIngreseLaCantidad);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
			//RefreshWindow(objeto);
		}
		// TODO Auto-generated method stub
		
	}
	//BUTTON OK
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		
		//RefreshWindow(objeto);
		
		//int fsel = table.getSelectedRow();
		
		//BUSCAR EL STOCK DEL PRODUCTO SELECCIONADO 
		ProductoBussiness PB = new ProductoBussiness();
		int _StockActual=PB.retornarStockActual(ObjDat.getId());		
		
		if(Integer.parseInt(txtCant_VModificar.getText()) <= 0 || Integer.parseInt(txtCant_VModificar.getText())>_StockActual){
			JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida ","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
		}else{
			
//			RegistroPedidoProductoBussiness ObjRegistroPed=new RegistroPedidoProductoBussiness();
//			
//			//modificar el registro de la BD en el detalle de pedido, modificar la cantidad de producto 
//			ObjRegistroPed.UpdateDetallePedido(
//					new Detalle_Pedido(
//							objeto.getPedidoId(), null, Integer.parseInt(txtCant_VModificar.getText()), ID, null, -1, -1)
//					);
			
			//modificar el registro del objeto del detalle de pedido, modificar la cantidad de producto 
			ArrayList<VwDetallePedidoBE> details = new ArrayList<>();
			
			for(int i=0;i<objeto.getListaDetalle().size();i++){		
				
				if(objeto.getListaDetalle().get(i).getCodProducto()==ObjDat.getId()){					
					details.add( new VwDetallePedidoBE(
							objeto.getListaDetalle().get(i).getCodProducto(),
							objeto.getListaDetalle().get(i).getNombreProducto(),
							Integer.parseInt(txtCant_VModificar.getText()),
							objeto.getListaDetalle().get(i).getPrecio(),
							objeto.getListaDetalle().get(i).getPrecio()*Integer.parseInt(txtCant_VModificar.getText())
							 )
					);
				}else{
				
				details.add(new VwDetallePedidoBE(
							objeto.getListaDetalle().get(i).getCodProducto(),
							objeto.getListaDetalle().get(i).getNombreProducto(),
							objeto.getListaDetalle().get(i).getCantidad(),
							objeto.getListaDetalle().get(i).getPrecio(),
							objeto.getListaDetalle().get(i).getPrecio()*objeto.getListaDetalle().get(i).getCantidad())
							 
						);
				}
				
			}
			objeto.setListaDetalle(details);
			//double totalActual=objeto.getTotal();
			double totalPagar=0.0;
			for(int i=0;i<details.size();i++){
				totalPagar+=details.get(i).getSubtotal();
			}
			objeto.setTotal(totalPagar);
			
			//si la cantidad seleccionada es mayor que la cantidad a modificar
			if(ObjDat.getCantidadSeleccionada()>Integer.parseInt(txtCant_VModificar.getText())){
				ProductoBussiness pb= new ProductoBussiness();
				pb.ModificarRegistroProducto(new Producto(
						ObjDat.getId(), null, -1, _StockActual+(ObjDat.getCantidadSeleccionada()-Integer.parseInt(txtCant_VModificar.getText())), null));
				
			}else{ 
				//si la cantidad seleccionada es menor que la cantidad modificada 
				ProductoBussiness pb= new ProductoBussiness();
				pb.ModificarRegistroProducto(new Producto(
						ObjDat.getId(), null, -1, _StockActual-(Integer.parseInt(txtCant_VModificar.getText())-ObjDat.getCantidadSeleccionada()), null));
				
			}						
			RefreshWindow(objeto);
			JOptionPane.showMessageDialog(null, "CANTIDAD MODIFICADA SATISFACTORIAMENTE ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			
			
		}
		
		
		
	}
	
	//BUTTON CANCEL
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
