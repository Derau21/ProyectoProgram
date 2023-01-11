package main.ventanasCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Administrador;
import main.clases.Cliente;
import main.clases.Usuario;
import main.utilidades.Utilidades;
import main.ventanaInicial.Login;
import main.ventanasAdministrador.CrearAdministrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class CrearCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Login padre;
	

	public CrearCliente(Login padre) {
		this.padre=padre;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPantalla = new JLabel("Crear Cliente");
		lblPantalla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPantalla.setBounds(193, 56, 139, 20);
		contentPane.add(lblPantalla);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(68, 124, 127, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(68, 192, 127, 20);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(205, 121, 146, 26);
		contentPane.add(textField);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioIntroducido = textField.getText();
				String contrasenyaIntroducida = passwordField.getText();
				
				
				
				if(!usuarioIntroducido.equals("") && !contrasenyaIntroducida.equals("")){//comprobar que se han rellenado usuario y contrase?a
					ArrayList<Usuario>usuarios = Utilidades.leerUsuarios(); 
					boolean entradoAIf = false;
					
					for (Usuario usuario : usuarios) {
						if (usuario.getUsername().equals(usuarioIntroducido)) {
							JOptionPane.showMessageDialog(CrearCliente.this, "Error: el nombre del usuario ya existe en el sistema.");
							entradoAIf = true;
						}
					}
					if(entradoAIf == false) {

						usuarios.add(new Cliente(usuarioIntroducido,contrasenyaIntroducida)); 

						Utilidades.escribirFihcero(usuarios);

						JOptionPane.showMessageDialog(CrearCliente.this, "Cliente creado");

						padre.setVisible(true);
						CrearCliente.this.setVisible(false);
						CrearCliente.this.dispose();

					}
				}else{
					JOptionPane.showMessageDialog(CrearCliente.this, "Por favor rellene todos los campos");
				}
			}
		});
		btnConfirmar.setBounds(216, 264, 115, 29);
		contentPane.add(btnConfirmar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 186, 146, 26);
		contentPane.add(passwordField);
	}
}
