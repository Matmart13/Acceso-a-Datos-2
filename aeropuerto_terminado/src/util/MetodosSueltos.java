/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.Aeropuerto;
import modelo.AeropuertoPrivado;
import modelo.AeropuertoPublico;

public class MetodosSueltos {

    /**
     * Valida si una cadena es un numero entero
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero entero
     */
    public static boolean validaNumeroEntero_Exp(String texto) {
        return texto.matches("^-?[0-9]+$");
    }

    /**
     * Valida si una cadena es un numero real (positivo o negativo)
     *
     * @param texto String que contiene el valor a validar
     * @return True = es un numero real
     */
    public static boolean validaNumeroReal_Exp(String texto) {
        return texto.matches("^-?[0-9]+([\\.,][0-9]+)?$");
    }

    /**
     * Carga todos los aeropuertos de la BD
     * @return ObservableList con todos los aeropuertos
     * @throws SQLException 
     */
    public static ObservableList<Aeropuerto> cargarAeropuertos() throws SQLException {

        ObservableList<Aeropuerto> obsAeropuertos = FXCollections.observableArrayList();

        AeropuertoPrivado apri = new AeropuertoPrivado();
        AeropuertoPublico apub = new AeropuertoPublico();

        ObservableList<AeropuertoPrivado> obsAeropuertosPrivados = apri.getAeropuertos("");
        ObservableList<AeropuertoPublico> obsAeropuertosPublicos = apub.getAeropuertos("");

        for (AeropuertoPrivado a : obsAeropuertosPrivados) {
            obsAeropuertos.add(a);
        }

        for (AeropuertoPublico a : obsAeropuertosPublicos) {
            obsAeropuertos.add(a);
        }

        return obsAeropuertos;
        
    }
    
    
    public static void iconoVentana(Stage stage){
        stage.getIcons().add(new Image("/img/plane.png"));
    }

}
