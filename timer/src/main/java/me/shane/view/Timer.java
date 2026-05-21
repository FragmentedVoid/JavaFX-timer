package me.shane.view;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

public class Timer extends HBox {
    CustomSpinner hourSpinner;
    CustomSpinner minuteSpinner;
    CustomSpinner secondSpinner;
    Button actionButton;

    public Timer() {
        hourSpinner = new CustomSpinner(0, 23, 0);
        minuteSpinner = new CustomSpinner(0, 59, 0);
        secondSpinner = new CustomSpinner(0, 59, 0);
        actionButton = new Button("Start Timer");

        this.getChildren().addAll(hourSpinner, minuteSpinner, secondSpinner, actionButton);
        this.setAlignment(Pos.CENTER);
        
    }

    public Button getActionButton() {
        return actionButton;
    }

    public CustomSpinner getHour() {
        return hourSpinner;
    }

    public CustomSpinner getMinute() {
        return minuteSpinner;
    }

    public CustomSpinner getSecond() {
        return secondSpinner;
    }
}