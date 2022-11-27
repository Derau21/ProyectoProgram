package ventanasCliente;

import java.awt.EventQueue;
import java.util.ArrayList;

import clases.Pelicula;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class NuevaReserva extends JFrame {

	private JPanel contentPane;
	private Reservas padre;
	private JList list;
	private ArrayList <Pelicula>peliculas;
	private DefaultListModel<Pelicula> defaulListModel;
	
	public NuevaReserva(Reservas padre) {
		this.padre=padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
}
