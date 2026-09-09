package ni.edu.uam.practicafiledirectorychooser1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class RegistroProyectoController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtResponsable;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtArchivo;
    @FXML
    private TextField txtDirectorio;
    @FXML
    private Button btnSeleccionar1;
    @FXML
    private Button btnSeleccionar2;

    @FXML
    private void seleccionarArchivo (){
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Archivo");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo TXT", "*.txt"),
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf")
        );
        File f = fc.showOpenDialog(btnSeleccionar1.getScene().getWindow());

        if(f != null){
            txtArchivo.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void seleccionarDirectorio (){
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        dc.setInitialDirectory(new File("C:\\"));
        File f = dc.showDialog(btnSeleccionar2.getScene().getWindow());

        if(f != null){
            txtDirectorio.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void guardarProyecto (){
        if(!validarFormulario()){
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmacion");
        confirmacion.setHeaderText("Seguro que quiere guardar el proyecto?");
        confirmacion.setContentText("Proyecto: "+ txtNombre.getText());

        Optional<ButtonType> result = confirmacion.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Proyecto guardado" + txtNombre.getText());
            alert.setHeaderText("Guardado");
            alert.setContentText("El proyecto se ha guardado correctamente");
            alert.showAndWait();
        }
    }

    private boolean validarFormulario(){
        return true;
    }

    private void limpiarFormulario(){
        txtNombre.clear();
        txtResponsable.clear();
        txtDescripcion.clear();
        txtArchivo.clear();
        txtDirectorio.clear();
    }

    public void setBtnSeleccionar2(Button btnSeleccionar2) {
        this.btnSeleccionar2 = btnSeleccionar2;
    }

    //Este metodo fue creado por error en el fxml de limpiar
    @FXML
    public void limpiar(ActionEvent actionEvent) {
        limpiarFormulario();
    }
}
