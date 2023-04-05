package modelo;

import java.io.Serializable;
import java.sql.SQLException;
import util.ConexionDB;

/**
 * Clase Direccion, representa una direccion
 *
 * 
 */
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String pais;
    private String calle;
    private int numero;
    private String ciudad;

    /**
     * Constructor vacio
     */
    public Direccion() {
        this(0, "", "", 0, "");
    }

    /**
     * Constructor completo
     *
     * @param pais pais donde se encuentra
     * @param calle calle donde se encuentra
     * @param numero numero donde se encuentra
     * @param ciudad ciudad donde se encuentra
     */
    public Direccion(String pais, String calle, int numero, String ciudad) {
        this.pais = pais;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    /**
     * Constructor completo
     *
     * @param id id de la direccion
     * @param pais pais donde se encuentra
     * @param calle calle donde se encuentra
     * @param numero numero donde se encuentra
     * @param ciudad ciudad donde se encuentra
     */
    public Direccion(int id, String pais, String calle, int numero, String ciudad) {
        this.id = id;
        this.pais = pais;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    /**
     * Devuelve el id de la direccion
     *
     * @return id de la direccion
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica el id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el pais
     *
     * @return pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Modifica el pais
     *
     * @param pais nuevo pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Devuelve la calle
     *
     * @return calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Modifica la calle
     *
     * @param calle nueva calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Devuelve el numero
     *
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifica el numero
     *
     * @param numero nuevo numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve la ciudad
     *
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Modifica la ciudad
     *
     * @param ciudad nueva ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Insertar la direccion en la BD
     *
     * @return indica si se ha insertado o no
     * @throws SQLException
     */
    public boolean insertar() throws SQLException {

        ConexionDB conexion = new ConexionDB();

        String SQL = "";
        SQL += "INSERT INTO direcciones VALUES(null, ";
        SQL += "'" + this.pais + "', '" + this.ciudad + "', '" + this.calle + "', " + this.numero + ")";

        int filas = conexion.ejecutarInstruccion(SQL);

        this.id = conexion.ultimoID();

        conexion.cerrarConexion();

        return filas > 0;

    }

    /**
     * Actualizar la direccion en la BD
     *
     * @return indica si se ha actualizado o no
     * @throws SQLException
     */
    public boolean actualizar() throws SQLException {

        ConexionDB conexion = new ConexionDB();

        String SQL = "";
        SQL += "UPDATE direcciones SET pais = '" + this.pais + "', ciudad = '" + this.ciudad + "', ";
        SQL += "calle = '" + this.calle + "', numero = " + this.numero + " ";
        SQL += "WHERE id = " + this.id;

        int filas = conexion.ejecutarInstruccion(SQL);

        conexion.cerrarConexion();

        return filas > 0;

    }

    /**
     * Borrar la direccion en la BD
     *
     * @return indica si se ha borrar o no
     * @throws SQLException
     */
    public boolean borrar() throws SQLException {

        ConexionDB conexion = new ConexionDB();

        String SQL = "DELETE FROM direcciones WHERE id = " + this.id;

        int filas = conexion.ejecutarInstruccion(SQL);

        conexion.cerrarConexion();

        return filas > 0;

    }

    /**
     * Devuelve la informacion del objeto
     *
     * @return info
     */
    @Override
    public String toString() {
        return "esta en el pais " + pais + " en la direccion: \n "
                + "calle " + calle + ", numero " + numero + ", ciudad " + ciudad + ".";
    }

}
