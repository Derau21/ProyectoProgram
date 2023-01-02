package main.ventanasAdministrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class General extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public General(Usuario usuarioIntroducido) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAnyadirPelicula = new JButton("Aniadir Pelicula");
		btnAnyadirPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnyadirPeliculas ap = new AnyadirPeliculas(General.this);
				ap.setVisible(true);
				General.this.setVisible(false);
			}
		});
		btnAnyadirPelicula.setBounds(57, 98, 176, 54);
		contentPane.add(btnAnyadirPelicula);

		JButton btnEliminarPelicula = new JButton("Eliminar Pelicula");
		btnEliminarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPelicula ep = new EliminarPelicula(General.this);
				ep.setVisible(true);
				General.this.setVisible(false);
			}
		});
		btnEliminarPelicula.setBounds(57, 174, 176, 54);
		contentPane.add(btnEliminarPelicula);

		JButton btnModificarHorarios = new JButton("Modificar horarios");
		btnModificarHorarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarHorarios mh = new ModificarHorarios(General.this);
				mh.setVisible(true);
				General.this.setVisible(false);

			}
		});
		btnModificarHorarios.setBounds(57, 263, 176, 54);
		contentPane.add(btnModificarHorarios);

		JButton btnGestionEconomica = new JButton("Gestion Economica");
		btnGestionEconomica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEconomica ge = new GestionEconomica(General.this);
				ge.setVisible(true);
				General.this.setVisible(false);
			}
		});
		btnGestionEconomica.setBounds(57, 345, 176, 54);
		contentPane.add(btnGestionEconomica);
	}
}
