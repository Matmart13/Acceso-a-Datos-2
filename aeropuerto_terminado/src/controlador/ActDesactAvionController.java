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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import modelo.Aeropuerto;
import modelo.Avion;
import util.MetodosSueltos;

public class ActDesactAvionController implements Initializable {

    @FXML
    private ComboBox<Aeropuerto> cmbAeropuertos;
    @FXML
    private ComboBox<Avion> cmbAviones;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnCancelar;
    @FXML
    private RadioButton rdbActivado;
    @FXML
    private RadioButton rdbDesactivado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            ToggleGroup toggle = new ToggleGroup();

            this.rdbActivado.setToggleGroup(toggle);
            this.rdbDesactivado.setToggleGroup(toggle);

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
     * Carga los aviones al seleccionar un aeropuerto
     *
     * @param event
     */
    @FXML
    private void cargarAviones(ActionEvent event) {

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
     * Al seleccionar un avion, marca si esta o no activo
     *
     * @param event
     */
    @FXML
    private void seleccionarActivado(ActionEvent event) {

        // Cojo el avion
        Avion a = this.cmbAviones.getValue();

        // Indico visualmente si esta o no activado
        if (a.isActivado()) {
            this.rdbActivado.setSelected(true);
        } else {
            this.rdbDesactivado.setSelected(true);
        }

    }

    /**
     * Actualiza el estado del avion
     *
     * @param event
     */
    @FXML
    private void actualizarAvion(ActionEvent event) {

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
                // Modifica el estado del avion segun lo seleccionado
                a.setActivado(this.rdbActivado.isSelected());

                // Actualizo el avion
                if (a.actualizar()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Exito");
                    alert.setContentText("Se ha actualizado el avion");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("No se ha actualizado el avion");
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

    @FXML
    private void cancelar(ActionEvent event) {

        // Cierro la ventana
        Stage myStage = (Stage) this.btnActualizar.getScene().getWindow();
        myStage.close();
    }

}
