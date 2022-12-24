package main.ventanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Administrador;
import main.clases.Usuario;
import main.utilidades.Utilidades;
import main.ventanaInicial.Login;
import main.ventanasCliente.CrearCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CrearAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private Login padre;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CrearAdministrador(Login padre) {
		this.padre=padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Crear Administrador");
		lblNewLabel.setBounds(291, 78, 126, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(111, 154, 131, 38);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(111, 212, 78, 38);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(111, 259, 110, 38);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(252, 154, 279, 38);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(252, 259, 279, 38);
		contentPane.add(textField_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(252, 203, 279, 38);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("CREAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioIntroducido = textField.getText();
				String contrasenyaIntroducida = passwordField.getText();
				String dNIIntroducida = textField_1.getText();

				if(!usuarioIntroducido.equals("") && !contrasenyaIntroducida.equals("") && !dNIIntroducida.equals("")){//comprobar que se han rellenado usuario y contrase?a
					ArrayList<Usuario>usuarios = Utilidades.leerUsuarios(); //para rellenar el array con los usuarios que ya tienes
					//usuarios.remove(clienteSeleccioando); //se borra el cliente

					usuarios.add(new Administrador(usuarioIntroducido,contrasenyaIntroducida, dNIIntroducida )); //se crea el admin

					Utilidades.escribirFihcero(usuarios);

					//padre.cargarModelo();//como ha habido un cambio cargas el Jlist otra vez para cargarlo de nuevo

					JOptionPane.showMessageDialog(CrearAdministrador.this, "Administrador creado");
					
					padre.setVisible(true);
					CrearAdministrador.this.setVisible(false); //vueleves a la pesta?a anterior
					CrearAdministrador.this.dispose();
					
				}else{
					JOptionPane.showMessageDialog(CrearAdministrador.this, "Por favor rellene todos los campos");
				}
			}
		});
	
		btnNewButton.setBounds(262, 318, 227, 55);
		contentPane.add(btnNewButton);
	}
}

