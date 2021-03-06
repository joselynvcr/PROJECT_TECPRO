package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import saborea.model.bussiness.ProductoBussiness;
import saborea.model.bussiness.DTO.GetDataJTableORDENPEDIDO;
import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;
import saborea.model.entities.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JDWarningEliminarRegistroOrden extends javax.swing.JDialog implements ActionListener {
	private JButton btnOk;
	private JButton btnCancel;
	private VwRegistroPedidoProductoBE objeto;	
	DefaultTableModel m;
	private JTable table;
	private GetDataJTableORDENPEDIDO ObjDat;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			VW_WARNING_ELIMINAR dialog = new VW_WARNING_ELIMINAR();
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
		
		TablaDetalleOrdenrRegistrar.seeTable(table, obj);			
		//lblTotalPagar.setText(obj.getTotal()+ "");
		
	}
	public JDWarningEliminarRegistroOrden(java.awt.Frame parent, boolean modal,JTable tabla, VwRegistroPedidoProductoBE obj, GetDataJTableORDENPEDIDO ObjData) {
		
		super(parent,modal);
		table=tabla;		
		objeto=obj;
		ObjDat=ObjData;
		setBounds(100, 100, 467, 213);
		getContentPane().setLayout(null);
		{
			btnOk = new JButton("YES");
			btnOk.addActionListener(this);
			btnOk.setBounds(99, 106, 89, 36);
			getContentPane().add(btnOk);
		}
		{
			btnCancel = new JButton("CANCEL");
			btnCancel.addActionListener(this);
			btnCancel.setBounds(223, 106, 89, 36);
			getContentPane().add(btnCancel);
		}
		{
			JLabel lblAreYouSure = new JLabel("Esta seguro de eliminar este registro ?");
			lblAreYouSure.setBounds(111, 59, 229, 22);
			getContentPane().add(lblAreYouSure);
		}
		
		setLocationRelativeTo(null);
	}
	
	
	
	
	
	

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnOk) {
			do_btnOk_actionPerformed(arg0);
		}
	}
	//BUTTON OK
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		
			
		
		ArrayList<VwDetallePedidoBE> details = new ArrayList<>();
		System.out.println("ingrese al boton eliminar");
		System.out.println("objeto.getListaDetalle().size() :" +objeto.getListaDetalle().size());
		for(int i=0;i<objeto.getListaDetalle().size();i++){
			
			if(objeto.getListaDetalle().get(i).getCodProducto()!=ObjDat.getId()){				
				details.add( new VwDetallePedidoBE(
						objeto.getListaDetalle().get(i).getCodProducto(),
						objeto.getListaDetalle().get(i).getNombreProducto(),
						objeto.getListaDetalle().get(i).getCantidad(),
						objeto.getListaDetalle().get(i).getPrecio(),
						objeto.getListaDetalle().get(i).getPrecio()*objeto.getListaDetalle().get(i).getCantidad()
						 )
				);
			}
			
		}
		
		objeto.setListaDetalle(details);
		
		double totalPagar=0.0;
		for(int i=0;i<details.size();i++){
			totalPagar+=details.get(i).getSubtotal();
		}
		objeto.setTotal(totalPagar);
		
		ProductoBussiness PB = new ProductoBussiness();
		int _StockActual=PB.retornarStockActual(ObjDat.getId());
		
		ProductoBussiness pb= new ProductoBussiness();
		pb.ModificarRegistroProducto(new Producto(
				ObjDat.getId(), null, -1, _StockActual+(ObjDat.getCantidadSeleccionada()), null));
		
		
		RefreshWindow(objeto);
		JOptionPane.showMessageDialog(null, "FILA ELIMINADA SATISFACTORIAMENTE ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
		this.dispose();
		
		
		
		
		
		
		
	
	}
	//BUTTON CANCEL
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
