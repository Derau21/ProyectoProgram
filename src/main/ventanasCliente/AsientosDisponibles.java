package main.ventanasCliente;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AsientosDisponibles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public AsientosDisponibles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
