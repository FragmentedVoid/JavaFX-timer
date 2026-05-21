package me.shane.view;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import me.shane.controller.StopwatchController;

public class Stopwatch extends HBox {
        private Button startStopButton;
        private Button resetButton;
        private Label timeLabel;
    
        public Stopwatch() {
            startStopButton = new Button("Start");
            resetButton = new Button("Reset");
            timeLabel = new Label(Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds));
    
            this.getChildren().addAll(timeLabel, startStopButton, resetButton);
            this.setAlignment(Pos.CENTER);
            this.
        }
    
}
