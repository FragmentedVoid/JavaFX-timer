package me.shane.controller;

import me.shane.view.*;
import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

public class StopwatchController {
    private Timeline timeline;
    IntegerProperty hours;
    IntegerProperty minutes;
    IntegerProperty seconds;
    Stopwatch stopwatch;
    int totalSeconds;

    public StopwatchController(Stopwatch stopwatch) {
        hours = new SimpleIntegerProperty(0);
        minutes = new SimpleIntegerProperty(0);
        seconds = new SimpleIntegerProperty(0);
        this.stopwatch = stopwatch;
        totalSeconds = 0;
        stopwatch.getStartStopButton().setOnAction(e -> startStop());
        stopwatch.getResetButton().setOnAction(e -> reset());
    }

    private void startStop() {
        stopwatch.getStartStopButton().setText("Stop");

        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
            stopwatch.getStartStopButton().setText("Start");
            return;
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (stopwatch.getStartStopButton().getText().equals("Stop")) {
                totalSeconds++;
                hours.set(totalSeconds / 3600);
                minutes.set((totalSeconds % 3600) / 60);
                seconds.set(totalSeconds % 60);
            } else {
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void reset() {
        if (timeline != null) {
            timeline.stop();
        }
        totalSeconds = 0;
        hours.set(0);
        minutes.set(0);
        seconds.set(0);
        stopwatch.getStartStopButton().setText("Start");
    }

    public IntegerProperty hoursProperty() {
        return hours;
    }

    public IntegerProperty minutesProperty() {
        return minutes;
    }

    public IntegerProperty secondsProperty() {
        return seconds;
    }
    
}
