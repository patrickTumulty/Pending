package com.pt.controllers;


import com.pt.components.WindowInitializer;
import com.pt.tasks.TaskManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController implements Controller {

    @FXML
    public TextField bottomTextField;
    @FXML
    public ComboBox<Label> listComboBox;
    @FXML
    public ListView<Label> mainListView;
    @FXML
    public Button addTaskButton;
    @FXML
    public Button addListButton;

    private TaskManager taskManager;

    public void initialize() {

    }

    public void passTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void addNewTaskButtonClicked(MouseEvent mouseEvent) throws IOException {
        openNewTaskWindow();
    }

    private void openNewTaskWindow() throws IOException {
        Stage stage = new Stage();
        WindowInitializer newTaskWindow = new WindowInitializer("/new_task_window.fxml");
        NewTaskWindowController newTaskWindowController = (NewTaskWindowController) newTaskWindow.getController();


        stage.setScene(newTaskWindow.getScene());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Task");
        stage.show();
    }

    public void newListButtonClicked(MouseEvent mouseEvent) {
    }
}
