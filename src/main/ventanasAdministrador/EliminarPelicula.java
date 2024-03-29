package main.ventanasAdministrador;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.baseDatos.GestorBaseDatos;
import main.clases.Pelicula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EliminarPelicula extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private General padre;
	
	private JList list;
	private ArrayList <Pelicula> peliculas;
	private DefaultListModel<Pelicula> defaulListModel;


	
	public EliminarPelicula(General padre) {
		this.padre=padre;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PELICULAS EN CARTELERA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(191, -1, 282, 108);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona la pelicula que quieres eliminar:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(26, 89, 282, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				EliminarPelicula.this.setVisible(false);
				EliminarPelicula.this.dispose();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAtras.setBounds(619, 419, 118, 39);
		contentPane.add(btnAtras);
		
		JButton btnEliminar = new JButton("ELIMINAR\r\n");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula pelicula = (Pelicula) list.getSelectedValue();
				String nombrePelicula = pelicula.getNombre();
				GestorBaseDatos.delete(nombrePelicula);
				
				int peliculaSeleccionada = (Integer) list.getSelectedIndex();
						peliculas.remove(peliculaSeleccionada);	
				defaulListModel.remove(peliculaSeleccionada);
				 
				//GestorBaseDatos.
				JOptionPane.showMessageDialog(EliminarPelicula.this, "Pelicula eliminada con exito");
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEliminar.setBounds(264, 361, 229, 64);
		contentPane.add(btnEliminar);
		
		list = new JList<Pelicula>();
		
		cargarJlist();
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(36, 118, 500, 185);
		contentPane.add(scrollPane);
		
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
