package main.ventanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.baseDatos.GestorBaseDatos;
import main.clases.Pelicula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModificarHorarios extends JFrame {

	private JPanel contentPane;
	private General padre;
	private JTextField textField;
	
	private JList list;
	private ArrayList <Pelicula> peliculas;
	private DefaultListModel<Pelicula> defaulListModel;
	
	public ModificarHorarios(General padre) {
		this.padre=padre;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PELICULAS EN CARTELERA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(250, 33, 286, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona la pelicula que quieres modificar:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(31, 95, 374, 42);
		contentPane.add(lblNewLabel_1);
		
		list = new JList();
		list.setBounds(64, 148, 572, 195);
		contentPane.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Nuevo horario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(42, 368, 114, 53);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(168, 382, 172, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("MODIFICAR\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(199, 444, 261, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATRAS\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				ModificarHorarios.this.setVisible(false);
				ModificarHorarios.this.dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(607, 470, 136, 42);
		contentPane.add(btnNewButton_1);
		
		cargarJlist();
	}
	
	public void cargarJlist(){
		peliculas = GestorBaseDatos.leerPeliculas();
		defaulListModel = new DefaultListModel<>(); 
		for (Pelicula pelicula : peliculas) { 
			defaulListModel.addElement(pelicula);
		}
		list.setModel(defaulListModel); 
	}
}
