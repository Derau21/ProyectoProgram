package main.ventanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class EliminarPelicula extends JFrame {

	private JPanel contentPane;
	private General padre;

	
	public EliminarPelicula(General padre) {
		this.padre=padre;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PELICULAS EN CARTELERA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(191, -1, 282, 108);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(36, 118, 500, 185);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona la pelicula que quieres eliminar:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(26, 89, 282, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAtras.setBounds(518, 392, 118, 39);
		contentPane.add(btnAtras);
		
		JButton btnEliminar = new JButton("ELIMINAR\r\n");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEliminar.setBounds(156, 326, 229, 64);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(36, 118, 500, 185);
		contentPane.add(scrollPane);

		
	}
}
