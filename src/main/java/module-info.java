module ni.edu.uam.practicafiledirectorychooser1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.practicafiledirectorychooser1 to javafx.fxml;
    exports ni.edu.uam.practicafiledirectorychooser1;
}