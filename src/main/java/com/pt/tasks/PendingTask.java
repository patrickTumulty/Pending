package com.pt.tasks;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PendingTask extends SimpleNote implements Task, Comparable<PendingTask> {
    private LocalDateTime dueDate;
    private final LocalDateTime dateCreated;
    private boolean completionStatus;


    public PendingTask() {
        super();
        completionStatus = false;
        dateCreated = LocalDateTime.now();
    }

    public PendingTask(String title, String description, LocalDateTime dueDate) {
        super(title, description);
        completionStatus = false;
        this.dueDate = dueDate;
        dateCreated = LocalDateTime.now();
    }

    @Override
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    @Override
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    @Override
    public void setCompletionStatus(boolean status) {
        completionStatus = status;
    }

    @Override
    public boolean isComplete() {
        return completionStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(title);
        sb.append(description);
        sb.append("\n\n");
        sb.append("DueDate : ");
        sb.append(dueDate);
        return sb.toString();
    }

    @Override
    public int compareTo(PendingTask otherTask) {
        Duration thisDuration = Duration.between(this.dueDate, LocalDate.now());
        Duration otherDuration = Duration.between(otherTask.dueDate, LocalDate.now());
        return thisDuration.compareTo(otherDuration);
    }

    public long getDaysTillDue() {
        return Duration.between(dueDate, LocalDate.now()).toDays();
    }
}
