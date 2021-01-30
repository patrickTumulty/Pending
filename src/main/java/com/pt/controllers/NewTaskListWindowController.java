package com.pt.controllers;

import com.pt.tasks.TaskManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NewTaskListWindowController implements Controller {
    @FXML
    public Button newListButton;
    @FXML
    public TextField newListTextField;

    private TaskManager taskManager;

    public void newListButtonClicked(MouseEvent mouseEvent) {
        closeNewListWindow();
    }

    private void closeNewListWindow() {
        Stage popUpStage = (Stage) newListButton.getScene().getWindow();
        popUpStage.close();
    }
}
