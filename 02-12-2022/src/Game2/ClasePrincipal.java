package Game2;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
	static ArrayList<Producto> listaCarrito = new ArrayList<>();
	static DecimalFormat format = new DecimalFormat("#.##");
	public static void main(String[]args) throws IOException {
		lista(lista);
		menu();
		
	}
	
	public static void menu() throws IOException {
		int a ;
		System.out.println("\t \t " + ANSI_PURPLE + "BIENVENIDO A GAME" + ANSI_RESET );
		String  a1 ;
		do {
			menu2();
			 a = sc.nextInt();
			switch (a) {
			case 1:
				f.imprimirlista(lista);
				break;
			case 2:
				f.imprimirlista(lista);
				System.out.println("Pon el producto que quieres ");
				 a1 = sc.next();
				 System.out.println("Pon la cantidad que quieres de " + a1);
				 int cantidad = sc.nextInt();
				 Producto p = new Producto(cantidad, a1, lista.get(a1), cantidad *lista.get(a1) );
				listaCarrito.add(p);
				break;
			case 3:
				f.Carrito(listaCarrito);
				System.out.println("Quiere pagar o seguir comprando");
				String pagar = sc.next();
				if(pagar.equalsIgnoreCase("pagar")) {
					System.out.println("Como quieres pagar en Efectivo o en Tarjeta");
					String eleccion = sc.next();
					f.compra(eleccion, listaCarrito);
					System.out.println("Quiere su ticket");
					eleccion = sc.next();
					if(eleccion.equalsIgnoreCase("Si")) {
						f.guardarlista(listaCarrito);
					}else {
						System.out.println("Se lo tiro");
					}
					System.out.println();
					System.out.println("Quiere seguir comprando");
					eleccion = sc.next();
					if(eleccion.equalsIgnoreCase("Si")) {
						break;
					}else {
						a = 4;
					}
				}else if(pagar.equals("seguir")) {
					break;
				}
			default:
				break;
			}
		} while (a != 4);
		System.out.println("Saliste del Game"
				+ "\nGracias por su visita");
			
	}
	public static void menu2() {
		System.out.println( 
				"1)Productos"
				+ "\n2)Añadir al carrito"
				+ "\n3)Carrito"
				+ "\n4)Salir");
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
