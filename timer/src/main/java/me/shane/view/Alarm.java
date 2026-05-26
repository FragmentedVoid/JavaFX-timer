package me.shane.view;

import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Alarm extends HBox{
    private Button toggleAlarm;
    private CustomSpinner hourSpinner;
    private CustomSpinner minuteSpinner;
    private TextField alarmLable;

    public Alarm() {
        toggleAlarm = new Button("OFF");
        hourSpinner = new CustomSpinner(0, 23, 0);
        minuteSpinner = new CustomSpinner(0, 59, 0);
        alarmLable = new TextField();
        alarmLable.setPrefHeight(30);
        alarmLable.setPrefWidth(100);

        this.getChildren().addAll(hourSpinner, minuteSpinner, alarmLable, toggleAlarm);
    }

    public Button getToggleAlarm() {
        return toggleAlarm;
    }

    public CustomSpinner getHourSpinner() {
        return hourSpinner;
    }

    public CustomSpinner getMinuteSpinner() {
        return minuteSpinner;
    }
}
