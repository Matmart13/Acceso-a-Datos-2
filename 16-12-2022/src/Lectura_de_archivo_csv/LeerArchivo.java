package Lectura_de_archivo_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LeerArchivo {
	public LeerArchivo() {
		// TODO Auto-generated constructor stub
		  String SEPARADOR = ",";
		 BufferedReader bufferLectura = null;
		 
		 try {
		  // Abrir el .csv en buffer de lectura
		  bufferLectura = new BufferedReader(new FileReader("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\Acceso a Datos 2ºTrimetre\\16-12-2022\\src\\archivo.csv"));
		  
		  // Leer una linea del archivo
		  String linea = bufferLectura.readLine();
		  
		  while (linea != null) {
		   // Sepapar la linea leída con el separador definido previamente
		   String[] campos = linea.split(SEPARADOR); 
		   
		   System.out.println(Arrays.toString(campos));
		   
		   // Volver a leer otra línea del fichero
		   linea = bufferLectura.readLine();
		  }
		 } 
		 catch (IOException e) {
		  e.printStackTrace();
		 }
		 finally {
		  // Cierro el buffer de lectura
		  if (bufferLectura != null) {
		   try {
		    bufferLectura.close();
		   } 
		   catch (IOException e) {
		    e.printStackTrace();
		   }
		  }
		 }
		}
	}
	
