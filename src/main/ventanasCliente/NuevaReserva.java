package main.ventanasCliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import main.clases.Cliente;
import main.clases.Pelicula;
import main.clases.Reserva;
import main.baseDatos.GestorBaseDatos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class NuevaReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Menu padre;
	private JList<Pelicula> list;
	private Cliente cliente;

	public NuevaReserva(Menu padrel, Cliente cliente) {
		this.padre = padre;
		this.cliente = cliente;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSeleccioneHorario = new JLabel("Seleccione horario");
		lblSeleccioneHorario.setFont(new Font("Serif", Font.BOLD, 18));
		lblSeleccioneHorario.setBounds(15, 228, 163, 25);
		contentPane.add(lblSeleccioneHorario);

		JComboBox horariosComboBox = new JComboBox();
		horariosComboBox.setBounds(217, 230, 72, 26);
		contentPane.add(horariosComboBox);
		String[] opciones = { "16:30", "18:30", "20:30" };
		horariosComboBox.setModel(new DefaultComboBoxModel(opciones));

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula peliculaSeleccionada = list.getSelectedValue();
				if (peliculaSeleccionada != null) {
					Reserva r = new Reserva(list.getSelectedValue(), (String) horariosComboBox.getSelectedItem(),
							cliente);
					SeleccionAsientos seleccionAsientos = new SeleccionAsientos(NuevaReserva.this, r);
					seleccionAsientos.setVisible(true);
					NuevaReserva.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Elige una pelicula");
				}
				

			}
		});
		btnAceptar.setBounds(63, 309, 115, 29);
		contentPane.add(btnAceptar);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				NuevaReserva.this.setVisible(false);
				NuevaReserva.this.dispose();
			}
		});
		btnAtrs.setBounds(238, 309, 115, 29);
		contentPane.add(btnAtrs);

		JLabel lblElPrecioDe = new JLabel("El precio de cada entrada son: 10\u20AC");
		lblElPrecioDe.setFont(new Font("Serif", Font.BOLD, 18));
		lblElPrecioDe.setBounds(70, 46, 283, 25);
		contentPane.add(lblElPrecioDe);

		JLabel lblSeleccioneHorario_1 = new JLabel("Seleccione pelicula:");
		lblSeleccioneHorario_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblSeleccioneHorario_1.setBounds(15, 104, 163, 25);
		contentPane.add(lblSeleccioneHorario_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 108, 108, 111);
		contentPane.add(scrollPane);

		// inicializar Jlist
		list = new JList<Pelicula>();
		scrollPane.setViewportView(list);

		// cargamos el Jlist con datos utilizando el metodo
		cargarJList(list);
		list.setVisible(true);

	}

	public void cargarJList(JList<Pelicula> jList) {

		// cargar lista de peliculas
		ArrayList<Pelicula> peliculas = GestorBaseDatos.leerPeliculas();

		// inicializar el defaultlistmodel
		DefaultListModel<Pelicula> model = new DefaultListModel<Pelicula>();

		// anyadimos cada pelicula al defaultlistmodel
		for (Pelicula pelicula : peliculas) {
			model.addElement(pelicula);
		}

		// anyadimos el model a la lista
		list.setModel(model);

	}
}
