package me.shane.view;

import me.shane.controller.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;

public class Alarmlist extends VBox{

    Alarm alarm;
    Button addAlarm;
    Button removeAlarm;

    public Alarmlist() {
        addAlarm = new Button("Add Alarm");
        removeAlarm = new Button("Remove Alarm");
        this.getChildren().add(addAlarm);
        this.getChildren().add(this.getChildren().size(), removeAlarm);
        this.setAlignment(Pos.CENTER);

        addAlarm.setOnAction(e -> addAlarm());
        removeAlarm.setOnAction(e -> removeAlarm(this.getChildren().size() > 2 ? (Alarm)this.getChildren().get(this.getChildren().size() - 2) : null));
    }

    public void addAlarm() {
        alarm = new Alarm();
        this.getChildren().add(1, new AlarmController(alarm).getAlarmView());
        alarm.setAlignment(Pos.CENTER);
    }

    public void removeAlarm(Alarm alarm) {
        this.getChildren().remove(alarm);
    }
}
