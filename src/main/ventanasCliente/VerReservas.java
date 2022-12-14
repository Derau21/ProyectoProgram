package main.ventanasCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import main.baseDatos.GestorBaseDatos;
import main.clases.Cliente;
import main.clases.Reserva;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class VerReservas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Menu padre;
	private JTable table;
	private VerReservaTableModel tableModel;
	private Cliente cliente;

	public VerReservas(Menu padre, Cliente cliente) {
		this.padre = padre;
		this.cliente = cliente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		List<Reserva> reservas = GestorBaseDatos.leerReservasDeCliente(cliente);
		tableModel = new VerReservaTableModel(reservas);
		
		
		table = new JTable();
		table.setModel(tableModel);
		//table.setBounds(118, 80, 360, 323);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(118, 80, 404, 323);
		contentPane.add(scrollPane);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				VerReservas.this.setVisible(false);
				VerReservas.this.dispose();
			}
		});
		btnAtrs.setBounds(10, 411, 89, 23);
		contentPane.add(btnAtrs);
		
		
	}
}
