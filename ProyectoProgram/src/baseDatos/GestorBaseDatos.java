package baseDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


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
	
	public void insertar(String nombre, String pelicula, int numeroEntradas, int importe) {
		String sql="insert into reservas(nombre, pelicula, numeroEntradas, importe) values (?, ?, ?, ?)";
		try (Connection conn=this.conectar(); PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setString(1, nombre); 
			pstmt.setString(2, pelicula);
			pstmt.setInt(3, numeroEntradas);
			pstmt.setInt(4, importe);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
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
			gestor.createTable();
			gestor.insertar("Bastiaan", "Forrest Gump", 2, 20);
			gestor.insertar("Alex", "La vida es Bella", 8, 80);
			gestor.insertar("Pablo", "Salvando al Soldado Ryan", 3, 30);
			gestor.insertar("Unai", "Jumanji", 4, 40);
			gestor.insertar("Ander", "La lista de Schiendler", 5, 50);
			gestor.insertar("Adrian", "El pianista", 2, 20);
			
		}
	
	
	

}