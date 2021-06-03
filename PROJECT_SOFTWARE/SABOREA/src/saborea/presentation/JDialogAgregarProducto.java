package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import saborea.model.bussiness.ProductoBussiness;
import saborea.model.bussiness.RegistroPedidoProductoBussiness;
import saborea.model.bussiness.DTO.ListaProductosBE;
import saborea.model.bussiness.DTO.VwDetallePedidoBE;
import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;
import saborea.model.entities.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JDialogAgregarProducto extends javax.swing.JDialog implements ActionListener, KeyListener, ItemListener {

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
	DefaultTableModel m =new DefaultTableModel();
	private JButton btnNewButton;
	private JButton btnBebidas;
	private JButton btnPastas;
	private JButton btnPizzas;
	private JLabel lblBuscar;
	private JTextField txtFiltro;
	TableRowSorter<DefaultTableModel> trs= new TableRowSorter<DefaultTableModel>(m);
	private JComboBox comboBoxFilterCategory;
	private JLabel lblBuscarPorCategora;
	
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
		scrollPane.setBounds(10, 137, 644, 414);
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
		txtCant.setBounds(561, 580, 65, 29);
		contentPanel.add(txtCant);
		txtCant.setColumns(10);
		
		lblCantidad = new JLabel("cantidad :");
		lblCantidad.setBounds(465, 587, 86, 14);
		contentPanel.add(lblCantidad);
		
		TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, listaProductosBE);
		
		btnNewButton = new JButton("POSTRES");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(704, 188, 115, 35);
		contentPanel.add(btnNewButton);
		
		btnBebidas = new JButton("BEBIDAS");
		btnBebidas.addActionListener(this);
		btnBebidas.setBounds(704, 234, 115, 35);
		contentPanel.add(btnBebidas);
		
		btnPastas = new JButton("PASTAS");
		btnPastas.addActionListener(this);
		btnPastas.setBounds(704, 280, 115, 35);
		contentPanel.add(btnPastas);
		
		btnPizzas = new JButton("PIZZAS");
		btnPizzas.addActionListener(this);
		btnPizzas.setBounds(704, 326, 115, 35);
		contentPanel.add(btnPizzas);
		
		lblBuscar = new JLabel("BUSCAR POR NOMBRE :");
		lblBuscar.setBounds(84, 23, 133, 23);
		contentPanel.add(lblBuscar);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(227, 24, 313, 20);
		contentPanel.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		comboBoxFilterCategory = new JComboBox();
		comboBoxFilterCategory.addItemListener(this);
		comboBoxFilterCategory.setModel(new DefaultComboBoxModel(new String[] {"", "POSTRES", "BEBIDAS", "PASTAS", "PIZZAS"}));
		comboBoxFilterCategory.setBounds(227, 69, 179, 20);
		contentPanel.add(comboBoxFilterCategory);
		
		lblBuscarPorCategora = new JLabel("BUSCAR POR CATEGOR\u00CDA:");
		lblBuscarPorCategora.setBounds(84, 68, 133, 23);
		contentPanel.add(lblBuscarPorCategora);
		
		setLocationRelativeTo(null);
		
		
		
	}

	
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
//		if (arg0.getSource() == btnPizzas) {
//			do_btnPizzas_actionPerformed(arg0);
//		}
//		if (arg0.getSource() == btnPastas) {
//			do_btnPastas_actionPerformed(arg0);
//		}
//		if (arg0.getSource() == btnBebidas) {
//			do_btnBebidas_actionPerformed(arg0);
//		}
//		if (arg0.getSource() == btnNewButton) {
//			do_btnNewButton_actionPerformed(arg0);
//		}
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
		
			String id,nombre, precio, stock,  cantidad,subtotal;
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
//	//BUTTON FILTRO POSTRES
//	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
//		System.out.println("filter postres");
//		Producto produc= new Producto(-1, null,-1,-1,"POSTRES");
//		ProductoBussiness PB = new ProductoBussiness();
//		ArrayList<ListaProductosBE> listaProductosBEE=PB.FiltroProductosPorCategory(produc);
//		if(listaProductosBEE==null){
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR�A POSTRES","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
//		}else{
//			_listaProductosBE=listaProductosBEE;
//			TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, listaProductosBEE);
//		}
//		
//	}
//	//BUTTON FILTRO BEBIDAS
//	protected void do_btnBebidas_actionPerformed(ActionEvent arg0) {
//		System.out.println("filter bebidas");
//		Producto produc= new Producto(-1, null,-1,-1,"BEBIDAS");
//		ProductoBussiness PB = new ProductoBussiness();
//		ArrayList<ListaProductosBE> listaProductosBEE=PB.FiltroProductosPorCategory(produc);
//		if(listaProductosBEE==null){
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR�A BEBIDAS","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
//		}else{
//			_listaProductosBE=listaProductosBEE;
//			TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, listaProductosBEE);
//		}
//		
//	}
//	//BUTTON FILTRO PASTAS
//	protected void do_btnPastas_actionPerformed(ActionEvent arg0) {
//		System.out.println("filter pastas");
//		Producto produc= new Producto(-1, null,-1,-1,"PASTAS");
//		ProductoBussiness PB = new ProductoBussiness();
//		ArrayList<ListaProductosBE> listaProductosBEE=PB.FiltroProductosPorCategory(produc);
//		if(listaProductosBEE==null){
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR�A PASTAS","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
//		}else{
//			_listaProductosBE=listaProductosBEE;
//			TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, listaProductosBEE);
//		}
//	}
//	//BUTTON FILTRO PIZZAS
//	protected void do_btnPizzas_actionPerformed(ActionEvent arg0) {
//		System.out.println("filter pizzas");
//		Producto produc= new Producto(-1, null,-1,-1,"PIZZAS");
//		ProductoBussiness PB = new ProductoBussiness();
//		ArrayList<ListaProductosBE> listaProductosBEE=PB.FiltroProductosPorCategory(produc);
//		if(listaProductosBEE==null){
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR�A PIZZAS","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
//		}else{
//			_listaProductosBE=listaProductosBEE;
//			
//			m=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();			
//			trs= new TableRowSorter<>(m);
//			TABLAAGREGARPRODUCTOS.setRowSorter(trs);
//			
//			TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, listaProductosBEE);
//		}
//		
//	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtFiltro) {
			do_txtFiltro_keyTyped(arg0);
			//TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, _listaProductosBE);
			//System.out.println("termine el filter");
		}
	}
	
	protected void do_txtFiltro_keyTyped(KeyEvent arg0) {
		//System.out.println("ENTRO AL TXTFILTER");
		
		txtFiltro.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtFiltro.getText(), 1));
			}			
			
		});
		
		m=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
		
		trs= new TableRowSorter<>(m);
		
		TABLAAGREGARPRODUCTOS.setRowSorter(trs);
		
		TABLAAGREGARPRODUCTOS.updateUI();
		
		
		//TablaAgregarProductos.setRowSorter(TABLAAGREGARPRODUCTOS,trs);
		
		//TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, _listaProductosBE);
	}
	
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == comboBoxFilterCategory) {
			do_comboBox_itemStateChanged(arg0);
		}
	}
	
	protected void do_comboBox_itemStateChanged(ItemEvent arg0) {
		m=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
		String query= comboBoxFilterCategory.getSelectedItem().toString();
		
		TableRowSorter<DefaultTableModel> TR= new	TableRowSorter<DefaultTableModel> ((DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel());
		
		TABLAAGREGARPRODUCTOS.setRowSorter(TR);
		
//		txtFiltro.addKeyListener(new KeyAdapter() {
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				trs.setRowFilter(RowFilter.regexFilter("(?i)"+query, 4));
//				
//			}			
//			
//		});
//		
//		trs= new TableRowSorter<>(m);
//		
//		TABLAAGREGARPRODUCTOS.setRowSorter(trs);
//		
//		TABLAAGREGARPRODUCTOS.updateUI();
		
		//m=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
		
		if(query==" "){
			TR.setRowFilter(RowFilter.regexFilter(comboBoxFilterCategory.getSelectedItem().toString()));
		}else{
			TABLAAGREGARPRODUCTOS.setRowSorter(TR);
		}
		
	}
}