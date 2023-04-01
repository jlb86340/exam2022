package com.example.exam_2022.question1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Compteur extends HBox {

    private static final int valMin = 0;
    private static final int valMax = 500;
    private Button btnPlus;
    private Label lbcpt;
    private Button btnMoins;

    private int cpt;

    public Compteur(int valeurInitiale){
        super();
        btnPlus = new Button("+");
        btnMoins = new Button("-");
        this.cpt = valeurInitiale;
        lbcpt = new Label(Integer.toString(cpt));
        lbcpt.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: black");
        lbcpt.setPadding(new Insets(0,5,0,5));
        btnPlus.setStyle("-fx-background-color: transparent");
        btnMoins.setStyle("-fx-background-color: transparent");

        btnPlus.setOnAction(e -> increment());
        btnMoins.setOnAction(e -> decrement());

        this.getChildren().addAll(btnPlus,lbcpt,btnMoins);
        this.setStyle("-fx-border-radius: 1; -fx-border-width: 2; -fx-border-color: blue");
        this.setAlignment(Pos.CENTER);
    }

    public int getCpt(){return cpt;}

    public void increment(){
        if (this.cpt < valMax){
            this.cpt ++;
            this.lbcpt.setText(Integer.toString(this.cpt));
        }
    }

    public void decrement(){
        if (this.cpt > valMin){
            this.cpt --;
            this.lbcpt.setText(Integer.toString(this.cpt));
        }
    }
}
