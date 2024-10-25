package Model;

public class Task {
    private int id; // Task ID
    private String requirementName; // Requirement name
    private TaskType taskType; // Type of task
    private String date; // Task date
    private double planFrom; // Start time
    private double planTo; // End time
    private String assignee; // Person assigned to the task
    private String reviewer; // Task reviewer

    // Default constructor
    public Task() {
    }

    // Constructor with parameters
    public Task(int id, String requirementName, TaskType taskType, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id; 
        this.requirementName = requirementName; 
        this.taskType = taskType; 
        this.date = date; 
        this.planFrom = planFrom; 
        this.planTo = planTo; 
        this.assignee = assignee; 
        this.reviewer = reviewer; 
    }

    // Getters and setters for task properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public TaskType getTaskType() {
        return taskType; 
    }

    public void setTaskType(TaskType taskType) { 
        this.taskType = taskType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
