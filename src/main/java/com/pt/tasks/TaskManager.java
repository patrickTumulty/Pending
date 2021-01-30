package com.pt.tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskManager extends HashMap<String, PendingTaskList> implements Map<String, PendingTaskList> {

    private static TaskManager uniqueInstance;

    private TaskManager() {

    }

    public static TaskManager getInstance() {
        if (uniqueInstance == null) {
            synchronized (TaskManager.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new TaskManager();
                }
            }
        }
        return uniqueInstance;
    }


    public boolean hasTasks() {
        return !this.isEmpty();
    }

    public void addNewTaskList(String listName) {
        if (this.containsKey(listName)) return;
        this.put(listName, new PendingTaskList());
    }

    public void addNewTaskList(String listName, PendingTaskList tasks) {
        if (this.containsKey(listName)) return;
        this.put(listName, tasks);
    }

    public void addTaskToList(String listName, PendingTask task) {
        PendingTaskList thisArray = this.get(listName);
        thisArray.add(task);
        this.put(listName, thisArray);
    }

    public PendingTaskList getTaskList(String key) {
        return this.get(key);
    }

    public ArrayList<String> getTaskListNames() {
        return new ArrayList<>(this.keySet());
    }

    public void removeTaskList(String listName) {
        this.remove(listName);
    }

    public void removeTaskFromTaskList(String listName, PendingTask task) {
        this.get(listName).remove(task);
    }

}
