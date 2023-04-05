package DiccionarioHash;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio1 {
	static HashMap<String,String> m = new HashMap<String,String>();
	static Scanner sc = new Scanner(System.in);
	static String palabra;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m.put("Hola", "Hello");
		m.put("Adios", "Goodbye");
		m.put("Rojo", "Red");
		
		System.out.println("Como quieres traducir");
		System.out.println("1) De Español a Inglés");

		int a = sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("Pon la palabra");
			 palabra = sc.next();
			 System.out.println("La traduccion de " + palabra + " es " + EspañolIngles());
			break;
		case 2:
			
			break;

		default:
			break;
		}
		
		
	}
	
	public static String EspañolIngles() {
		if(m.containsKey(palabra) == true) {
			return m.get(palabra);
		}else
		return "No existe";
	}

}
