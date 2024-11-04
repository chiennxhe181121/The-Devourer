package Controller;

import Model.Task;
import Model.TaskType;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    Validation val = new Validation(); // Instance of Validation class for input validation
    List<Task> tasks = new ArrayList<>(); // List to hold tasks
    private int crID = 1; // Current task ID counter

    // Method to add a new task
    public void addTask() {
        System.out.println("------------ Add Task ---------------");
        while (true) {
            String requirementName; // Variable to store the requirement name
            TaskType type = null; // Define type here
            String assignee = ""; // Declare assignee for later use
            String reviewer = ""; // Declare reviewer for later use

            // Input requirementName and taskType with error checks
            while (true) {
                requirementName = val.getString("Requirement Name: "); // Get the requirement name from user
                int taskType = val.getInt("Task Type (1: Code, 2: Test, 3: Design, 4: Review): ", 1, 4); // Get task type from user

                // Create TaskType object based on taskType
                switch (taskType) {
                    case 1:
                        type = new TaskType(1, "Code");
                        break;
                    case 2:
                        type = new TaskType(2, "Test");
                        break;
                    case 3:
                        type = new TaskType(3, "Design");
                        break;
                    case 4:
                        type = new TaskType(4, "Review");
                        break;
                }

                // Check if requirementName contains assignee
                while (true) {
                    assignee = val.getString("Assignee: "); // Get the name of the assignee
                    if (!requirementName.toUpperCase().contains(assignee.toUpperCase())) {
                        System.err.println("Error: Requirement Name must contain the Assignee (" + assignee + "). Please enter again."); // Error message
                    } else {
                        break; // Exit loop if valid
                    }
                }

                // Get the reviewer's name and check if it matches the selected taskType
                while (true) {
                    reviewer = val.getString("Reviewer: "); // Get the reviewer's name
                    if (!reviewer.equalsIgnoreCase(type.getName())) {
                        System.err.println("Error: Reviewer must match the Task Type (" + type.getName() + "). Please enter again."); // Error message
                    } else {
                        break; // Exit loop if valid
                    }
                }

                break; // Exit outer loop if valid
            }

            String date = val.getDate("Date: "); // Get the task date from user
            double planFrom = val.getFrom("From: ", 8, 17); // Get the planned start time
            double planTo = val.getTo("To: ", planFrom, 17.5); // Get the planned end time

            // Create a new Task object and add it to the list if valid
            Task task = new Task(crID++, requirementName, type, date, planFrom, planTo, assignee, reviewer);
            tasks.add(task); // Add the new task to the list

            String choice = val.getYesOrNo("Do you want to add more (Y/N): "); // Ask user if they want to add more tasks
            if (choice.equals("N")) {
                break; // Exit loop if not adding more
            }
        }
        System.out.println("*** Add successful ***"); // Success message
    }

    // Method to display all tasks
    public void displayTask() {
        System.out.println("------------ Task ---------------");
        if (tasks.isEmpty()) {
            System.out.println("*** The task table is empty ***"); // Error message if no tasks are found
        } else {
            // Print header for the task table
            System.out.printf("%-5s %-20s %-15s %-15s %-10s %-15s %s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            // Loop through and display each task
            for (Task task : tasks) {
                System.out.printf("%-5d %-20s %-15s %-15s %-10.1f %-15s %s\n",
                        task.getId(),
                        task.getRequirementName(),
                        task.getTaskTypeName(), // Get the task type name from the TaskType object
                        task.getDate(),
                        (task.getPlanTo() - task.getPlanFrom()), // Calculate total time
                        task.getAssignee(),
                        task.getReviewer());
            }
        }
    }

    // Method to delete a task
    public void deleteTask() {
        System.out.println("------------ Task ---------------");
        if (tasks.isEmpty()) {
            System.out.println("*** The task table is empty ***"); // Error message if no tasks are found
        } else {
            boolean flag = false; // Flag to check if task is found
            int delId = val.getInt("ID: ", 1, tasks.size()); // Get task ID to delete

            // Loop through tasks to find the specified task
            for (int i = 0; i < tasks.size(); i++) {
                if (delId == tasks.get(i).getId()) { // Check if task ID matches
                    tasks.remove(i); // Remove task from the list
                    flag = true; // Set flag to true
                    System.out.println("*** Delete successful ***"); // Success message
                    break; // Exit loop after deletion
                }
            }

            if (!flag) {
                System.out.println("*** Your ID does not exist in the table ***"); // Error if task ID is not found
            }

            // Update IDs for remaining tasks
            for (int j = 0; j < tasks.size(); j++) {
                tasks.get(j).setId(j + 1); // Update IDs for remaining tasks
            }
            crID = tasks.size() + 1; // Update the current task ID counter
        }
    }
}
