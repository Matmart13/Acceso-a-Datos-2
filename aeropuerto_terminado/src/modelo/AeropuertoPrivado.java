    

 package modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.ConexionDB;

/**
 * Clase AeropuertoPrivado, heredada de Aeropuerto
 *
 * 
 */
public class AeropuertoPrivado extends Aeropuerto implements Serializable {

    private int numSocios;

    /**
     * Constructor vacio
     */
    public AeropuertoPrivado() {
        super();
    }

    /**
     * Constructor con direccion
     *
     * @param numSocios
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(nombre, direccion, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Constructor con direccion
     *
     * @param numSocios
     * @param id
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, int id, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(id, nombre, direccion, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Constructor completo
     *
     * @param numSocios
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Constructor completo
     *
     * @param numSocios
     * @param id
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, int id, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(id, nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Devuelve el numero de socios
     *
     * @return numero de socios
     */
    public int getNumSocios() {
        return numSocios;
    }

    /**
     * Modifica el numero de socios
     *
     * @param numSocios nuevo numero de socios
     */
    public void setNumSocios(int numSocios) {
        this.numSocios = numSocios;
    }

    /**
     * Indica las ganancias totales. Muestra lo ganado por cada socio
     *
     * @param cantidad
     * @return
     */
    @Override
    public String gananciasTotales(double cantidad) {

        double ganancia = cantidad / this.numSocios;

        return "La cantidad ganada por cada socio es de " + ganancia;

    }

    /**
     * Devuelve la informacion mas detallada del objeto
     *
     * @return info
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " Es privado y tiene " + numSocios + " socios";
    }

    @Override
    public ObservableList<AeropuertoPrivado> getAeropuertos(String busqueda) throws SQLException {

        // Creo el ObservableList
        ObservableList<AeropuertoPrivado> aeropuertos = FXCollections.observableArrayList();

        // Abro la conexion
        ConexionDB conexion = new ConexionDB();

        // Formo el SQL
        String SQL = "";
        SQL += "SELECT a.id, a.nombre, a.anio_inauguracion, a.capacidad, ";
        SQL += "d.id as id_direccion, d.pais, d.ciudad, d.calle, d.numero, ap.numero_socios ";
        SQL += "FROM aeropuertos a, direcciones d, aeropuertos_privados ap ";
        SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";

        if (busqueda != null && !busqueda.isEmpty()) {
            SQL += " and trim(lower(a.nombre)) LIKE '" + busqueda.toLowerCase().trim() + "%'";
        }

        // Ejecuto la consulta y la guardo en un resultset
        ResultSet rs = conexion.ejecutarConsulta(SQL);

        // Recorro los datos
        while (rs.next()) {

            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int anio = rs.getInt("anio_inauguracion");
            int capacidad = rs.getInt("capacidad");
            int idDireccion = rs.getInt("id_direccion");
            String pais = rs.getString("pais");
            String ciudad = rs.getString("ciudad");
            String calle = rs.getString("calle");
            int numero = rs.getInt("numero");

            int numeroSocios = rs.getInt("numero_socios");

            // Creo la direccion
            Direccion dir = new Direccion(pais, calle, numero, ciudad);

            // Creo el aeropuerto
            AeropuertoPrivado a = new AeropuertoPrivado(numeroSocios, id, nombre, dir, anio, capacidad);

            // actualizo el id de la direccion
            a.getDireccion().setId(idDireccion);

            // Añado el aeropuerto a la lista
            aeropuertos.add(a);

        }

        // Cerramos el ResultSet
        rs.close();

        // Cerramos la conexion
        conexion.cerrarConexion();

        // Recorro los aeropuertos
        for (AeropuertoPrivado a : aeropuertos) {

            // Creo un avion y lo asocio con el aeropuerto
            Avion avion = new Avion();
            avion.setIdAeropuerto(a.getId());

            // Recojo los aviones de ese aeropuerto
            ObservableList<Avion> aviones = avion.getAviones();

            // Añado los aeropuertos
            for (Avion av : aviones) {
                a.aniadirAvion(av);
            }

        }

        // Devuelvo el observable de aeropuertos
        return aeropuertos;

    }

    /**
     * Inserta un aeropuerto privado
     *
     * @return
     * @throws SQLException
     */
    @Override
    public boolean insertar() throws SQLException {

        // Llamo al padre para insertar el aeropuerto
        boolean exito = super.insertar();

        // Si se inserto el aeropuerto
        if (exito) {

            // Abro la conexion
            ConexionDB conexion = new ConexionDB();

            // Formo el SQL
            String SQL = "";
            SQL += "INSERT INTO aeropuertos_privados VALUES (" + super.getId() + ", ";
            SQL += this.numSocios + ")";

            // Ejecuto la instruccion
            int filas = conexion.ejecutarInstruccion(SQL);

            // cierro la conexion
            conexion.cerrarConexion();

            // Indico si se ha insertado o no
            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * Inserta un aeropuerto privado
     *
     * @return
     * @throws SQLException
     */
    @Override
    public boolean actualizar() throws SQLException {

        // Llamo al padre para insertar el aeropuerto
        boolean exito = super.actualizar();

        // Si se inserto el aeropuerto
        if (exito) {

            // Abro la conexion
            ConexionDB conexion = new ConexionDB();

            // Formo el SQL
            String SQL = "";
            SQL += "UPDATE aeropuertos_privados SET numero_socios = " + this.numSocios + " ";
            SQL += "WHERE id_aeropuerto = " + super.getId();

            // Ejecuto la instruccion
            int filas = conexion.ejecutarInstruccion(SQL);

            // cierro la conexion
            conexion.cerrarConexion();

            // Indico si se ha insertado o no
            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
