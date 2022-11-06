package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import utils.Ficheros;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(39, 110, 69, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setBounds(39, 143, 99, 40);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(161, 107, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(161, 48, 69, 20);
		contentPane.add(lblLogin);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n ");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String usuario = textField.getText();
				String contraseña = passwordField.getText();
				
				
				HashMap<String, Usuario> map = Ficheros.leerUsuarios();
				
				if(map.containsKey(usuario)){
					if(map.get(usuario).getContraseña().equals(contraseña)){
						JOptionPane.showMessageDialog(Login.this, "Inicio de sesión correcto");
						Reservas r = new Reservas(Login.this,textField.getText());
						r.setVisible(true);
						Login.this.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(Login.this, "Contraseña incorrecta");	
					}
				}else{
					JOptionPane.showMessageDialog(Login.this, "El usuario no existe");
				}
				
			}
		});
		btnIniciarSesin.setBounds(161, 190, 146, 26);
		contentPane.add(btnIniciarSesin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 148, 146, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Crear usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario cr = new CrearUsuario(Login.this);
				cr.setVisible(true);
				Login.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(161, 232, 146, 29);
		contentPane.add(btnNewButton);
	}

	
}
