package main.ventanasCliente;

import javax.swing.table.DefaultTableModel;

import main.constantes.Constantes;

import java.util.Arrays;
import java.util.List;

public class AsientosTableModel extends DefaultTableModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String[][] sala = null;

	private final List<String> alfabeto = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

	public AsientosTableModel(int filas, int columnas, List<String> asientosOcupados) {
		sala = new String[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				String butaca = String.valueOf(i + 1) + alfabeto.get(j);
				if (asientosOcupados.contains(butaca)) {
					sala[i][j] = Constantes.ASIENTO_OCUPADO;
				} else {
					sala[i][j] = butaca;
				}

			}
		}
	}


	@Override
	public int getRowCount() {
		if (sala == null) {
			return 0;
		}

		return sala.length;
	}

	@Override
	public int getColumnCount() {
		if (sala == null) {
			return 0;
		}
		return sala[0].length;
	}

	@Override
	public String getColumnName(int column) {
		return String.valueOf(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return sala[row][column];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
