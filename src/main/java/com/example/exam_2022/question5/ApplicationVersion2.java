package com.example.exam_2022.question5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ApplicationVersion2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox mother = new VBox();
        mother.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: black");

        Pane board = new Pane();
        board.setPrefSize(500,500);
        board.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: black");
        // test

        Compteur cptX = new Compteur(100);
        Compteur cptY = new Compteur(180);

        Circle turtle = new Circle(7);
        turtle.setStyle("-fx-stroke: black; -fx-fill: #0ac70a");
        turtle.setCenterX(cptX.getCpt());
        turtle.setCenterY(cptY.getCpt());
        board.getChildren().add(turtle);

        Label info = new Label("La tortue est à la position "+cptX.getCpt()+" "+cptY.getCpt());
        info.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: black; -fx-background-color: transparent");
        Label X = new Label("X");
        Label Y = new Label("Y");

        Button Avance = new Button("Avance");
        Avance.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: black; -fx-background-color: transparent");

        Button Tourner = new Button("Tourner");
        Tourner.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: black; -fx-background-color: transparent");

        Button Start = new Button("Start");
        Start.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: black; -fx-background-color: transparent");

        Button Pause = new Button("Pause");
        Pause.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: black; -fx-background-color: transparent");

        board.setOnMouseClicked(
                e ->{
                    if (!(e.getX()<0 || e.getX()>500 || e.getY()<0 || e.getY()>500)){
                        turtle.setCenterX(e.getX());
                        turtle.setCenterY(e.getY());
                        cptX.setCpt((int) e.getX());
                        cptY.setCpt((int) e.getY());
                    }
                }
        );

        cptX.getBtnPlus().setOnMouseClicked(
                e -> {
                    cptX.increment();
                    turtle.setCenterX(cptX.getCpt());
                }
        );

        cptX.getBtnMoins().setOnMouseClicked(
                e -> {
                    cptX.decrement();
                    turtle.setCenterX(cptX.getCpt());
                }
        );

        cptY.getBtnPlus().setOnMouseClicked(
                e -> {
                    cptY.increment();
                    turtle.setCenterY(cptY.getCpt());
                }
        );

        cptY.getBtnMoins().setOnMouseClicked(
                e -> {
                    cptY.decrement();
                    turtle.setCenterY(cptY.getCpt());
                }
        );

        //info.textProperty().bind(cptX.accessibleTextProperty());
//        info.textProperty().bind(Bindings.createStringBinding(() -> {
//            return String.format(
//                    "La tortue est a la position %d %d",
//                    board.getLayoutX(),
//                    cptY.getCpt()
//            );
//        }, cptX.getCpt()., cptY.getCpt()));

        Start.setOnAction(
                e -> {
                    cptX.setDisable(true);
                    cptY.setDisable(true);
                    board.setDisable(true);

                    while(turtle.getCenterX() != 500 || Pause.isCancelButton()){
                        //Thread.sleep(50);
                        turtle.setCenterX(turtle.getCenterX()+1);
                    }
                }
        );
        Pause.setOnAction(
                e -> {
                    cptX.setDisable(false);
                    cptY.setDisable(false);
                    board.setDisable(false);
                }
        );

        Spring spring = new Spring();

        HBox hbx = new HBox();
        hbx.getChildren().addAll(X,cptX);
        hbx.setSpacing(25);
        hbx.setAlignment(Pos.CENTER);

        HBox hby = new HBox();
        hby.getChildren().addAll(Y,cptY);
        hby.setSpacing(25);
        hby.setAlignment(Pos.CENTER);

        VBox vbCpt = new VBox();
        vbCpt.getChildren().addAll(hbx,hby);
        vbCpt.setAlignment(Pos.CENTER_RIGHT);
        vbCpt.setSpacing(15);

        HBox hbAT = new HBox();
        hbAT.getChildren().addAll(Avance,Tourner);
        hbAT.setAlignment(Pos.CENTER_LEFT);
        hbAT.setSpacing(25);

        HBox hbSP = new HBox();
        hbSP.getChildren().addAll(Start,Pause);
        hbSP.setAlignment(Pos.CENTER_LEFT);
        hbSP.setSpacing(25);

        VBox vbFct = new VBox();
        vbFct.getChildren().addAll(info,hbAT,hbSP);
        vbFct.setSpacing(15);
        vbFct.setAlignment(Pos.CENTER_LEFT);

        HBox allFct = new HBox();
        allFct.getChildren().addAll(vbFct,spring,vbCpt);

        mother.getChildren().addAll(board,allFct);
        mother.setPadding(new Insets(25,25,25,25));
        mother.setSpacing(25);

        Scene root = new Scene(mother);
        primaryStage.setTitle("question 2");
        primaryStage.setScene(root);
        primaryStage.show();

    }
}
