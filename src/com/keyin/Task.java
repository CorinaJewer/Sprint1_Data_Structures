package com.keyin;

public class Task {

    private static int idIncrement = 1;
    private int id;
    private String description;
    private Boolean completionStatus;

    public Task (String description){
        this.id = idIncrement++;
        this.description = description;
        this.completionStatus = false;
    }

    public int getId(){
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(Boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + " - " + description + (completionStatus ? " (Task Complete)" : " (Task Incomplete)");
    }

    public void markComplete(){
        this.completionStatus = true;
    }
}
