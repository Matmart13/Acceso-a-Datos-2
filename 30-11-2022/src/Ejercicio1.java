import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio1 {
	public static ArrayList<String> lista = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader( new FileReader("B:\\DAM\\2ºAÑO\\Acceso a Datos 2ºTrimetre\\30-11-2022\\src\\numero.txt"));
			for (int i = 0; i <10; i++) {
				lista.add(br.readLine());
			}
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
			}
			System.out.println("De menor a mayor");
			Collections.sort(lista);
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i) + " < ");
			}
			System.out.println();
			System.out.println("De mayor a menor");
			Collections.reverse(lista);
			for (int i = 0; i < lista.size(); i++) {
				
				System.out.print(lista.get(i) + " > ");
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
