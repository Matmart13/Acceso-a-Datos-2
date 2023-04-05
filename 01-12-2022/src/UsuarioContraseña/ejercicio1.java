package UsuarioContraseña;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ejercicio1 {
	static HashMap<String,String> m = new HashMap<String,String>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m.put("admin", "admin");
		

		int contador = 0;

		do {
			System.out.println("Pon el usuario y contraseña");
			String a = sc.next();
			String b = sc.next();
			Map completo;
			if (m.containsKey(a) && m.containsValue(b)) {
				System.out.println("El usuario es correcto");
				break;
			}else {
				if (contador == 2) {
					System.out.println("No tienes mas oportunidades");
					break;
				}
				System.out.println("El usuario es incorrecto prueba otra vez");
				contador ++;

			}
			
		}while (contador != 3); {
			
		}
	}

}
