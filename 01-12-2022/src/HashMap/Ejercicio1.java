package HashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class Ejercicio1 {
	   static HashMap<String,Float> listaProductos = new HashMap<String,Float>();
	    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    int opcionElegida = 0;
		    float precio;
		    String codigo;

		    while (opcionElegida != 5) {
		        System.out.println("Introduce el numero de la opción que quieras:");
		        System.out.println("1.- Introducir producto");
		        System.out.println("2.- Modificar precio");
		        System.out.println("3.- Mostrar todos los productos");
		        System.out.println("4.- Eliminar producto");
		        System.out.println("5.- Salir");
		        opcionElegida = sc.nextInt();

		        switch (opcionElegida) {
		            case 1:
		                System.out.println("Introduce el códido del producto:");
		                codigo = sc.next();
		                System.out.println("Introduce el precio del producto:");
		                precio = sc.nextFloat();
		                guardarProducto(codigo, precio, listaProductos);
		                break;
		            case 2:
		                System.out.println("Introduce el códido del producto del que quieres cambiar el precio:");
		                codigo = sc.next();
					try {
						try {
							modificaPrecio(codigo, listaProductos);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		                break;
		            case 3:
		                mostrarProductos(listaProductos);
		                break;
		            case 4:
		                System.out.println("Introduce el códido del producto que quieres eliminar:");
		                codigo = sc.next();
		                eliminaProducto(codigo, listaProductos);
		                break;
		            case 5:
		                break;   // Si la opcion es 5 no se hace nada 
		            default:
		                System.out.println("Tienes que introducir una opción valida");
	}
		    }
		        
		        
	}
		    public static void guardarProducto(String codigo, float precio, HashMap <String,Float> listaProductos){
		            if (listaProductos.containsKey(codigo)) {
		                System.out.println("No se puede introducir el producto. El código esta repetido.");
		            } else {
		                listaProductos.put(codigo, precio);               
		            }
		        }
		    public static void modificaPrecio(String codigo, HashMap<String,Float> listaProductos){
		        Scanner sc = new Scanner(System.in);
		        if (listaProductos.containsKey(codigo)) {
		            System.out.println("Introduce el precio del producto:");
		            listaProductos.put(codigo, sc.nextFloat());            
		        } else {
		            System.out.println("No hay ningun producto con ese código.");
		        }
		    }
		    public static void mostrarProductos(HashMap<String, Float> listaProductos) {
		        String clave;
		        Iterator<String> productos = listaProductos.keySet().iterator();
		        System.out.println("Hay los siguientes productos:");
		        while(productos.hasNext()){
		            clave = productos.next();
		            System.out.println(clave + " - " + listaProductos.get(clave));
		        }        
		    }
		    public static void mostrarProductos2(HashMap<String, Float> listaProductos) {
		        Iterator iterador = listaProductos.entrySet().iterator();
		        //Iterator<Map.Entry<String, Float>> iterador = listaProductos.entrySet().iterator();
		        Map.Entry producto;
		        while (iterador.hasNext()) {
		            producto = (Map.Entry) iterador.next();
		            //producto = iterador.next(); Si se usase tambien la otra linea comentada.
		            System.out.println(producto.getKey() + " - " + producto.getValue());
		        } 
		    }
		    public static void eliminaProducto(String codigo, HashMap<String,Float> listaProductos) {
		        if (listaProductos.containsKey(codigo)) {
		            listaProductos.remove(codigo);
		        } else {
		            System.out.println("No hay ningun producto con ese código.");  
		        }       
		    } 

}
