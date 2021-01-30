package com.pt.controllers;

import com.pt.app.TextAreaLineParser;
import com.pt.tasks.PendingTask;
import com.pt.tasks.PendingTaskList;
import com.pt.tasks.Task;
import com.pt.tasks.TaskManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.text.html.StyleSheet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewTaskWindowController implements Controller {
    @FXML
    private Button newTaskCreateButton;
    @FXML
    private CheckBox specifyTimeToggle;
    @FXML
    private TextField timeTextField; // TODO add listener to control text input
    @FXML
    private RadioButton radioAM;
    @FXML
    private RadioButton radioPM;
    @FXML
    private DatePicker newTaskDatePicker;
    @FXML
    private TextArea newTaskTextArea;


    private boolean bypassSpecifyTime;
    private ToggleGroup toggleGroupAMPM;
    private TaskManager taskManager;

    public NewTaskWindowController() {
        bypassSpecifyTime = true;
    }

    public void initialize() {
        groupRadioButtonsAMPM();
        disablePastDatesForDatePicker();

    }

    private void groupRadioButtonsAMPM() {
        toggleGroupAMPM = new ToggleGroup();
        radioAM.setToggleGroup(toggleGroupAMPM);
        radioPM.setToggleGroup(toggleGroupAMPM);
    }

    private void disablePastDatesForDatePicker() {
        newTaskDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0);
            }
        });
    }

    public void passTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void createButtonClicked(MouseEvent mouseEvent) {
        LocalTime time;
        if (newTaskTextArea.getText().equals("")) {
            System.out.println("Text area empty.");
            return;
        }
        time = getNewTaskCompletionDateTime();
        LocalDateTime dateTime = LocalDateTime.of(newTaskDatePicker.getValue(), time);

        String textAreaString = newTaskTextArea.getText();

        TextAreaLineParser lineParser = new TextAreaLineParser(textAreaString);
        PendingTask newTask = new PendingTask(lineParser.getTitle(), lineParser.getDescription(), dateTime);
        taskManager.addNewTaskList("Default List", new PendingTaskList(newTask));
        closeWindow();
    }

    private LocalTime getNewTaskCompletionDateTime() {
        LocalTime time;
        if (!bypassSpecifyTime) {
            String timeString = timeTextField.getText();
            String[] hrs_mins = timeString.split(":");
            int hours = Integer.parseInt(hrs_mins[0]);
            int minutes = Integer.parseInt(hrs_mins[1]);
            if (radioPM.isSelected()) {
                hours += 12;
            }
            time = LocalTime.of(hours, minutes);
        } else {
            time = LocalTime.MIDNIGHT;
        }
        return time;
    }

    private void closeWindow() {
        Stage popUpStage = (Stage) newTaskCreateButton.getScene().getWindow();
        popUpStage.close();
    }

    public void specifyTimeToggleButton(MouseEvent mouseEvent) {
        setTimeComponentsDisable(!specifyTimeToggle.isSelected());
    }

    private void setTimeComponentsDisable(boolean state) {
        bypassSpecifyTime = state;
        timeTextField.setDisable(state);
        radioPM.setDisable(state);
        radioAM.setDisable(state);
    }


    public void datePickerOnAction(ActionEvent actionEvent) {
        enableCreateButtonIfDatePicked();
    }

    private void enableCreateButtonIfDatePicked() {
        if (newTaskDatePicker.getValue() != null) {
            newTaskCreateButton.setDisable(false);
        }
    }
}
