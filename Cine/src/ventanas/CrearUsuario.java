package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import utils.Ficheros;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private Login padre; // +
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private Ficheros ficheros;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param login
	 */
	public CrearUsuario(Login login) {
		this.padre = login; // +
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDatos = new JLabel("DATOS");
		lblDatos.setForeground(new Color(255, 255, 255));
		lblDatos.setBackground(new Color(255, 255, 255));
		lblDatos.setBounds(53, 0, 115, 50);
		contentPane.add(lblDatos);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(53, 88, 69, 20);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setBounds(53, 124, 115, 37);
		contentPane.add(lblContrasea);

		JButton btnCrearUsuario = new JButton("CREAR");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HashMap<String, Usuario> mapUsuarios = Ficheros.leerUsuarios();

				if (mapUsuarios.containsKey(textField_1.getText())) {
					JOptionPane.showMessageDialog(contentPane, "El usuario ya existe");
				} else {
					
							
					String nombre = textField.getText();
					String usuario = textField_1.getText();
					String contraseña = passwordField.getText();
					String edad = textField_2.getText();
					String dni = textField_3.getText();
					Usuario u = new Usuario(nombre, usuario, contraseña, edad, dni);
					mapUsuarios.put(usuario, u);
					

					boolean cuentaCreada = Ficheros.escribirNuevoUsuario(mapUsuarios);

					if (cuentaCreada == true) {
						padre.setVisible(true); // +
						CrearUsuario.this.setVisible(false); // + PARA VOLVER A
																// AL LOGIN
						CrearUsuario.this.dispose(); // +

					}
					

				}
			}
		});
		btnCrearUsuario.setBounds(115, 279, 191, 50);
		contentPane.add(btnCrearUsuario);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(53, 52, 69, 20);
		contentPane.add(lblNombre);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(new Color(255, 255, 255));
		lblEdad.setBounds(53, 177, 69, 20);
		contentPane.add(lblEdad);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setBounds(53, 213, 69, 20);
		contentPane.add(lblDni);

		textField = new JTextField();
		textField.setBounds(183, 49, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(183, 85, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(183, 174, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(183, 210, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(183, 129, 146, 26);
		contentPane.add(passwordField);
	}
}
