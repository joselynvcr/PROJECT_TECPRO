package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import saborea.model.bussiness.EmpleadoBussiness;
import saborea.model.bussiness.PedidosBussiness;
import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.bussiness.DTO.ListaPedidosBE;
import saborea.model.bussiness.DTO.VwListaEmpleadosBE;
import saborea.model.bussiness.DTO.VwListaProductosBE;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
//import saborea.presentation.RSButtonMetro;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Dimension;
//import saborea.presentation.RSButtonMetro;
import java.awt.event.MouseListener;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.border.TitledBorder;

public class FormAdministrador extends JFrame implements ActionListener, KeyListener, FocusListener, WindowFocusListener {

	private JPanel contentPane;
	private JLabel lblNewLabel_cargo;
	private JLabel lblNewLabel_1_nombreAndApe;
	private JPanel MAINpanelADMIN;
	private JPanel FuntionalPanel;
	private JLabel lblNewLabel;
	private JButton btnLISTAR_EMPLEADOS;
	private JPanel MENUpanel;
	private JButton btnRegistrarEmpleado;
	private JButton btnCerrarSesin;
	TableRowSorter<DefaultTableModel> sorter;
	DefaultTableModel model =new DefaultTableModel();
	
	private JLabel lblNewLabel_2;
	JLabel lblNewLabel_BUSCAR;
	private JLabel lblNewLabel_1;
	private JPanel panelwithJtable;
	private JScrollPane scrollPane;
	private JTable TABLA_EMPLEADOS;
	private JLabel lblNewLabel_3;
	private JTextField txtFiltroEmpleado;
	private JButton btnActualizarTabla;
	private JButton buttonDescargarReporte;
	ArrayList<VwListaEmpleadosBE> _listaEmpleadosBE;
	private JButton btnLISTAR_PEDIDOS;
	ArrayList<ListaPedidosBE> _listaPedidos;
	CredencialesBE _cred;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
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
	public void GetListaEmpleados() {
		EmpleadoBussiness eb = new EmpleadoBussiness();
		ArrayList<VwListaEmpleadosBE> lista = eb.ListarEmpleados();
		_listaEmpleadosBE=lista;
		//TablaEmpleados.seeTable(TABLA_EMPLEADOS, lista, sorter);
		//model=TablaEmpleados.seeTable(TABLA_EMPLEADOS,lista,sorter);
	}
	public void GetListaPedidos() {
		PedidosBussiness pb= new PedidosBussiness ();
		ArrayList<ListaPedidosBE> listaPedidos= pb.listaPedidos();
		_listaPedidos=listaPedidos;
		//TablaEmpleados.seeTable(TABLA_EMPLEADOS, lista, sorter);
		//model=TablaEmpleados.seeTable(TABLA_EMPLEADOS,lista,sorter);
	}
	public void refreshTablaEmpleados() {
		EmpleadoBussiness eb = new EmpleadoBussiness();
		ArrayList<VwListaEmpleadosBE> lista = eb.ListarEmpleados();
		_listaEmpleadosBE=lista;
		TablaEmpleados.seeTable(TABLA_EMPLEADOS,_listaEmpleadosBE,sorter);
		
	}
	public FormAdministrador(CredencialesBE cred) {
		_cred=cred;
		addWindowFocusListener(this);
		GetListaEmpleados();
		setResizable(false);
		setUndecorated(true);
		// Asigna un titulo a la barra de titulo
		setTitle("VENTANA ADMINISTRADOR");
		// tama�o de la ventana
		 setSize(400,200);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1400, 750);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(32773, 32774));
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/Nuevo proyecto.png")));
		lblNewLabel_4.setBackground(new Color(205, 92, 92));
		lblNewLabel_4.setBounds(289, 92, 875, 647);
		contentPane.add(lblNewLabel_4);

		MAINpanelADMIN = new JPanel();
		MAINpanelADMIN.setBorder(new LineBorder(new Color(0, 128, 128), 1, true));
		MAINpanelADMIN.setBackground(Color.WHITE);
		MAINpanelADMIN.setBounds(0, 92, 279, 658);
		contentPane.add(MAINpanelADMIN);

		lblNewLabel_1_nombreAndApe = new JLabel(cred.getNombreEmpleado() + " " + cred.getApellidoEmpleado());
		lblNewLabel_1_nombreAndApe.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_1_nombreAndApe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_nombreAndApe.setBounds(10, 188, 259, 23);

		lblNewLabel_cargo = new JLabel(cred.getTipoCargo().toUpperCase());
		lblNewLabel_cargo.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_cargo.setBounds(10, 222, 259, 33);
		lblNewLabel_cargo.setHorizontalAlignment(SwingConstants.CENTER);
		MAINpanelADMIN.setLayout(null);
		MAINpanelADMIN.add(lblNewLabel_1_nombreAndApe);
		MAINpanelADMIN.add(lblNewLabel_cargo);
		btnCerrarSesin = new JButton("CERRAR SESI\u00D3N");
		btnCerrarSesin.addActionListener(this);
		btnCerrarSesin.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/login_icon_151220.png")));
		btnCerrarSesin.setOpaque(false);
		btnCerrarSesin.setForeground(Color.BLACK);
		btnCerrarSesin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrarSesin.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnCerrarSesin.setBackground(Color.WHITE);
		btnCerrarSesin.setBounds(1, 578, 277, 69);
		MAINpanelADMIN.add(btnCerrarSesin);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 11, 259, 166);
		MAINpanelADMIN.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/icon_Administrador.png")));

		btnLISTAR_EMPLEADOS = new JButton("LISTAR EMPLEADOS");
		btnLISTAR_EMPLEADOS.setBounds(1, 338, 277, 69);
		MAINpanelADMIN.add(btnLISTAR_EMPLEADOS);
		btnLISTAR_EMPLEADOS.addActionListener(this);
		btnLISTAR_EMPLEADOS.setOpaque(false);
		btnLISTAR_EMPLEADOS.setPressedIcon(null);
		btnLISTAR_EMPLEADOS.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLISTAR_EMPLEADOS.setForeground(Color.BLACK);
		btnLISTAR_EMPLEADOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// btnNewButton.addMouseListener(this);
		// btnNewButton.addMouseMotionListener(this);
		btnLISTAR_EMPLEADOS.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnLISTAR_EMPLEADOS.setBackground(UIManager.getColor("CheckBox.highlight"));
		btnLISTAR_EMPLEADOS.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/list_task_tasklist_checklist_check_icon_145964.png")));

		btnRegistrarEmpleado = new JButton("REGISTRAR EMPLEADO");
		btnRegistrarEmpleado.addActionListener(this);
		btnRegistrarEmpleado.setBounds(1, 466, 277, 69);
		MAINpanelADMIN.add(btnRegistrarEmpleado);
		btnRegistrarEmpleado.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/business_application_addmale_useradd_insert_add_user_client_2312.png")));
		btnRegistrarEmpleado.setOpaque(false);
		btnRegistrarEmpleado.setForeground(Color.BLACK);
		btnRegistrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrarEmpleado.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnRegistrarEmpleado.setBackground(Color.WHITE);
		
		btnLISTAR_PEDIDOS = new JButton("LISTAR PEDIDOS");
		btnLISTAR_PEDIDOS.addActionListener(this);
		btnLISTAR_PEDIDOS.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/create-list-button_icon-icons.com_54025.png")));
		btnLISTAR_PEDIDOS.setOpaque(false);
		btnLISTAR_PEDIDOS.setForeground(Color.BLACK);
		btnLISTAR_PEDIDOS.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLISTAR_PEDIDOS.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnLISTAR_PEDIDOS.setBackground(Color.WHITE);
		btnLISTAR_PEDIDOS.setBounds(1, 386, 277, 69);
		MAINpanelADMIN.add(btnLISTAR_PEDIDOS);
		JButton btnDescargarReporte = new JButton("DESCARGAR REPORTE");
		btnDescargarReporte.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Tabla.Exportar(TABLA_EMPLEADOS);
			}
		});
		btnDescargarReporte.setOpaque(false);
		btnDescargarReporte.setForeground(Color.BLACK);
		btnDescargarReporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDescargarReporte.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnDescargarReporte.setBackground(Color.WHITE);
		btnDescargarReporte.setBounds(1, 418, 277, 69);
		MAINpanelADMIN.add(btnDescargarReporte);

		FuntionalPanel = new JPanel();
		FuntionalPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		FuntionalPanel.setBounds(278, 92, 1122, 658);
		contentPane.add(FuntionalPanel);
		FuntionalPanel.setLayout(null);

		panelwithJtable = new JPanel();
		panelwithJtable.setBounds(0, 0, 1122, 658);
		panelwithJtable.setVisible(false);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 749, 582);
		FuntionalPanel.add(lblNewLabel_1);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/LOGO_NEGRO.png")));
		FuntionalPanel.add(panelwithJtable);
		panelwithJtable.setLayout(null);
		
		lblNewLabel_3 = new JLabel("BUSCAR :");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblNewLabel_3.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/business_man_usersearch_thesearch_theclient_2356.png")));
		lblNewLabel_3.setBounds(191, 33, 175, 71);
		panelwithJtable.add(lblNewLabel_3);

		txtFiltroEmpleado = new JTextField("Ingrese el nombre de un empleado");
		txtFiltroEmpleado.addFocusListener(this);
		txtFiltroEmpleado.addKeyListener(this);
		//txtFiltroEmpleado.setText();
		txtFiltroEmpleado.setBounds(376, 51, 347, 31);
		panelwithJtable.add(txtFiltroEmpleado);
		addPlaceHolderStyle(txtFiltroEmpleado);
		txtFiltroEmpleado.setColumns(10);

		btnActualizarTabla = new JButton("");
		btnActualizarTabla.addActionListener(this);
		btnActualizarTabla.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/cloudrefresh_icon-icons.com_54403.png")));
		btnActualizarTabla.setOpaque(false);
		btnActualizarTabla.setForeground(Color.BLACK);
		btnActualizarTabla.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnActualizarTabla.setBorder(null);
		btnActualizarTabla.setBackground(Color.WHITE);
		btnActualizarTabla.setBounds(1015, 576, 97, 71);
		panelwithJtable.add(btnActualizarTabla);

		buttonDescargarReporte = new JButton("");
		buttonDescargarReporte.addActionListener(this);
		buttonDescargarReporte.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/file_Exel_download_icon-icons.com_68955.png")));
		buttonDescargarReporte.setOpaque(false);
		buttonDescargarReporte.setForeground(Color.BLACK);
		buttonDescargarReporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonDescargarReporte.setBorder(null);
		buttonDescargarReporte.setBackground(Color.WHITE);
		buttonDescargarReporte.setBounds(1047, 11, 65, 65);
		panelwithJtable.add(buttonDescargarReporte);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 1102, 402);
		panelwithJtable.add(scrollPane);
		
				TABLA_EMPLEADOS = new JTable();
				TABLA_EMPLEADOS.setForeground(new Color(0, 0, 0));
				TABLA_EMPLEADOS.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
				TABLA_EMPLEADOS.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 2), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				TABLA_EMPLEADOS.setBackground(new Color(240, 248, 255));
				scrollPane.setViewportView(TABLA_EMPLEADOS);
				//model
				//GetListaEmpleados();
				
				model= TablaEmpleados.seeTable(TABLA_EMPLEADOS,_listaEmpleadosBE,sorter);

		MENUpanel = new JPanel();
		MENUpanel.setBackground(new Color(32, 178, 170));
		MENUpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		MENUpanel.setBounds(0, 0, 1400, 92);
		contentPane.add(MENUpanel);
		MENUpanel.setLayout(null);

		lblNewLabel_2 = new JLabel("BIENVENIDO A SABOREA");
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setBackground(new Color(240, 248, 255));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 32));
		lblNewLabel_2.setBounds(531, 11, 394, 51);
		MENUpanel.add(lblNewLabel_2);
		
		separator = new JSeparator();
		separator.setBounds(174, 44, 325, 2);
		MENUpanel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(956, 44, 325, 2);
		MENUpanel.add(separator_1);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/thi3s-69bny.png")));
		lblNewLabel_4.setBounds(33, 0, 120, 92);
		MENUpanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(FormAdministrador.class.getResource("/img/thi3s-69bny.png")));
		lblNewLabel_5.setBounds(1298, 0, 120, 92);
		MENUpanel.add(lblNewLabel_5);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLISTAR_PEDIDOS) {
			do_btnLISTAR_PEDIDOS_actionPerformed(arg0);
		}
		if (arg0.getSource() == buttonDescargarReporte) {
			do_buttonDescargarReporte_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnActualizarTabla) {
			do_btnActualizarTabla_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnRegistrarEmpleado) {
			do_btnRegistrarEmpleado_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrarSesin) {
			do_btnCerrarSesin_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnLISTAR_EMPLEADOS) {
			do_btnNewButton_actionPerformed(arg0);
		}
	}

	// BUTTON LISTAR EMPLEADOS
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {

		// lblNewLabel_1.setIcon(new ImageIcon(
		// "D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de
		// datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\thi3s-69bny.png"));
		// FuntionalPanel.setVisible(false);
		lblNewLabel_1.setVisible(false);
		panelwithJtable.setVisible(true);
//		EmpleadoBussiness eb = new EmpleadoBussiness();
//
//		ArrayList<VwListaEmpleadosBE> lista = eb.ListarEmpleados();

		//TablaEmpleados.seeTable(TABLA_EMPLEADOS, lista, sorter);
		
		//model.setValueAt(lista, ERROR, ABORT);
		//model=TablaEmpleados.seeTable(TABLA_EMPLEADOS,lista,sorter);

	}

	protected void do_btnCerrarSesin_actionPerformed(ActionEvent arg0) {
		this.dispose();
		FormLogin fl = new FormLogin();
		fl.setVisible(true);
	}

	protected void do_btnRegistrarEmpleado_actionPerformed(ActionEvent arg0) {
		lblNewLabel_1.setVisible(true);
		JDRegistrarEmpleado re = new JDRegistrarEmpleado(this,true);
		re.setVisible(true);
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtFiltroEmpleado) {
			do_txtFiltroEmpleado_keyTyped(e);
		}
	}
	protected void do_txtFiltroEmpleado_keyTyped(KeyEvent e) {
		//System.out.println("ENTRO AL TXTFILTER");
		
		txtFiltroEmpleado.addKeyListener(new KeyAdapter() {
					
					@Override
					public void keyReleased(KeyEvent e) {
						sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtFiltroEmpleado.getText(), 2));
					}			
					
				});
				
				model=(DefaultTableModel) TABLA_EMPLEADOS.getModel();
				
				sorter= new TableRowSorter<>(model);
				
				TABLA_EMPLEADOS.setRowSorter(sorter);
				
				//TABLAAGREGARPRODUCTOS.updateUI();
				
				
				//TablaAgregarProductos.setRowSorter(TABLAAGREGARPRODUCTOS,trs);
				
				//TablaAgregarProductos.seeTable(TABLAAGREGARPRODUCTOS, _listaProductosBE);
	}
	
	public void focusGained(FocusEvent e) {
		if (e.getSource() == txtFiltroEmpleado) {
			do_txtFiltroEmpleado_focusGained(e);
		}
	}
	public void focusLost(FocusEvent e) {
		if(txtFiltroEmpleado.getText().length()==0){
			addPlaceHolderStyle(txtFiltroEmpleado);
			txtFiltroEmpleado.setText("Ingrese el nombre de un empleado");
		}
	}
	protected void do_txtFiltroEmpleado_focusGained(FocusEvent e) {
		if(txtFiltroEmpleado.getText().equals("Ingrese el nombre de un empleado")){
			txtFiltroEmpleado.setText(null);
			txtFiltroEmpleado.requestFocus();
			
			removePlaceholderStyle(txtFiltroEmpleado);
		}
	}
	public void windowGainedFocus(WindowEvent e) {
		if (e.getSource() == this) {
			do_this_windowGainedFocus(e);
		}
	}
	public void windowLostFocus(WindowEvent e) {
	}
	protected void do_this_windowGainedFocus(WindowEvent e) {
		this.requestFocusInWindow();
	}
	protected void do_btnActualizarTabla_actionPerformed(ActionEvent arg0) {
		refreshTablaEmpleados();
		
	}
	protected void do_buttonDescargarReporte_actionPerformed(ActionEvent arg0) {
		TablaEmpleados.Exportar(TABLA_EMPLEADOS);
	}
	protected void do_btnLISTAR_PEDIDOS_actionPerformed(ActionEvent arg0) {		
		
		//lblNewLabel_1.setVisible(false);
		panelwithJtable.setVisible(false);
		
		PedidosBussiness pb= new PedidosBussiness ();
		ArrayList<ListaPedidosBE> listaPedidos= pb.listaPedidos();
		
		//_listaPedidos=listaPedidos;
		//this.setVisible(false);
		
		//FormAdministrador.setDefaultLookAndFeelDecorated(false);
		JDListarPedidos LP= new JDListarPedidos (this,true,listaPedidos);
		LP.setVisible(true);
		
		
		//PanelTablaPedidos.setVisible(true);
		
		//TablaPedidos.seeTable(tableListaPedidos, listaPedidos, sorter);		
		
		
	}
}
