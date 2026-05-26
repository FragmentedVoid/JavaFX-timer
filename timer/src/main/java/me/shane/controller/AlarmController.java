package me.shane.controller;

import me.shane.view.*;
import java.time.LocalTime;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.media.*;
import java.io.File;

public class AlarmController {
    private Alarm alarm;
    private LocalTime alarmTime;
    int alarmHour;
    int alarmMinute;
    Timeline timeline;
    File soundFile;

    public AlarmController(Alarm alarm) {
        this.alarm = alarm;
        soundFile = new File("C:\\Windows\\Media\\Ring03.wav");
        alarm.getToggleAlarm().setOnAction(e -> toggleAlarm());
    }

    private void toggleAlarm() {
        if (alarm.getToggleAlarm().getText().equals("OFF")) {
            alarm.getToggleAlarm().setText("ON");
            alarm.getHourSpinner().setEditable(false);
            alarm.getHourSpinner().setArrowsVisible(false);
            alarm.getMinuteSpinner().setEditable(false);
            alarm.getMinuteSpinner().setArrowsVisible(false);
            timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                alarmTime = LocalTime.now();
                alarmHour = alarm.getHourSpinner().getValue();
                alarmMinute = alarm.getMinuteSpinner().getValue();
                if (alarmTime.getHour() == alarmHour && alarmTime.getMinute() == alarmMinute) {
                    timeline.stop();
                    alarm.getHourSpinner().setEditable(true);
                    alarm.getHourSpinner().setArrowsVisible(true);
                    alarm.getMinuteSpinner().setEditable(true);
                    alarm.getMinuteSpinner().setArrowsVisible(true);
                    alarm.getToggleAlarm().setText("OFF");
                    AudioClip sound = new AudioClip(soundFile.toURI().toString());
                    sound.play();
                }
            }));
        } else {
            alarm.getHourSpinner().setEditable(true);
            alarm.getHourSpinner().setArrowsVisible(true);
            alarm.getMinuteSpinner().setEditable(true);
            alarm.getMinuteSpinner().setArrowsVisible(true);
            alarm.getToggleAlarm().setText("OFF");
        }
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public Alarm getAlarmView() {
        return alarm;
    }
}
