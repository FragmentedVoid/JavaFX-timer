package me.shane.view;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;

public class Alarmlist extends VBox{

    Alarm alarm;
    Button addAlarm;

    public Alarmlist() {
        addAlarm = new Button("Add Alarm");
        this.getChildren().add(addAlarm);
        addAlarm.setAlignment(Pos.CENTER);

        addAlarm.setOnAction(e -> addAlarm());
    }

    public void addAlarm() {
        alarm = new Alarm();
        this.getChildren().add(alarm);
        alarm.setAlignment(Pos.TOP_CENTER);
    }
}
