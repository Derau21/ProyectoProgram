package main.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import main.clases.Administrador;
import main.clases.Cliente;
import main.clases.Usuario;
import main.baseDatos.GestorBaseDatos;

public class Utilidades {

	public static ArrayList<Usuario> leerUsuarios() {
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		File aFile = new File("usuarios.txt");

		try{
			FileReader fr = new FileReader(aFile);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();

			while(linea!= null){
				String[] lineaSeparada = linea.split(";");
				if(lineaSeparada.length == 2){
					String username = lineaSeparada[0];
					String contrasenya = lineaSeparada[1];


					users.add(new Cliente(username, contrasenya));
					
				}else if(lineaSeparada.length == 3){
					String username = lineaSeparada[0];
					String contrasenya = lineaSeparada[1];
					String dni = lineaSeparada[2];

					users.add(new Administrador(username, contrasenya, dni));
				
				}
				linea = br.readLine();
			}
			br.close();
			fr.close();

		}catch(IOException e){ //hay que poner IOException
			GestorBaseDatos.logger.log(Level.WARNING, "No se han leido bien los usuarios", e);
		}
		return users;
	}

	public static void escribirFihcero(ArrayList<Usuario>users){
		File aFile = new File("usuarios.txt");
		
		try{
			FileWriter fw = new FileWriter(aFile);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (Usuario usuario : users) {
				String texto = ""; //creas la variable texto para rellenar en funcion de si es admin o cliente
				
				String  username = usuario.getUsername();
				String contrasenya = usuario.getContrasenya();

				texto+=  username + ";" +contrasenya;
				
				if(usuario instanceof Administrador){
					String dNI = ((Administrador) usuario).getdNI();//casteo por que es un metoo del admin
					texto+= ";" + dNI;
				}
				bw.write(texto + "\n");
				
			}
			bw.flush();
			bw.close();
			fw.close();
			
		} catch(IOException e){
			GestorBaseDatos.logger.log(Level.WARNING, "No se han escrito bien los usuarios", e);
			
		}
		
	}
	
	public static void escribirArrayEnFichero(ArrayList<String>horarios) {
		File aFile = new File("horarios.txt");
		  try {
		    BufferedWriter bw = new BufferedWriter(new FileWriter(aFile));
		    for (String string : horarios) {
		    	bw.write(string);
			      bw.newLine();
			} 
		      
		    bw.close();
		  } catch (IOException ex) {
		    ex.printStackTrace();
		  }
		}

	public static ArrayList<String> leerHorarios() {
		File aFile = new File("horarios.txt");
		ArrayList<String> horarios = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(aFile));
			String linea;
			while ((linea = br.readLine()) != null) {
				horarios.add(linea);
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return horarios;
	}





}


