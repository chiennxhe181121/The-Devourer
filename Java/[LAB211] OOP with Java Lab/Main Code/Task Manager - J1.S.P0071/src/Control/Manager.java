package Control;

import Model.Task;
import Model.TaskType;
import Model.Validation;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    List<Task> tasks = new ArrayList<>(); // List of tasks
    List<TaskType> taskTypes = new ArrayList<>(); // List of task types
    Validation va  = new Validation(); // Validation object
    private int crID = 1; // Current ID for new tasks

    // Constructor to initialize task types
    public Manager() {
        taskTypes.add(new TaskType(1, "Code"));
        taskTypes.add(new TaskType(2, "Test"));
        taskTypes.add(new TaskType(3, "Design"));
        taskTypes.add(new TaskType(4, "Review"));
    }

    // Method to add a new task
    public void addTask() {
        System.out.println("------------ Add Task ---------------");
        while (true) {
            String name = va.getString("Requirement Name: ");
            int typeId = va.getInt("Task Type (1: Code, 2: Test, 3: Design, 4: Review): ", 1, 4);

            try {
                // Validate the requirement name against the task type
                va.validateRequirementName(name, typeId);

                // Find the selected task type based on typeId
                TaskType selectedTaskType = null;
                for (TaskType taskType : taskTypes) {
                    if (taskType.getId() == typeId) {
                        selectedTaskType = taskType;
                        break;
                    }
                }

                // Get additional task details
                String date = va.getDate("Date: ");
                double from = va.getFrom("From: ", 8, 17.5);
                double to = va.getTo("To: ", from, 17.5);
                String assignee = va.getAssignee();
                String reviewer = va.getReviewer(assignee);

                // Add the new task to the list
                tasks.add(new Task(crID++, name, selectedTaskType, date, from, to, assignee, reviewer));

                // Ask if the user wants to add another task
                String choice = va.getYesOrNo("Do you want to add more (Y/N): ");
                if (choice.equals("N")) {
                    break; // Exit the loop if the user doesn't want to add more tasks
                }

            } catch (IllegalArgumentException e) {
                // Print error message and prompt for a new Requirement Name
                System.err.println(e.getMessage());
            }
        }
    }

    // Method to delete an existing task
    public void deleteTask() {
        System.out.println("------------ Del Task ---------------");
        boolean found = false; // Flag to check if task is found
        if (tasks.isEmpty()) {
            System.out.println("*** The task table is empty ***");
        } else {
            int choice = va.getInt("ID: ", 1, tasks.size());
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId() == choice) {
                    tasks.remove(tasks.get(i)); // Remove the task
                    found = true;
                    // Reassign IDs to remaining tasks
                    for (int j = i; j < tasks.size(); j++) {
                        tasks.get(j).setId(j + 1);
                    }
                    crID = tasks.size() + 1; // Update the current ID
                }
            }
            if (!found) {
                System.out.println("*** Not found id need to remove ***");
            }
        }
    }

    // Method to display all tasks
    public void displayTask() {
        System.out.println("------------ Display Task ---------------");
        if (tasks.isEmpty()) {
            System.out.println("*** The task table is empty ***");
        } else {
            // Header with formatted output
            System.out.printf("%-5s %-20s %-15s %-12s %-10s %-15s %-15s%n",
                    "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            for (Task task : tasks) {
                String taskTypeName = task.getTaskType().getName(); // Get the task type name
                // Print task details with formatted output
                System.out.printf("%-5d %-20s %-15s %-12s %-10.1f %-15s %-15s%n",
                        task.getId(),
                        task.getRequirementName(),
                        taskTypeName,
                        task.getDate(),
                        (task.getPlanTo() - task.getPlanFrom()), // Đây là biến kiểu double
                        task.getAssignee(),
                        task.getReviewer());
            }
        }
    }

    // Method to validate Requirement Name based on Task Type
    public void validateRequirementName(String requirementName, int taskTypeId) {
        String keyword = "";

        // Determine the keyword based on the task type
        switch (taskTypeId) {
            case 1:
                keyword = "Code";
                break;
            case 2:
                keyword = "Test";
                break;
            case 3:
                keyword = "Design";
                break;
            case 4:
                keyword = "Review";
                break;
            default:
                break;
        }

        // Check if the requirement name contains the keyword
        if (!requirementName.contains(keyword)) {
            throw new IllegalArgumentException("Requirement Name must contain the keyword '" + keyword + "' for Task Type " + taskTypeId);
        }
    }
}
