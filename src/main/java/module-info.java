module com.example.coursework_fix {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.coursework_fix to javafx.fxml;
    exports com.example.coursework_fix;
    exports com.example.coursework_fix.Text;
    opens com.example.coursework_fix.Text to javafx.fxml;
    opens com.example.coursework_fix.Gameplay to javafx.fxml;
    exports com.example.coursework_fix.Gameplay;
    exports com.example.coursework_fix.Controllers;
    opens com.example.coursework_fix.Controllers to javafx.fxml;
    //exports com.example.coursework_fix.Text;
    //opens com.example.coursework_fix.Text to javafx.fxml;
}