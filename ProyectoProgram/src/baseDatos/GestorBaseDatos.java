package baseDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBaseDatos {

	public static void createNewDatabase(String fileName) { // para crear base de datos
		String url = "jdbc:sqlite:" + fileName;
		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

	private Connection conn;

	private Connection conectar() { 
		Connection conn = null;
		String url = "jdbc:sqlite:BDProyecto.db"; 
		try {
			conn = DriverManager.getConnection(url);

		} catch (Exception e) {
			System.out.println("Error");
		}
		return conn;
	}
	
	public void createTable () {
		String sql= "Create table if not exists reservas (nombre text primary key, pelicula text not null, numeroEntradas int not null, importe int not null )";		
		try(Connection conn=this.conectar(); Statement stmt= conn.createStatement()) {
			stmt.execute(sql);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	public void insertar(String nombre, String pelicula, int numeroEntradas, int importe) {
		String sql="insert into persona (nombre, pelicula, numeroEntradas, importe) values (?, ?, ?, ?)";
		try (Connection conn=this.conectar(); PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setString(1, nombre); 
			pstmt.setString(2, pelicula);
			pstmt.setInt(3, numeroEntradas);
			pstmt.setInt(4, importe);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}	
	
	

}