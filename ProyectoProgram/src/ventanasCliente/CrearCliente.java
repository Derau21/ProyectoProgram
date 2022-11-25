package ventanasCliente;
import utilidades.Utilidades;
import ventanaInicial.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Usuario;

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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente();
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
	public CrearCliente() {
		
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
				String contraseņaIntroducida = new String (passwordField.getPassword());
				

				if(!usuarioIntroducido.equals("") && !contraseņaIntroducida.equals("")){//comprobar que se han rellenado usuario y contraseņa
					ArrayList<Usuario>usuarios = Utilidades.leerUsuarios(); //para rellenar el array con los usuarios que ya tienes
					//usuarios.remove(clienteSeleccioando); //se borra el cliente

					usuarios.add(new Cliente(usuarioIntroducido,contraseņaIntroducida)); //se crea el admin

					Utilidades.escribirFihcero(usuarios);

					//padre.cargarModelo();//como ha habido un cambio cargas el Jlist otra vez para cargarlo de nuevo

					//padre.setVisible(true);
					//CrearCliente.this.setVisible(false); //vueleves a la pestaņa anterior
					//CrearCliente.this.dispose();

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
