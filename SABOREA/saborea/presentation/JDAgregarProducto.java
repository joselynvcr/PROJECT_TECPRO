package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableRowSorter;

import saborea.model.bussiness.ProductoBussiness;

import saborea.model.bussiness.DTO.VwListaProductosBE;
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
import javax.swing.SwingConstants;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class JDAgregarProducto extends javax.swing.JDialog implements ActionListener, KeyListener, ItemListener, FocusListener, WindowFocusListener {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private JTable TABLAAGREGARPRODUCTOS;
	private JButton btnBack;
	private JButton btnAgregar;
	private JTextField txtCant;
	private JLabel lblCantidad;
	ArrayList<VwListaProductosBE> _listaProductosBE;
	private VwRegistroPedidoProductoBE objeto;	
	DefaultTableModel m =new DefaultTableModel();
	DefaultTableModel model =new DefaultTableModel();
	private JLabel lblBuscar;
	private JTextField txtFiltro;	
	TableRowSorter<DefaultTableModel> sorter;
	private JComboBox comboBoxFilterCategory;
	private JLabel lblBuscarPorCategora;
	private JPanel panel;
	//private TextPrompt placeholder;
	//private TablaAgregarProductos TAP;
	//new TableRowSorter<DefaultTableModel>(m)
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
	public void addPlaceHolderStyle(JTextField textField){
		Font font= textField.getFont();
		font=font.deriveFont(Font.ITALIC);
		textField.setFont(font);
		textField.setForeground(Color.gray);
		
	}
	public void removePlaceholderStyle(JTextField textField){
		Font font= textField.getFont();
		font=font.deriveFont(Font.PLAIN|Font.BOLD);
		textField.setFont(font);
		textField.setForeground(Color.black);
	}
//	public void CreateTable(){
//		 model= new DefaultTableModel(){
//				
//				public boolean isCellEditable(int row, int column) {
//					//if(column==4)return true;
//					return false;
//				}
//				
//			};		
//			
//			model.addColumn("ID PRODUCTO");
//			model.addColumn("NOMBRE");
//			model.addColumn("PRECIO");
//			model.addColumn("STOCK");
//			model.addColumn("CATEGORY");
//			
//			TABLAAGREGARPRODUCTOS.setRowHeight(30);
//			TABLAAGREGARPRODUCTOS.setModel(model);
//			if(_listaProductosBE!=null){
//			for(int i=0;i<_listaProductosBE.size();i++){
//				Object [] fila = {
//						_listaProductosBE.get(i).getId(),
//						_listaProductosBE.get(i).getNombre(),
//						_listaProductosBE.get(i).getPrecio(),		
//						_listaProductosBE.get(i).getStock(),
//						_listaProductosBE.get(i).getCategory(),	
//						
//						
//				};
//				
//				model.addRow(fila);				
//			}
//			TABLAAGREGARPRODUCTOS.setModel(model);
//		}
//		
//			TABLAAGREGARPRODUCTOS.setAutoCreateRowSorter(true);
//			sorter= new TableRowSorter<>(model);
//			TABLAAGREGARPRODUCTOS.setRowSorter(sorter);
//		
//	}
	public JDAgregarProducto(java.awt.Frame parent, boolean modal,ArrayList<VwListaProductosBE> listaProductosBE,JTable tabla, VwRegistroPedidoProductoBE obj) {
		super(parent,modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JDialogAgregarProducto.class.getResource("/img/Logo_Solitario_opt (3).png")));
		addWindowFocusListener(this);
			
		_listaProductosBE=listaProductosBE;
		table=tabla;		
		objeto=obj;
	
		setTitle("VENTANA AGREGAR PRODUCTOS");
		setBounds(100, 100, 883, 675);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 250, 210));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 121, 726, 427);
		contentPanel.add(scrollPane);
		
		TABLAAGREGARPRODUCTOS = new JTable();
		scrollPane.setViewportView(TABLAAGREGARPRODUCTOS);
		//CreateTable();
				
		model=TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, listaProductosBE,sorter);
		
		
		btnBack = new JButton("VOLVER");
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBack.setIcon(new ImageIcon(JDialogAgregarProducto.class.getResource("/img/icon_volver.png")));
		btnBack.addActionListener(this);
		btnBack.setBounds(10, 554, 101, 82);
		contentPanel.add(btnBack);
		
		btnAgregar = new JButton("AGREGAR PRODUCTO ");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(641, 572, 164, 44);
		contentPanel.add(btnAgregar);
		
		txtCant = new JTextField();
		txtCant.setHorizontalAlignment(SwingConstants.CENTER);
		txtCant.setText("1");
		txtCant.setBounds(405, 582, 65, 29);
		contentPanel.add(txtCant);
		txtCant.setColumns(10);
		
		lblCantidad = new JLabel("CANTIDAD :");
		lblCantidad.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblCantidad.setBounds(305, 587, 101, 14);
		contentPanel.add(lblCantidad);
		
		panel = new JPanel();
		panel.setBackground(new Color(210, 105, 30));
		panel.setBounds(0, 11, 815, 89);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		
		comboBoxFilterCategory = new JComboBox();
		comboBoxFilterCategory.setBackground(new Color(255, 255, 255));
		comboBoxFilterCategory.setBounds(335, 57, 313, 23);
		panel.add(comboBoxFilterCategory);
		comboBoxFilterCategory.addItemListener(this);
		comboBoxFilterCategory.setModel(new DefaultComboBoxModel(new String[] {" ", "POSTRES", "BEBIDAS", "PASTAS", "PIZZAS"}));
		
		lblBuscarPorCategora = new JLabel("BUSCAR POR CATEGOR\u00CDA:");
		lblBuscarPorCategora.setBounds(146, 56, 179, 23);
		panel.add(lblBuscarPorCategora);
		lblBuscarPorCategora.setForeground(new Color(255, 255, 255));
		lblBuscarPorCategora.setFont(new Font("Century Gothic", Font.BOLD, 13));
		
		lblBuscar = new JLabel("BUSCAR POR NOMBRE :");
		lblBuscar.setBounds(146, 11, 179, 23);
		panel.add(lblBuscar);
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setFont(new Font("Century Gothic", Font.BOLD, 13));
		
		txtFiltro = new JTextField("Ingresar el nombre de un producto");
		txtFiltro.setBounds(335, 12, 313, 23);
		panel.add(txtFiltro);
		txtFiltro.addFocusListener(this);
		txtFiltro.addKeyListener(this);
		//		TextPrompt placeholder = new TextPrompt("Apellido Paterno", txtFiltro);
		//		placeholder.changeAlpha(0.75f);
		//		placeholder.changeStyle(Font.ITALIC);
				addPlaceHolderStyle(txtFiltro);
				txtFiltro.setColumns(10);
		
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
				 JOptionPane.showMessageDialog(null, "no seleccion??? ning???n producto","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
			 }
			 m=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
			//System.out.println(TableProductos.getValueAt(fsel, 3));
			
			id=TABLAAGREGARPRODUCTOS.getValueAt(fsel, 0).toString();
			nombre= TABLAAGREGARPRODUCTOS.getValueAt(fsel, 1).toString();
			precio=TABLAAGREGARPRODUCTOS.getValueAt(fsel, 2).toString();
			stock=TABLAAGREGARPRODUCTOS.getValueAt(fsel, 3).toString();
			cantidad= txtCant.getText();
			
			//Realizando los c???lculos
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
					JOptionPane.showMessageDialog(null, "Ingrese una cantidad v???lida ","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
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
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR???A POSTRES","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
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
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR???A BEBIDAS","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
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
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR???A PASTAS","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
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
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR???A PIZZAS","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
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
				sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtFiltro.getText(), 1));
			}			
			
		});
		
		model=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
		
		sorter= new TableRowSorter<>(model);
		
		TABLAAGREGARPRODUCTOS.setRowSorter(sorter);
		
		//TABLAAGREGARPRODUCTOS.updateUI();
		
		
		//TablaAgregarProductos.setRowSorter(TABLAAGREGARPRODUCTOS,trs);
		
		//TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, _listaProductosBE);
	}
	
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == comboBoxFilterCategory) {
			do_comboBox_itemStateChanged(arg0);
		}
	}
	
	protected void do_comboBox_itemStateChanged(ItemEvent arg0)  {		
		//m=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
		
		System.out.println("entre al combo box  ");
		
		String query= comboBoxFilterCategory.getSelectedItem().toString();
		
		System.out.println("query : "+query);
		
		//m=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
		
		//tr= new TableRowSorter<>(m);
		
		//m2=(DefaultTableModel) TABLAAGREGARPRODUCTOS.getModel();
		TableRowSorter<DefaultTableModel> sorter= new TableRowSorter<DefaultTableModel> (model);
		
		TABLAAGREGARPRODUCTOS.setRowSorter(sorter);
//		
		if(query!=" "){
			sorter.setRowFilter(RowFilter.regexFilter(query));
		}else{
			TABLAAGREGARPRODUCTOS.setRowSorter(sorter);
		}
		
//		String query= comboBoxFilterCategory.getSelectedItem().toString();
//		System.out.println("filter postres");
//		Producto produc= new Producto(-1, null,-1,-1,query);
//		ProductoBussiness PB = new ProductoBussiness();
//		ArrayList<ListaProductosBE> listaProductosBEE=PB.FiltroProductosPorCategory(produc);
//		if(listaProductosBEE==null){
//			JOptionPane.showMessageDialog(null, "NO HAY DATA PARA LA CATEGOR???A POSTRES","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
//		}else{
//			_listaProductosBE=listaProductosBEE;
//			TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, listaProductosBEE);
//		}
//		
		
		
		
	}
	
	
	public void focusGained(FocusEvent arg0) {
		if (arg0.getSource() == txtFiltro) {
			do_txtFiltro_focusGained(arg0);
		}
	}
	public void focusLost(FocusEvent arg0) {
		if(txtFiltro.getText().length()==0){
			addPlaceHolderStyle(txtFiltro);
			txtFiltro.setText("Ingresar el nombre de un producto");
		}
	}
	protected void do_txtFiltro_focusGained(FocusEvent arg0) {
		if(txtFiltro.getText().equals("Ingresar el nombre de un producto")){
			txtFiltro.setText(null);
			txtFiltro.requestFocus();
			
			removePlaceholderStyle(txtFiltro);
		}
	}
	public void windowGainedFocus(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			do_this_windowGainedFocus(arg0);
		}
	}
	public void windowLostFocus(WindowEvent arg0) {
	}
	protected void do_this_windowGainedFocus(WindowEvent arg0) {
		this.requestFocusInWindow();
	}
}
