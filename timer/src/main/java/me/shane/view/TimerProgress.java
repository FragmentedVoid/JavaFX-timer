package me.shane.view;

import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import me.shane.controller.*;
import javafx.scene.Group;


public class TimerProgress extends StackPane {
    final Arc progressBar;
    Timer timerView;
    TimerController timerController;
    Circle circle;
    Group progressGroup;

    public TimerProgress() {
        timerView = new Timer();
        timerController = new TimerController(timerView);
        circle = new Circle(150);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.web("#e0e0e0"));
        circle.setStrokeWidth(10);
        progressBar = timerController.getProgressBar();
        progressBar.setCenterX(0);
        progressBar.setCenterY(0);
        progressBar.setRadiusX(150);
        progressBar.setRadiusY(150);
        progressBar.setStartAngle(90);
        progressBar.setLength(360);
        progressBar.setType(ArcType.OPEN);
        progressBar.setFill(Color.TRANSPARENT);
        progressBar.setStroke(Color.web("#0078d4"));
        progressBar.setStrokeWidth(10);
        progressGroup = new Group(circle, progressBar);
        this.getChildren().addAll(progressGroup, timerController.getTimerView());
        this.setAlignment(Pos.CENTER);
    }
    
}
