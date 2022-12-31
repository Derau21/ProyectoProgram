
package main.ventanasAdministrador;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ModificarHorarios extends JFrame {

	private JPanel contentPane;
	private General padre;
	private JTextField textField;

	
	public ModificarHorarios(General padre) {
		this.padre = padre;
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
		list.setBounds(1, 1, 665, 468);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona la pelicula que quieres modificar:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(26, 89, 282, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAtras.setBounds(518, 392, 118, 39);
		contentPane.add(btnAtras);
		
		JButton btnEliminar = new JButton("MODIFICAR");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEliminar.setBounds(159, 383, 229, 64);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(36, 118, 500, 185);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Nuevo horario:");
		lblNewLabel_2.setBounds(36, 332, 80, 29);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(128, 332, 130, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		

	}

}
