package com.example.mytd;

public class TodoItem {
    private String task;
    private boolean completed;
    private int priority;

    public TodoItem(String task) {
        this.task = task;
        this.completed = false;
        this.priority = 0;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}