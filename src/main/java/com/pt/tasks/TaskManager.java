package com.pt.tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskManager extends HashMap<String, ArrayList<PendingTask>> implements Map<String, ArrayList<PendingTask>> {

    public TaskManager() {

    }

    public boolean hasTasks() {
        return !this.isEmpty();
    }

    public void addNewTaskList(String listName) {
        if (this.containsKey(listName)) return;
        this.put(listName, new ArrayList<PendingTask>());
    }

    public void addNewTaskList(String listName, ArrayList<PendingTask> tasks) {
        if (this.containsKey(listName)) return;
        this.put(listName, tasks);
    }

    public void addTaskToList(String listName, PendingTask task) {
        ArrayList<PendingTask> thisArray = this.get(listName);
        thisArray.add(task);
        this.put(listName, thisArray);
    }

    public ArrayList<PendingTask> getTaskList(String key) {
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
