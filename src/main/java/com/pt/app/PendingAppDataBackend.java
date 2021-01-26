package com.pt.app;

import com.pt.controllers.MainController;
import com.pt.tasks.TaskManager;

public class PendingAppDataBackend {
    MainController mainController;
    TaskManager taskManager;

    public PendingAppDataBackend(MainController mainController) {
        this.mainController = mainController;
        taskManager = new TaskManager();
    }

}
