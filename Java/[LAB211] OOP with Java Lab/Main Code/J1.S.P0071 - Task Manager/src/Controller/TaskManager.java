package Controller;

import Model.Task;
import Model.Validation;
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
            String requirementName; // Variable to hold requirement name
            int taskType; // Variable to hold task type
            
            // Input requirementName and taskType with error checking
            while (true) {
                requirementName = val.getString("Requirement Name: "); // Get requirement name from user
                taskType = val.getInt("Task Type (1: Code, 2: Test, 3: Design, 4: Review): ", 1, 4); // Get task type from user
                
                // Get task type name based on taskTypeId
                String taskTypeName = "";
                switch (taskType) {
                    case 1: taskTypeName = "Code"; break; // Set task type to Code
                    case 2: taskTypeName = "Test"; break; // Set task type to Test
                    case 3: taskTypeName = "Design"; break; // Set task type to Design
                    case 4: taskTypeName = "Review"; break; // Set task type to Review
                }
                
                // Check if requirementName contains taskType
                if (!requirementName.toUpperCase().contains(taskTypeName.toUpperCase())) {
                    System.err.println("Error: Requirement Name must contain the Task Type (" + taskTypeName + "). Please enter again."); // Error message
                } else {
                    break; // Exit the loop if valid
                }
            }

            String date = val.getDate("Date: "); // Get task date from user
            double planFrom = val.getFrom("From: ", 8, 17); // Get planned start time
            double planTo = val.getTo("To: ", planFrom, 17.5); // Get planned end time
            String assignee = val.getString("Assignee: "); // Get assignee's name
            String reviewer = val.getString("Reviewer: "); // Get reviewer's name

            // Create a new Task object and add it to the list if valid
            Task task = new Task(crID++, requirementName, taskType, date, planFrom, planTo, assignee, reviewer);
            task.setTaskType(); // Set the task type based on the task type ID
            tasks.add(task); // Add the new task to the list

            String choice = val.getYesOrNo("Do you want to add more (Y/N): "); // Ask if user wants to add more tasks
            if (choice.equals("N")) {
                break; // Exit the loop if user does not want to add more
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
            // Print header for task table
            System.out.printf("%-5s %-20s %-15s %-15s %-10s %-15s %s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            // Loop through and display each task
            for (Task task : tasks) {
                System.out.printf("%-5d %-20s %-15s %-15s %-10.1f %-15s %s\n",
                        task.getId(),
                        task.getRequirementName(),
                        task.getTaskType(),
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
                }
                // Reset task IDs after deletion
                for (int j = 0; j < tasks.size(); j++) {
                    tasks.get(j).setId(j + 1); // Update task IDs
                    crID = tasks.size() + 1; // Update current task ID counter
                }
            }
            if (!flag) {
                System.out.println("*** Your ID does not exist in the table ***"); // Error if task ID is not found
            }
        }
    }
}
