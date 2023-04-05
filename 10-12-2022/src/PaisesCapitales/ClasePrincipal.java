package PaisesCapitales;

import java.util.HashMap;
import java.util.Scanner;

public class ClasePrincipal {
	static Scanner sc = new Scanner(System.in);
	static HashMap <String,String>lista = new HashMap<String, String>();
	static Funciones f = new Funciones();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lista.put("España", "Madrid");
		lista.put("Francia", "Paris");
		lista.put("Rusia", "Moscu");
		lista.put("Italia", "Roma");
		f.menu(lista, sc);
	}

}
