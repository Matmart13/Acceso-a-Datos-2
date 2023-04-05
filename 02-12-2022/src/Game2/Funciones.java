package Game2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Funciones {
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	DecimalFormat format = new DecimalFormat("#.##");
	static Scanner sc = new Scanner(System.in);

	public Double precio(HashMap<String, Double> hm, String obj) {
		return hm.get(obj);
	}

	public int cantidad(HashMap<String, Double> hm, String obj) {
		int cantidad = 0;
		for (int i = 0; i < hm.size(); i++) {
			if (hm.containsKey(obj) == true) {
				cantidad++;
			} else {
				return 0;
			}
		}
		return cantidad;
	}

	public void imprimirlista(HashMap<String, Double> hm) {
		String clave;
		Iterator<String> productos = hm.keySet().iterator();
		while (productos.hasNext()) {
			clave = productos.next();
			System.out.println(ANSI_GREEN + clave + ANSI_RESET + " - " + ANSI_RED + hm.get(clave) + "\n" + ANSI_RESET);
		}
	}

	public void imprimirProductos(HashMap<String, Double> hm) {
		String clave;
		Iterator<String> productos = hm.keySet().iterator();
		while (productos.hasNext()) {
			clave = productos.next();
			System.out.println(ANSI_GREEN + clave + ANSI_RESET);
		}
	}

	public void guardarlista(ArrayList<Producto> _listaCarrito) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Ticket.txt"));
		bw.write("\tCantidad  " + "\t|\t" + "  Nombre  " + "\t|\t" + "  Precio  " + "\t|\t" + "  Total  \t|\n");
		for (int i = 0; i < _listaCarrito.size(); i++) {
			bw.write("\t" + _listaCarrito.get(i).cantidad + " \t|\t " + _listaCarrito.get(i).nombre + "\t|\t"
					+ format.format(_listaCarrito.get(i).precio) + " euros \t|\t"
					+ format.format(_listaCarrito.get(i).total) + " euros |\n");
		}
		bw.write("Precio total de la compra " + format.format(totalcarrito(_listaCarrito)) + " euros");
		bw.close();
		System.out.println(ANSI_PURPLE + "Aqui lo tiene" + ANSI_RESET);
	}

	public void Carrito(ArrayList<Producto> _listaCarrito) {

		for (int i = 0; i < _listaCarrito.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (_listaCarrito.get(i).nombre.equals(_listaCarrito.get(j).nombre)) {

				}
			}

		}

		System.out.println(ANSI_CYAN + "\t\t\t\t\t\t\t TICKET " + ANSI_RESET);
		System.out.println("\tCantidad  " + "\t|\t" + "  Nombre  " + "\t|\t" + "  Precio  " + "\t|\t" + "  Total  \t|");
		for (int j = 0; j < _listaCarrito.size(); j++) {
			System.out.println("\t" + _listaCarrito.get(j).cantidad + " \t|\t " + _listaCarrito.get(j).nombre + "\t|\t"
					+ format.format(_listaCarrito.get(j).precio) + " euros \t|\t"
					+ format.format(_listaCarrito.get(j).total) + " euros |");
		}
		System.out.println();
		System.out.println("Precio total de la compra " + format.format(totalcarrito(_listaCarrito)) + " euros");
		System.out.println();
	}

	public double totalcarrito(ArrayList<Producto> _listaCarrito) {
		double cantidad = 0;
		for (int i = 0; i < _listaCarrito.size(); i++) {
			cantidad = cantidad + _listaCarrito.get(i).total;
		}
		return cantidad;
	}

	public void compra(String _eleccion, ArrayList<Producto> _listaCarrito) {
		if (_eleccion.equalsIgnoreCase("Tarjeta")) {
			try {
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.println();
				System.out.println("Ya ha sido pagado");
				System.out.println("Gracias por la compra");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (_eleccion.equalsIgnoreCase("Efectivo")) {
			System.out.println("Cantidad que debe  " + totalcarrito(_listaCarrito));
			double a = sc.nextDouble();
			double total = a - totalcarrito(_listaCarrito);
			System.out.println("Aqui tiene sus vueltas " + format.format(total) + " euros");
			System.out.println("Gracias por la compra");
		} else {
			System.out.println("Ese metodo no existe");
		}
	}
}
