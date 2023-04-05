/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.Aeropuerto;
import modelo.Avion;
import util.MetodosSueltos;

/**
 * FXML Controller class
 *
 * 
 */
public class EliminarAvionController implements Initializable {

    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnEliminar;
    @FXML
    private ComboBox<Avion> cmbAviones;
    @FXML
    private ComboBox<Aeropuerto> cmbAeropuertos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            // Cargo los aeropuertos
            ObservableList<Aeropuerto> obs = MetodosSueltos.cargarAeropuertos();
            this.cmbAeropuertos.setItems(obs);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Cierra la ventana
     *
     * @param event
     */
    @FXML
    private void cancelar(ActionEvent event) {

        // Cierro la ventana
        Stage myStage = (Stage) this.btnCancelar.getScene().getWindow();
        myStage.close();
    }

    /**
     * Carga los aviones al seleccionar un aeropuerto
     *
     * @param event
     */
    @FXML
    private void cargarAviones(ActionEvent event) {
        this.cargarAvionesAeropuerto();
    }

    /**
     * Carga lo aviones
     */
    private void cargarAvionesAeropuerto() {
        // Cojo el aeropuerto
        Aeropuerto a = this.cmbAeropuertos.getValue();

        // Sino no es nulo
        if (a != null) {

            try {
                // Creo un avion y lo seteo el ide del aeropuerto
                Avion avion = new Avion();
                avion.setIdAeropuerto(a.getId());

                // Obtengo los aviones
                ObservableList<Avion> obs = avion.getAviones();

                // Cargo los aviones
                this.cmbAviones.setItems(obs);

            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }

        }
    }

    /**
     * Elimina un avion
     *
     * @param event
     */
    @FXML
    private void eliminarAvion(ActionEvent event) {
        // Coje el avion seleccionado
        Avion a = this.cmbAviones.getValue();

        if (a == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un avion");
            alert.showAndWait();
        } else {

            try {
                // Borrar el avion
                if (a.borrar()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Exito");
                    alert.setContentText("Se ha borrado el avion");
                    alert.showAndWait();

                    // Cargo los aeropuertos de nuevo
                    this.cargarAvionesAeropuerto();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("No se ha borrado el avion");
                    alert.showAndWait();
                }
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }

        }
    }

}
