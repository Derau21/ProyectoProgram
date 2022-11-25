package ventanasUsuario;
import utilidades.Utilidades;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Utilidades util;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario frame = new CrearUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPantalla = new JLabel("Crear Usuario");
		lblPantalla.setBounds(193, 56, 139, 20);
		contentPane.add(lblPantalla);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(68, 124, 127, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(68, 192, 127, 20);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(205, 121, 146, 26);
		contentPane.add(textField);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = textField.getText();
				String contrasenya = new String (passwordField.getPassword());
				
				
				
				
				
				
			}
		});
		btnConfirmar.setBounds(216, 264, 115, 29);
		contentPane.add(btnConfirmar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 192, 139, 20);
		contentPane.add(passwordField);
	}
}
