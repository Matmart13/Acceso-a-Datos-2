package controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;
import util.MetodosSueltos;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField txtPass;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void comprobarLogin(ActionEvent event) {

        try {
            // Cojo los datos del usuario
            String usuario = this.txtUsuario.getText();
            String password = this.txtPass.getText();

            // Creo el usuario
            Usuario u = new Usuario(usuario, password);

            // Compruebo si existe o no el usuario
            if (u.login()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exito");
                alert.setContentText("Login correcto");
                alert.showAndWait();

                // carga la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/AeropuertosVista.fxml"));

                // Cargo el padre
                Parent root = loader.load();

                // Creo la scene
                Scene scene = new Scene(root);

                // Creo la stage
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Aeropuertos");
                MetodosSueltos.iconoVentana(stage);
                stage.show();

                // Cierro la ventana
                /*
                Stage myStage = (Stage) this.btnLogin.getScene().getWindow();
                myStage.close();
                */

                //cerrar ventana a partir del evento
                Node source = (Node) event.getSource();
                Stage vista_login = (Stage) source.getScene().getWindow();
                vista_login.close();

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Login incorrecto");
                alert.showAndWait();

            }
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

}
