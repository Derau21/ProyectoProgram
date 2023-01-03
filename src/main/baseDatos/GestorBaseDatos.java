package main.baseDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import main.clases.Cliente;
import main.clases.Pelicula;
import main.clases.Reserva;

public class GestorBaseDatos {

	private Connection conn;
	public static Logger logger = Logger.getLogger("BaseDatos");

	private static Connection conectar() {
		Connection conn = null;
		String url = "jdbc:sqlite:BDProyecto.db";
		try {
			conn = DriverManager.getConnection(url);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void configurarBD() {

		// Crear Tablas si no existen
		createTablePelicula();
		createTableReservas();

		// Cargar Tabla
		cargarTablaPeliculas();
	}

	public static void createNewDatabase(String fileName) {
		String url = "jdbc:sqlite:" + fileName;
		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				logger.log(Level.INFO, "The driver name is " + meta.getDriverName());
				logger.log(Level.INFO, "A new database has been created.");
			}
		} catch (SQLException e) {
			logger.log(Level.WARNING, "No se pudo crear la base de datos", e);
		}
	}

	public static void createTableReservas() {
		String sql = "Create table if not exists reservas (id int primary key, hora text not null, nombrePelicula int, nombreUsuario  not null, asientos text not null,  FOREIGN KEY (nombrePelicula) references pelicula (nombrePelicula))";
		try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
			//stmt.executeUpdate("DROP TABLE IF EXISTS reservas");
			stmt.execute(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createTablePelicula() {
		String sql = "Create table if not exists pelicula (nombrePelicula text primary key, genero text not null, duracion int not null )";
		try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
			//stmt.executeUpdate("DROP TABLE IF EXISTS pelicula");
			stmt.execute(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void cargarTablaPeliculas() {

		Pelicula piratas = leerPeliculaPorNombre("Piratas del caribe");
		if (piratas == null) {
			logger.log(Level.INFO, "Insertando pelicula piratas");
			piratas = new Pelicula("Accion", "Piratas del caribe", 145);
			insertarPelicula(piratas);
		}
		Pelicula homlet = leerPeliculaPorNombre("Homlet");
		if (homlet == null) {
			logger.log(Level.INFO, "Insertando pelicula piratas");
			homlet = new Pelicula("Terror", "Homlet", 120);
			insertarPelicula(homlet);
		}

		Pelicula mrBean = leerPeliculaPorNombre("Mr Bean");
		if (mrBean == null) {
			logger.log(Level.INFO, "Insertando pelicula piratas");
			mrBean = new Pelicula("Comedia", "Mr Bean", 100);
			insertarPelicula(mrBean);
		}
	}

	public static void insertarPelicula(Pelicula p) {

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (PreparedStatement ps = conn.prepareStatement("INSERT INTO PELICULA VALUES (?,?,?)")) {
				ps.setString(1, p.getNombre());
				ps.setString(2, p.getGenero());
				ps.setInt(3, p.getDuracion());

				ps.executeUpdate();

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El prepared statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();
			
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();
		}
	}

	public static ArrayList<Pelicula> leerPeliculas() {

		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (Statement s = conn.createStatement()) {

				try (ResultSet rs = s.executeQuery("SELECT genero, nombrePelicula, duracion FROM PELICULA")) {

					while (rs.next()) {

						String genero = rs.getString("genero");
						String nombre = rs.getString("nombrePelicula");
						int duracion = rs.getInt("duracion");

						Pelicula p = new Pelicula(genero, nombre, duracion);

						peliculas.add(p);
					}

				}

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();

		}

		return peliculas;

	}

	public static ArrayList<Pelicula> leerPeliculasGenero(String condicionGenero) { // ejemplo condicion (where)

		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (Statement s = conn.createStatement()) {

				try (ResultSet rs = s.executeQuery(
						"SELECT genero, nombrePelicula, duracion FROM PELICULA WHERE genero = " + condicionGenero)) {
					
					while (rs.next()) {

						String genero = rs.getString("genero");
						String nombre = rs.getString("nombrePelicula");
						int duracion = rs.getInt("duracion");

						Pelicula p = new Pelicula(genero, nombre, duracion);

						peliculas.add(p);
					}

				}

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();

		}

		return peliculas;
	}

	public static Pelicula leerPeliculaPorNombre(String nombrePelicula) {

		Pelicula pelicula = null;

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (PreparedStatement ps = conn.prepareStatement(
					"SELECT genero, nombrePelicula, duracion FROM PELICULA WHERE nombrePelicula = ?")) {
				ps.setString(1, nombrePelicula);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					String genero = rs.getString("genero");
					String nombre = rs.getString("nombrePelicula");
					int duracion = rs.getInt("duracion");

					pelicula = new Pelicula(genero, nombre, duracion);
				}

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();
		}

		return pelicula;
	}

	public static void insertarReserva(Reserva reserva) {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			int numeroFilas;

			try (Statement s = conn.createStatement()) {
				try (ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM reservas")) {
					numeroFilas = rs.getInt(1);
				}

			}
			try (PreparedStatement ps = conn.prepareStatement("INSERT INTO reservas VALUES (?,?,?,?,?)")) {
				ps.setInt(1, numeroFilas + 1);
				ps.setString(2, reserva.getHora());
				ps.setString(3, reserva.getPeli().getNombre());
				ps.setString(4, reserva.getCliente().getUsername());
				// convierte una lista en un string separado por comas
				String asientos = reserva.getAsientos().stream().collect(Collectors.joining(","));
				ps.setString(5, asientos);

				ps.executeUpdate();

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El prepared statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();
		}

	}

	public static List<String> leerAsientosOcupados(String nombrePelicula, String horarioPelicula) {

		List<String> asientosOcupados = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (PreparedStatement ps = conn.prepareStatement("SELECT asientos FROM reservas WHERE hora = ? AND nombrePelicula = ?")) {
				ps.setString(1, horarioPelicula);
				ps.setString(2, nombrePelicula);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					String asientos = rs.getString("asientos");

					List<String> asientosList = Arrays.asList(asientos.split(","));

					asientosOcupados.addAll(asientosList);
				}

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();

		}

		return asientosOcupados;
	}
	
	public static List<Reserva> leerReservasDeCliente(Cliente cliente){
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservas WHERE nombreUsuario = ?")) {
				ps.setString(1, cliente.username);
				

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					String asientos = rs.getString("asientos");
					List<String> asientosList = Arrays.asList(asientos.split(","));
					
					String usuario = rs.getString("nombreUsuario");
					String peli = rs.getString("nombrePelicula");
					Pelicula pelicula = new Pelicula(peli);
					String hora = rs.getString("hora");
					
					Reserva reserva = new Reserva(asientosList, hora, pelicula, cliente);
					
					reservas.add(reserva);				
				}

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();
		} catch(SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();
		}
		
		return reservas;
	}
	
	
	
	public static void delete (String nombrePelicula) {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (PreparedStatement ps = conn.prepareStatement("DELETE FROM pelicula WHERE nombrePelicula = ?")) {
				ps.setString(1, nombrePelicula);
				ps.executeUpdate();

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El prepared statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();
		}
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	private void log(Level level, String msg, Throwable excepcion) {
		if (logger == null) { // Logger por defecto local:
			logger = Logger.getLogger("BD-Local"); // Nombre del logger
			logger.setLevel(Level.ALL); // Loguea todos los niveles
			try {
				logger.addHandler(new FileHandler("bd.log.xml", true)); // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log(Level.SEVERE, "No se pudo crear fichero de log", e);
			}
		}
		if (excepcion == null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}

}