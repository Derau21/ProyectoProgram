package main.ventanasAdministrador;

import java.awt.EventQueue;
import main.ventanasAdministrador.*;
import main.ventanasCliente.NuevaReserva;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.baseDatos.GestorBaseDatos;
import main.clases.Pelicula;
import main.utilidades.Utilidades;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModificarHorarios extends JFrame {

	private JPanel contentPane;
	private General padre;
	private JTextField textField;
	
	private JList list;
	private ArrayList <String> horarios;
	private DefaultListModel<String> defaulListModel;
	private JTextField textField_1;
	
	
	public ModificarHorarios(General padre) {
		this.padre=padre;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PELICULAS EN CARTELERA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(250, 33, 286, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserta el horario que quieres añadir o selecciona el que quieres eliminar:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(31, 95, 572, 42);
		contentPane.add(lblNewLabel_1);
		
		
		horarios = Utilidades.leerHorarios();
		
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
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped (KeyEvent e) {
				if(textField.getText().length() >= 2) {
			        e.consume();
			    }
				
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		JButton btnNewButton = new JButton("ELIMINAR\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String horarioSeleccionado = (String) list.getSelectedValue();
				horarios.remove(horarioSeleccionado);	
				Utilidades.escribirArrayEnFichero(horarios);
				
				int indice = list.getSelectedIndex();
				defaulListModel.remove(indice);
				
				JOptionPane.showMessageDialog(ModificarHorarios.this, "Horario eliminado con exito");
				
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(52, 434, 261, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATRAS\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eaa) {
				padre.setVisible(true);
				ModificarHorarios.this.setVisible(false);
				ModificarHorarios.this.dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(606, 496, 136, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("AÑADIR\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> horarios = Utilidades.leerHorarios();
				String Hora = textField.getText();
				String Minutos = textField_1.getText();
				
				horarios.add(Hora + ":" + Minutos);
				Utilidades.escribirArrayEnFichero(horarios);
				cargarJlist();
				
				JOptionPane.showMessageDialog(ModificarHorarios.this, "Horario añadido con exito");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(342, 434, 261, 53);
		contentPane.add(btnNewButton_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(378, 382, 172, 31);
		contentPane.add(textField_1);
		
		
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped (KeyEvent e) {
				if(textField_1.getText().length() >= 2){
			        e.consume();
			    }
				
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("HORA\r\n");
		lblNewLabel_3.setBounds(166, 357, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("MINUTOS");
		lblNewLabel_3_1.setBounds(378, 354, 158, 14);
		contentPane.add(lblNewLabel_3_1);
		
		cargarJlist();
	}
	
	public void cargarJlist(){
		horarios = Utilidades.leerHorarios();
		defaulListModel = new DefaultListModel<>(); 
		for (String string : horarios) {
			defaulListModel.addElement(string);
		} 
		list.setModel(defaulListModel);
	}
}
