package me.shane.view;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Userview extends BorderPane {
    public Userview() {
        // Create the buttons for the different views
        //Button timerButton = new Button("Timer");
        //Button stopwatchButton = new Button("Stopwatch");
        Button alarmButton = new Button("Alarm");

        // Set the action for each button to switch to the corresponding view
        //timerButton.setOnAction(e -> setCenter(new Timer()));
        //stopwatchButton.setOnAction(e -> setCenter(new Stopwatch()));
        alarmButton.setOnAction(e -> setCenter(new Alarm()));

        // Create a VBox to hold the buttons and add it to the left side of the BorderPane
        HBox buttonBox = new HBox(10,alarmButton);
        setBottom(buttonBox);
    }
    
    public Userview getView() {
        return this;
    }
}
