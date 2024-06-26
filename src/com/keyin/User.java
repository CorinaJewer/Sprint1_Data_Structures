package com.keyin;

public class User {

    private String userName;
    private String password;
    private TaskList toDoList;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.toDoList = new TaskList();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public void setToDoList(TaskList toDoList) {
        this.toDoList = toDoList;
    }

    public void addTask(Task task) {
       toDoList.addTask(task);
    }

    public void completeTask(int id){
        toDoList.markTaskComplete(id);
    }

    public void printMyTasks(){
        toDoList.displayAllTasks();
    }

    public void printIncompleteTasks(){
        toDoList.displayIncompleteTasks();
    }

    public boolean hasTasks() {
        return !toDoList.isEmpty();
    }
}
