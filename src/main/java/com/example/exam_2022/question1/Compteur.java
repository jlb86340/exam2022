package com.example.exam_2022.question1;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Compteur extends HBox {

    private Button btnPlus;
    private Label lbcpt;
    private Button btnMoins;

    public Compteur(int valeurInitiale){
        btnPlus = new Button("+");
        btnMoins = new Button("-");
        int cpt = valeurInitiale;
        lbcpt = new Label(""+cpt);

        this.getChildren().addAll(btnPlus,lbcpt,btnMoins);
    }
}
