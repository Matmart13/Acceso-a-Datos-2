import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio2 {
	static int a ;
	
	public int getA() {
		return a;
	}

	public static void setA(int a) {
		Ejercicio2.a = a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Personas> lista = new ArrayList<>();
		lista.add(new Personas("Poma", 1, "Paccha", 8, 2));
		lista.add(new Personas("Pilar", 2, "Rodriguez",3, 2));
		lista.add(new Personas("Martin", 3, "Mancini", 8, 2));
		lista.add(new Personas("Pablo",4, "Tolosa", 9, 2));
		lista.add(new Personas("Sergio", 5, "Rodriguez", 7, 2));
		lista.add(new Personas("Waldemar", 6, "Stegierski", 2, 2));
		lista.add(new Personas("Alberto", 7, "Gutierrez", 10, 2));
		lista.add(new Personas("Hector", 8, "Angeles", 7, 2));
		lista.add(new Personas("Jonathan", 9, "Torres", 8, 2));
		System.out.println("Pulsa uno para ordenarlo por nombre");
		System.out.println("Pulse dos para ordenarlo por nota");
		a = sc.nextInt();
		switch (a) {
		case 1:
			Collections.sort(lista);
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i).Dni + " ");
				System.out.print(lista.get(i).nombre + " ");
				System.out.print(lista.get(i).apellidos + " ");
				System.out.print(lista.get(i).curso + " ");
				System.out.print(lista.get(i).nota + " " + "\n");
		}
			break;
		case 2:
			Collections.sort(lista);
			for (int i = 0; i < lista.size(); i++) {
				System.out.print(lista.get(i).Dni + " ");
				System.out.print(lista.get(i).nombre + " ");
				System.out.print(lista.get(i).apellidos + " ");
				System.out.print(lista.get(i).curso + " ");
				System.out.print(lista.get(i).nota + " " + "\n");
		}
			break;

		default:
			break;
		}
		sc.close();
	}

}
