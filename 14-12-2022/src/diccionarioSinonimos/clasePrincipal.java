package diccionarioSinonimos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class clasePrincipal {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, ArrayList<String>> lista = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lista();
		menu();
	}

	public static void menu() {

		int opcion = 0;
		do {
			System.out.println("Pon una palabra");
			String palabra = sc.next();
			if (lista.containsKey(palabra)) {
				System.out.println("Sus sinonimos son:");

				System.out.println(lista.get(palabra));

			} else {
				System.out.println("Cual era la palabra");
				palabra = sc.next();
				ArrayList<String> listasinonimos = new ArrayList<>();
				System.out.println("Pon 3 sinonimos");
				System.out.println("El primero");
				String sinonimo = sc.next();
				listasinonimos.add(sinonimo);
				lista.put(palabra, listasinonimos);
				System.out.println("El segundo");
				sinonimo = sc.next();
				listasinonimos.add(sinonimo);
				lista.put(palabra, listasinonimos);
				System.out.println("El tercero");
				sinonimo = sc.next();
				listasinonimos.add(sinonimo);
				lista.put(palabra, listasinonimos);
				System.out.println("Gracias por su aportación");
			}
			System.out.println("Quiere buscar otra palabra");
			System.out.println(" 1 si ");
			System.out.println(" 2 no");
			opcion = sc.nextInt();
		} while (opcion != 2);
		System.out.println("Gracias por usar el diccionario de sinonimos");
	}

	public static void lista() {
		ArrayList<String> listasinonimos = new ArrayList<>();
		listasinonimos.add("enigma");
		listasinonimos.add("dilema");
		listasinonimos.add("duda");
		lista.put("problema", listasinonimos);
	}
}
