package main.ventanasCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Reserva;
import main.constantes.Constantes;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.stream.Collectors;

public class DetallesReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame padre;
	
	Reserva reserva;

	
	
	public DetallesReserva(JFrame padre, Reserva reserva) {
		this.padre = padre;
		this.reserva = reserva;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombrePelicula = new JLabel("ˇFelicidades, asistiras a " + reserva.getPeli() + " !" );
		lblNombrePelicula.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNombrePelicula.setBounds(181, 98, 463, 135);
		contentPane.add(lblNombrePelicula);
		
		String asientosReservados = reserva.getAsientos().stream().collect(Collectors.joining(", "));
		
		
		JLabel lblAsientos = new JLabel("Asientos: " + asientosReservados);
		lblAsientos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAsientos.setBounds(74, 277, 387, 73);
		contentPane.add(lblAsientos);
		
		JLabel lblPrecio = new JLabel("Precio: " + reserva.calcularCosteTotal(Constantes.PRECIOENTRADA) );
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrecio.setBounds(74, 384, 172, 73);
		contentPane.add(lblPrecio);
		
		JLabel lblHora = new JLabel("Hora de comienzo: " +reserva.getHora());
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHora.setBounds(74, 219, 328, 47);
		contentPane.add(lblHora);
	}
}
