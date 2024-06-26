package com.keyin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<User> users = new ArrayList<>();
    private static User activeUser = null;

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        while (true) {
            if (activeUser == null) {
                System.out.println();
                System.out.println("To-Do List Manager");
                System.out.println("------------------");
                System.out.println("1. Create A New User Account");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println();
                System.out.print("Please make your selection: ");

                int selection = userInput.nextInt();
                userInput.nextLine();

                switch (selection) {
                    case 1:
                        System.out.print("Please create your username: ");
                        String userName = userInput.nextLine();
                        if (userNameAvailable(userName)) {
                            System.out.print("Please create your password: ");
                            String password = userInput.nextLine();
                            createUser(userName, password);
                        } else {
                            System.out.println("That username already exists. Please choose another.");
                        }
                        break;
                    case 2:
                        loginUser(userInput);
                        break;
                    case 3:
                        System.out.println("Goodbye for now...");
                        userInput.close();
                        return;
                    default:
                        System.out.println("Invalid selection! Please choose again.");
                }
            } else {
                System.out.println();
                System.out.println("Main Menu");
                System.out.println("---------");
                System.out.println("1. Add A New Task");
                System.out.println("2. Mark An Existing Task Complete");
                System.out.println("3. View Incomplete Tasks");
                System.out.println("4. View All Tasks");
                System.out.println("5. Exit");
                System.out.println();
                System.out.print("Please make your selection: ");

                int selection = userInput.nextInt();
                userInput.nextLine();

                switch (selection) {
                    case 1:
                        addNewUserTask(userInput);
                        break;
                    case 2:
                        if (displayAllUserTasks()) {
                            markTaskAsCompleted(userInput);
                        }
                        break;
                    case 3:
                        displayIncompleteTasks();
                        break;
                    case 4:
                        displayAllUserTasks();
                        break;
                    case 5:
                        System.out.println("Goodbye for now...");
                        userInput.close();
                        return;
                    default:
                        System.out.println("Invalid selection! Please choose again.");
                }
            }
        }
    }

    private static void createUser (String userName, String password){
            User newUser = new User(userName, password);
            users.add(newUser);
            System.out.println("User " + newUser.getUserName() + " was created successfully.");
    }

    private static boolean userNameAvailable (String userName){
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }

    private static void loginUser(Scanner userInput) {
        User user = null;
        while (user == null) {
            System.out.print("Please enter your username: ");
            String userName = userInput.nextLine();

            user = findUserByUserName(userName);

            if (user == null) {
                System.out.println("A User with that username was not found. Please try again.");
            }
        }

        while (true) {
            System.out.print("Please enter your password: ");
            String password = userInput.nextLine();

            if (password.equals(user.getPassword())) {
                activeUser = user;
                System.out.println("Login successful. Welcome, " + user.getUserName() + "!");
                return; // Exit because login successful
            } else {
                System.out.println("Invalid password! Please try again.");
            }
        }
    }

    private static void addNewUserTask (Scanner userInput){
        while(true) {
            System.out.print("Enter your task description or type 'exit' to return to the main menu: ");
            String taskDescription = userInput.nextLine();
            if (taskDescription.equalsIgnoreCase("exit")) {
                break;
            }
            Task newTask = new Task(taskDescription);
            activeUser.addTask(newTask);
            System.out.println("Task ID: " + newTask.getId() + " - '" + newTask.getDescription() + "'"
                     + " has been added successfully.");
        }
    }

    private static void markTaskAsCompleted(Scanner userInput) {
        while (true) {
            System.out.print("Please enter the ID of the task you wish to complete or type 'exit' to return to the main menu: ");
            String input = userInput.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            int id = Integer.parseInt(input);
            activeUser.completeTask(id);
        }
    }

    private static boolean displayAllUserTasks (){
            activeUser.printMyTasks();
            return activeUser.hasTasks();
    }

    private static void displayIncompleteTasks (){
            activeUser.printIncompleteTasks();
    }

    private static User findUserByUserName (String userName){
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}


