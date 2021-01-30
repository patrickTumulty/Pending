package com.pt.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PendingTaskList extends ArrayList<PendingTask> implements List<PendingTask> {

    public PendingTaskList() {

    }

    public PendingTaskList(PendingTask task) {
        this.add(task);
    }

    public PendingTaskList(PendingTask[] tasks) {
        this.addAll(Arrays.asList(tasks));
    }

    public void sortByDueDate() {
        Collections.sort(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PendingTask task : this) {
            sb.append(task.getTitle());
            sb.append(" : Days Till Due ");
            sb.append(task.getDaysTillDue());
            sb.append("\n");
        }
        return sb.toString();
    }
}
