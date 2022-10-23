package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.Reserva;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DetallesReserva extends JFrame {

	private JPanel contentPane;
	private VerReservas padre;
	private Reserva res;
	

	/**
	 * Create the frame.
	 * @param object 
	 * @param verReservas 
	 */
	public DetallesReserva(VerReservas padre, Reserva res) {
		
		this.padre = padre;
		this.res = res;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la pelicula:");
		lblNombreDeLa.setForeground(new Color(255, 255, 255));
		lblNombreDeLa.setBounds(48, 58, 239, 56);
		contentPane.add(lblNombreDeLa);
		
		JLabel lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setForeground(new Color(255, 255, 255));
		lblSinopsis.setBounds(48, 263, 247, 78);
		contentPane.add(lblSinopsis);
		
		JLabel lblNumeroDeEntradas = new JLabel("Numero de entradas:");
		lblNumeroDeEntradas.setForeground(new Color(255, 255, 255));
		lblNumeroDeEntradas.setBounds(48, 142, 239, 46);
		contentPane.add(lblNumeroDeEntradas);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setForeground(new Color(255, 255, 255));
		lblHora.setBounds(48, 214, 181, 44);
		contentPane.add(lblHora);
		
		JLabel lblNewLabel = new JLabel(res.getHora());
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(287, 208, 181, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(res.getPeli().getTitulo());
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(287, 53, 325, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(res.getNumeroDeEntradas()+"");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(287, 126, 205, 78);
		contentPane.add(lblNewLabel_2);
		
		JTextArea txtAreaDescripcion = new JTextArea(res.getPeli().getDescripcion());
		txtAreaDescripcion.setLineWrap(true);
		txtAreaDescripcion.setWrapStyleWord(true);
		
		txtAreaDescripcion.setForeground(new Color(255, 255, 255));
		txtAreaDescripcion.setBounds(276, 292, 387, 159);
		txtAreaDescripcion.setOpaque(false);
		contentPane.add(txtAreaDescripcion);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				DetallesReserva.this.setVisible(false); 
				DetallesReserva.this.dispose(); 
			}
		});
		btnVolver.setBounds(48, 393, 162, 46);
		contentPane.add(btnVolver);
	}
}
