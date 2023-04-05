package modelo;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.collections.ObservableList;
import util.ConexionDB;

/**
 * Clase Aeropuerto, representa a un aeropuerto
 *
 * 
 */
public abstract class Aeropuerto implements Serializable {

    protected static final long serialVersionUID = 1L;

    // Atributos
    private int id;
    private String nombre;
    private Direccion direccion;
    private int anioInauguracion;
    private int capacidad;
    private ArrayList<Avion> aviones;

    /**
     * Constructor vacio
     */
    public Aeropuerto() {
        //this(0, "", "", "", 0, "", 0, 0);
    }

    /**
     * Constructor con direccion sin id
     *
     * @param nombre nombre del aeropuerto
     * @param direccion direccion del aeropuerto
     * @param anioInauguracion año de inauguracion del aeropuerto
     * @param capacidad capacidad del aeropuerto
     */
    public Aeropuerto(String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        this(nombre, direccion.getPais(),
                direccion.getCalle(),
                direccion.getNumero(),
                direccion.getCiudad(),
                anioInauguracion,
                capacidad);
    }

    /**
     * Constructor con direccion con id
     *
     * @param id id del aeropuerto
     * @param nombre nombre del aeropuerto
     * @param direccion direccion del aeropuerto
     * @param anioInauguracion año de inauguracion del aeropuerto
     * @param capacidad capacidad del aeropuerto
     */
    public Aeropuerto(int id, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        this(id, nombre, direccion.getPais(),
                direccion.getCalle(),
                direccion.getNumero(),
                direccion.getCiudad(),
                anioInauguracion,
                capacidad);
    }

    /**
     * Constructor completo sin id
     *
     * @param nombre nombre del aeropuerto
     * @param pais pais del aeropuerto
     * @param calle calle del aeopuerto
     * @param numero numero del aeropuerto
     * @param ciudad ciudad del aeropuerto
     * @param anioInauguracion año de inauguracion del aeropuerto
     * @param capacidad capacidad del aeropuerto
     */
    public Aeropuerto(String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        this.nombre = nombre;
        this.direccion = new Direccion(pais, calle, numero, ciudad);
        this.anioInauguracion = anioInauguracion;
        this.capacidad = capacidad;
        this.aviones = new ArrayList();
    }

    /**
     * Constructor completo con id
     *
     * @param id id del aeropuertos
     * @param nombre nombre del aeropuerto
     * @param pais pais del aeropuerto
     * @param calle calle del aeopuerto
     * @param numero numero del aeropuerto
     * @param ciudad ciudad del aeropuerto
     * @param anioInauguracion año de inauguracion del aeropuerto
     * @param capacidad capacidad del aeropuerto
     */
    public Aeropuerto(int id, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = new Direccion(pais, calle, numero, ciudad);
        this.anioInauguracion = anioInauguracion;
        this.capacidad = capacidad;
        this.aviones = new ArrayList();
    }

    /**
     * Devuelve el nombre del aeropuerto
     *
     * @return nombre del aeropuerto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del aeropuerto
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la dirección
     *
     * @return direccion del aeropuerto
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Devuelve el pais del aeropuerto
     *
     * @return pais del aeropuerto
     */
    public String getPais() {
        return this.direccion.getPais();
    }

    /**
     * Devuelve la ciudad del aeropuerto
     *
     * @return ciudad del aeropuerto
     */
    public String getCiudad() {
        return this.direccion.getCiudad();
    }

    /**
     * Devuelve la calle del aeropuerto
     *
     * @return calle del aeropuerto
     */
    public String getCalle() {
        return this.direccion.getCalle();
    }

    /**
     * Devuelve el numero del aeropuerto
     *
     * @return numero del aeropuerto
     */
    public int getNumero() {
        return this.direccion.getNumero();
    }

    /**
     * Modifica la direccion del aeropuerto
     *
     * @param direccion nueva direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el año de inauguración del aeropuerto
     *
     * @return año de inauguracion del aeropuerto
     */
    public int getAnioInauguracion() {
        return anioInauguracion;
    }

    /**
     * Modifica el año de inauguracion del aeropuerto
     *
     * @param anioInauguracion
     */
    public void setAnioInauguracion(int anioInauguracion) {
        this.anioInauguracion = anioInauguracion;
    }

    /**
     * Devuelve la capacidad del aeropuerto
     *
     * @return capacidad del aeropuerto
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Devuelve el id del aeropuerto
     *
     * @return id del aeropuerto
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica la capacidad del aeropuerto
     *
     * @param capacidad nueva capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Indica el numero de años que lleva abierto el aeropuerto No se puede
     * sobrescribir
     *
     * @return diferencia de la fecha actual con el año de inauguracion
     */
    public final int aniosAbierto() {

        int anioActual = Calendar.getInstance().get(Calendar.YEAR);

        return anioActual - this.anioInauguracion;

    }

    /**
     * Añade un avion al array
     *
     * @param a Avion a añadir
     */
    public void aniadirAvion(Avion a) {

        if (a != null) {
            this.aviones.add(a);
        } else {
            System.out.println("No debe ser nulo");
        }

    }

    /**
     * Elimina un avion
     *
     * @param a
     */
    public void eliminarAvion(Avion a) {

        if (a != null) {
            this.aviones.remove(a);
        } else {
            System.out.println("No debe ser nulo");
        }
    }

    public boolean tieneAviones() {
        return this.aviones.size() > 0;
    }

    public Avion getAvion(String nombre) {
        for (Avion a : aviones) {
            if (a.getModelo().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Obtiene los aviones
     *
     * @return
     */
    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    /**
     * Muestra los aviones Solo aquellos que esten activados
     *
     * @return Cadena con la informacion de los aviones activados
     */
    private String mostrarAviones() {

        String avionesCadena = "";
        for (Avion a : aviones) {
            if (a.isActivado()) {
                avionesCadena += a.toString() + "\n";
            }
        }
        return avionesCadena;

    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Aeropuerto other = (Aeropuerto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    */
    

    /**
     * Método abstracto que muestra las ganancias totales Implementada en las
     * clases hijas
     *
     * @param cantidad cantidad ganada
     * @return
     */
    public abstract String gananciasTotales(double cantidad);

    /**
     *
     * Devuelve los aeropuertos
     *
     * @param busqueda cadena a buscar en el nombre del aeropuerto
     * @return ObservableList con todos los aeropuertos publicos que contengan
     * en el nombre la cadena dada
     * @throws SQLException
     */
    public abstract ObservableList getAeropuertos(String busqueda) throws SQLException;

    public String mostrarInformacion() {
        return "El aeropuerto con id " + this.id + " y nombre " + nombre + " " + this.direccion + " \n "
                + "Fue inugurado el año " + anioInauguracion + " \n "
                + "y cuenta con una capacidad de " + capacidad + " personas. \n"
                + "Cuenta con los siguientes aviones: \n"
                + mostrarAviones() + "\n";
    }

    /**
     * Inserta un aeropuerto
     *
     * @return indica si se ha insertado
     * @throws SQLException
     */
    public boolean insertar() throws SQLException {

        // Abrimos la conexion
        ConexionDB conexion = new ConexionDB();

        // Formo el SQL
        String SQL = "";
        SQL += "INSERT INTO aeropuertos VALUES (null, ";
        SQL += "'" + this.nombre + "', " + this.anioInauguracion + ", ";
        SQL += this.capacidad + ", " + this.direccion.getId() + ")";

        // Ejecuto la instruccion
        int filas = conexion.ejecutarInstruccion(SQL);

        // Obtengo el ultimo id
        int ultimoID = conexion.ultimoID();

        this.id = ultimoID;

        // Cierro la conexion
        conexion.cerrarConexion();

        // Indico si se ha insertado o no
        if (filas > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Actualizar un aeropuerto
     *
     * @return indica si se ha actualizado
     * @throws SQLException
     */
    public boolean actualizar() throws SQLException {

        // Abrimos la conexion
        ConexionDB conexion = new ConexionDB();

        // Formo el SQL
        String SQL = "";
        SQL += "UPDATE aeropuertos ";
        SQL += "SET nombre = '" + this.nombre + "', anio_inauguracion = " + this.anioInauguracion + ", ";
        SQL += "capacidad = " + this.capacidad + ", id_direccion = " + this.direccion.getId() + " ";
        SQL += "WHERE id = " + this.id;

        // Ejecuto la instruccion
        int filas = conexion.ejecutarInstruccion(SQL);

        // Cierro la conexion
        conexion.cerrarConexion();

        // Indico si se ha insertado o no
        if (filas > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Borra un aeropuerto de la BD
     * @return indica si se ha borrado o no el aeropuerto
     * @throws SQLException 
     */
    public boolean borrarAeropuerto() throws SQLException {

        ConexionDB conexion = new ConexionDB();

        String SQL = "DELETE FROM aeropuertos where id = " + this.id;

        int filas = conexion.ejecutarInstruccion(SQL);

        conexion.cerrarConexion();

        return filas > 0;

    }

    /**
     * Muestra la informacion del objeto
     *
     * @return info
     */
    @Override
    public String toString() {
        return this.nombre;
    }

}
