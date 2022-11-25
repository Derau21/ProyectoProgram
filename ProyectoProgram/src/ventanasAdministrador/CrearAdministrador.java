package ventanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Administrador;
import clases.Usuario;
import utilidades.Utilidades;
import ventanas.HacerAdmin;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearAdministrador frame = new CrearAdministrador();
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
	public CrearAdministrador() {
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
		
		JLabel lblNewLabel_3 = new JLabel("Antiguedad");
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
		btnHacerAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuarioIntroducido = textField.getText();
				String contraseñaIntroducida = passwordField.getText();
				int antiguedadIntroducida = Integer.parseInt(textField_1.getText());
				
				if(!usuarioIntroducido.equals("") && !contraseñaIntroducida.equals("") && !antiguedadIntroducida.equals("")){//comprobar que se han rellenado usuario y contraseña
					ArrayList<Usuario>usuarios = Utilidades.leerUsuarios(); //para rellenar el array con los usuarios que ya tienes
					//usuarios.remove(clienteSeleccioando); //se borra el cliente
					
					usuarios.add(new Administrador(usuarioIntroducido,contraseñaIntroducida, antiguedadIntroducida )); //se crea el admin
				
				Utilidades.escribirFihcero(usuarios);
				
				//padre.cargarModelo();//como ha habido un cambio cargas el Jlist otra vez para cargarlo de nuevo
				
				//padre.setVisible(true);
				//HacerAdmin.this.setVisible(false); //vueleves a la pestaña anterior
				//HacerAdmin.this.dispose();
				
				}else{
					//JOptionPane.showMessageDialog(HacerAdmin.this, "Por favor rellene todos los campos");
				}
			}
		});
		btnNewButton.setBounds(262, 318, 227, 55);
		contentPane.add(btnNewButton);
	}
}
