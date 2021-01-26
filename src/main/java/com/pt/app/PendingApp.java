package com.pt.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PendingApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/mainscreen.fxml"));

        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setResizable(false);
        primaryStage.setTitle(".pending");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
