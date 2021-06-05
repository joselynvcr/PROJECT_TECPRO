package saborea.presentation;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import saborea.model.bussiness.RegistroPedidoProductoBussiness;
import saborea.model.bussiness.DTO.CredencialesBE;

import saborea.model.bussiness.DTO.VwRegistroPedidoProductoBE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;

import javax.swing.JButton;


import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


public class FormMozo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnMesa;
	private JButton btnMesa_1;
	private JButton btnMesa_2;
	private JButton btnMesa_3;
	private JButton btnMesa_4;
	private JButton btnMesa_5;
	private JButton btnMesa_6;
	private JButton btnSalir;
	private Container contenedor;
	private CredencialesBE Cred;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Mozo frame = new Mozo();
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
	public FormMozo(CredencialesBE cred) {
		//JPanel PanelRegistrarProducto = new JPanel();
		
		
		Cred=cred;
		contenedor=getContentPane();
		contenedor.setLayout(null);
		        //Asigna un titulo a la barra de titulo
		 setTitle("VENTANA MOZO");
		 //tama�o de la ventana
		 setSize(400,200);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel(cred.getNombreEmpleado()+" "+ cred.getApellidoEmpleado());
		lblNewLabel.setBounds(10, 76, 203, 49);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(cred.getTipoCargo());
		lblNewLabel_1.setBounds(43, 131, 91, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("MESA 1");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(178, 139, 89, 23);
		contentPane.add(btnNewButton);
		
		btnMesa = new JButton("MESA 2");
		btnMesa.setBounds(321, 139, 89, 23);
		contentPane.add(btnMesa);
		
		btnMesa_1 = new JButton("MESA 3");
		btnMesa_1.setBounds(466, 139, 89, 23);
		contentPane.add(btnMesa_1);
		
		btnMesa_2 = new JButton("MESA 4");
		btnMesa_2.setBounds(598, 139, 89, 23);
		contentPane.add(btnMesa_2);
		
		btnMesa_3 = new JButton("MESA 5");
		btnMesa_3.setBounds(176, 226, 89, 23);
		contentPane.add(btnMesa_3);
		
		btnMesa_4 = new JButton("MESA 6");
		btnMesa_4.setBounds(321, 226, 89, 23);
		contentPane.add(btnMesa_4);
		
		btnMesa_5 = new JButton("MESA 7");
		btnMesa_5.setBounds(466, 226, 89, 23);
		contentPane.add(btnMesa_5);
		
		btnMesa_6 = new JButton("MESA 8");
		btnMesa_6.setBounds(598, 226, 89, 23);
		contentPane.add(btnMesa_6);
		
		btnSalir = new JButton("EXIT");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(24, 370, 89, 23);
		contentPane.add(btnSalir);
		
		
//		PanelRegistrarProducto panel = new PanelRegistrarProducto(null);
//		panel.setBounds(0, 0, 772, 416);
//		contentPane.add(panel,BorderLayout.CENTER);
		
		
		 //pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);			
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
		
	
	
	//BUTTON EXIT TO LOGIN
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		FormLogin fl= new FormLogin();
		fl.setVisible(true);
		this.dispose();
		
		
	}	
	//BUTTON MESA 1
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {	
		//TRAER LA DATA DESDE LA BD 		
		int mesa=1;//capturar desde el formulario
		//para rellenar obj se tiene que buscar a las ordenes de la mesa 1 pagado=F enviado=F
		
		RegistroPedidoProductoBussiness RegistroPedidoProducto= new RegistroPedidoProductoBussiness();	
		//traer los cambios desde la BD
		VwRegistroPedidoProductoBE VWOrdenPedidoRegistrado =RegistroPedidoProducto.findPedidos(Cred, mesa);		
		
		
		FormRegistrarPedido frp= new FormRegistrarPedido(VWOrdenPedidoRegistrado,Cred);
		
		
		frp.setVisible(true);
		this.dispose();
		
		
		
		
		
		

		
		
		
		
		
		
	}
	
	
	
	
	
}