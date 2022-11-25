package ventanaInicial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Administrador;
import clases.Cliente;
import clases.Usuario;
import utilidades.Utilidades;
import ventanasAdministrador.General;
import ventanasCliente.Reservas;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	private boolean loginCorrecto; //variable true o false de login
	private Usuario usuarioIntroducido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(225, 97, 300, 121);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setBounds(96, 230, 187, 63);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setBounds(96, 330, 187, 56);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(278, 244, 287, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(278, 330, 300, 26);
		getContentPane().add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Iniciar Sesi\u00F3n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarLogin(textField.getText(), passwordField.getText());
				if (loginCorrecto) {
				  JOptionPane.showMessageDialog(contentPane, "Login correcto");
				  if (usuarioIntroducido instanceof Administrador) { //cuando el usuario sea administrador que vaya a esa ventana
					General g = new General((Administrador) usuarioIntroducido);
					g.setVisible(true);

				  } else {//cuando el usuario sea clientes que vaya a otra ventana
					Reservas r = new Reservas((Cliente) usuarioIntroducido);
					r.setVisible(true);
				  }
				Login.this.setVisible(false);
				Login.this.dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Login incorrecto");
						}
			}
		});
		
		
	
		btnNewButton_1.setBounds(227, 425, 226, 56);
		getContentPane().add(btnNewButton_1);
	}
		
		
	public void comprobarLogin(String username, String password) {
		ArrayList<Usuario> usuarios = Utilidades.leerUsuarios();

		loginCorrecto = false;
		for (Usuario usuario : usuarios) {
			if ((usuario.getUsername().equals(username)) && (usuario.getContrasenya().equals(password))){
					loginCorrecto = true;
					usuarioIntroducido = usuario;

				}
			}
		}
}
