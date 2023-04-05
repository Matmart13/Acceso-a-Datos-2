package modelo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.ConexionDB;

/**
 * Clase Avion, representa un avion
 *
 * 
 */
public class Avion implements Activable, Serializable {

    private static final long serialVersionUID = 1L;
    // Atributos
    private int id;
    private String modelo;
    private int nAsientos;
    private double velocidadMaxima;
    private boolean activado;
    private int idAeropuerto;

    /**
     * Constructor vacio
     */
    public Avion() {
        this("", 0, 0, 0);
    }

    /**
     * Constructor completo
     *
     * @param modelo model del avion
     * @param nAsientos numero de asientos del avion
     * @param velocidadMaxima velocidad maxima del avion
     * @param idAeropuerto id del aeropuerto al que pertenece
     */
    public Avion(String modelo, int nAsientos, double velocidadMaxima, int idAeropuerto) {
        this.modelo = modelo;
        this.nAsientos = nAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.activado = false;
        this.idAeropuerto = idAeropuerto;
    }

    /**
     * Constructor completo
     *
     * @param id id del avion
     * @param modelo model del avion
     * @param nAsientos numero de asientos del avion
     * @param velocidadMaxima velocidad maxima del avion
     * @param idAeropuerto id del aeropuerto al que pertenece
     */
    public Avion(int id, String modelo, int nAsientos, double velocidadMaxima, int idAeropuerto) {
        this.id = id;
        this.modelo = modelo;
        this.nAsientos = nAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.activado = false;
        this.idAeropuerto = idAeropuerto;
    }

    /**
     * Devuelve el id del avion
     *
     * @return id del avion
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el modelo del avion
     *
     * @return model del avion
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Modifica el modelo del avion
     *
     * @param modelo nuevo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve el numero de asientos
     *
     * @return numero de asientos
     */
    public int getnAsientos() {
        return nAsientos;
    }

    /**
     * Modifica el numero de asientos
     *
     * @param nAsientos nuevo numero de asientos
     */
    public void setnAsientos(int nAsientos) {
        this.nAsientos = nAsientos;
    }

    /**
     * Devuelve la velocidad maxima
     *
     * @return velocidad maxima
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Modifica la velocidad maxima
     *
     * @param velocidadMaxima nueva velocidad maxima
     */
    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Indica si el avion esta activado
     *
     * @return a true si esta activado, false si no lo esta
     */
    @Override
    public boolean isActivado() {
        return activado;
    }

    /**
     * Modifca si esta activado o no
     *
     * @param value nueva
     */
    @Override
    public void setActivado(boolean value) {
        this.activado = value;
    }

    /**
     * Devuelve el id del aeropuerto
     *
     * @return id del aeropuerto
     */
    public int getIdAeropuerto() {
        return idAeropuerto;
    }

    /**
     * Modifica el id del aeropuerto
     *
     * @param idAeropuerto nuevo id aeropuerto
     */
    public void setIdAeropuerto(int idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    /**
     * Devuelve un ObservableList con los aviones
     *
     * @return ObservableList con todos los aviones de un aeropuerto
     * @throws SQLException
     */
    public ObservableList<Avion> getAviones() throws SQLException {

        ConexionDB conexion = new ConexionDB();

        ObservableList<Avion> aviones = FXCollections.observableArrayList();

        // Formo el SQL
        String SQL = "";
        SQL += "SELECT *";
        SQL += "FROM aviones ";
        SQL += "WHERE id_aeropuerto = " + this.idAeropuerto;

        ResultSet rs = conexion.ejecutarConsulta(SQL);

        while (rs.next()) {

            int idAvion = rs.getInt("id");
            String modelo = rs.getString("modelo");
            int numeroAsientos = rs.getInt("numero_asientos");
            int velMax = rs.getInt("velocidad_maxima");
            int activado = rs.getInt("activado");

            // Creo el objeto
            Avion a = new Avion(idAvion, modelo, numeroAsientos, velMax, this.idAeropuerto);

            // Si esta activado lo indico
            if (activado == 1) {
                a.setActivado(true);
            }

            // Añado el avion
            aviones.add(a);
        }

        conexion.cerrarConexion();

        return aviones;

    }

    /**
     * Inserta un avion en la BD
     *
     * @return indica si se ha insertado o no
     * @throws SQLException
     */
    public boolean insertar() throws SQLException {

        ConexionDB conexion = new ConexionDB();

        // Como es un boolean, lo tengo que poner como numero
        int act = 0;

        // Si esta activaod, lo pongo a 1
        if (this.activado) {
            act = 1;
        }

        // Formo el SQL
        String SQL = "";
        SQL += "INSERT INTO aviones VALUES(null, ";
        SQL += "'" + this.modelo + "', " + this.nAsientos + ", ";
        SQL += this.velocidadMaxima + ", " + act + ", " + this.idAeropuerto + ") ";

        // Recupero las filas
        int filas = conexion.ejecutarInstruccion(SQL);

        // Obtenemos el ultimo id
        this.id = conexion.ultimoID();

        conexion.cerrarConexion();

        return filas > 0;

    }

    /**
     * Actualiza un avion en la BD
     *
     * @return indica si se ha actualizado o no
     * @throws SQLException
     */
    public boolean actualizar() throws SQLException {

        ConexionDB conexion = new ConexionDB();

        // Como es un boolean, lo tengo que poner como numero
        int act = 0;

        // Si esta activaod, lo pongo a 1
        if (this.activado) {
            act = 1;
        }

        // Formo el SQL
        String SQL = "UPDATE aviones SET activado =  " + act + " WHERE id = " + this.id;

        // Recupero las filas
        int filas = conexion.ejecutarInstruccion(SQL);

        conexion.cerrarConexion();

        return filas > 0;

    }

    /**
     * Borra un avion en la BD
     *
     * @return indica si se ha borra o no
     * @throws SQLException
     */
    public boolean borrar() throws SQLException {

        ConexionDB conexion = new ConexionDB();

        // Formo el SQL
        String SQL = "DELETE FROM aviones WHERE id = " + this.id;

        // Recupero las filas
        int filas = conexion.ejecutarInstruccion(SQL);

        conexion.cerrarConexion();

        return filas > 0;

    }

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
        final Avion other = (Avion) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve la informacion del objeto
     *
     * @return info
     */
    @Override
    public String toString() {
        return "Avion{" + "modelo=" + modelo + ", nAsientos=" + nAsientos + ", velocidadMaxima=" + velocidadMaxima + '}';
    }

}
