module org.mikmin.typingtutor {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.mikmin.typingtutor to javafx.fxml;
    exports org.mikmin.typingtutor;
}