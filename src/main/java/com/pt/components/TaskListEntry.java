package com.pt.components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class TaskListEntry extends HBox {
    private Label title;
    private Region spacer;
    private Label timeRemaining;
    private final int fontSize = 20;

    public TaskListEntry(String title) {
        this.getStylesheets().add("/taskListEntry.css");

        this.title = new Label(title);
        spacer = new Region();
        timeRemaining = new Label("35 Days");

        this.getChildren().addAll(this.title, spacer, timeRemaining);
        timeRemaining.setAlignment(Pos.CENTER_RIGHT);
        this.title.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(this.title, Priority.NEVER);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox.setHgrow(timeRemaining, Priority.NEVER);
        this.setAlignment(Pos.CENTER);


    }
}
