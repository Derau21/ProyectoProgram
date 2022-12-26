package main.ventanasCliente;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AsientosTableModel extends DefaultTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private String [][] sala = null;

    private final List<String> alfabeto = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    public AsientosTableModel(int filas, int columnas) {
        sala = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sala[i][j] = String.valueOf(i+1) + alfabeto.get(j);
            }
        }
    }

    public void inicializarSala(int filas, int columnas) {

        sala = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sala[i][j] = String.valueOf(i+1) + alfabeto.get(j);
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

