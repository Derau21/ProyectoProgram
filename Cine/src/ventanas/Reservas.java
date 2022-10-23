package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Reservas extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 * @param login 
	 */
	public Reservas(Login login,String nombreUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerResrvas = new JButton("VER RESRVAS");
		btnVerResrvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerReservas vr = new VerReservas(Reservas.this,nombreUsuario);
				vr.setVisible(true);
				Reservas.this.setVisible(false);
				
			}
		});
		btnVerResrvas.setBounds(72, 200, 195, 78);
		contentPane.add(btnVerResrvas);
		
		JButton btnReservarPelicula = new JButton("RESERVAR PELICULA");
		btnReservarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cartelera c = new Cartelera(Reservas.this,nombreUsuario);
				c.setVisible(true);
				Reservas.this.setVisible(false);
			}
		});
		btnReservarPelicula.setBounds(329, 200, 195, 78);
		contentPane.add(btnReservarPelicula);
	}

}
