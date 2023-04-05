package PaisesCapitales;
import java.util.HashMap;
import java.util.Scanner;
public class Funciones {

	public void menu(HashMap <String,String>_lista, Scanner sc) {
				int a ;
				do {
					System.out.println("Que quiere hacer ");
					System.out.println("1)Saber el nombre de un pais \n2)Saber la lista de paises \n3)Salir");
					a = sc.nextInt();
				switch (a) {
				case 1:
					System.out.println("Pon el nombre de un pais");
					String pais = sc.next();
					if(_lista.containsKey(pais)==true) {
						System.out.println("Su capital es " + _lista.get(pais));
					}else if(_lista.containsKey(pais)==false) {
						System.out.println("No sabemos su capital");
						System.out.println("Por favor ponla a continuacion para mejorar el programa");
						String capital = sc.next();
						_lista.put(pais, capital);
						System.out.println("Gracias por Colaborar para mejorar el programa");
					}
					System.out.println("La lista se queda asi");
					for (String key: _lista.keySet()){  
						System.out.println(key+ " = " + _lista.get(key));
					}
					
					break;
				case 2:
					for (String key: _lista.keySet()){  
						System.out.println(key+ " = " + _lista.get(key));
					}
					break;
					}
				} while (a != 3);
		}

}