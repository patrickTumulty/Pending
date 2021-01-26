package com.pt.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

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
        bottomTextField.setText("Hello World!");

        listComboBox.getItems().add(new Label("Item 3"));
        listComboBox.getItems().add(new Label("Item 4"));


        mainListView.getItems().add(new Label("Item 1"));
        mainListView.getItems().add(new Label("Item 2"));
    }

    public void newListButtonClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Parent newListWindow = FXMLLoader.load(getClass().getResource("/new_task_window.fxml"));
        Scene scene = new Scene(newListWindow);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Task");

        stage.show();
    }
}
