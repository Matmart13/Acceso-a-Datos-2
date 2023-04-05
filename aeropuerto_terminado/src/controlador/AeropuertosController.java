/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Aeropuerto;
import modelo.AeropuertoPrivado;
import modelo.AeropuertoPublico;
import util.MetodosSueltos;

public class AeropuertosController implements Initializable {

    @FXML
    private TableView tblAeropuertos;
    @FXML
    private TableColumn<Aeropuerto, Integer> colId;
    @FXML
    private TableColumn<Aeropuerto, String> colNombre;
    @FXML
    private TableColumn<Aeropuerto, String> colPais;
    @FXML
    private TableColumn<Aeropuerto, String> colCiudad;
    @FXML
    private TableColumn<Aeropuerto, String> colCalle;
    @FXML
    private TableColumn<Aeropuerto, Integer> colNumero;
    @FXML
    private TableColumn<Aeropuerto, Integer> colAnio;
    @FXML
    private TableColumn<Aeropuerto, Integer> colCapacidad;
    @FXML
    private TableColumn<Aeropuerto, Integer> colSocios;
    @FXML
    private TableColumn<Aeropuerto, Double> colFinanciacion;
    @FXML
    private TableColumn<Aeropuerto, Integer> colDiscapacitados;
    @FXML
    private RadioButton rdbPrivados;
    @FXML
    private RadioButton rdbPublicos;
    @FXML
    private TextField txtFiltroNombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Sirve para relacionar radio button
        ToggleGroup group = new ToggleGroup();

        // indico que estan relacionados
        this.rdbPrivados.setToggleGroup(group);
        this.rdbPublicos.setToggleGroup(group);

        // Asocio las columnas con las propiedades del objeto
        this.colId.setCellValueFactory(new PropertyValueFactory("id"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colPais.setCellValueFactory(new PropertyValueFactory("pais"));
        this.colCiudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
        this.colCalle.setCellValueFactory(new PropertyValueFactory("calle"));
        this.colNumero.setCellValueFactory(new PropertyValueFactory("numero"));
        this.colAnio.setCellValueFactory(new PropertyValueFactory("anioInauguracion"));
        this.colCapacidad.setCellValueFactory(new PropertyValueFactory("capacidad"));
        this.colSocios.setCellValueFactory(new PropertyValueFactory("numSocios"));
        this.colFinanciacion.setCellValueFactory(new PropertyValueFactory("financiacion"));
        this.colDiscapacitados.setCellValueFactory(new PropertyValueFactory("numTrabajadoresDiscapacitados"));

        // Cargo los aeropuertos al iniciar
        this.cargarAeropuertos();
    }

    /**
     * Carga los aeropuertos privados
     *
     * @param event
     */
    @FXML
    private void cambiarAeropuertosPrivados(ActionEvent event) {
        this.cargarAeropuertos();
    }

    /**
     * Carga los aeropuertos publicos
     *
     * @param event
     */
    @FXML
    private void cambiarAeropuertosPublicos(ActionEvent event) {
        this.cargarAeropuertos();
    }

    /**
     * Abre la vista para añadir un aeropuerto
     *
     * @param event
     */
    @FXML
    private void AniadirAeropuerto(ActionEvent event) {

        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Añadir_editar_AeropuertoVista.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Añadir aeropuerto");
            MetodosSueltos.iconoVentana(stage);
            stage.showAndWait();

            // cargo los aeropuertos de nuevo
            this.cargarAeropuertos();

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

    /**
     * Abre la ventana para editar un aeropuerto
     *
     * @param event
     */
    @FXML
    private void editarAeropuerto(ActionEvent event) {

        // Obtengo el aeropuerto seleccionado
        Aeropuerto a = (Aeropuerto) this.tblAeropuertos.getSelectionModel().getSelectedItem();

        // Si es nulo, muestro error
        if (a == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un aeropuerto");
            alert.showAndWait();
        } else {

            try {
                // carga la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Añadir_editar_AeropuertoVista.fxml"));

                // Cargo el padre
                Parent root = loader.load();

                // Cargo el controlador asociado a la vista y le paso el aeropuerto seleccionado
                Añadir_editar_AeropuertoController controlador = loader.getController();
                controlador.initAttributes(a);

                // Creo la scene
                Scene scene = new Scene(root);

                // Creo la stage
                Stage stage = new Stage();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setTitle("Editar aeropuerto");

                MetodosSueltos.iconoVentana(stage);
                stage.showAndWait();

                // cargo los aeropuertos de nuevo
                this.cargarAeropuertos();
                this.tblAeropuertos.refresh();

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }

        }

    }

    /**
     * Borra el aropuerto seleccionado
     *
     * @param event
     */
    @FXML
    private void borrarAeropuerto(ActionEvent event) {

        // Obtengo el aeropuerto seleccionado
        Aeropuerto a = (Aeropuerto) this.tblAeropuertos.getSelectionModel().getSelectedItem();

        // Si es nulo, muestro error
        if (a == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un aeropuerto");
            alert.showAndWait();
        } else {

            // Abrimos una ventana de confirmacion
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Introduce");
            alert.setContentText("¿Quieres borrar el aeropuerto?");
            // Cogemos el resultado del boton seleccionado
            Optional<ButtonType> action = alert.showAndWait();

            // Si hemos pulsado en aceptar
            if (action.get() == ButtonType.OK) {

                try {
                    // Borramos el aeropuerto
                    if (a.borrarAeropuerto()) {

                        // Borramos la direccion
                        if (a.getDireccion().borrar()) {
                            Alert alertAeropuerto = new Alert(Alert.AlertType.INFORMATION);
                            alertAeropuerto.setHeaderText(null);
                            alertAeropuerto.setTitle("Exito");
                            alertAeropuerto.setContentText("Se ha borrado el aeropuerto y la direccion");
                            alertAeropuerto.showAndWait();

                        } else {
                            Alert alertAeropuerto = new Alert(Alert.AlertType.INFORMATION);
                            alertAeropuerto.setHeaderText(null);
                            alertAeropuerto.setTitle("Exito");
                            alertAeropuerto.setContentText("No se ha borrado la direccion");
                            alertAeropuerto.showAndWait();
                        }

                    } else {
                        Alert alertAeropuerto = new Alert(Alert.AlertType.ERROR);
                        alertAeropuerto.setHeaderText(null);
                        alertAeropuerto.setTitle("Error");
                        alertAeropuerto.setContentText("No se ha borrado el aeropuerto");
                        alertAeropuerto.showAndWait();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(AeropuertosController.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Cargamos de nuevo
                this.cargarAeropuertos();
                this.tblAeropuertos.refresh();

            }

        }

    }

    /**
     * Muestra las ganancias del aeropuerto
     *
     * @param event
     */
    @FXML
    private void gananciasAeropuerto(ActionEvent event) {

        // Obtengo el aeropuerto seleccionado
        Aeropuerto a = (Aeropuerto) this.tblAeropuertos.getSelectionModel().getSelectedItem();

        // Si es nulo, muestro error
        if (a == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un aeropuerto");
            alert.showAndWait();
        } else {

            // TextInputDialog sirve parapedir valores
            TextInputDialog tid = new TextInputDialog();
            tid.setHeaderText(null);
            tid.setTitle("Error");
            tid.setContentText("Introduce una cantidad");
            Optional<String> texto = tid.showAndWait();

            // Valido si es un numero real
            if (!MetodosSueltos.validaNumeroReal_Exp(texto.get())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El numero debe ser una cantidad real");
                alert.showAndWait();
            } else {

                // Casteamos el valor
                double cantidad = Double.parseDouble(texto.get());

                // Mostramos las ganancias
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Ganancias");
                alert.setContentText(a.gananciasTotales(cantidad));
                alert.showAndWait();

            }

        }

    }

    /**
     * Muestra la informacion completa del aeropuerto
     *
     * @param event
     */
    @FXML
    private void infoAeropuerto(ActionEvent event) {
        // Obtengo el aeropuerto seleccionado
        Aeropuerto a = (Aeropuerto) this.tblAeropuertos.getSelectionModel().getSelectedItem();

        // Si es nulo, muestro error
        if (a == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un aeropuerto");
            alert.showAndWait();
        } else {
            // Mostramos la informacion del aeropuerto
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Exito");
            alert.setContentText(a.mostrarInformacion());
            alert.showAndWait();
        }
    }

    /**
     * Muestra la vista para añadir un avion
     *
     * @param event
     */
    @FXML
    private void aniadirAvion(ActionEvent event) {
        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/AniadirAvionVista.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Añadir avión");

            MetodosSueltos.iconoVentana(stage);
            stage.showAndWait();

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Muestra la vista para activar o desactivar un avion
     *
     * @param event
     */
    @FXML
    private void activarDesactivarAvion(ActionEvent event) {

        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ActDesactAvionVista.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Activar/desactivar avion");

            MetodosSueltos.iconoVentana(stage);
            stage.showAndWait();

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

    /**
     * Muestra la vista para borrar un avion
     *
     * @param event
     */
    @FXML
    private void BorrarAvion(ActionEvent event) {

        try {
            // carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EliminarAvionVista.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Eliminar avion");

            MetodosSueltos.iconoVentana(stage);
            stage.showAndWait();

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

    /**
     * Filtra aeropuertos por nombre
     *
     * @param event
     */
    @FXML
    private void filtroPorNombre(KeyEvent event) {
        this.cargarAeropuertos();
        
        
        
        
    }

    /**
     * Cargo los aeropuertos segun el filtro seleccionado
     */
    private void cargarAeropuertos() {
        try {

            String busqueda = this.txtFiltroNombre.getText();

            // Si el radio de privados esta seleccionado
            if (this.rdbPrivados.isSelected()) {

                // Cargo los aeropuertos privados
                AeropuertoPrivado ap = new AeropuertoPrivado();
                ObservableList<AeropuertoPrivado> obs = ap.getAeropuertos(busqueda);
                this.tblAeropuertos.setItems(obs);

                // Muestro la columna de socios
                this.colSocios.setVisible(true);

                //Oculto las columnas de financiacion y discapacitados
                this.colFinanciacion.setVisible(false);
                this.colDiscapacitados.setVisible(false);

            } else {

                // Cargo los aeropuertos publicos
                AeropuertoPublico ap = new AeropuertoPublico();
                ObservableList<AeropuertoPublico> obs = ap.getAeropuertos(busqueda);
                this.tblAeropuertos.setItems(obs);

                // Oculta la columna de socios
                this.colSocios.setVisible(false);

                // Muestro las columnas de financiacion y discapacitados
                this.colFinanciacion.setVisible(true);
                this.colDiscapacitados.setVisible(true);

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
