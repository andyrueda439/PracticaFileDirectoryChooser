package ni.edu.uam.practicafiledirectorychooser1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuRegistroController {

    @FXML
    private MenuBar menuBar;

    @FXML
    private void abrirRegistroProyecto(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registro-proyectos.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Registro de Proyecto");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void abrirRegistroEstudiante(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registro-estudiante.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Registro de Estudiante");
        stage.setScene(new Scene(root));
        stage.show();
    }
}