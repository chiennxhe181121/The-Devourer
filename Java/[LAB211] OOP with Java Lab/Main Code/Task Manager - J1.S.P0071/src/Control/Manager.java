package Control;

import Model.Task;
import Model.TaskType;
import Model.Validation;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    List<Task> tasks = new ArrayList<>();
    List<TaskType> taskTypes = new ArrayList<>();
    Validation va  = new Validation();
    private int crID = 1;

    public Manager() {
        taskTypes.add(new TaskType(1, "Code"));
        taskTypes.add(new TaskType(2, "Test"));
        taskTypes.add(new TaskType(3, "Design"));
        taskTypes.add(new TaskType(4, "Review"));
    }

    public void addTask() {
        System.out.println("------------Add Task---------------");
        String name = va.getString("Requirement Name: ");
        int type = va.getInt("Task Type: ", 1, 4);
        String date = va.getDate("Date: ");
        double from = va.getDouble("From: ", 8, 17.5);
        double to = va.getDouble("To: ", from, 17.5);
        String assigne = va.getAssignee();
        String review = va.getReviewer(assigne);
        tasks.add(new Task(crID++, review, type, date, from, to, assigne, review));
    }

    public void deleteTask() {
        System.out.println("---------Del Task------");
        boolean found = false;
        if (tasks.isEmpty()) {
            System.out.println("*** The task table is empty ***");
        } else {
            int choice = va.getInt("ID: ", 1, tasks.size());
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId() == choice) {
                    tasks.remove(tasks.get(i));
                    found = true;
                    for (int j = i; j < tasks.size(); j++) {
                        tasks.get(i).setId(j + 1);
                    }
                    crID = tasks.size() + 1;
                }
            }
            if (found == false) {
                System.out.println("*** Not found id need to remove ***");
            }
        }
    }

    public void displayTask() {
        System.out.println("----------------------------------------- Task ---------------------------------------");
        if (tasks.size() == 0) {
            System.out.println("*** The task table is empty ***");
        } else {
            System.out.println("ID 	Name			Task Type	Date		Time		Assignee	Reviewer");
            for (Task task : tasks) {
                String s = "";
                for (TaskType o : taskTypes) {
                    if (o.getId() == task.getTaskType()) {
                        s = o.getName();
                        break;
                    }
                }
                System.out.println("" + task.getId() + " 	" + task.getRequirementName()
                        + "			" + s + "	" + task.getDate() + "		"
                        + (task.getPlanTo() - task.getPlanFrom()) + "	" + task.getAssignee() + " 	");
            }
        }
    }

}
