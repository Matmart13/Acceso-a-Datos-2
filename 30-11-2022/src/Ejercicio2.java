import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio2 {
	public static ArrayList<String> lista = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader( new FileReader("C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\Acceso a Datos 2ºTrimetre\\30-11-2022\\src\\letras.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("resultado.txt"));
			for (int i = 0; i < 10; i++) {
				lista.add(br.readLine());
			}
			
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i) + " ");
			}
			System.out.println();
			bw.write("De la A a la Z \n");
			System.out.println("De la A a la Z");
			Collections.sort(lista);
			//Por Pantalla
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i) + " ");
			}
			//Enviar al archivo
			for (int i = 0; i < lista.size(); i++) {
				bw.write(lista.get(i).toString() +" ");
			}
			System.out.println();
			bw.write("\n");
			bw.write("De la Z a la A");
			bw.write("\n");
			System.out.println("De la Z a la A");
			
			Collections.reverse(lista);
			//Por Pantalla
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i) + " ");
			}
			//Enviar al archivo
			for (int i = 0; i < lista.size(); i++) {
				bw.write(lista.get(i).toString() +" ");
			}
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
