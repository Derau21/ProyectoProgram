package main.ventanasAdministrador;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnyadirPeliculas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private General padre;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	
	
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public AnyadirPeliculas(General padre) {
		this.padre=padre;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Genero\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(64, 139, 186, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblDuracion = new JLabel("Duracion \r\n\r\n(Minutos)");
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDuracion.setBounds(64, 198, 186, 64);
		contentPane.add(lblDuracion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(64, 84, 186, 64);
		contentPane.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(228, 100, 291, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 155, 291, 39);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("A\u00D1ADIR PELICULA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(202, 300, 229, 64);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		
		//Para que solo deje meter numeros en la duracion
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped (KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(228, 214, 291, 39);
		contentPane.add(textField);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAtras.setBounds(541, 377, 118, 39);
		contentPane.add(btnAtras);
		
		
		
	}
	
	
}
