module com.example.coursework_fix {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.coursework_fix to javafx.fxml;
    exports com.example.coursework_fix;
}