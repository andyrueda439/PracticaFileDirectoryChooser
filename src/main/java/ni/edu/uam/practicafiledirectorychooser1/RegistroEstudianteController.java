package ni.edu.uam.practicafiledirectorychooser1;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class RegistroEstudianteController {

    @FXML
    private TextField txtNombresEstudiante;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextArea txtAreaDireccion;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtDirectorioCedula;
    @FXML
    private Button btnSeleccionarCedula;
    @FXML
    private Button btnSeleccionarDirectorioCedula;

    @FXML
    private void seleccionarCedula() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Cedula");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Imagen PNG", "*.png")
        );
        File f = fc.showOpenDialog(btnSeleccionarCedula.getScene().getWindow());

        if (f != null) {
            txtCedula.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void seleccionarDirectorioCedula() {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        dc.setInitialDirectory(new File("C:\\"));
        File f = dc.showDialog(btnSeleccionarDirectorioCedula.getScene().getWindow());

        if (f != null) {
            txtDirectorioCedula.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void guardarEstudiante() {
        if (!validarFormulario()) {
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmacion");
        confirmacion.setHeaderText("Seguro que quiere guardar el estudiante?");
        confirmacion.setContentText("Estudiante: " + txtNombresEstudiante.getText() + " " + txtApellidos.getText());

        Optional<ButtonType> result = confirmacion.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Estudiante guardado");
            alert.setHeaderText("Guardado");
            alert.setContentText("El estudiante se ha guardado correctamente");
            alert.showAndWait();
        }
    }

    private boolean validarFormulario() {
        return true;
    }

    @FXML
    private void limpiarRegistroEstudiantil() {
        txtNombresEstudiante.clear();
        txtApellidos.clear();
        txtAreaDireccion.clear();
        txtCedula.clear();
        txtDirectorioCedula.clear();
    }
}
