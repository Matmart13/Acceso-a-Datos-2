package Game2;

import java.util.ArrayList;

public class Carrito {
	 ArrayList<Producto> listaCarrito = new ArrayList<>();
	 
	 public Carrito() {
		// TODO Auto-generated constructor stub
	}
	 public Carrito(ArrayList<Producto> _listaCarrito ) {
		// TODO Auto-generated constructor stub
		 this.listaCarrito = _listaCarrito ;
	}
	public ArrayList<Producto> getListaCarrito() {
		return listaCarrito;
	}
	public void setListaCarrito(ArrayList<Producto> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}
	
	
	 
	 
}
