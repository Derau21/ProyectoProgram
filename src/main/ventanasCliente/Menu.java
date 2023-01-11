package main.ventanasCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private Cliente cliente;
	
	public Menu(Cliente  cliente) {
		
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevaReserva = new JButton("Nueva Reserva");
		btnNuevaReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNuevaReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevaReserva nr = new NuevaReserva(Menu.this, cliente);
				nr.setVisible(true);
				Menu.this.setVisible(false);
			}
		});
		btnNuevaReserva.setBounds(251, 179, 233, 92);
		contentPane.add(btnNuevaReserva);
		
		JButton btnVerReservas = new JButton("Ver Reservas");
		btnVerReservas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerReservas vr = new VerReservas(Menu.this, cliente);
				vr.setVisible(true);
				Menu.this.setVisible(false);
			}
		});
		btnVerReservas.setBounds(251, 298, 233, 92);
		contentPane.add(btnVerReservas);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(140, 95, 233, 67);
		contentPane.add(lblNewLabel);
	}
}
