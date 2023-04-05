package HashMap;
import java.util.HashMap;

public class Ejercicio2 {
	  static HashMap<Integer,String> m = new HashMap<Integer,String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m.put(924, "Pablo");
		m.put(432, "Martin");
		
		System.out.println("Los elementos son : " + m);
		System.out.println(m.keySet());
		System.out.println(m.values());
		System.out.println(m.entrySet());
		
	}

}