package ventanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AñadirPeliculas extends JFrame {
	
	private JPanel contentPane;
	private General padre;
	
	
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public AñadirPeliculas(General padre) {
		this.padre=padre;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
