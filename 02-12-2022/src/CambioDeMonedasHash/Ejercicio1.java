package CambioDeMonedasHash;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio1 {
	  static HashMap<String,Double> listaDivisas = new HashMap<String,Double>();
	  static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listaDivisas.put("Dolares", 1.05);
		listaDivisas.put("Libra Esterlina", 0.86 );
		listaDivisas.put("Peso Colombiano", 4984.43 );
		double valor;
		String moneda ;
		System.out.println("Pon el valor en euros");
		valor = sc.nextDouble();
		System.out.println("En que divisa quieres convertir el valor puesto");
		System.out.println("Dolares"
				+ "\nLibra Esterlina"
				+ "\nPeso Colombiano");
		moneda = sc.next();
		if (listaDivisas.containsKey(moneda)) {
			System.out.println("El valor de euros a " + moneda + " es de " + valor *listaDivisas.get(moneda) + " euros");
		} 
	}
}