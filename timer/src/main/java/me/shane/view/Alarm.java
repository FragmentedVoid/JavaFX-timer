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

        this.getChildren().addAll(hourSpinner, minuteSpinner, alarmLable, toggleAlarm);
    }
}
