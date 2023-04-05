package CambioDeMonedasHash;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio2 {
	 static HashMap<String,Double> listaEuros= new HashMap<String,Double>();
	 static HashMap<String,Double> listaDolares= new HashMap<String,Double>();
	 static HashMap<String,Double> listaLibras= new HashMap<String,Double>();
	 static HashMap<String,Double> listaPesos= new HashMap<String,Double>();
	  static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Valor listaEuros
		listaEuros.put("Dolares", 1.05);
		listaEuros.put("Libra Esterlina", 0.86 );
		listaEuros.put("Peso Colombiano", 4984.43 );
		//Valor listaDolares
		listaDolares.put("Euros", 0.95 );
		listaDolares.put("Libras Esterlina", 0.82);
		listaDolares.put("Pesos Colombiano", 4769.15 );
		//Valor listaLibras
		listaLibras.put("Euros", 1.17);
		listaLibras.put("Dolares", 1.22);
		listaLibras.put("Pesos Colombiano",5818.73  );
		//Valor listaPeso
		listaPesos.put("Euros", 0.00020 );
		listaPesos.put("Dolar", 0.00021 );
		listaPesos.put("Libra Esterlina", 0.00017 );
		System.out.println("Pon el valor");
		int moneda = sc.nextInt();
		System.out.println("Tu valor en que moneda esta en");
		System.out.println("Libras Esterlinas\nEuros\nDolares\nPesos");
		String moneda1 = sc.next();
		
		if(moneda1.contains("Dolares")) {
			System.out.println("En que divisa quieres convertir el valor puesto");
			System.out.println("Euros"
					+ "\nLibra Esterlina"
					+ "\nPeso Colombiano");
				moneda1 = sc.next();
			if (listaDolares.containsKey(moneda1)) {
				System.out.println("El valor de euros a " + moneda + " es de " +  moneda*listaDolares.get(moneda1) + " euros");
			} 
		}else if (moneda1.equals("Euros")) {
	
				System.out.println("En que divisa quieres convertir el valor puesto");
				System.out.println("Dolares"
						+ "\nLibra Esterlina"
						+ "\nPeso Colombiano");
					moneda1 = sc.next();
				if (listaEuros.containsKey(moneda1)) {
					System.out.println("El valor de euros a " + moneda + " es de " +  moneda*listaEuros.get(moneda1) + " euros");
				} 
		}else if (moneda1.contains("Libras Esterlina")) {

				System.out.println("En que divisa quieres convertir el valor puesto");
				System.out.println("Euros"
						+ "\nDolares"
						+ "\nPeso Colombiano");
					moneda1 = sc.next();
				if (listaDolares.containsKey(moneda1)) {
					System.out.println("El valor de euros a " + moneda + " es de " +  moneda*listaLibras.get(moneda1) + " euros");
				} 
		}else if (moneda1.contains("Pesos Colombianos")) {
		
				System.out.println("En que divisa quieres convertir el valor puesto");
				System.out.println("Euros"
						+ "\nLibra Esterlina"
						+ "\nDolares");
					moneda1 = sc.next();
				if (listaDolares.containsKey(moneda1)) {
					System.out.println("El valor de euros a " + moneda + " es de " +  moneda*listaPesos.get(moneda1) + " euros");
				} 
		}
	}

}
