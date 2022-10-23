package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clases.Pelicula;
import clases.Reserva;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VerReservas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @param reservas 
	 */
	public VerReservas(Reservas reservas, String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		ArrayList<Reserva> array=seleccioandorPelis(nombre);
		
		
		JLabel lblReservasHechas = new JLabel("RESERVAS HECHAS");
		lblReservasHechas.setForeground(new Color(255, 255, 255));
		lblReservasHechas.setBounds(66, 43, 214, 87);
		contentPane.add(lblReservasHechas);
		
		JList list = new JList();
		list.setBounds(45, 121, 334, 307);
		contentPane.add(list);
		
		DefaultListModel<Reserva> modeloLista=new DefaultListModel<>();
		for (int i = 0; i < array.size(); i++) {
			modeloLista.addElement(array.get(i));
		}
		
		list.setModel(modeloLista);
		
		JButton btnVerDetalles = new JButton("VER DETALLES ");
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetallesReserva dr = new DetallesReserva(VerReservas.this,(Reserva)list.getSelectedValue());
				dr.setVisible(true);
				VerReservas.this.setVisible(false);
			}
		});
		btnVerDetalles.setBounds(417, 261, 178, 87);
		contentPane.add(btnVerDetalles);
		
		btnVerDetalles.setEnabled(false);
		
		list.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				btnVerDetalles.setEnabled(true);
				
			}
		});
				
	}
	
	public static ArrayList<Reserva> seleccioandorPelis(String nombreUsuario){
		ArrayList<Reserva> reservasRealizadas=new ArrayList<Reserva>();
		File aFile=null;
		FileReader fr=null;
		BufferedReader bf=null;
		try {
			aFile = new File("reservas.txt");
			fr = new FileReader(aFile);
			bf = new BufferedReader(fr);
			
			String linea=bf.readLine();
			
			while(linea!=null){
				String[] separacion=linea.split(";");
				//usuario,hora,numEntradas,titulo,descripcion
				if(separacion[0].equals(nombreUsuario)){
					Pelicula peli = new Pelicula(separacion[3], separacion[4]);
					Reserva r = new Reserva(peli, separacion[1],Integer.parseInt(separacion[2]) , separacion[0]);
					reservasRealizadas.add(r);
				}
				linea=bf.readLine();
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
		return reservasRealizadas;
	}

}
