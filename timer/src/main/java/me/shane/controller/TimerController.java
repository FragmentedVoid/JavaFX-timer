package me.shane.controller;

import me.shane.view.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.media.*;
import java.io.File;

public class TimerController {
    private Timeline timeline;
    int totalSeconds;
    int progressSeconds;
    Timer timerView;
    CustomSpinner hours;
    CustomSpinner minutes;
    CustomSpinner seconds;
    File soundFile;
    Arc progressBar;

    public TimerController(Timer timerView) {
        this.timerView = timerView;
        this.hours = timerView.getHour();
        this.minutes = timerView.getMinute();
        this.seconds = timerView.getSecond();
        progressBar = new Arc();
        timerView.getActionButton().setOnAction(e -> startTimer());
        soundFile = new File("C:\\Windows\\Media\\Ring03.wav");
    }

    private void startTimer() {
        boolean isRunning = timeline != null && timeline.getStatus() == Animation.Status.RUNNING;

        if (isRunning) {
            timeline.stop();
            hours.setEditable(true);
            hours.setArrowsVisible(true);
            minutes.setEditable(true);
            minutes.setArrowsVisible(true);
            seconds.setEditable(true);
            seconds.setArrowsVisible(true);
            timerView.getActionButton().setText("Start Timer");
            return;
        }
        
        timerView.getActionButton().setText("Stop Timer");
        hours.setEditable(false);
        hours.setArrowsVisible(false);
        minutes.setEditable(false);
        minutes.setArrowsVisible(false);
        seconds.setEditable(false);
        seconds.setArrowsVisible(false);

        totalSeconds = (hours.getValue() * 3600) + (minutes.getValue() * 60) + seconds.getValue();
        progressSeconds = totalSeconds;


        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (progressSeconds > 0) {
                progressSeconds--;
                hours.getValueFactory().setValue(progressSeconds / 3600);
                minutes.getValueFactory().setValue((progressSeconds % 3600) / 60);
                seconds.getValueFactory().setValue(progressSeconds % 60);
                progressBar.setLength(360 * ((double) progressSeconds / (double) totalSeconds));

            } else {
                timeline.stop();
                timerView.getActionButton().setText("Start Timer");
                progressBar.setLength(360);
                hours.setEditable(true);
                hours.setArrowsVisible(true);
                minutes.setEditable(true);
                minutes.setArrowsVisible(true);
                seconds.setEditable(true);
                seconds.setArrowsVisible(true);
                AudioClip sound = new AudioClip(soundFile.toURI().toString());
                sound.play();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public Arc getProgressBar() {
        return progressBar;
    }

    public Timer getTimerView() {
        return timerView;
    }
}
