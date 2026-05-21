package me.shane.view;

import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Alarm extends HBox{
    private Button toggleAlarm;
    private Spinner<Integer> hourSpinner;
    private Spinner<Integer> minuteSpinner;
    private TextField alarmLable;

    public Alarm() {
        toggleAlarm = new Button("Toggle Alarm");
        hourSpinner = new Spinner<>(0, 23, 0);
        minuteSpinner = new Spinner<>(0, 59, 0);
        alarmLable = new TextField();

        this.getChildren().addAll(hourSpinner, minuteSpinner, alarmLable, toggleAlarm);
    }
}
