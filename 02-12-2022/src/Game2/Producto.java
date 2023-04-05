package Game2;

public class Producto {
	int cantidad;
	String nombre;
	double precio;
	double total;
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public Producto(int _cantidad,String _nombre, double _precio, double _total) {
		// TODO Auto-generated constructor stub
		this.cantidad = _cantidad;
		this.nombre = _nombre;
		this.precio = _precio;
		this.total = _total;
				
	}
	
	//Getters and Setters
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
