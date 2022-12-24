package main.ventanasCliente;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import main.clases.Reserva;

public class SeleccionAsientos extends JFrame {

	private JPanel contentPane;

	private List<String> butacasSeleccionadas;

	public SeleccionAsientos(NuevaReserva nuevaReserva, Reserva r) {

		butacasSeleccionadas = new ArrayList<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		AsientosTableModel tableModel = new AsientosTableModel(5, 6);
//		tableModel.inicializarSala(5,8);
		JTable table = new JTable(tableModel);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				butacasSeleccionadas = new ArrayList<>();

				int[] selectedRows = table.getSelectedRows();
				int[] selectedColumns = table.getSelectedColumns();

				for (int i = 0; i < selectedRows.length; i++) {
					for (int j = 0; j < selectedColumns.length; j++) {
						butacasSeleccionadas.add((String) table.getValueAt(selectedRows[i], selectedColumns[j]));
					}
				}

				System.out.println(butacasSeleccionadas);
			}

		});


		contentPane.add(table);

		setContentPane(contentPane);
	}

}
