package baseDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.Pelicula;


public class GestorBaseDatos {
	private Connection conn;
	public static  Logger logger = null;
	
	private Connection conectar() { 
		Connection conn = null;
		String url = "jdbc:sqlite:BDProyecto.db"; 
		try {
			conn = DriverManager.getConnection(url);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
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

	public void createTable () {
		String sql= "Create table if not exists reservas (nombre text primary key, pelicula text not null, numeroEntradas int not null, importe int not null )";		
		try(Connection conn=this.conectar(); Statement stmt= conn.createStatement()) {
			stmt.execute(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createTablePelicula () {
		String sql= "Create table if not exists Pelicula (Genero text not null, Nombre text primary key, Duracion int not null )";		
		try(Connection conn=this.conectar(); Statement stmt= conn.createStatement()) {
			stmt.execute(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertarPelicula(Pelicula p) {
		String genero = p.getGenero();
		String nombre = p.getNombre();
		int duracion = p.getDuracion();
		
		try(Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")){
			
			try(PreparedStatement ps = conn.prepareStatement("INSERT INTO PELICULA VALUES (?,?,?)")){
				ps.setString(1,genero);
				ps.setString(2,nombre);
				ps.setInt(3,duracion);
				
				ps.executeUpdate();
				
				
			}catch(SQLException e1) {
				logger.log(Level.WARNING, "El prepared statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();// preguntar si se puede cerrar asi
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();
		}
	}


	public static ArrayList<Pelicula> leerPeliculas() {

		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (Statement s = conn.createStatement()) {

				try (ResultSet rs = s.executeQuery("SELECT genero, nombre, duracion FROM PELICULA")) {

					while (rs.next()) {

						String genero = rs.getString("genero");
						String nombre = rs.getString("nombre");
						int duracion = rs.getInt("duracion");

						Pelicula p = new Pelicula(genero, nombre, duracion);

						peliculas.add(p);
					}
					conn.close();

				}

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();// preguntar si se puede cerrar asi
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();

		}

		return peliculas;

	}
 
	
	public static ArrayList<Pelicula> leerPeliculasGenero(String condicionGenero) { //ejemplo condicion (where)

		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BDProyecto.db")) {

			try (Statement s = conn.createStatement()) {

				try (ResultSet rs = s.executeQuery("SELECT genero, nombre, duracion FROM PELICULA WHERE genero = " + condicionGenero)) {
						//preguntar si se puede hacer asi
					while (rs.next()) {

						String genero = rs.getString("genero");
						String nombre = rs.getString("nombre");
						int duracion = rs.getInt("duracion");

						Pelicula p = new Pelicula(genero, nombre, duracion);

						peliculas.add(p);
					}
					conn.close();

				}

			} catch (SQLException e1) {
				logger.log(Level.WARNING, "El statement no se ha creado bien", e1);
				e1.printStackTrace();
			}
			conn.close();// preguntar si se puede cerrar asi
		} catch (SQLException e2) {
			logger.log(Level.WARNING, "La conexion no se ha creado correctamente", e2);
			e2.printStackTrace();

		}

		return peliculas;

	}


	
	
	

//	public void insertar(String nombre, String pelicula, int numeroEntradas, int importe) {
//		String sql="insert into reservas(nombre, pelicula, numeroEntradas, importe) values (?, ?, ?, ?)";
//		try (Connection conn=this.conectar(); PreparedStatement pstmt= conn.prepareStatement(sql)){
//			pstmt.setString(1, nombre); 
//			pstmt.setString(2, pelicula);
//			pstmt.setInt(3, numeroEntradas);
//			pstmt.setInt(4, importe);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	
	
	public void setLogger( Logger logger ) {
		this.logger = logger;
		}
		
		private void log(Level level, String msg, Throwable excepcion) {
			if (logger==null) {  // Logger por defecto local:
				logger = Logger.getLogger( "BD-Local" );  // Nombre del logger
				logger.setLevel(Level.ALL);  // Loguea todos los niveles
				try {
					logger.addHandler(new FileHandler("bd.log.xml", true));  // Y saca el log a fichero xml
				} catch (Exception e) {
					logger.log(Level.SEVERE, "No se pudo crear fichero de log", e);
				}
			}
			if (excepcion==null)
				logger.log(level, msg);
			else
				logger.log(level, msg, excepcion);
		}
	

		public static void main(String[] args) {
			GestorBaseDatos gestor= new GestorBaseDatos();
			gestor.conectar();
			
			gestor.createTablePelicula();
			
			
			
		}
	
	
	

}