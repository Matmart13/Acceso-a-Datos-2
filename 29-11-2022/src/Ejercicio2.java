import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio2 {
	public static ArrayList<Integer> lista = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a; 
		System.out.println("Pon 10 numeros");
		for (int i = 0; i < 10; i++) {
			a = sc.nextInt();
			lista.add(a);
		}
		System.out.println("menor a mayor");
		Collections.sort(lista);
		for (int i = 0; i <lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		System.out.println("Mayor a menor");

		Collections.reverse(lista);
		for (int i = 0; i <lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		sc.close();
	}

}
