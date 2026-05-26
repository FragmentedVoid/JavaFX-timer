package me.shane.view;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.util.StringConverter;

public class CustomSpinner extends Spinner<Integer> {

    public CustomSpinner(int min, int max, int initial) {
        SpinnerValueFactory.IntegerSpinnerValueFactory factory = 
            new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initial);
        
        factory.setWrapAround(true);

        factory.setConverter(new StringConverter<Integer>() {
            @Override
            public String toString(Integer value) {
                if (value == null) return "00";
                return String.format("%02d", value);
            }

            @Override
            public Integer fromString(String string) {
                try {
                    if (string == null || string.trim().isEmpty()) return min;
                    return Integer.parseInt(string.trim());
                } catch (NumberFormatException e) {
                    return min;
                }
            }
        });

        this.setValueFactory(factory);
        this.setEditable(true);
        this.applyCustomStyles();
    }

    private void applyCustomStyles() {
        this.getEditor().setStyle("-fx-alignment: center; -fx-font-size: 14px;");

        this.setPrefWidth(65);
        this.setPrefHeight(30);

        
        this.setStyle(
            "-fx-background-radius: 5px; " +
            "-fx-border-radius: 5px; " +
            "-fx-border-color: #bdc3c7; " +
            "-fx-border-width: 1px;"
        );
    }

    public void setArrowsVisible(boolean visible) {
        if (!visible) {
            this.getEditor().setStyle("-fx-alignment: center; -fx-font-size: 14px;");
            this.setStyle(
                "-fx-background-radius: 5px; -fx-border-radius: 5px; " +
                "-fx-border-color: #e74c3c; -fx-border-width: 1px;"
            );

            this.getStyleClass().clear();
        } else {
            this.getStyleClass().add("spinner");
            this.applyCustomStyles();
        }
    }
}
