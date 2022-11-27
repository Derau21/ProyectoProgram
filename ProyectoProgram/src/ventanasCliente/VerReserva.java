package ventanasCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerReserva extends JFrame {

	private JPanel contentPane;
	private Reservas padre;

	
	public VerReserva(Reservas padre) {
		this.padre=padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Detalles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetallesReserva dr = new DetallesReserva(VerReserva.this);
				dr.setVisible(true);
				VerReserva.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(198, 300, 132, 63);
		contentPane.add(btnNewButton);
	}
}
