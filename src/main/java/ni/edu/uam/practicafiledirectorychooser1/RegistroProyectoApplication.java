package ni.edu.uam.practicafiledirectorychooser1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroProyectoApplication extends Application {

    public static  void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegistroProyectoController.class.getResource("menu-registro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bienvenidos al sistema de registro de proyectos");
        stage.setScene(scene);
        stage.show();
    }
}