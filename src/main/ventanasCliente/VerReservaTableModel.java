package main.ventanasCliente;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


import main.clases.Reserva;

public class VerReservaTableModel extends AbstractTableModel {
	
	private final List<String> headers = Arrays.asList("Pelicula", "Hora", "Asientos");
	
	private List<Reserva> reservas;
	
	
	public VerReservaTableModel(List<Reserva> reservas){
		this.reservas = reservas;
	}
	
	@Override
	public int getRowCount() {
		return reservas.size();
	}

	@Override
	public int getColumnCount() {
		return headers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Reserva reserva = reservas.get(rowIndex);
		switch(columnIndex) {
			case 0: return reserva.getPeli().getNombre();
			case 1: return reserva.getHora();
			case 2:String asientosSeleccionados = reserva.getAsientos().stream().collect(Collectors.joining(", "));
					return asientosSeleccionados;
			default: return null;
		}
	}
	
	
	@Override
	public String getColumnName(int column) {
		return headers.get(column);
	}

}
	
