package com.pt.tasks;

import javax.swing.border.TitledBorder;

public class SimpleNote implements Note {
    protected String title;
    protected String description;

    public SimpleNote() {
        title = "";
        description = "";
    }

    public SimpleNote(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
