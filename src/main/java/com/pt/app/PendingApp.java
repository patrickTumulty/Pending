package com.pt.app;

import com.pt.components.WindowInitializer;
import com.pt.controllers.MainController;
import com.pt.tasks.TaskManager;
import javafx.application.Application;
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

        TaskManager taskManager = TaskManager.getInstance();
        mainController.passTaskManager(taskManager);

        primaryStage.setResizable(false);
        primaryStage.setTitle("P∑NDiNG");
        primaryStage.setScene(mainWindow.getScene());
        primaryStage.show();


    }
}
