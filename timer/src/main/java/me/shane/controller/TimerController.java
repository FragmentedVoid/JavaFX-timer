package me.shane.controller;

import me.shane.view.*;
import javafx.animation.*;
import javafx.util.Duration;

public class TimerController {
    private Timeline timeline;
    int totalSeconds;
    Timer timerView;
    CustomSpinner hours;
    CustomSpinner minutes;
    CustomSpinner seconds;

    public TimerController(Timer timerView) {
        this.timerView = timerView;
        this.hours = timerView.getHour();
        this.minutes = timerView.getMinute();
        this.seconds = timerView.getSecond();
        this.timerView.getActionButton().setOnAction(e -> startTimer());
    }

    private void startTimer() {
        hours.setEditable(false);
        hours.setArrowsVisible(false);
        minutes.setEditable(false);
        minutes.setArrowsVisible(false);
        seconds.setEditable(false);
        seconds.setArrowsVisible(false);
        timerView.getActionButton().setDisable(true);

        totalSeconds = (hours.getValue() * 3600) + (minutes.getValue() * 60) + seconds.getValue();

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (totalSeconds > 0) {
                totalSeconds--;
                hours.getValueFactory().setValue(totalSeconds / 3600);
                minutes.getValueFactory().setValue((totalSeconds % 3600) / 60);
                seconds.getValueFactory().setValue(totalSeconds % 60);

            } else {
                timeline.stop();
                hours.setEditable(true);
                hours.setArrowsVisible(true);
                minutes.setEditable(true);
                minutes.setArrowsVisible(true);
                seconds.setEditable(true);
                seconds.setArrowsVisible(true);
                timerView.getActionButton().setDisable(false);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public Timer getTimerView() {
        return timerView;
    }
}
