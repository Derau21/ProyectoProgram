package main.ventanasAdministrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.clases.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class General extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public General(Usuario usuarioIntroducido) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAnyadirPelicula = new JButton("Aniadir Pelicula");
		btnAnyadirPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAnyadirPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnyadirPeliculas ap = new AnyadirPeliculas(General.this);
				ap.setVisible(true);
				General.this.setVisible(false);
			}
		});
		btnAnyadirPelicula.setBounds(274, 80, 251, 88);
		contentPane.add(btnAnyadirPelicula);

		JButton btnEliminarPelicula = new JButton("Eliminar Pelicula");
		btnEliminarPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPelicula ep = new EliminarPelicula(General.this);
				ep.setVisible(true);
				General.this.setVisible(false);
			}
		});
		btnEliminarPelicula.setBounds(274, 201, 251, 88);
		contentPane.add(btnEliminarPelicula);

		JButton btnModificarHorarios = new JButton("Modificar horarios");
		btnModificarHorarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificarHorarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarHorarios mh = new ModificarHorarios(General.this);
				mh.setVisible(true);
				General.this.setVisible(false);

			}
		});
		btnModificarHorarios.setBounds(274, 323, 251, 95);
		contentPane.add(btnModificarHorarios);
	}
}
