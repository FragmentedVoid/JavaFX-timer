package me.shane.view;

import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Alarmlist extends VBox{

    Alarm alarm;
    Button addAlarm;

    public Alarmlist() {
        alarm = new Alarm();
        addAlarm = new Button("Add Alarm");

        this.getChildren().add(addAlarm);
    }

    public void addAlarm() {
        this.getChildren().add(alarm);
    }
}
