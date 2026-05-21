package me.shane.main;

import javafx.application.*;
import javafx.stage.Stage;
import me.shane.view.Userview;
import javafx.scene.*;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    Userview userview;

    @Override
    public void start(Stage stage) throws IOException {
        userview = new Userview();
        scene = new Scene(userview.getView(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}