package saborea.presentation.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import saborea.model.bussiness.ProductoBussiness;
import saborea.model.bussiness.RegistroPedidoProductoBussiness;
import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.bussiness.DTO.ListaProductosBE;
import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;
import saborea.model.entities.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FormAgregarProductos extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblBuscarProducto;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable TableProductos;
	ArrayList<ListaProductosBE> _listaProductosBE;
	TablaAgregarProductos tb;
	private JButton btnNewButton;
	private JTextField txtCant;
	private JLabel lblNewLabel;
	private JTable table;
	DefaultTableModel m;
	private JButton btnNewButton_1;
	//private JLabel lblTotalPagar;
	private VwRegistroPedidoProductoBE objeto;	
//	static double TotalPagar;
//	double subtotal;
	//JLabel lblTotal;
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormAgregarProductos frame = new FormAgregarProductos();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FormAgregarProductos(ArrayList<ListaProductosBE> listaProductosBE,JTable tabla, VwRegistroPedidoProductoBE obj) {
		_listaProductosBE=listaProductosBE;
		table=tabla;		
		objeto=obj;
		//lblTt=lblTotalPagar;
//		contenedor=getContentPane();
//		contenedor.setLayout(null);
		        //Asigna un titulo a la barra de titulo
		 setTitle("VENTANA AGREGAR PRODUCTOS");
		//tama�o de la ventana			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBuscarProducto = new JLabel("BUSCAR PRODUCTO");
		lblBuscarProducto.setBounds(114, 26, 137, 22);
		contentPane.add(lblBuscarProducto);
		
		textField = new JTextField();
		textField.setBounds(275, 27, 357, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 226, 698, 348);
		contentPane.add(scrollPane);
		
		TableProductos = new JTable();
		TableProductos.addMouseListener(this);
		scrollPane.setViewportView(TableProductos);
		
		tb= new TablaAgregarProductos();
		
		tb.seeTable(TableProductos, listaProductosBE);
		
		
		btnNewButton = new JButton("AGREGAR");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(844, 390, 89, 23);
		contentPane.add(btnNewButton);
		
		txtCant = new JTextField();
		txtCant.setText("1");
		txtCant.setBounds(847, 285, 86, 20);
		contentPane.add(txtCant);
		txtCant.setColumns(10);
		
		lblNewLabel = new JLabel("CANTIDAD :");
		lblNewLabel.setBounds(771, 288, 87, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(22, 686, 89, 23);
		contentPane.add(btnNewButton_1);
		
		setLocationRelativeTo(null);
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(arg0);
			//FormRegistrarPedido objFrm=new FormRegistrarPedido(objeto); 
			//objFrm.setVisible(true);
			this.dispose();
			
		}
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);
			
		}
		
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == TableProductos) {
			//do_TableProductos_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
//	protected void do_TableProductos_mouseClicked(MouseEvent arg0) {
//		int column=TableProductos.getColumnModel().getColumnIndexAtX(arg0.getX());
//		int row= arg0.getY()/TableProductos.getRowHeight();
//		
//		if(row<TableProductos.getRowCount() && row>=0 && column<TableProductos.getColumnCount() && column>=0){
//			
//			Object value = TableProductos.getValueAt(row, column);
//			
//			if(value instanceof JButton){
//				//si doy click al button
//				((JButton) value).doClick();
//				//devolvemos la acci�n
//				JButton b= (JButton) value;
//				
//				//System.out.println("Click en el button");
//				if(b.getName().equals("ADICIONAR")){
////					System.out.println("ENTRO A MOUSE CLICK  BOTON ADD");
////					System.out.println("Click en el button ADD");
//					int fsel = TableProductos.getSelectedRow();
//					try{
//						String id,nombre, precio, stock,  cantidad, subtotal,total;
//						//int cant;
////						 if(fsel==-1){
////							 JOptionPane.showMessageDialog(null, "no seleccion� ning�n producto","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
////						 }
//						DefaultTableModel m=(DefaultTableModel) TableProductos.getModel();
//						//System.out.println(TableProductos.getValueAt(fsel, 3));
//						
//						id=TableProductos.getValueAt(fsel, 0).toString();
//						nombre= TableProductos.getValueAt(fsel, 1).toString();
//						precio=TableProductos.getValueAt(fsel, 2).toString();
//						stock=TableProductos.getValueAt(fsel, 3).toString();
//						cantidad= TableProductos.getValueAt(fsel, 4).toString();
//						
//						//System.out.println(Integer.parseInt(stock ));
//						System.out.println("(int) TableProductos.getValueAt(fsel, 4) > Integer.parseInt(stock ) -> cant"
//								+ " : "+ (int) TableProductos.getValueAt(fsel, 4) +" stock "+ (int) TableProductos.getValueAt(fsel, 3));
//						//cantidad
//						if((int) TableProductos.getValueAt(fsel, 4)<=0){
//							 JOptionPane.showMessageDialog(null, "Ingrese una cantidad v�lida ","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
//						}
//						if((int) TableProductos.getValueAt(fsel, 4) > (int) TableProductos.getValueAt(fsel, 3)){
//							JOptionPane.showMessageDialog(null, "Ingrese una cantidad v�lida ","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
//						}
//						
//						
//						
//						
//						
//						
//					}catch (Exception e){
//						
//					}
//					
//					
//					
//				}
//				
//				
//			}			
//							
//		}	
//		
//		
//	}
	
	
	
	
	//BUTTON AGREGAR
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {		
		int fsel = TableProductos.getSelectedRow();
		
		
			String id,nombre, precio, stock,  cantidad,subtotal;
			double x=0.0;
			//int cant;
			 if(fsel==-1){
				 JOptionPane.showMessageDialog(null, "no seleccion� ning�n producto","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
			 }
			 m=(DefaultTableModel) TableProductos.getModel();
			//System.out.println(TableProductos.getValueAt(fsel, 3));
			
			id=TableProductos.getValueAt(fsel, 0).toString();
			nombre= TableProductos.getValueAt(fsel, 1).toString();
			precio=TableProductos.getValueAt(fsel, 2).toString();
			stock=TableProductos.getValueAt(fsel, 3).toString();
			cantidad= txtCant.getText();
			
			//System.out.println(Integer.parseInt(stock ));
//			System.out.println("(int) TableProductos.getValueAt(fsel, 4) > Integer.parseInt(stock ) -> cant"
//					+ " : "+ (int) TableProductos.getValueAt(fsel, 4) +" stock "+ (int) TableProductos.getValueAt(fsel, 3));
			//cantidad
			if(Integer.parseInt(txtCant.getText()) <= 0 || Integer.parseInt(txtCant.getText())>(int)TableProductos.getValueAt(fsel, 3)){
				 JOptionPane.showMessageDialog(null, "Ingrese una cantidad v�lida ","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
			}
			//Realizando los c�lculos
			x=(Double.parseDouble(precio)* Integer.parseInt(cantidad));
			subtotal=String.valueOf(x);
			
			//System.out.println("size: "+objeto.getListaDetalle().size());
//			DefaultTableModel ma=(DefaultTableModel) table.getModel();
//			String filaElement []={nombre,precio,cantidad,"S/"+subtotal};
//			
//			ma.addRow(filaElement); 
			//System.out.println("llego hasta aqui: ");
			//System.out.println("lblTotalPagar ventana agregar 2: "+obj.getTotal()+Integer.parseInt(subtotal));
			
			//calcula = (Double.parseDouble(precio));
			//TotalPagar=TotalPagar+calcula;
			
			VwDetallePedidoBE dp=new VwDetallePedidoBE(
					Integer.parseInt(id),
					nombre,
					Integer.parseInt(cantidad),
					Double.parseDouble(precio),
					Double.parseDouble(subtotal)
					);
			
			objeto.getListaDetalle().add(dp);
			double totalActual=objeto.getTotal();
			objeto.setTotal(totalActual+dp.getCantidad()*dp.getPrecio());
			
			
//			System.out.println("Integer.parseInt(id): "+Integer.parseInt(id));
//			System.out.println("nombre: "+nombre);
//			System.out.println("Integer.parseInt(cantidad): "+Integer.parseInt(cantidad));
//			System.out.println("Integer.parseInt(id): "+Integer.parseInt(id));
//			
			//objeto.getListaDetalle().add(dp);
			
			//Producto prod= new Producto(cod_produto, nom_producto, precio_producto, stock_producto, category)
			Producto prod= new Producto(Integer.parseInt(id), null,-1,((Integer.parseInt(stock))-(Integer.parseInt(cantidad))), null);
			ProductoBussiness prodB=new ProductoBussiness();
			prodB.ModificarRegistroProducto(prod);
			
			//System.out.println("size 2 : "+objeto.getListaDetalle().size());
			//CredencialesBE Cred= new CredencialesBE(obj.getCodmozo(), null, obj.getNombreMozo(), obj.getApellidoMozo(), null);
			
//			RegistroPedidoProductoBussiness RPPB= new RegistroPedidoProductoBussiness(); 
//			
//			VwRegistroPedidoProductoBE ObjVRPP =RPPB.findPedidos(null , objeto.getCodMesa());
//			
//			
//			objeto=ObjVRPP;
			
//			System.out.println("RAAAAAAAAAAAAAAAA");
//			System.out.println("total  : "+ObjVRPP.getTotal());
			
			
		
		
		
		
		
		
	}
	//BUTTON BACK TO ORDEN DE PEDIDO
	protected void do_btnNewButton_1_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
