package saborea.presentation;

import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import saborea.model.bussiness.ProductoBussiness;
import saborea.model.bussiness.RegistroPedidoProductoBussiness;
import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.bussiness.DTO.GetDataJTableORDENPEDIDO;
import saborea.model.bussiness.DTO.ListaProductosBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import java.awt.Container;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.Checkbox;
import java.awt.Scrollbar;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;


public class FormRegistrarPedido extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;	
	private Container contenedor;
	private VwRegistroPedidoProductoBE objeto;
	//private Tabla t;
	//
//	DefaultTableModel model= new DefaultTableModel(){
//		public boolean isCellEditable(int row, int column) {
//			if(column==2){
//				return true;
//			}else{
//				return false;
//			}
//		};
//	};
	
	private JScrollPane scrollPane;
	private JTable TABLAORDENPEDIDO;
	private JButton btnSave;
	private JButton btnEnviarOrdenA;
	private JButton btnBack;
	private JLabel lblDetalleDePedido;
	private JLabel lblDniCliente;
	private JLabel lblCliente;
	private JTextField txtClienteDNI_pedido;
	private JLabel lblMozo;
	private JLabel lblNMesa;
	private JLabel lblNommozo;
	private JLabel lblIDMESA;
	private JLabel LblnomCliente;
	private JButton btnAgregarProducto;
	private JLabel lblNewLabel;
	private JLabel lblTotalPagar;
	private CredencialesBE Cred;
	DefaultTableModel m;
	private JLabel lblNomCliente;
	private JLabel lblNomMozo;
	private JLabel lblNumMesa;
	private JPanel panel;
	private JLabel lblOrdenDePedido;
	private JLabel lblNewLabel_1;
	 
	//private JLabel lblTotalPagar;
//	static double TotalPagar;
//	double subtotal;
	
	
	
//	protected void do_scrollPane_mouseClicked(java.awt.event.MouseEvent evt) {
//		System.out.println("ENTRO A MOUSECLICKED");
//		//private void tableMouseClicked (java.awt.event.MouseEvent evt) {
//			
//			//PARA OBTENER LA POSICIÓN DONDE DAMOS CLICK x and y 
//			int column=table.getColumnModel().getColumnIndexAtX(evt.getX());
//			int row= evt.getY()/table.getRowHeight();
//			 
//			if(row<table.getRowCount() && row>=0 && column<table.getColumnCount() && column>=0){
//				
//				Object value = table.getValueAt(row, column);
//				
//				if(value instanceof JButton){
//					//si doy click al button
//					((JButton)value).doClick();
//					//devolvemos la acción
//					JButton btn= (JButton) value;
//					
//					System.out.println("Click en el button");
//					
//				}
//				
//				
//				
//			}
//			
//			
//			
//		}
		
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormRegistrarPedido frame = new FormRegistrarPedido(obj);
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
	
//	public FormRegistrarPedido(){
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		
//		System.out.println("mostrar columnas");
//		model.addColumn("NOMBRE");
//		model.addColumn("PRECIO");
//	}
	
	public void RefreshWindow(VwRegistroPedidoProductoBE obj){
		
		Tabla.seeTable(TABLAORDENPEDIDO, obj);			
		lblTotalPagar.setText(obj.getTotal()+ "");
		
	}
	
	public FormRegistrarPedido(VwRegistroPedidoProductoBE obj,CredencialesBE Creden) {
		setUndecorated(true);
		
		objeto=obj;
		Cred= Creden;
		
//		TotalPagar=0.00;
//		subtotal=0.00;
		//System.out.println("size: "+objeto.getListaDetalle().size());
		
		contenedor=getContentPane();
		contenedor.setLayout(null);
		        //Asigna un titulo a la barra de titulo
		 setTitle("VENTANA ORDEN DE PEDIDO");
		//tamaño de la ventana
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 950, 751);	
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FormRegistrarPedido.class.getResource("/img/lista (1).png")));
		lblNewLabel_1.setBounds(387, 0, 141, 133);
		contentPane.add(lblNewLabel_1);
		
		scrollPane = new JScrollPane();
		//scrollPane.addMouseListener(this);
		scrollPane.setBounds(10, 237, 914, 382);
		contentPane.add(scrollPane);
		
		TABLAORDENPEDIDO = new JTable();
		TABLAORDENPEDIDO.addMouseListener(this);
		//table.addMouseListener(this);
		scrollPane.setViewportView(TABLAORDENPEDIDO);
		
//		
//		System.out.println("mostrar columnas");
//		model.addColumn("NOMBRE");
//		model.addColumn("PRECIO");
//		model.addColumn("CANTIDAD");
//		table.setModel(model);
				
		
		btnSave = new JButton("SAVE");
		btnSave.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSave.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSave.setIcon(new ImageIcon(FormRegistrarPedido.class.getResource("/img/icon_guardar.png")));
		btnSave.setContentAreaFilled(false);
		btnSave.setBorder(null);
		btnSave.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnSave.addActionListener(this);
		btnSave.setBounds(581, 645, 141, 95);
		contentPane.add(btnSave);
		
		btnEnviarOrdenA = new JButton("ENVIAR ORDEN A CAJA");
		btnEnviarOrdenA.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEnviarOrdenA.setBorder(null);
		btnEnviarOrdenA.setContentAreaFilled(false);
		btnEnviarOrdenA.setVerticalAlignment(SwingConstants.TOP);
		btnEnviarOrdenA.setIcon(new ImageIcon(FormRegistrarPedido.class.getResource("/img/correo-electronico (2).png")));
		btnEnviarOrdenA.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEnviarOrdenA.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnEnviarOrdenA.setBounds(747, 645, 177, 95);
		contentPane.add(btnEnviarOrdenA);
		
		btnBack = new JButton("");
		btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.setRolloverIcon(new ImageIcon(FormRegistrarPedido.class.getResource("/img/icon_volver (1).png")));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setText("VOLVER");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setText("");
			}
		});
		btnBack.setVerticalAlignment(SwingConstants.TOP);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setIcon(new ImageIcon(FormRegistrarPedido.class.getResource("/img/icon_volver.png")));
		btnBack.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnBack.addActionListener(this);
		btnBack.setBounds(0, 650, 97, 75);
		contentPane.add(btnBack);
		
		lblDetalleDePedido = new JLabel("DETALLE DE PEDIDO");
		lblDetalleDePedido.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblDetalleDePedido.setBounds(10, 205, 173, 14);
		contentPane.add(lblDetalleDePedido);
				
		
		btnAgregarProducto = new JButton("AGREGAR PRODUCTO");
		btnAgregarProducto.setIcon(new ImageIcon(FormRegistrarPedido.class.getResource("/img/1904677-add-addition-calculate-charge-create-new-plus_122527.png")));
		btnAgregarProducto.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnAgregarProducto.addActionListener(this);
		btnAgregarProducto.setBounds(704, 193, 220, 33);
		contentPane.add(btnAgregarProducto);
		
		lblDniCliente = new JLabel("DNI CLIENTE :");
		lblDniCliente.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblDniCliente.setBounds(33, 99, 115, 14);
		contentPane.add(lblDniCliente);
		
		lblCliente = new JLabel("CLIENTE :");
		lblCliente.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblCliente.setBounds(33, 144, 89, 14);
		contentPane.add(lblCliente);
		
		lblMozo = new JLabel("MOZO :");
		lblMozo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblMozo.setBounds(589, 92, 72, 14);
		contentPane.add(lblMozo);
		
		lblNMesa = new JLabel("N\u00B0 MESA :");
		lblNMesa.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNMesa.setBounds(592, 142, 83, 14);
		contentPane.add(lblNMesa);
		
		txtClienteDNI_pedido = new JTextField();
		txtClienteDNI_pedido.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		txtClienteDNI_pedido.setBounds(143, 98, 123, 20);
		contentPane.add(txtClienteDNI_pedido);
		txtClienteDNI_pedido.setColumns(10);
		
		lblNewLabel = new JLabel("TOTAL PAGAR : S/ ");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel.setBounds(387, 619, 141, 14);
		contentPane.add(lblNewLabel);
		
		lblTotalPagar = new JLabel("");
		lblTotalPagar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblTotalPagar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 11));
		lblTotalPagar.setBounds(529, 619, 123, 14);
		contentPane.add(lblTotalPagar);
		
		lblNomCliente = new JLabel("");
		lblNomCliente.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNomCliente.setBounds(143, 144, 220, 16);
		contentPane.add(lblNomCliente);
		
		lblNomMozo = new JLabel("");
		lblNomMozo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNomMozo.setBounds(685, 69, 220, 16);
		contentPane.add(lblNomMozo);
		
		lblNumMesa = new JLabel("");
		lblNumMesa.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNumMesa.setBounds(685, 114, 220, 16);
		contentPane.add(lblNumMesa);
		
		panel = new JPanel();
		panel.setBackground(new Color(210, 105, 30));
		panel.setBorder(null);
		panel.setBounds(-22, 21, 950, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblOrdenDePedido = new JLabel("ORDEN DE PEDIDO");
		lblOrdenDePedido.setForeground(new Color(255, 255, 255));
		lblOrdenDePedido.setBounds(113, 0, 651, 46);
		lblOrdenDePedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblOrdenDePedido.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrdenDePedido.setFont(new Font("Microsoft YaHei", Font.BOLD, 23));
		lblOrdenDePedido.setBorder(null);
		lblOrdenDePedido.setBackground(Color.WHITE);
		panel.add(lblOrdenDePedido);
		
				
		
		//obj=null;		
		if(obj==null){//registro nuevo 
			Tabla.seeTable(TABLAORDENPEDIDO, obj);
			lblTotalPagar.setText("0.00");
			
			
		}else if(obj.isEnable()){//todos los permisos
						
			Tabla.seeTable(TABLAORDENPEDIDO, obj);			
			lblTotalPagar.setText(""+ obj.getTotal());
			
			txtClienteDNI_pedido.setText(""+obj.getDniCliente());			
			
			//nombre cliente api reniec
			LblnomCliente = new JLabel("gaaa");
			LblnomCliente.setBounds(143,144, 123, 14);
			contentPane.add(LblnomCliente);
			
			lblNommozo = new JLabel(obj.getNombreMozo()+" "+obj.getApellidoMozo());
			lblNommozo.setBounds(685, 92, 220, 16);
			contentPane.add(lblNommozo);
			
			lblIDMESA = new JLabel(""+obj.getCodMesa());
			lblIDMESA.setBounds(685, 142, 123, 14);
			contentPane.add(lblIDMESA);			
			
			
			
			
		}else {//si el empleado no atiende esa mesa
			
			Tabla.seeTable(TABLAORDENPEDIDO, obj);			
			
			lblTotalPagar.setText(""+ obj.getTotal());
			lblTotalPagar.setEnabled(false);
			
			txtClienteDNI_pedido.setText(""+obj.getDniCliente());
			txtClienteDNI_pedido.setEnabled(false);
			
			//nombre cliente api reniec
			LblnomCliente = new JLabel("gaaa");
			LblnomCliente.setBounds(118, 92, 220, 16);
			contentPane.add(LblnomCliente);
			
			lblNommozo = new JLabel(obj.getNombreMozo()+" "+obj.getApellidoMozo());
			lblNommozo.setBounds(685, 92, 220, 16);
			contentPane.add(lblNommozo);
			
			lblIDMESA = new JLabel(""+obj.getCodMesa());
			lblIDMESA.setBounds(685, 142, 123, 14);
			contentPane.add(lblIDMESA);		
			
			TABLAORDENPEDIDO.setEnabled(false);	
		
	}
		setLocationRelativeTo(null);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBack) {
			do_btnBack_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSave) {
			do_btnSave_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregarProducto) {
			do_btnAgregarProducto_actionPerformed(arg0);
			RefreshWindow(objeto);
			//this.dispose();
		}
		//System.out.println("PASO POR AQUI MOOUSE CLICKED 1 ");
		
	}
	
	

	
	//BUTTON AGREGAR PRODUCTOS AL PEDIDO
	protected void do_btnAgregarProducto_actionPerformed(ActionEvent arg0) {
		
		ProductoBussiness objprod= new ProductoBussiness();
		
		ArrayList<ListaProductosBE> listaProductosBE=objprod.ListaProductos();
		
		
		JDialogAgregarProducto JdialogHijo= new JDialogAgregarProducto(this,true,listaProductosBE,TABLAORDENPEDIDO,objeto);
		
		JdialogHijo.setVisible(true);
		
		
		
		
//		FormAgregarProductos fap= new FormAgregarProductos(listaProductosBE,table,objeto);
//		
//		
//		
//		fap.setVisible(true);
//		System.out.println("se refresco");
		//RefreshWindow(objeto);
		
		
		
	}

//	@Override
//	public void mouseEntered(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
	//BUTTON SAVE
	protected void do_btnSave_actionPerformed(ActionEvent arg0) {
		
		RefreshWindow(objeto);
//		System.out.println("size objeto en btn save : " + objeto.getListaDetalle().size() );
//		System.out.println("tt en btn save : " + objeto.getTotal());
		
		RegistroPedidoProductoBussiness RppB= new RegistroPedidoProductoBussiness();
		
		RppB.SavePedidotoBD(objeto);
		
		
		
		
		
		
		
	}
	//BTN BACK TO FORM MOZO
	protected void do_btnBack_actionPerformed(ActionEvent arg0) {
		
		FormMozo frmMz= new FormMozo(Cred);
		frmMz.setVisible(true);
		this.dispose();
		
		
		
	}
	public void mouseClicked(MouseEvent arg0) {
		//RefreshWindow(objeto);
		if (arg0.getSource() == TABLAORDENPEDIDO) {
			do_table_mouseClicked(arg0);
			
		}
		RefreshWindow(objeto);
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	
	//CLICK ON THE TABLE
	protected void do_table_mouseClicked(MouseEvent arg0) {	
		//RefreshWindow(objeto);
		System.out.println("ENTRO A MOUSE CLICK");
		System.out.println("obj.getListaDetalle().size() :"+ objeto.getListaDetalle().size());
		
		//private void tableMouseClicked (java.awt.event.MouseEvent evt) {
			int fsel = TABLAORDENPEDIDO.getSelectedRow();
			//PARA OBTENER LA POSICIÓN DONDE DAMOS CLICK x and y 
			int column=TABLAORDENPEDIDO.getColumnModel().getColumnIndexAtX(arg0.getX());
			int row= arg0.getY()/TABLAORDENPEDIDO.getRowHeight();
			 
//			System.out.println("table.getRowCount() "+TABLAORDENPEDIDO.getRowCount());
//			System.out.println("table.getColumnCount()" +TABLAORDENPEDIDO.getColumnCount());
//			System.out.println("table.getColumnModel().getColumnIndexAtX(arg0.getX())" +TABLAORDENPEDIDO.getColumnModel().getColumnIndexAtX(arg0.getX()));
//			System.out.println("arg0.getY()/table.getRowHeight()" +arg0.getY()/TABLAORDENPEDIDO.getRowHeight());
			
			if(row<TABLAORDENPEDIDO.getRowCount() && row>=0 && column<TABLAORDENPEDIDO.getColumnCount() && column>=0){
				
				Object value = TABLAORDENPEDIDO.getValueAt(row, column);
				
				if(value instanceof JButton){
					//si doy click al button
					((JButton) value).doClick();
					//devolvemos la acción
					JButton b= (JButton) value;
					
					//System.out.println("Click en el button");
					if(b.getName().equals("m")){	
						
//						System.out.println("ENTRO A MOUSE CLICK  BOTON MODIFICAR");
//						System.out.println("Click en el button MODIFICAR");						
						
						 m=(DefaultTableModel) TABLAORDENPEDIDO.getModel();
							//System.out.println(TableProductos.getValueAt(fsel, 3));
						 String id,nombre,precio,cantidadSeleccionada;
						 
						id=TABLAORDENPEDIDO.getValueAt(fsel, 0).toString();
						nombre= TABLAORDENPEDIDO.getValueAt(fsel, 1).toString();
						precio=TABLAORDENPEDIDO.getValueAt(fsel, 2).toString();
							//stock=TableProductos.getValueAt(fsel, 3).toString();
						cantidadSeleccionada=TABLAORDENPEDIDO.getValueAt(fsel, 3).toString();
						 
						//data seleccionada para modificar
						GetDataJTableORDENPEDIDO ObjData= new GetDataJTableORDENPEDIDO(
								Integer.parseInt(id), 
								nombre,
								Double.parseDouble(precio),
								Integer.parseInt(cantidadSeleccionada)
								
								);		
							
							
							//cantidad= txtCant.getText();
							

						System.out.println("id : "+id);
						System.out.println("cantidadSeleccionada :"+cantidadSeleccionada);
						
						VENTANA_MODIFICAR JDIALOG_CANT= new VENTANA_MODIFICAR(this,true, TABLAORDENPEDIDO,objeto,ObjData);
						
						JDIALOG_CANT.setVisible(true);						
						//lblTotalPagar.setText(objeto.getTotal()+ "");
						
					}
					if(b.getName().equals("e")){
						
						System.out.println("ENTRO A MOUSE CLICK  BOTON ELIMINAR");
						System.out.println("Click en el button ELIMINAR");
						
						
						 m=(DefaultTableModel) TABLAORDENPEDIDO.getModel();
						
						 String id,nombre,precio,cantidadSeleccionada;
						
						 id=TABLAORDENPEDIDO.getValueAt(fsel, 0).toString();
							nombre= TABLAORDENPEDIDO.getValueAt(fsel, 1).toString();
							precio=TABLAORDENPEDIDO.getValueAt(fsel, 2).toString();
								//stock=TableProductos.getValueAt(fsel, 3).toString();
							cantidadSeleccionada=TABLAORDENPEDIDO.getValueAt(fsel, 3).toString();
						
							GetDataJTableORDENPEDIDO ObjData= new GetDataJTableORDENPEDIDO(
									Integer.parseInt(id), 
									nombre,
									Double.parseDouble(precio),
									Integer.parseInt(cantidadSeleccionada)
									
									);		
						
							VW_WARNING_ELIMINAR JDIALOG_ELIMINAR= new VW_WARNING_ELIMINAR(this,true,
									TABLAORDENPEDIDO,objeto,ObjData									
									);
							
							JDIALOG_ELIMINAR.setVisible(true);
							
							
						
					}
					
				}			
								
			}
			
		
	}
	
	
	
}
	




