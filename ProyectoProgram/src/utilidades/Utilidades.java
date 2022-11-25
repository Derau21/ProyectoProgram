package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import clases.Administrador;
import clases.Cliente;
import clases.Usuario;

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
				if(lineaSeparada.length == 5){
					String nombre = lineaSeparada[0];
					int edad = Integer.parseInt(lineaSeparada[1]);
					String dni = lineaSeparada[2];
					String username = lineaSeparada[3];
					String contrasenya = lineaSeparada[4];
					
					
					users.add(new Cliente(nombre, edad, dni, username, contrasenya));
				
				}else if(lineaSeparada.length == 6){
					String nombre = lineaSeparada[0];
					int edad = Integer.parseInt(lineaSeparada[1]);
					String dni = lineaSeparada[2];
					String username = lineaSeparada[3];
					String contrasenya = lineaSeparada[4];
					int antiguedad = Integer.parseInt(lineaSeparada[5]);
					
					users.add(new Administrador(nombre, edad, dni, username, contrasenya,antiguedad));
				}
				linea = br.readLine();
			}
			br.close();
			fr.close();
			
		}catch(IOException e){ //hay que poner IOException
			e.printStackTrace();
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
				
				
				String nombre = usuario.getNombre();
				int edad = usuario.getEdad();
				String dNI = usuario.getDNI();
				String  username = usuario.getUsername();
				String contrasenya = usuario.getContrasenya();

				texto+= nombre + ";" + edad + ";" + dNI + ";" + username + ";" +contrasenya;
				
				if(usuario instanceof Administrador){
					int antiguedad = ((Administrador) usuario).getAntiguedad();//casteo por que es un metoo del admin
					texto+= ";" + antiguedad;
				}
				bw.write(texto + "\n");
				
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
}
