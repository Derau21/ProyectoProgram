package main.ventanaInicial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Administrador;
import main.clases.Cliente;
import main.clases.Usuario;
import main.baseDatos.GestorBaseDatos;
import main.utilidades.Utilidades;
import main.ventanasAdministrador.CrearAdministrador;
import main.ventanasAdministrador.EliminarPelicula;
import main.ventanasAdministrador.General;
import main.ventanasCliente.CrearCliente;
import main.ventanasCliente.Reservas;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	private boolean loginCorrecto; // variable true o false de login
	private Usuario usuarioIntroducido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorBaseDatos.configurarBD();
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
		setBounds(150, 50, 850, 600);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(394, 51, 103, 56);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(96, 127, 187, 63);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(96, 220, 187, 56);
		getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(272, 141, 393, 35);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(272, 235, 393, 35);
		getContentPane().add(passwordField);

		JButton btnNewButton_1 = new JButton("Iniciar Sesi\u00F3n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarLogin(textField.getText(), passwordField.getText());
				if (loginCorrecto) {
					JOptionPane.showMessageDialog(contentPane, "Login correcto");
					if (usuarioIntroducido instanceof Administrador) {
						// cuando el usuario sea administrador que vaya a esa ventana
						General g = new General((Administrador) usuarioIntroducido);
						g.setVisible(true);

					} else {
						// cuando el usuario sea clientes que vaya a otra ventana
						Reservas r = new Reservas((Cliente) usuarioIntroducido);
						r.setVisible(true);
						System.out.println(usuarioIntroducido);
					}
					Login.this.setVisible(false);
					Login.this.dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Login incorrecto");
				}
			}
		});

		btnNewButton_1.setBounds(272, 309, 177, 39);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton = new JButton("Crear Cliente");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente Cc = new CrearCliente(Login.this);
				Cc.setVisible(true);
				Login.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(488, 305, 177, 46);
		getContentPane().add(btnNewButton);

		JButton btnCrearAdministrador = new JButton("Crear Administrador");
		btnCrearAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCrearAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearAdministrador Ca = new CrearAdministrador(Login.this);
				Ca.setVisible(true);
				Login.this.setVisible(false);
			}
		});
		btnCrearAdministrador.setBounds(382, 384, 177, 46);
		getContentPane().add(btnCrearAdministrador);
	}

	public void comprobarLogin(String username, String password) {
		ArrayList<Usuario> usuarios = Utilidades.leerUsuarios();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}

		loginCorrecto = false;
		for (Usuario usuario : usuarios) {
			if ((usuario.getUsername().equals(username)) && (usuario.getContrasenya().equals(password))) {
				loginCorrecto = true;
				usuarioIntroducido = usuario;

			}
		}
	}
}
