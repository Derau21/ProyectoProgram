package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Pelicula;
import utils.Ficheros;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ConfirmacionReserva extends JFrame {

	private JPanel contentPane;
	
	
     
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @param cartelera 
	 */
	public ConfirmacionReserva(Cartelera cartelera,Pelicula peliElegida,String nombreUsuario) {
		
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblHora = new JLabel("HORA");
		lblHora.setForeground(new Color(255, 255, 255));
		lblHora.setBounds(512, 151, 69, 20);
		contentPane.add(lblHora);
		
		String peliculaJlist=filtrarPeliculas(peliElegida);
		String[] separacionpelicula=peliculaJlist.split(";");
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"19:00", "21:00", "23:00"}));
		comboBox.setBounds(512, 187, 114, 38);
		contentPane.add(comboBox);
		
		JLabel lblNumeroDeEntradas = new JLabel("NUMERO DE ENTRADAS");
		lblNumeroDeEntradas.setForeground(new Color(255, 255, 255));
		lblNumeroDeEntradas.setBounds(512, 283, 185, 38);
		contentPane.add(lblNumeroDeEntradas);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(512, 337, 114, 38);
		contentPane.add(comboBox_1);
		
		JButton btnReservar = new JButton("RESERVAR");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ConfirmacionReserva.this,"Reserva realizada con exito");
				escribirEntrada(nombreUsuario, String.valueOf(comboBox.getSelectedItem()),String.valueOf(comboBox_1.getSelectedItem()) , peliElegida.getTitulo(), peliElegida.getDescripcion());
				
			
			}
		});
		btnReservar.setBounds(198, 435, 225, 68);
		contentPane.add(btnReservar);
		
		
		JLabel lblConfirmacinReserva = new JLabel("CONFIRMACI\u00D3N DE RESERVA");
		lblConfirmacinReserva.setForeground(new Color(255, 255, 255));
		lblConfirmacinReserva.setBounds(32, 16, 347, 50);
		contentPane.add(lblConfirmacinReserva);
		
		JLabel lblInformacinPelicula = new JLabel("Informaci\u00F3n pelicula:");
		lblInformacinPelicula.setForeground(new Color(255, 255, 255));
		lblInformacinPelicula.setBounds(32, 70, 201, 28);
		contentPane.add(lblInformacinPelicula);
		
		JList list = new JList();
		list.setForeground(new Color(0, 0, 205));
		list.setBounds(46, 100, 347, 310);
		contentPane.add(list);
		
		
		
		String texto=separacionpelicula[1];
		
		separacionpelicula[1]="";
		DefaultListModel<String> modeloLista=new DefaultListModel<String>();
		for (int i = 0; i < separacionpelicula.length; i++) {
			modeloLista.addElement(separacionpelicula[i]);
			modeloLista.addElement("");
		}
		
		String[] segundaSepracion=texto.split(",");
		
		for (int i = 0; i < segundaSepracion.length; i++) {
			modeloLista.addElement(segundaSepracion[i]);
		}
		
		
		list.setModel(modeloLista);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(46, 100, 347, 310);
		contentPane.add(scrollPane);
	}
	
	public static String filtrarPeliculas(Pelicula peliculaPasada){
		File aFile=null;
		FileReader fr=null;
		BufferedReader buffer=null;
		String peliculaDevuelta=null;
		try {
			aFile = new File("peliculas.txt");
			fr = new FileReader(aFile);
			buffer = new BufferedReader(fr);
			
			String linea = buffer.readLine();
			
			while(linea != null){
				
				String[] arrayPelis = linea.split(";");
				if(arrayPelis[0].equals(peliculaPasada.getTitulo())){
					peliculaDevuelta = linea;
					
				}
				
				linea=buffer.readLine();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null){
					fr.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
		return peliculaDevuelta;
		
	}
	
	public static void escribirEntrada(String nombreUsuario,String hora,String numeroEntradas,String nombrePeli, String sinopsis){
		PrintWriter pw = null;
		FileWriter fw = null;
		try { 
			fw = new FileWriter("reservas.txt",true);
			pw = new PrintWriter(fw);
			
			pw.println(nombreUsuario+";"+hora+";"+numeroEntradas+";"+nombrePeli+";"+sinopsis);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(fw != null){
					fw.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
}
