package utils;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import clases.Pelicula;
import clases.Usuario;


public class Ficheros {
	private File fichero;

	public Ficheros() {
		fichero = new File("usuarios.txt");
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static boolean comprobarLigin(HashMap<String, String> users, String username, String password){
		
		
		if(users.containsKey(username)){

			if(users.get(username).equals(password)){ //Esta mirando si el username esta asociado con la contraseña correcta
				
			}
		
		}
		
		return false;
		
	}
	
	
	public static HashMap<String, Usuario> leerUsuarios(){
		HashMap<String, Usuario> map = new HashMap<String, Usuario>();
		File aFile = new File("usuarios.txt");
		FileReader fr;
		
			try{
				fr = new FileReader(aFile);
				BufferedReader br = new BufferedReader(fr);
				String linea = br.readLine();
				while(linea!= null){
					String[] lineaSeparada = linea.split(";");
					map.put(lineaSeparada[1],new Usuario(lineaSeparada[0], lineaSeparada[1], lineaSeparada[2], lineaSeparada[3], lineaSeparada[4])); //añadir la primera como clave y la segunda como contra
					linea = br.readLine();
				}
				//escribiria
				br.close();
				fr.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		return map;
		
	}
	public static boolean escribirNuevoUsuario(HashMap<String, Usuario> map){
		boolean usuarioCreado = false;
		File aFile = new File("usuarios.txt");
		FileWriter fw = null; 
		
		try {
			
			fw= new FileWriter(aFile);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<String> it = map.keySet().iterator(); //para tener las claves y poder recorrer el hashmap
			while(it.hasNext()){
				String user = it.next();
				Usuario u = map.get(user);
				String escribir = u.getNombre() +";" + u.getUsuario() +";"+u.getContraseña()+";"+u.getEdad()+";"+u.getDni()+"\n";
				bw.write(escribir);
				
			}
			bw.flush();
			bw.close();
			
			usuarioCreado = true;	
			
			
		}catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fw != null){
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
			}
			
			return usuarioCreado;
	
		
		
		
		//primero vas a tener que ller hasta la ultima fila y luego escribir una nueva linea
		
	
	
		
	}
	
	public static ArrayList<Pelicula> leerNombrePeliculas(){
		
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		File aFile = new File("peliculas.txt");
		FileReader fr = null;
		
		try{
			fr = new FileReader(aFile);
			BufferedReader brr = new BufferedReader(fr);
			String linea = brr.readLine();
			
			while(linea!= null){
				String[] lineaSeparada = linea.split(";");
				String nombre = lineaSeparada[0];
				String descripcion = lineaSeparada[1];
				String duracion = lineaSeparada[2]; // pones en corchetes en la posicion del array que va a estar cada elemento
				String director = lineaSeparada[3];
				peliculas.add(new Pelicula(nombre, descripcion, duracion, director)); //para añadir cada pelicula a la lista
				
				linea = brr.readLine(); // para leer la siguiente linea
			}
			brr.close();
			fr.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}return peliculas;
		
	}
	public static boolean escribirReserva(HashMap<String, Pelicula> map){
		boolean peliculaGuardada = false;
		File aFile = new File("reservas.txt");
		FileWriter fw = null; 
		
		try {
			
			fw= new FileWriter(aFile);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<String> it = map.keySet().iterator(); //para tener las claves y poder recorrer el hashmap
			while(it.hasNext()){
				String reserva = it.next();
				Pelicula p = map.get(reserva);//p es el nombre que quieras darle a la instancia
				String escribir = p.getTitulo() +";" + p.getDescripcion() +";"+p.getDuracion()+";"+p.getDirector()+"\n";
				bw.write(escribir);
				
			}
			bw.flush();
			bw.close();
			
			peliculaGuardada = true;	
			
			
		}catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fw != null){
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
			}
			
			return peliculaGuardada;
	}

	
	public static boolean escribirSeleccionReserva(String s){
		boolean seleccionReserva = false;
		File aFile = new File("temp.txt");
		FileWriter fw = null; 
		
		try {
			
			fw= new FileWriter(aFile);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(s);	
			
			bw.flush();
			bw.close();
			
			seleccionReserva = true;	
			
			
		}catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fw != null){
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
			}
			
			return seleccionReserva;
	}
	
	
	
}

