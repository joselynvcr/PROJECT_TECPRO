package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import saborea.model.bussiness.EmpleadoBussiness;
import saborea.model.bussiness.DTO.CredencialesBE;
import saborea.model.bussiness.DTO.ListaEmpleadosBE;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import saborea.presentation.RSButtonMetro;
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
import saborea.presentation.RSButtonMetro;
import java.awt.event.MouseListener;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FormAdministrador extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel_cargo;
	private JLabel lblNewLabel_1_nombreAndApe;
	private JPanel MAINpanelADMIN;
	private JPanel FuntionalPanel;
	private JLabel lblNewLabel;
	private JButton btnLISTAR_EMPLEADOS;
	private JPanel MENUpanel;
	private JButton btnRegistrarEmpleado;
	private JButton btnDescargarReporte;
	private JButton btnCerrarSesin;
	TableRowSorter<DefaultTableModel> sorter;
	private JLabel lblNewLabel_2;
	JLabel lblNewLabel_BUSCAR;
	private JLabel lblNewLabel_1;
	private JPanel panelwithJtable;
	private JScrollPane scrollPane;
	private JTable TABLA_EMPLEADOS;
	private JLabel lblNewLabel_3;
	private JTextField txtFiltroEmpleado;
	private JButton btnActualizarTabla;
	private JButton button;

	public FormAdministrador(CredencialesBE cred) {
		setResizable(false);
		setUndecorated(true);
		// Asigna un titulo a la barra de titulo
		setTitle("VENTANA ADMINISTRADOR");
		// tama�o de la ventana
		// setSize(400,200);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1200, 750);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(32773, 32774));
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MAINpanelADMIN = new JPanel();
		MAINpanelADMIN.setBorder(new LineBorder(new Color(0, 128, 128), 1, true));
		MAINpanelADMIN.setBackground(Color.WHITE);
		MAINpanelADMIN.setBounds(0, 92, 279, 658);
		contentPane.add(MAINpanelADMIN);

		lblNewLabel_1_nombreAndApe = new JLabel(cred.getNombreEmpleado() + " " + cred.getApellidoEmpleado());
		lblNewLabel_1_nombreAndApe.setBounds(78, 201, 123, 23);

		lblNewLabel_cargo = new JLabel(cred.getTipoCargo().toUpperCase());
		lblNewLabel_cargo.setBounds(78, 235, 123, 33);
		lblNewLabel_cargo.setHorizontalAlignment(SwingConstants.CENTER);
		MAINpanelADMIN.setLayout(null);
		MAINpanelADMIN.add(lblNewLabel_1_nombreAndApe);
		MAINpanelADMIN.add(lblNewLabel_cargo);
		
		btnDescargarReporte.setIcon(new ImageIcon("D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\business_application_download_downloaddatabase_thedatabase_2320.png"));
		btnDescargarReporte.setOpaque(false);
		btnDescargarReporte.setForeground(Color.BLACK);
		btnDescargarReporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDescargarReporte.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnDescargarReporte.setBackground(Color.WHITE);
		btnDescargarReporte.setBounds(1, 357, 277, 49);
		MAINpanelADMIN.add(btnDescargarReporte);
		btnCerrarSesin = new JButton("CERRAR SESI\u00D3N");
		btnCerrarSesin.addActionListener(this);
		btnCerrarSesin.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\login_icon_151220.png"));
		btnCerrarSesin.setOpaque(false);
		btnCerrarSesin.setForeground(Color.BLACK);
		btnCerrarSesin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrarSesin.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnCerrarSesin.setBackground(Color.WHITE);
		btnCerrarSesin.setBounds(1, 609, 277, 49);
		MAINpanelADMIN.add(btnCerrarSesin);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(78, 62, 134, 128);
		MAINpanelADMIN.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\user-icon.png"));

		btnLISTAR_EMPLEADOS = new JButton("LISTAR EMPLEADOS");
		btnLISTAR_EMPLEADOS.setBounds(17, 303, 261, 69);
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
		btnLISTAR_EMPLEADOS.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\list_task_tasklist_checklist_check_icon_145964.png"));

		btnRegistrarEmpleado = new JButton("REGISTRAR EMPLEADO");
		btnRegistrarEmpleado.addActionListener(this);
		btnRegistrarEmpleado.setBounds(17, 378, 261, 69);
		MAINpanelADMIN.add(btnRegistrarEmpleado);
		btnRegistrarEmpleado.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\business_application_addmale_useradd_insert_add_user_client_2312.png"));
		btnRegistrarEmpleado.setOpaque(false);
		btnRegistrarEmpleado.setForeground(Color.BLACK);
		btnRegistrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrarEmpleado.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnRegistrarEmpleado.setBackground(Color.WHITE);

		btnDescargarReporte = new JButton("DESCARGAR REPORTE");
		btnDescargarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabla.Exportar(TABLA_EMPLEADOS);
			}
		});		
		btnDescargarReporte.setBounds(17, 458, 261, 69);
		MAINpanelADMIN.add(btnDescargarReporte);
		btnDescargarReporte.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\business_application_download_downloaddatabase_thedatabase_2320.png"));
		btnDescargarReporte.setOpaque(false);
		btnDescargarReporte.setForeground(Color.BLACK);
		btnDescargarReporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDescargarReporte.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnDescargarReporte.setBackground(Color.WHITE);

		FuntionalPanel = new JPanel();
		FuntionalPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		FuntionalPanel.setBounds(278, 92, 922, 658);
		contentPane.add(FuntionalPanel);
		FuntionalPanel.setLayout(null);

		panelwithJtable = new JPanel();
		panelwithJtable.setVisible(false);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 722, 647);
		FuntionalPanel.add(lblNewLabel_1);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\LOGO_NEGRO.png"));
		panelwithJtable.setBounds(0, 0, 921, 658);
		FuntionalPanel.add(panelwithJtable);
		panelwithJtable.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 901, 385);
		panelwithJtable.add(scrollPane);

		TABLA_EMPLEADOS = new JTable();
		scrollPane.setViewportView(TABLA_EMPLEADOS);

		lblNewLabel_3 = new JLabel("BUSCAR :");
		lblNewLabel_3.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\search_locate_find_icon-icons.com_67287.png"));
		lblNewLabel_3.setBounds(173, 33, 142, 72);
		panelwithJtable.add(lblNewLabel_3);

		txtFiltroEmpleado = new JTextField();
		txtFiltroEmpleado.setBounds(313, 57, 366, 25);
		panelwithJtable.add(txtFiltroEmpleado);
		txtFiltroEmpleado.setColumns(10);

		btnActualizarTabla = new JButton("");
		btnActualizarTabla.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\cloudrefresh_icon-icons.com_54403.png"));
		btnActualizarTabla.setOpaque(false);
		btnActualizarTabla.setForeground(Color.BLACK);
		btnActualizarTabla.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnActualizarTabla.setBorder(null);
		btnActualizarTabla.setBackground(Color.WHITE);
		btnActualizarTabla.setBounds(775, 563, 124, 84);
		panelwithJtable.add(btnActualizarTabla);

		button = new JButton("");
		button.setIcon(new ImageIcon(
				"D:\\UPN-CICLOS-ARCHIVOS\\V CICLO_SISTEMAS_poo-electricidad-base de datos\\PROJECT_TECPRO\\PROJECT_SOFTWARE\\SABOREA\\img\\Excel_2013_23480.png"));
		button.setOpaque(false);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(620, 563, 124, 84);
		panelwithJtable.add(button);

		MENUpanel = new JPanel();
		MENUpanel.setBackground(new Color(0, 128, 128));
		MENUpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		MENUpanel.setBounds(0, 0, 1200, 92);
		contentPane.add(MENUpanel);
		MENUpanel.setLayout(null);

		lblNewLabel_2 = new JLabel("BIENVENIDO ");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblNewLabel_2.setBounds(374, 22, 133, 51);
		MENUpanel.add(lblNewLabel_2);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent arg0) {
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
		EmpleadoBussiness eb = new EmpleadoBussiness();

		ArrayList<ListaEmpleadosBE> lista = eb.ListarEmpleados();

		TablaEmpleados.seeTable(TABLA_EMPLEADOS, lista, sorter);

	}

	protected void do_btnCerrarSesin_actionPerformed(ActionEvent arg0) {
		this.dispose();
		FormLogin fl = new FormLogin();
		fl.setVisible(true);
	}

	protected void do_btnRegistrarEmpleado_actionPerformed(ActionEvent arg0) {
		JRegistrarEmpleado re = new JRegistrarEmpleado();
		re.setVisible(true);
	}
}