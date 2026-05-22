package me.shane.view;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Pos;
import me.shane.controller.StopwatchController;

public class Stopwatch extends HBox {
        private Button startStopButton;
        private Button resetButton;
        private Label timeLabel;
        private StopwatchController controller;
    
        public Stopwatch() {
            startStopButton = new Button("Start");
            resetButton = new Button("Reset");
            controller = new StopwatchController(this);
            timeLabel = new Label();
            timeLabel.textProperty().bind(Bindings.format("%02d:%02d:%02d", controller.hoursProperty(), controller.minutesProperty(), controller.secondsProperty()));
            this.getChildren().addAll(timeLabel, startStopButton, resetButton);
            this.setAlignment(Pos.CENTER);
        }

        public Button getStartStopButton() {
            return startStopButton;
        }

        public Button getResetButton() {
            return resetButton;
        }

}
