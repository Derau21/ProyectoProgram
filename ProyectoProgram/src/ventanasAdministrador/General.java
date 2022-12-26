package ventanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import ventanaInicial.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class General extends JFrame {

	private JPanel contentPane;
	


	public General(Usuario usuarioIntroducido) {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnA�adirPelicula = new JButton("A�adir Pelicula");
		btnA�adirPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A�adirPeliculas ap = new A�adirPeliculas(General.this);
				ap.setVisible(true);
				General.this.setVisible(false);
			}
		});
		btnA�adirPelicula.setBounds(57, 98, 176, 54);
		contentPane.add(btnA�adirPelicula);
		
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
		
		JButton btnGestionEcon�mica = new JButton("Gesti�n Econ�mica");
		btnGestionEcon�mica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEconomica ge = new GestionEconomica(General.this);
				ge.setVisible(true);
				General.this.setVisible(false);
			}
		});
		btnGestionEcon�mica.setBounds(57, 345, 176, 54);
		contentPane.add(btnGestionEcon�mica);
	}
}
