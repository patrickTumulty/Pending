package com.pt.tasks;

import java.time.LocalDateTime;

public interface Task extends Note {
    public void setDueDate(LocalDateTime dueDate);
    public LocalDateTime getDueDate();
    public LocalDateTime getDateCreated();
    public void setCompletionStatus(boolean status);
    public boolean isComplete();


}
