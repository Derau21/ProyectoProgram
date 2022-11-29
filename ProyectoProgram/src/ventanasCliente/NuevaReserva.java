package ventanasCliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import clases.Pelicula;
import clases.Reserva;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class NuevaReserva extends JFrame {

	private JPanel contentPane;
	private Reservas padre;
	private JList list;
	private Pelicula peli;
	private DefaultListModel<Pelicula> defaulListModel;
	
	public NuevaReserva(Reservas padre) {
		this.padre=padre;
		this.peli=peli;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblSeleccioneHorario = new JLabel("Seleccione horario");
		lblSeleccioneHorario.setFont(new Font("Serif", Font.BOLD, 18));
		lblSeleccioneHorario.setBounds(15, 74, 163, 25);
		contentPane.add(lblSeleccioneHorario);

		JLabel lblIndiqueCuantosAsientos = new JLabel("Indique cuantos asientos desea");
		lblIndiqueCuantosAsientos.setFont(new Font("Serif", Font.BOLD, 18));
		lblIndiqueCuantosAsientos.setBounds(15, 150, 239, 25);
		contentPane.add(lblIndiqueCuantosAsientos);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(216, 73, 72, 26);
		contentPane.add(comboBox);
		String[] opciones = { "16:30", "18:30", "20:30" };
		comboBox.setModel(new DefaultComboBoxModel(opciones));

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(291, 150, 72, 26);
		contentPane.add(comboBox_1);
		String[] opciones2 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };// maximo
																					// se
																					// podran
																					// reservar
																					// 10
																					// entradad
		comboBox_1.setModel(new DefaultComboBoxModel(opciones2));

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reserva r = new Reserva(Integer.parseInt(comboBox_1.getSelectedItem() + ""),
						(comboBox.getSelectedItem() + ""), peli);
				SeleccionHorarioYEntradas Nr = new SeleccionHorarioYEntradas(NuevaReserva.this, r);
				Nr.setVisible(true);
				NuevaReserva.this.setVisible(false);

			}
		});
		btnAceptar.setBounds(63, 199, 115, 29);
		contentPane.add(btnAceptar);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				NuevaReserva.this.setVisible(false);
				NuevaReserva.this.dispose();
			}
		});
		btnAtrs.setBounds(248, 199, 115, 29);
		contentPane.add(btnAtrs);

		JLabel lblElPrecioDe = new JLabel("El precio de cada entrada son: 10\u20AC");
		lblElPrecioDe.setFont(new Font("Serif", Font.BOLD, 18));
		lblElPrecioDe.setBounds(63, 16, 283, 25);
		contentPane.add(lblElPrecioDe);

		
	}
}
