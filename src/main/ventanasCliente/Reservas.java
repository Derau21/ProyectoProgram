package main.ventanasCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reservas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private Cliente cliente;
	
	public Reservas(Cliente  cliente) {
		
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevaReserva = new JButton("Nueva Reserva");
		btnNuevaReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevaReserva nr = new NuevaReserva(Reservas.this, cliente);
				nr.setVisible(true);
				Reservas.this.setVisible(false);
			}
		});
		btnNuevaReserva.setBounds(30, 58, 171, 59);
		contentPane.add(btnNuevaReserva);
		
		JButton btnVerReservas = new JButton("Ver Reservas");
		btnVerReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerReserva vr = new VerReserva(Reservas.this);
				vr.setVisible(true);
				Reservas.this.setVisible(false);
			}
		});
		btnVerReservas.setBounds(30, 159, 171, 59);
		contentPane.add(btnVerReservas);
	}
}
