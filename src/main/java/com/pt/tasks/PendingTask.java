package com.pt.tasks;

import java.time.LocalDateTime;

public class PendingTask extends SimpleNote implements Task {
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
}
