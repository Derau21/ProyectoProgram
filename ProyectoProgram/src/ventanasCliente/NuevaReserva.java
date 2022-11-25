package ventanasCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class NuevaReserva extends JFrame {

	private JPanel contentPane;
	private Reservas padre;
	
	public NuevaReserva(Reservas padre) {
		this.padre=padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("reserva");
		btnNewButton.setBounds(135, 113, 89, 23);
		contentPane.add(btnNewButton);
	}
}
