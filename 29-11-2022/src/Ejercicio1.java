import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
	public static ArrayList<Integer> lista = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i <100; i++) {
			lista.add((int)(Math.random() * 100) +1);
		}
		
		int a ;
		Scanner sc = new Scanner(System.in);


		do {
			System.out.println("Pulsa 1 para sumar");
			System.out.println("Pulse 2 para la media");
			System.out.println("Pulse 3 para el valor máximo");
			System.out.println("Pulse 4 para el valor minimo");
			System.out.println("Pulse 5 para Salir");
			a = sc.nextInt();
			switch (a) {
			case 1:
				System.out.println("La suma es " + suma());
				break;

			case 2:
				System.out.println("La media es " + media());
				break;
			case 3:
				System.out.println("El numero mayor es " + max());
				break;
			case 4:
				System.out.println("El numero menor es " + min());
				break;
			default:
				break;
			}
		} while (a != 5);{
			System.out.println("Se finalizo");
		}
		sc.close();
	}
	
	public static int suma() {
		int suma  = 0;
		for (int i = 0; i < lista.size(); i++) {
			suma = lista.get(i) + suma;
		}
		return suma;
	}
	public static int media() {
		int media = 0;
		for (int i = 0; i < lista.size(); i++) {
			media = lista.get(i) + media;
		}
		media = media / lista.size();
		return media;
	}
	public static int max() {
		int max = lista.get(0);
		for (int i = 1; i < lista.size(); i++) {
			if (max < lista.get(i)) {
				max = lista.get(i);
			}
			
		}
		return max;
	}
	
	public static int min() {
	
		int min = lista.get(0);
		for (int i = 0; i < lista.size(); i++) {
			if (min > lista.get(i)) {
				min = lista.get(i);
			}
				
			}
		return min;
	}
}
