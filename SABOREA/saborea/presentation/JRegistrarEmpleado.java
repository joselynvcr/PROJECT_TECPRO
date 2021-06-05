package saborea.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;

public class JRegistrarEmpleado extends JDialog implements ActionListener, KeyListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JButton BackButton;
	private JLabel lblNewLabel;
	private JLabel lblApellidos;
	private JLabel lblEstadoCivil;
	private JLabel lblEmpleado;
	private JLabel lblNewLabel_1;
	private JLabel lblSueldo;
	private JLabel lblGnero;
	private JLabel lblNumHijos;
	private JLabel lblCargo;
	private JLabel lblUsername;
	private JLabel lblContrasea;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField textField_SUELDO;
	private JSeparator separator;
	private JLabel lblDni;
	private JComboBox comboBox_ESTADOCIVIL;
	private JComboBox comboBox_CARGO;
	private JComboBox comboBox_GENDER;
	private JSpinner spinner_NUMHIJOS;
	private JLabel lblNewLabel_2;
	private JPanel JpanelCheck1;
	private JPanel Jpanelcheck2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JButton btnLimpiar;
	private JButton okButton;
	private JPanel panel;
	private JLabel lblTelfono;
	private JTextField txtTelf;
	private JLabel label_9;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JButton btnCorregirUsername;
	private JButton btnSearchData;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// try {
	// RegistrarEmpleado dialog = new RegistrarEmpleado();
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the dialog.
	 */
	public JRegistrarEmpleado() {
		setBounds(100, 100, 823, 728);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			okButton = new JButton("");
			okButton.setHorizontalTextPosition(SwingConstants.CENTER);
			okButton.setVerticalTextPosition(SwingConstants.BOTTOM);
			okButton.addMouseListener(this);
			okButton.setBackground(new Color(240, 248, 255));
			okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			okButton.addActionListener(this);
			okButton.setBorder(null);
			okButton.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/ic_cloud_done_128_28300.png")));
			okButton.setBounds(611, 553, 186, 114);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			BackButton = new JButton("");
			BackButton.addMouseListener(this);
			BackButton.setVerticalTextPosition(SwingConstants.BOTTOM);
			BackButton.setHorizontalTextPosition(SwingConstants.CENTER);
			BackButton.setBackground(new Color(240, 248, 255));
			BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			BackButton.setBorder(null);
			BackButton.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/1486485553-ago-arrow-arrow-left-back-previous-direction-left_81160 (1).png")));
			BackButton.addActionListener(this);
			BackButton.setBounds(10, 577, 111, 101);
			contentPanel.add(BackButton);
			BackButton.setActionCommand("Cancel");
		}
		{
			lblNewLabel = new JLabel("NOMBRE : ");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblNewLabel.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/3592853-align-employee-general-human-human-list-list-member_107786.png")));
			lblNewLabel.setBounds(21, 244, 140, 44);
			contentPanel.add(lblNewLabel);
		}
		{
			lblApellidos = new JLabel("APELLIDOS :");
			lblApellidos.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblApellidos.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/3592853-align-employee-general-human-human-list-list-member_107786.png")));
			lblApellidos.setBounds(21, 309, 140, 46);
			contentPanel.add(lblApellidos);
		}
		{
			lblEstadoCivil = new JLabel("ESTADO CIVIL :");
			lblEstadoCivil.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblEstadoCivil.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Couple_25426.png")));
			lblEstadoCivil.setBounds(394, 427, 158, 46);
			contentPanel.add(lblEstadoCivil);
		}
		{
			lblSueldo = new JLabel("SUELDO :");
			lblSueldo.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblSueldo.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/shoppaymentorderbuy-23_icon-icons.com_73884.png")));
			lblSueldo.setBounds(394, 371, 129, 44);
			contentPanel.add(lblSueldo);
		}
		{
			lblGnero = new JLabel("G\u00C8NERO :");
			lblGnero.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblGnero.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/gender_male_female_icon_138539.png")));
			lblGnero.setBounds(21, 366, 126, 46);
			contentPanel.add(lblGnero);
		}
		{
			lblNumHijos = new JLabel("NUM HIJOS :");
			lblNumHijos.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/3289560-babies-baby-family-kid-people-person_107104.png")));
			lblNumHijos.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblNumHijos.setBounds(21, 423, 149, 44);
			contentPanel.add(lblNumHijos);
		}
		{
			lblCargo = new JLabel("CARGO  :");
			lblCargo.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblCargo.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/1904677-add-addition-calculate-charge-create-new-plus_122527.png")));
			lblCargo.setBounds(394, 309, 131, 51);
			contentPanel.add(lblCargo);
		}

		{
			lblContrasea = new JLabel("CONTRASE\u00D1A  :");
			lblContrasea.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblContrasea.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/iconfinder-lock-4341303_120563.png")));
			lblContrasea.setBounds(394, 246, 158, 64);
			contentPanel.add(lblContrasea);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBorder(null);
			txtDNI.setForeground(new Color(0, 128, 128));
			txtDNI.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtDNI.setBackground(new Color(240, 248, 255));
			txtDNI.addKeyListener(this);
			txtDNI.setBounds(157, 212, 167, 20);
			contentPanel.add(txtDNI);
			txtDNI.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.addKeyListener(this);
			txtNombre.setBorder(null);
			txtNombre.setForeground(new Color(0, 128, 128));
			txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtNombre.setBackground(new Color(240, 248, 255));
			txtNombre.setColumns(10);
			txtNombre.setBounds(157, 259, 167, 20);
			contentPanel.add(txtNombre);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBorder(null);
			txtApellido.setForeground(new Color(0, 128, 128));
			txtApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtApellido.setBackground(new Color(240, 248, 255));
			txtApellido.setColumns(10);
			txtApellido.setBounds(157, 328, 167, 20);
			contentPanel.add(txtApellido);
		}
		{
			lblUsername = new JLabel("USERNAME  :");
			lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblUsername.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/user_icon-icons.com_66546.png")));
			lblUsername.setBounds(394, 189, 140, 64);
			contentPanel.add(lblUsername);
		}
		{
			lblEmpleado = new JLabel("");
			lblEmpleado.setBounds(314, 29, 149, 139);
			contentPanel.add(lblEmpleado);
			lblEmpleado.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/3592855-business-man-employee-general-human-member-office-tie_107745.png")));
		}
		{
			lblTelfono = new JLabel("TEL\u00C9FONO :");
			lblTelfono.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblTelfono.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/mobile_phone_14388.png")));
			lblTelfono.setBounds(394, 479, 130, 51);
			contentPanel.add(lblTelfono);
		}
		{
			panel = new JPanel();
			panel.setBackground(new Color(0, 128, 128));
			panel.setBounds(0, 66, 955, 57);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel_1 = new JLabel("REGISTRAR  EMPLEADO");
				lblNewLabel_1.setBounds(22, 27, 307, 19);
				panel.add(lblNewLabel_1);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			}
		}
		{
			txtUsername = new JTextField();
			txtUsername.setBorder(null);
			txtUsername.setForeground(new Color(0, 0, 0));
			txtUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtUsername.setBackground(new Color(240, 248, 255));
			txtUsername.setColumns(10);
			txtUsername.setBounds(544, 212, 168, 20);
			txtUsername.setEnabled(false);
			contentPanel.add(txtUsername);
		}
		{
			txtPassword = new JTextField();
			txtPassword.setBorder(null);
			txtPassword.setForeground(new Color(0, 128, 128));
			txtPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			txtPassword.setBackground(new Color(240, 248, 255));
			txtPassword.addKeyListener(this);
			txtPassword.setColumns(10);
			txtPassword.setBounds(562, 269, 150, 20);
			contentPanel.add(txtPassword);
		}
		{
			textField_SUELDO = new JTextField();
			textField_SUELDO.setBorder(null);
			textField_SUELDO.setForeground(new Color(0, 128, 128));
			textField_SUELDO.setFont(new Font("Tahoma", Font.BOLD, 12));
			textField_SUELDO.setBackground(new Color(240, 248, 255));
			textField_SUELDO.setColumns(10);
			textField_SUELDO.setBounds(562, 383, 150, 20);
			contentPanel.add(textField_SUELDO);
		}

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(379, 209, 2, 295);
		contentPanel.add(separator);
		{
			lblDni = new JLabel("DNI :");
			lblDni.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Icon_Business_Set_00011_A_icon-icons.com_59842.png")));
			lblDni.setFont(new Font("Century Gothic", Font.BOLD, 13));
			lblDni.setBounds(21, 189, 89, 44);
			contentPanel.add(lblDni);
		}

		comboBox_ESTADOCIVIL = new JComboBox();
		comboBox_ESTADOCIVIL.setModel(
				new DefaultComboBoxModel(new String[] { "SOLTERO(@)", "VIUDO(@)", "CASADO(@)", "DIVORCIADO(@)" }));
		comboBox_ESTADOCIVIL.setBounds(562, 439, 150, 20);
		contentPanel.add(comboBox_ESTADOCIVIL);

		comboBox_CARGO = new JComboBox();
		comboBox_CARGO.setModel(new DefaultComboBoxModel(new String[] { "MOZO", "CAJERO", "" }));
		comboBox_CARGO.setBounds(565, 318, 147, 20);
		contentPanel.add(comboBox_CARGO);

		comboBox_GENDER = new JComboBox();
		comboBox_GENDER.setModel(new DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO" }));
		comboBox_GENDER.setBounds(157, 378, 167, 20);
		contentPanel.add(comboBox_GENDER);

		spinner_NUMHIJOS = new JSpinner();
		spinner_NUMHIJOS.setBackground(new Color(0, 128, 128));
		spinner_NUMHIJOS.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_NUMHIJOS.setBounds(264, 435, 44, 31);
		contentPanel.add(spinner_NUMHIJOS);

		btnLimpiar = new JButton("");
		btnLimpiar.addMouseListener(this);
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setBackground(new Color(240, 248, 255));
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Clear_37294.png")));
		btnLimpiar.setBorder(null);
		btnLimpiar.setActionCommand("OK");
		btnLimpiar.setBounds(454, 553, 129, 114);
		contentPanel.add(btnLimpiar);

		JpanelCheck1 = new JPanel();
		JpanelCheck1.setBackground(new Color(240, 248, 255));
		JpanelCheck1.setVisible(false);
		JpanelCheck1.setBounds(334, 217, 32, 256);
		contentPanel.add(JpanelCheck1);
		JpanelCheck1.setLayout(null);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 32, 30);
		JpanelCheck1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));

		label = new JLabel("");
		label.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label.setBounds(0, 39, 32, 30);
		JpanelCheck1.add(label);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label_1.setBounds(0, 99, 32, 30);
		JpanelCheck1.add(label_1);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label_2.setBounds(0, 157, 32, 30);
		JpanelCheck1.add(label_2);

		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label_3.setBounds(0, 226, 32, 30);
		JpanelCheck1.add(label_3);

		Jpanelcheck2 = new JPanel();
		Jpanelcheck2.setBackground(new Color(240, 248, 255));
		Jpanelcheck2.setVisible(false);
		Jpanelcheck2.setBounds(742, 212, 32, 318);
		contentPanel.add(Jpanelcheck2);
		Jpanelcheck2.setLayout(null);

		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label_4.setBounds(0, 0, 32, 30);
		Jpanelcheck2.add(label_4);

		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label_5.setBounds(0, 53, 32, 30);
		Jpanelcheck2.add(label_5);

		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label_6.setBounds(0, 105, 32, 30);
		Jpanelcheck2.add(label_6);

		label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label_7.setBounds(0, 174, 32, 30);
		Jpanelcheck2.add(label_7);

		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
		label_8.setBounds(0, 225, 32, 30);
		Jpanelcheck2.add(label_8);
		{
			label_9 = new JLabel("");
			label_9.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/Tick_Mark_Circle_icon-icons.com_69145.png")));
			label_9.setBounds(0, 277, 32, 30);
			Jpanelcheck2.add(label_9);
		}

		// contentPanel.setBackground(new Color(77, 61, 58));
		txtTelf = new JTextField();
		txtTelf.setBorder(null);
		txtTelf.setForeground(new Color(0, 128, 128));
		txtTelf.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTelf.setBackground(new Color(240, 248, 255));
		txtTelf.addKeyListener(this);
		txtTelf.setColumns(10);
		txtTelf.setBounds(562, 496, 150, 20);
		contentPanel.add(txtTelf);

		separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		separator_1.setBackground(new Color(0, 128, 128));
		separator_1.setBounds(137, 232, 186, 2);
		contentPanel.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		separator_2.setBackground(new Color(0, 128, 128));
		separator_2.setBounds(138, 286, 186, 2);
		contentPanel.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		separator_3.setBackground(new Color(0, 128, 128));
		separator_3.setBounds(150, 353, 174, 2);
		contentPanel.add(separator_3);

		separator_4 = new JSeparator();
		separator_4.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		separator_4.setBackground(new Color(0, 128, 128));
		separator_4.setBounds(544, 244, 186, 2);
		contentPanel.add(separator_4);

		separator_5 = new JSeparator();
		separator_5.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		separator_5.setBackground(new Color(0, 128, 128));
		separator_5.setBounds(553, 300, 167, 2);
		contentPanel.add(separator_5);

		separator_6 = new JSeparator();
		separator_6.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		separator_6.setBackground(new Color(0, 128, 128));
		separator_6.setBounds(545, 410, 167, 2);
		contentPanel.add(separator_6);

		separator_7 = new JSeparator();
		separator_7.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		separator_7.setBackground(new Color(0, 128, 128));
		separator_7.setBounds(545, 516, 167, 2);
		contentPanel.add(separator_7);
		txtNombre.setText("");
		txtApellido.setText("");

		btnCorregirUsername = new JButton("");
		btnCorregirUsername.setEnabled(false);
		btnCorregirUsername.setBorder(null);
		btnCorregirUsername.setBackground(new Color(240, 248, 255));
		btnCorregirUsername.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/3592869-compose-create-edit-edit-file-office-pencil-writing-creative_107746.png")));
		btnCorregirUsername.addActionListener(this);
		btnCorregirUsername.setBounds(732, 202, 61, 51);
		contentPanel.add(btnCorregirUsername);
		
		btnSearchData = new JButton("");		
		btnSearchData.setIcon(new ImageIcon(JRegistrarEmpleado.class.getResource("/img/search_locate_find_icon-icons.com_67287_SEARCH.png")));
		btnSearchData.setBorder(null);
		btnSearchData.setBackground(new Color(240, 248, 255));
		btnSearchData.setBounds(324, 189, 51, 44);
		contentPanel.add(btnSearchData);
		btnSearchData.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (txtDNI.getText().length() > 0) {
					btnSearchData.setEnabled(true);
				} else {
					btnSearchData.setEnabled(false);
				}
			}
		});
		// txtUsername.setText(txtNombre + "" + txtApellido);

		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCorregirUsername) {
			do_btnNewButton_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(arg0);
		}
		if (arg0.getSource() == okButton) {
			do_okButton_actionPerformed(arg0);
		}
		if (arg0.getSource() == BackButton) {
			do_cancelButton_actionPerformed(arg0);
		}
	}

	protected void do_cancelButton_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}

	// BUTTON REGISTRAR
	protected void do_okButton_actionPerformed(ActionEvent arg0) {
		if (txtDNI.getText().length() < 8 || txtNombre.getText().length() == 0 || txtApellido.getText().length() == 0
				|| txtPassword.getText().length() < 9 || Integer.parseInt(textField_SUELDO.getText()) < 930
				|| txtTelf.getText().length() < 9 || txtUsername.getText().contains(" ")) {
			JOptionPane.showMessageDialog(null, "CAMPOS INVÁLIDOS, VUELVA A INTENTARLO", "WARNING",
					JOptionPane.WARNING_MESSAGE);
		} else {
			JpanelCheck1.setVisible(true);
			Jpanelcheck2.setVisible(true);
			JOptionPane.showMessageDialog(null, "REGISTRADO SATISFACOTRIAMENTE", "INFORMACIÓN",
					JOptionPane.INFORMATION_MESSAGE);
			btnCorregirUsername.setVisible(false);
		}

		String dni = txtDNI.getText();

	}

	// BUTTON LIMPIAR
	protected void do_btnLimpiar_actionPerformed(ActionEvent arg0) {
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
		textField_SUELDO.setText("");
		txtTelf.setText("");
		comboBox_CARGO.setSelectedIndex(0);
		comboBox_ESTADOCIVIL.setSelectedIndex(0);
		comboBox_GENDER.setSelectedIndex(0);
		spinner_NUMHIJOS.setValue(0);
		JpanelCheck1.setVisible(false);
		Jpanelcheck2.setVisible(false);

	}

	public void keyPressed(KeyEvent arg0) {

	}

	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtNombre) {
			do_txtNombre_keyReleased(arg0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtPassword) {
			do_txtPassword_keyTyped(arg0);
		}
		if (arg0.getSource() == txtTelf) {
			do_textField_keyTyped(arg0);
		}
		if (arg0.getSource() == txtDNI) {
			do_txtDNI_keyTyped(arg0);
		}
	}

	// LIMITAR AL DNI
	protected void do_txtDNI_keyTyped(KeyEvent arg0) {
		if (txtDNI.getText().length() >= 8) {
			arg0.consume();
		}

	}

	// LIMITAR AL NUM_TELF
	protected void do_textField_keyTyped(KeyEvent arg0) {
		if (txtTelf.getText().length() >= 9) {
			arg0.consume();
		}
	}

	protected void do_txtPassword_keyTyped(KeyEvent arg0) {
		if (txtPassword.getText().length() >= 9) {
			arg0.consume();
		}
	}

	protected void do_txtNombre_keyReleased(KeyEvent arg0) {
		txtUsername.setEnabled(true);
		txtUsername.setEditable(false);
		txtUsername.setText(txtNombre.getText().toUpperCase());
		// txtUsername.getText();
		// String frase= txtUsername.getText().replaceAll();
		// txtUsername.setText(frase);
		if (txtNombre.getText().length() > 0) {
			btnCorregirUsername.setEnabled(true);
		} else {
			btnCorregirUsername.setEnabled(false);
		}
		
		
		
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		String frase = txtNombre.getText().toUpperCase().replaceAll(" ", "_");
		txtUsername.setText(frase);
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == BackButton) {
			do_BackButton_mouseEntered(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			do_btnLimpiar_mouseEntered(arg0);
		}
		if (arg0.getSource() == okButton) {
			do_okButton_mouseEntered(arg0);
		}
	}

	public void mouseExited(MouseEvent arg0) {
		okButton.setText("");
		btnLimpiar.setText("");
		BackButton.setText("");
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	protected void do_okButton_mouseEntered(MouseEvent arg0) {
		// todo lo que va a realizar cual el mouse este adentro
		okButton.setText("REGISTRAR");

	}

	protected void do_btnLimpiar_mouseEntered(MouseEvent arg0) {
		btnLimpiar.setText("LIMPIAR");
	}

	protected void do_BackButton_mouseEntered(MouseEvent arg0) {
		BackButton.setText("VOLVER");
	}
}
