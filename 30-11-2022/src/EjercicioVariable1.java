import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioVariable1 {
	public static ArrayList<String> lista = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		//Variables
		Integer a, random =(int)(Math.random()*100 + 1)  ;
		//Buffered
		BufferedWriter bw = new BufferedWriter(new FileWriter("aleatorios.txt"));
		BufferedReader br = new BufferedReader(new FileReader("aleatorios.txt"));
		System.out.println("Pon la cantidad de numeros que quieres comparar");
		a = sc.nextInt();
		bw.write(String.valueOf(random) );
		for (int i = 1; i < a; i++) {
			random = (int)(Math.random()*100 + 1);
			bw.write("\n" + String.valueOf(random)  );
		}
		bw.close();
		for (int i = 0; i < a; i++) {
			lista.add(br.readLine());
		}
		
		System.out.println("Los números son : ");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		//Cierre del Buffered 

		br.close();
	}

}