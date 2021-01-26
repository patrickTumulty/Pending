package com.pt.controllers;


import com.pt.components.WindowInitializer;
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

    public void initialize() {

    }

    public void newListButtonClicked(MouseEvent mouseEvent) throws IOException {
//        openNewTaskListWindow();
        WindowInitializer initializer = new WindowInitializer("/new_task_list_window.fxml");
        NewTaskListWindowController controller = (NewTaskListWindowController)initializer.getController();
        controller.setSomething("Thing");
        Stage stage = new Stage();
        stage.setScene(initializer.getScene());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    private void openNewTaskListWindow() throws IOException {
        Stage stage = new Stage();
        Parent newTaskListWindow = FXMLLoader.load(getClass().getResource("/new_task_list_window.fxml"));
        Scene scene = new Scene(newTaskListWindow);
        stage.setScene(scene);

        stage.setTitle("New List");

        stage.show();
    }

    private void openNewTaskWindow() throws IOException {
        Stage stage = new Stage();
        Parent newListWindow = FXMLLoader.load(getClass().getResource("/new_task_window.fxml"));
        Scene scene = new Scene(newListWindow);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Task");

        stage.show();
    }
}
