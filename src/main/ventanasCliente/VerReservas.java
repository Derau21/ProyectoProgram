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
import java.awt.Font;

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
		setBounds(150, 50, 850, 600);
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
		scrollPane.setBounds(198, 76, 404, 323);
		contentPane.add(scrollPane);
		
		JButton btnAtrs = new JButton("ATR\u00C1S");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				VerReservas.this.setVisible(false);
				VerReservas.this.dispose();
			}
		});
		btnAtrs.setBounds(618, 450, 137, 47);
		contentPane.add(btnAtrs);
		
		
	}
}
