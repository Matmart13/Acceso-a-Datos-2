package Lectura_de_archivo_csv;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Principal {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	System.out.println("Dime cuantos objetos quieres generar");
	int a = sc.nextInt();
	makeFileTxt(a);
	LeerArchivo la = new LeerArchivo();
	}
	
	
	
	
	public static String makeFileTxt(int a) {
		
        try {
       
            String downloadPath ="C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\Acceso a Datos 2ºTrimetre\\16-12-2022\\src\\archivo.csv" ;
            File newFolder = new File(downloadPath);
            

            // get current time
    		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
    				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
    				"Caritina", "Carlota", "Baltazar"};
    		
    		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
    				"Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
    				"Grigalva" };
    		int edad[] = new int[100];
    		for (int i = 0; i < edad.length; i++) {
				edad[i] = (int)(Math.random()*100);
			}
    		
    		char genero[] = {'H','M'};
            ArrayList<Registro> lista = new ArrayList<>();
           
     

            FileOutputStream is = new FileOutputStream(newFolder);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
      

            for (int i = 0; i < a; i++) {
            	Registro r = new Registro();
                int genero1  = (int)(Math.random()*2);
                int edad1 = (int)(Math.random()*100 );
                int nomap =  (int)(Math.random()*18);
                r.setNombre(nombres[nomap]);
	            r.setApellido(apellidos[nomap]);
            	r.setEdad(edad[edad1]);
            	r.setGenero(genero[genero1]);
            	lista.add(r);
			}
            
           w.write("Nombre" + " Apellido" + " Edad" + " Genero\n");
            for (int i = 0; i < a; i++) {
               w.write(lista.get(i).getNombre() + ", " +lista.get(i).getApellido() + ", "+  lista.get(i).getEdad() + ", " + lista.get(i).getGenero() + "\n" );
            }
            w.close();
            return downloadPath ;
        } catch (IOException e) {
            System.err.println("Problem writing to the file " + e);
        }

        return "error";
    }

}
