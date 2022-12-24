package main.ventanasCliente;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Cliente;
import main.clases.Usuario;
import main.utilidades.Utilidades;
import main.ventanaInicial.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CrearCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Utilidades util;
	private Login padre;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CrearCliente(Login padre) {
		this.padre=padre;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPantalla = new JLabel("Crear Cliente");
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
				String usuarioIntroducido = textField.getText();
				String contraseñaIntroducida = new String (passwordField.getPassword());
				

				if(!usuarioIntroducido.equals("") && !contraseñaIntroducida.equals("")){//comprobar que se han rellenado usuario y contraseña
					ArrayList<Usuario>usuarios = Utilidades.leerUsuarios(); //para rellenar el array con los usuarios que ya tienes
					//usuarios.remove(clienteSeleccioando); //se borra el cliente

					usuarios.add(new Cliente(usuarioIntroducido,contraseñaIntroducida)); //se crea el admin

					Utilidades.escribirFihcero(usuarios);

					//padre.cargarModelo();//como ha habido un cambio cargas el Jlist otra vez para cargarlo de nuevo

					JOptionPane.showMessageDialog(CrearCliente.this, "Cliente creado");
					
					padre.setVisible(true);
					CrearCliente.this.setVisible(false); //vueleves a la pestaña anterior
					CrearCliente.this.dispose();
					

				}else{
					JOptionPane.showMessageDialog(CrearCliente.this, "Por favor rellene todos los campos");
				}
			}
		});
		btnConfirmar.setBounds(216, 264, 115, 29);
		contentPane.add(btnConfirmar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 192, 134, 20);
		contentPane.add(passwordField);
	}
}
