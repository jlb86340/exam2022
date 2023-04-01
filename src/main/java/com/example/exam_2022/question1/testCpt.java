package com.example.exam_2022.question1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testCpt extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Compteur cpt = new Compteur(250);

        Scene root = new Scene(cpt);
        primaryStage.setTitle("question 1");
        primaryStage.setScene(root);
        primaryStage.show();

    }
}
