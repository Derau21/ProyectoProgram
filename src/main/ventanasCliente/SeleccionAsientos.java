package main.ventanasCliente;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import main.baseDatos.GestorBaseDatos;
import main.clases.Reserva;
import main.constantes.Constantes;
import main.ventanaInicial.Login;
import main.ventanasAdministrador.CrearAdministrador;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SeleccionAsientos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel asientosSeleccionadosLabel;
	private JLabel precioLabel;
	private JTable table;
	private JLabel pantallaLabel;
	private JLabel lblNewLabel;
	private NuevaReserva padre;

	private List<String> asientosOcupados;

	private Reserva reserva;

	private final Integer precioEntrada = 10;
	private JButton btnNewButton_1;

	public SeleccionAsientos(NuevaReserva padre, Reserva reserva) {
		this.padre= padre;
		this.reserva = reserva;

		asientosOcupados = GestorBaseDatos.leerAsientosOcupados(reserva.getPeli().getNombre(), reserva.getHora());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		AsientosTableModel tableModel = new AsientosTableModel(5, 6, asientosOcupados);
		table = new JTable(tableModel);
		table.setBounds(179, 61, 450, 5 * 35);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		table.setRowHeight(35);

		table.getColumnModel().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				cambiarAsientosSeleccionados();
			}

		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				cambiarAsientosSeleccionados();
			}

		});

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		contentPane.add(table);
		// renderer
		

		setContentPane(contentPane);

		asientosSeleccionadosLabel = new JLabel("Asientos seleccionados: ");
		asientosSeleccionadosLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		asientosSeleccionadosLabel.setBounds(23, 310, 500, 70);
		contentPane.add(asientosSeleccionadosLabel);

		precioLabel = new JLabel("Precio: ");
		precioLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		precioLabel.setBounds(575, 310, 200, 70);
		contentPane.add(precioLabel);

		JButton btnNewButton = new JButton("Completar Reserva");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorBaseDatos.insertarReserva(reserva);
				DetallesReserva dr = new DetallesReserva(SeleccionAsientos.this, reserva);
				dr.setVisible(true);
				SeleccionAsientos.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(295, 380, 200, 70);
		contentPane.add(btnNewButton);

		pantallaLabel = new JLabel("Pantalla");
		pantallaLabel.setBackground(Color.WHITE);
		pantallaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pantallaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pantallaLabel.setBounds(252, 11, 301, 42);
		pantallaLabel.setOpaque(true);

		pantallaLabel.setBackground(Color.BLACK);
		pantallaLabel.setForeground(Color.WHITE);

		contentPane.add(pantallaLabel);

		lblNewLabel = new JLabel("Pelicula: " + reserva.getPeli().getNombre());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(252, 274, 290, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnAtrs = new JButton("ATR\u00C1S");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				SeleccionAsientos.this.setVisible(false);
				SeleccionAsientos.this.dispose();
			}
		});
		btnAtrs.setBounds(622, 462, 149, 58);
		contentPane.add(btnAtrs);

	}

	private void cambiarAsientosSeleccionados() {
		List<String> butacasSeleccionadas = new ArrayList<String>();

		int[] selectedRows = table.getSelectedRows();
		int[] selectedColumns = table.getSelectedColumns();

		for (int i = 0; i < selectedRows.length; i++) {
			for (int j = 0; j < selectedColumns.length; j++) {
				butacasSeleccionadas.add((String) table.getValueAt(selectedRows[i], selectedColumns[j]));
			}
		}

		if (asientosEstanLibres(butacasSeleccionadas)) {
			reserva.setAsientos(butacasSeleccionadas);
			// convierte una lista en un string separado por comas
			String asientosSeleccionados = butacasSeleccionadas.stream().collect(Collectors.joining(", "));
			asientosSeleccionadosLabel.setText("Asientos seleccionados: " + asientosSeleccionados);
			precioLabel.setText("Precio: " + reserva.calcularCosteTotal(Constantes.PRECIOENTRADA) + "€");
		} else {

			reserva.setAsientos(null);
			JOptionPane.showMessageDialog(contentPane, "Estos asientos estan ocupados");
			asientosSeleccionadosLabel.setText("Asientos seleccionados: ");
			precioLabel.setText("Precio: ");
			table.getSelectionModel().clearSelection();
		}

	}

	private boolean asientosEstanLibres(List<String> butacasSeleccionadas) {

		// disjoint devuelve true si las 2 listas no tienen elementos en común--> están
		// libres
		
		if (butacasSeleccionadas.contains(Constantes.ASIENTO_OCUPADO)) {
			return false;
		}
		
		return true;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionAsientos frame = new SeleccionAsientos(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
