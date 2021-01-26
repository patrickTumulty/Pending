package com.pt.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NewTaskListWindowController implements Controller {

    public Button newListButton;
    public TextField newListTextField;

    private String thing;

    public void setSomething(String thing) {
        this.thing = thing;
    }


    public void newListButtonClicked(MouseEvent mouseEvent) {
        closeNewListWindow();
    }

    private void closeNewListWindow() {
        System.out.println(thing);
        Stage popUpStage = (Stage) newListButton.getScene().getWindow();
        popUpStage.close();
    }
}
