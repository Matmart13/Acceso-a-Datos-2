package Game;


import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ClasePrincipal {
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	static Scanner sc = new Scanner(System.in);
	static HashMap <String,Double>lista = new HashMap<String, Double>();
	static Funciones f = new Funciones();
	static Producto p = new Producto();
	
	public static void main(String[]args) throws IOException {

		lista(lista);
		menu();
		
	}
	
	public static void menu() throws IOException {
		int a ;
		System.out.println("\t \t " + ANSI_PURPLE + "BIENVENIDO A GAME" + ANSI_RESET );
		do {
			menu2();
			 a = sc.nextInt();
			switch (a) {
			case 1:
				f.imprimirProductos(lista);
				System.out.println("Pon el producto para saber su precio");
				String 
				 a1 = sc.next();
				System.out.println();
				System.out.println("El precio de "  + a1 + " es " + f.precio(lista, a1) + ANSI_GREEN+" EUROS" +ANSI_RESET);
				System.out.println();
				break;
			case 2:
				f.imprimirProductos(lista);
				System.out.println("Pon el producto que quieres ver su cantidad");
				 a1 = sc.next();
				 System.out.println();
				System.out.println("La cantidad de " + a1 + " es de " + f.cantidad(lista, a1) + " unidades");
				System.out.println();
				break;
			case 3:
				f.imprimirlista(lista);
				break;
			case 4:
				f.guardarlista(lista);
				break;
			default:
				break;
			}
		} while (a != 5);
		System.out.println("Saliste del Game");
			
	}
	public static void menu2() {
		System.out.println(
				"1)Precio del producto"
				+ "\n2)Cuanta Cantidad hay"
				+ "\n3)Ver todos los articulos"
				+ "\n4)Guardar todos los articulos"
				+ "\n5)Salir");
	}
	public static HashMap <String,Double>lista(HashMap <String,Double>_lista ){
		lista.put("GodofWarRagnarok", 69.99);
		lista.put("Thelastofus2", 29.99);
		lista.put("MetroExodus", 29.99);
		lista.put("GodofWar", 19.99);
		lista.put("HorizonForbibbenWest", 49.99);
		lista.put("OuterWilds", 22.99);
		lista.put("ResidentEvil8", 39.99);
		lista.put("FF7", 12.99);
		lista.put("Outlast", 9.99);
		lista.put("Outlast2", 14.99);
		lista.put("Soma", 4.99);
		lista.put("Infamous", 2.99);
		lista.put("Rachet&Clank",9.99);
		lista.put("StardewValley",20.00);
		lista.put("TombRaider", 7.99);
		lista.put("Thief", 8.99);
		lista.put("WolfesteinColection", 69.99);
		lista.put("Sekiro", 49.99);
		lista.put("EldenRing", 89.99);
		lista.put("Thelastofus", 19.99);
		return _lista;
	}
}
