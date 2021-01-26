package com.pt.app;

import com.pt.components.WindowInitializer;
import com.pt.controllers.MainController;
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
        WindowInitializer mainWindow = new WindowInitializer("/mainscreen.fxml");
        MainController mainController = (MainController)mainWindow.getController();

        PendingAppDataBackend backend = new PendingAppDataBackend(mainController);

        primaryStage.setResizable(false);
        primaryStage.setTitle(".pending");
        primaryStage.setScene(mainWindow.getScene());
        primaryStage.show();


    }
}
