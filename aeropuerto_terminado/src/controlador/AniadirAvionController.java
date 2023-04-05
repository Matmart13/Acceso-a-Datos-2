/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import modelo.Aeropuerto;
import modelo.Avion;
import util.MetodosSueltos;

/**
 * FXML Controller class
 *
 * 
 */
public class AniadirAvionController implements Initializable {

    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtAsientos;
    @FXML
    private TextField txtVelMax;
    @FXML
    private RadioButton rdbActivado;
    @FXML
    private RadioButton rdbDesactivado;
    @FXML
    private ComboBox<Aeropuerto> cmbAeropuerto;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            ToggleGroup group = new ToggleGroup();

            this.rdbActivado.setToggleGroup(group);
            this.rdbDesactivado.setToggleGroup(group);

            ObservableList<Aeropuerto> obsAeropuertos = MetodosSueltos.cargarAeropuertos();
            this.cmbAeropuerto.setItems(obsAeropuertos);
        } catch (SQLException ex) {
            Logger.getLogger(AniadirAvionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void guardar(ActionEvent event) {

        String errores = "";

        String modelo = this.txtModelo.getText();

        boolean activado = this.rdbActivado.isSelected();

        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtAsientos.getText())) {
            errores += "- Debes insertar un numero en los asientos\n";
        }

        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtVelMax.getText())) {
            errores += "- Debes insertar un numero en la velocidad maxima\n";
        }

        if (this.cmbAeropuerto.getValue() == null) {
            errores += "- Debes seleccionar un aeropuerto\n";
        }

        if (errores.isEmpty()) {

            try {
                Aeropuerto a = this.cmbAeropuerto.getValue();

                int nAsientos = Integer.parseInt(this.txtAsientos.getText());
                int velMax = Integer.parseInt(this.txtVelMax.getText());

                Avion avion = new Avion(modelo, nAsientos, velMax, a.getId());

                avion.setActivado(activado);

                if (avion.insertar()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Exito");
                    alert.setContentText("Se ha insertado el avion");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("No se ha insertado el avion");
                    alert.showAndWait();
                }
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(errores);
            alert.showAndWait();
        }

    }

    @FXML
    private void cancelar(ActionEvent event) {
        // Cierro la ventana
        Stage myStage = (Stage) this.btnCancelar.getScene().getWindow();
        myStage.close();
    }

}
