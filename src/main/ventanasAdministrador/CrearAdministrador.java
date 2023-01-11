package main.ventanasAdministrador;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Administrador;
import main.clases.Usuario;
import main.utilidades.Utilidades;
import main.ventanaInicial.Login;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setBounds(150, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Crear Administrador");
		lblNewLabel.setBounds(291, 78, 192, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(111, 154, 131, 38);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(111, 212, 110, 38);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioIntroducido = textField.getText();
				String contrasenyaIntroducida = passwordField.getText();
				String dNIIntroducida = textField_1.getText();
				
				
				if(!usuarioIntroducido.equals("") && !contrasenyaIntroducida.equals("") && !dNIIntroducida.equals("")){//comprobar que se han rellenado usuario y contrase?a
					ArrayList<Usuario>usuarios = Utilidades.leerUsuarios(); 
					boolean entradoAIf = false;
					
					for (Usuario usuario : usuarios) {
						if (usuario.getUsername().equals(usuarioIntroducido)) {
							JOptionPane.showMessageDialog(CrearAdministrador.this, "Error: el nombre del usuario ya existe en el sistema.");
							entradoAIf = true;
						}
					}
					if(entradoAIf == false) {

						usuarios.add(new Administrador(usuarioIntroducido,contrasenyaIntroducida, dNIIntroducida )); 

						Utilidades.escribirFihcero(usuarios);

						JOptionPane.showMessageDialog(CrearAdministrador.this, "Administrador creado");

						padre.setVisible(true);
						CrearAdministrador.this.setVisible(false);
						CrearAdministrador.this.dispose();

					}
				}else{
					JOptionPane.showMessageDialog(CrearAdministrador.this, "Por favor rellene todos los campos");
				}
			}
		});
	
		btnNewButton.setBounds(268, 346, 227, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATRAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				CrearAdministrador.this.setVisible(false);
				CrearAdministrador.this.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(638, 432, 139, 48);
		contentPane.add(btnNewButton_1);
	}
}

