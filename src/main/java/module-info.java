module com.example.exam_2022 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exam_2022.question1 to javafx.fxml;
    exports com.example.exam_2022.question1;

    opens com.example.exam_2022.question2 to javafx.fxml;
    exports com.example.exam_2022.question2;

    opens com.example.exam_2022.question3 to javafx.fxml;
    exports com.example.exam_2022.question3;

    opens com.example.exam_2022.question4 to javafx.fxml;
    exports com.example.exam_2022.question4;
}