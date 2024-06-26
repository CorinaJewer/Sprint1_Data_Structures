package com.keyin;

public class TaskList {

    private Node head;
    private Node tail;
    private int size;

    public TaskList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addTask(Task task){
        Node newTaskNode = new Node(task);
        if (head == null){   // add to beginning of list
            head = newTaskNode;
            tail = newTaskNode;
        } else {
            tail.setNext(newTaskNode); // add to end of list
            tail = newTaskNode;
        }
        size++;
    }

    public void markTaskComplete(int id) {
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            if (tempNode.getTask().getId() == id){
                tempNode.getTask().markComplete();
                System.out.println("TaskID: " + id + " has been marked complete.");
                return;
            }
            tempNode = tempNode.getNext();
        }
        System.out.println("A Task with that description was not found.");
    }

   public boolean displayAllTasks(){
        if (head == null){
            System.out.println("No tasks to display. Please enter a task.");
            return false;
        } else {
            System.out.println();
            System.out.println("To-Do List");
            System.out.println("----------");
            Node tempNode = head;
            for (int i = 0; i< size; i++){
                System.out.print(tempNode.getTask() + "\n");
                tempNode = tempNode.getNext();
            }
            System.out.print("\n");
            return true;
        }
   }

    public void displayIncompleteTasks(){
        if (head == null){
            System.out.println("No tasks to display. Please enter a task.");
        } else {
            boolean incompleteTasks = false;
            System.out.println();
            System.out.println("To-Do List");
            System.out.println("----------");
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.getTask().getCompletionStatus().equals(false)) {
                    System.out.print(tempNode.getTask() + "\n");
                    incompleteTasks = true;
                }
                tempNode = tempNode.getNext();
            }
            if (!incompleteTasks) {
                System.out.println("Great Job! You're all caught up on your tasks.");
            }

            System.out.print("\n");
        }
    }

    public boolean isEmpty() {
        return head == null; // true if head null indicating an empty list
    }
}

