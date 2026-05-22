package me.shane.controller;

import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

public class StopwatchController {
    IntegerProperty hours;
    IntegerProperty minutes;
    IntegerProperty seconds;

    public StopwatchController() {
        hours = new SimpleIntegerProperty(0);
        minutes = new SimpleIntegerProperty(0);
        seconds = new SimpleIntegerProperty(0);
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
