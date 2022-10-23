package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clases.Pelicula;
import utils.Ficheros;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class Cartelera extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Pelicula> defaulListModel; //++++ para cargar el JLISTTTTT
	private JList list;//+++se añade
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param reservas 
	 * @param reservas 
	 */
	public Cartelera(Reservas reservas,String nombreUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Jlist listaVentana = new Jlist(); 
		list = new JList(); //se quita el JList
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(15, 104, 620, 171);
		contentPane.add(list);
		
		JLabel lblCartelera = new JLabel("CARTELERA");
		lblCartelera.setBounds(37, 32, 109, 38);
		contentPane.add(lblCartelera);
		
		JButton btnReservar = new JButton("RESERVAR");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean resultado = Ficheros.escribirSeleccionReserva(list.getSelectedValuesList().toString());
				
				ConfirmacionReserva cr = new ConfirmacionReserva(Cartelera.this,(Pelicula) list.getSelectedValue(),nombreUsuario);
				cr.setVisible(true);
				Cartelera.this.setVisible(false);
			    
			}
		});
		btnReservar.setBounds(223, 325, 198, 63);
		contentPane.add(btnReservar);
		
		btnReservar.setEnabled(false);
		
		list.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				btnReservar.setEnabled(true);
				
			}
		});
		
		CargarJlist();
	}
	public void CargarJlist(){
		ArrayList<Pelicula>peliculas = Ficheros.leerNombrePeliculas();
		
		defaulListModel = new DefaultListModel<>(); //azul nombre y verde tipo
		
		//tipo de objeto de la lista + variable temporal la podemos llamar como queramos + nombre del arraylist que te vas a recorrer
		for(Pelicula pelicula:peliculas){
			defaulListModel.addElement(pelicula); //addElement para añadir al defaultlistmodel
			
		}
		//añadimos el defaultListModel con los nombres al JList
		list.setModel(defaulListModel); //en ()la cosa que has cargado con todos nombres 
		
		
	}

	
}
