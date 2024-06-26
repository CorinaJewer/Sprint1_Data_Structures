package com.keyin;

public class Node {

    private Task task;
    private Node next;

    public Node(Task task){
        this.task = task;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
