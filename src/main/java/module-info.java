module com.example.exam_2022 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exam_2022 to javafx.fxml;
    exports com.example.exam_2022;
}