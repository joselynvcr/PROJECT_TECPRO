package saborea.presentation.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import saborea.model.bussiness.ProductoBussiness;
import saborea.model.bussiness.RegistroPedidoProductoBussiness;
import saborea.model.bussiness.DTO.ListaProductosBE;
import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;
import saborea.model.entities.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogAgregarProducto extends javax.swing.JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private JTable TABLAAGREGARPRODUCTOS;
	private JButton btnBack;
	private JButton btnAgregar;
	private JTextField txtCant;
	private JLabel lblCantidad;
	ArrayList<ListaProductosBE> _listaProductosBE;
	private VwRegistroPedidoProductoBE objeto;	
	DefaultTableModel m;
	//VwRegistroPedidoProductoBE ObjVRPP1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			JDialogAgregarProducto dialog = new JDialogAgregarProducto(new javax.swing.JFrame(),true);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param b 
	 * @param formRegistrarPedido 
	 */
	public JDialogAgregarProducto(java.awt.Frame parent, boolean modal,ArrayList<ListaProductosBE> listaProductosBE,JTable tabla, VwRegistroPedidoProductoBE obj) {
		super(parent,modal);
		_listaProductosBE=listaProductosBE;
		table=tabla;		
		objeto=obj;
		 setTitle("VENTANA AGREGAR PRODUCTOS");
		setBounds(100, 100, 883, 675);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 243, 708, 264);
		contentPanel.add(scrollPane);
		
		TABLAAGREGARPRODUCTOS = new JTable();
		scrollPane.setViewportView(TABLAAGREGARPRODUCTOS);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(this);
		btnBack.setBounds(10, 583, 89, 23);
		contentPanel.add(btnBack);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(730, 583, 89, 23);
		contentPanel.add(btnAgregar);
		
		txtCant = new JTextField();
		txtCant.setText("1");
		txtCant.setBounds(546, 584, 86, 20);
		contentPanel.add(txtCant);
		txtCant.setColumns(10);
		
		lblCantidad = new JLabel("cantidad :");
		lblCantidad.setBounds(433, 587, 86, 14);
		contentPanel.add(lblCantidad);
		
		TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, listaProductosBE);
		
		setLocationRelativeTo(null);
		
		
		
	}

	
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBack) {
			do_btnBack_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(arg0);
			//objeto=ObjVRPP1;
//			FormRegistrarPedido objFrm=new FormRegistrarPedido(objeto); 
//			objFrm.setVisible(true);
//			this.dispose();
		}
	}
	//BUTTON AGREGAR
	protected void do_btnAgregar_actionPerformed(ActionEvent arg0) {
			int fsel = TABLAAGREGARPRODUCTOS.getSelectedRow();
		
			String id,nombre, precio, stock,  cantidad,subtotal, total;
			double x=0.0;
			int ID = 0;
			String var=null;
			//int cant;
			 if(fsel==-1){
				 JOptionPane.showMessageDialog(null, "no seleccion� ning�n producto","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
			 }
			 m=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
			//System.out.println(TableProductos.getValueAt(fsel, 3));
			
			id=TABLAAGREGARPRODUCTOS.getValueAt(fsel, 0).toString();
			nombre= TABLAAGREGARPRODUCTOS.getValueAt(fsel, 1).toString();
			precio=TABLAAGREGARPRODUCTOS.getValueAt(fsel, 2).toString();
			stock=TABLAAGREGARPRODUCTOS.getValueAt(fsel, 3).toString();
			cantidad= txtCant.getText();
			
			//Realizando los c�lculos
			x=(Double.parseDouble(precio)* Integer.parseInt(cantidad));
			subtotal=String.valueOf(x);
			
			
			//BUSCAR SI ESTE REGISTRO ESTA EN EL PEDIDO 
			
			for(int i=0;i<objeto.getListaDetalle().size();i++){
			
				ID=objeto.getListaDetalle().get(i).getCodProducto();
				
				System.out.println("ID OBJ = "+ ID);	
				
				if(ID == Integer.parseInt(id)) { 
					System.out.println("ID OBJ 2= "+ id);
					var="NO";
					//
				}
				
			}
			System.out.println("nom = "+ var);
//			if(nom.equals("NO")){
//				JOptionPane.showMessageDialog(null, "EL PRODUCTO YA SE ENCUENTRA REGISTRADO","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
//			}else{
			
			if(var==null){	
				if(Integer.parseInt(txtCant.getText()) <= 0 || Integer.parseInt(txtCant.getText())>(int)TABLAAGREGARPRODUCTOS.getValueAt(fsel, 3)){
					JOptionPane.showMessageDialog(null, "Ingrese una cantidad v�lida ","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
				}else{
				VwDetallePedidoBE dp=new VwDetallePedidoBE(
						Integer.parseInt(id),
						nombre,
						Integer.parseInt(cantidad),
						Double.parseDouble(precio),
						Double.parseDouble(subtotal)
						);
				objeto.getListaDetalle().add(dp);
				double totalActual=objeto.getTotal();
				objeto.setTotal(totalActual+(dp.getCantidad()*dp.getPrecio()));			
				JOptionPane.showMessageDialog(null, "PRODUCTO REGISTRADO SATISFACTORIAMENTE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				//if(totalActual!=totalActual+(dp.getCantidad()*dp.getPrecio())){
					
				//}
				
				Producto prod= new Producto(Integer.parseInt(id), null,-1,((Integer.parseInt(stock))-(Integer.parseInt(cantidad))), null);
				ProductoBussiness prodB=new ProductoBussiness();
				prodB.ModificarRegistroProducto(prod);
				
				}
				
			}else{				
				JOptionPane.showMessageDialog(null, "EL PRODUCTO YA SE ENCUENTRA REGISTRADO EN LA ORDEN DE PEDIDO","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
			
			}
	
			
			
			
		
	}
	
	//BUTTON BACK TO ORDEN DE PEDIDO
	protected void do_btnBack_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
