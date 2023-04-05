/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import modelo.Aeropuerto;
import modelo.AeropuertoPrivado;
import modelo.AeropuertoPublico;
import modelo.Direccion;
import util.MetodosSueltos;

public class Añadir_editar_AeropuertoController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txtPais;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtCalle;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtAnio;
    @FXML
    private TextField txtCapacidad;
    @FXML
    private TextField txtFinanciacion;
    @FXML
    private TextField txtDiscapacitados;
    @FXML
    private TextField txtSocios;
    @FXML
    private RadioButton rdbPublico;
    @FXML
    private RadioButton rdbPrivado;

    private Aeropuerto aeropuerto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ToggleGroup toggle = new ToggleGroup();
        this.rdbPrivado.setToggleGroup(toggle);
        this.rdbPublico.setToggleGroup(toggle);

        this.txtSocios.setEditable(false);
    }

    public void initAttributes(Aeropuerto a) {
        this.aeropuerto = a;

        // Relleno los campos
        this.txtNombre.setText(a.getNombre());
        this.txtPais.setText(a.getPais());
        this.txtCiudad.setText(a.getCiudad());
        this.txtCalle.setText(a.getCalle());
        this.txtNumero.setText(a.getNumero() + "");
        this.txtCapacidad.setText(a.getCapacidad() + "");
        this.txtAnio.setText(a.getAnioInauguracion() + "");

        // Segun si es privado o publico
        if (a instanceof AeropuertoPrivado) {
            this.rdbPrivado.setSelected(true);
            AeropuertoPrivado ap = (AeropuertoPrivado) a;
            this.txtSocios.setText(ap.getNumSocios() + "");

            // Deshabilito Campos publicos
            this.txtDiscapacitados.setEditable(false);
            this.txtFinanciacion.setEditable(false);

            // Habilito campo socios
            this.txtSocios.setEditable(true);
        } else {
            this.rdbPublico.setSelected(true);
            AeropuertoPublico ap = (AeropuertoPublico) a;
            this.txtFinanciacion.setText(ap.getFinanciacion() + "");
            this.txtDiscapacitados.setText(ap.getNumTrabajadoresDiscapacitados() + "");

            // Deshabilito los campos privados
            this.txtSocios.setEditable(false);

            // Habilito los campos publicos
            this.txtDiscapacitados.setEditable(true);
            this.txtFinanciacion.setEditable(true);
        }

        // Sellamos los radio buttons
        this.rdbPrivado.setDisable(true);
        this.rdbPublico.setDisable(true);

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
     * Inserta o edita el aeropuerto
     *
     * @param event
     */
    @FXML
    private void guardar(ActionEvent event) {

        // Indico los errores que tengamos
        String errores = "";

        // Obtengo los datos
        String nombre = this.txtNombre.getText();
        String pais = this.txtPais.getText();
        String ciudad = this.txtCiudad.getText();
        String calle = this.txtCalle.getText();

        // Valido los numeros
        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtNumero.getText())) {
            errores += "- El numero de la calle debe ser un numero. \n";
        }

        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtCapacidad.getText())) {
            errores += "- La capacidad debe ser un numero. \n";
        }

        if (!MetodosSueltos.validaNumeroEntero_Exp(this.txtAnio.getText())) {
            errores += "- El año debe ser un numero. \n";
        }

        if (this.rdbPublico.isSelected() && !MetodosSueltos.validaNumeroReal_Exp(this.txtFinanciacion.getText())) {
            errores += "- La financiacion debe ser un numero real. \n";
        }

        if (this.rdbPublico.isSelected() && !MetodosSueltos.validaNumeroEntero_Exp(this.txtDiscapacitados.getText())) {
            errores += "- El numero de trabajadores debe ser un numero. \n";
        }

        if (this.rdbPrivado.isSelected() && !MetodosSueltos.validaNumeroEntero_Exp(this.txtSocios.getText())) {
            errores += "- Los socios deben ser un numero. \n";
        }

        // Si no hay errores, continuamos
        if (errores.isEmpty()) {

            try {
                // Parseamos los valores
                int numero = Integer.parseInt(this.txtNumero.getText());
                int capacidad = Integer.parseInt(this.txtCapacidad.getText());
                int anioInauguracion = Integer.parseInt(this.txtAnio.getText());

                if (this.aeropuerto == null) {
                    Aeropuerto aux;

                    // Creo la direccion
                    Direccion dir = new Direccion(pais, calle, numero, ciudad);

                    // Inserto la direccion
                    if (dir.insertar()) {

                        // Si elegimos publico
                        if (this.rdbPublico.isSelected()) {

                            // Obtenemos los datos del aeropuerto publico
                            double financiacion = Double.parseDouble(this.txtFinanciacion.getText());
                            int discapacitados = Integer.parseInt(this.txtDiscapacitados.getText());

                            aux = new AeropuertoPublico(financiacion, discapacitados, nombre, dir, anioInauguracion, capacidad);

                        } else {

                            // Obtenemos los datos del aeropuerto pricado
                            int socios = Integer.parseInt(this.txtSocios.getText());

                            aux = new AeropuertoPrivado(socios, nombre, dir, anioInauguracion, capacidad);

                        }

                        // Seteamos de nuevo la direccion
                        // Esto es porque cuando creamos el objeto del aeropuerto, este no le metemos el id directamente
                        aux.setDireccion(dir);

                        // Inserto el aeropuerto
                        if (aux.insertar()) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Exito");
                            alert.setContentText("El aeropuerto se ha insertado");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("El aeropuerto no se ha insertado");
                            alert.showAndWait();
                        }

                    }
                } else {

                    this.aeropuerto.setNombre(nombre);
                    this.aeropuerto.setCapacidad(capacidad);
                    this.aeropuerto.setAnioInauguracion(anioInauguracion);

                    Direccion dir = this.aeropuerto.getDireccion();

                    dir.setPais(pais);
                    dir.setCalle(calle);
                    dir.setCiudad(ciudad);
                    dir.setNumero(numero);

                    // Actualizamos la direccion
                    if (dir.actualizar()) {

                        // Si elegimos publico
                        if (this.rdbPublico.isSelected()) {

                            // Obtenemos los datos del aeropuerto publico
                            double financiacion = Double.parseDouble(this.txtFinanciacion.getText());
                            int discapacitados = Integer.parseInt(this.txtDiscapacitados.getText());

                            AeropuertoPublico ap = (AeropuertoPublico) this.aeropuerto;
                            ap.setFinanciacion(financiacion);
                            ap.setNumTrabajadoresDiscapacitados(discapacitados);

                        } else {

                            // Obtenemos los datos del aeropuerto pricado
                            int socios = Integer.parseInt(this.txtSocios.getText());
                            AeropuertoPrivado ap = (AeropuertoPrivado) this.aeropuerto;

                            ap.setNumSocios(socios);

                        }

                        // Actualizamos el aeropuerto
                        if (this.aeropuerto.actualizar()) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Exito");
                            alert.setContentText("El aeropuerto se ha actualizado");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("El aeropuerto no se ha actualizado");
                            alert.showAndWait();
                        }

                    }

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
    private void cambiarCamposPublicos(ActionEvent event) {

        // habilito los campos publicos
        this.txtDiscapacitados.setEditable(true);
        this.txtFinanciacion.setEditable(true);

        // Deshabilito los campos privados
        this.txtSocios.setEditable(false);
        this.txtSocios.setText("");

    }

    @FXML
    private void cambiarCamposPrivados(ActionEvent event) {

        // Deshabilito los campos publicos
        this.txtDiscapacitados.setEditable(false);
        this.txtFinanciacion.setEditable(false);
        this.txtDiscapacitados.setText("");
        this.txtFinanciacion.setText("");

        // Habilito los campos privados
        this.txtSocios.setEditable(true);
    }

}
