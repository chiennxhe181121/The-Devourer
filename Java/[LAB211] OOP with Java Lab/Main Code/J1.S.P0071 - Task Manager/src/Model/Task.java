package Model;

public class Task {

    private int id; // Task ID
    private String requirementName; // Task requirement name
    private int taskTypeId; // Task type ID
    private String taskType; // Task type name
    private String date; // Task date
    private double planFrom; // Planned start time
    private double planTo; // Planned end time
    private String assignee; // Assignee's name
    private String reviewer; // Reviewer's name

    public Task() {
    }

    public Task(int id, String requirementName, int taskTypeId, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskTypeId = taskTypeId;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id; // Get task ID
    }

    public void setId(int id) {
        this.id = id; // Set task ID
    }

    public String getRequirementName() {
        return requirementName; // Get requirement name
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName; // Set requirement name
    }

    public int getTaskTypeId() {
        return taskTypeId; // Get task type ID
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId; // Set task type ID
    }

    public String getTaskType() {
        return taskType; // Get task type
    }

    public void setTaskType() {
        switch (taskTypeId) {
            case 1:
                this.taskType = "Code"; // Set task type to Code
                break;
            case 2:
                this.taskType = "Test"; // Set task type to Test
                break;
            case 3:
                this.taskType = "Design"; // Set task type to Design
                break;
            case 4:
                this.taskType = "Review"; // Set task type to Review
                break;
        }
    }

    public String getDate() {
        return date; // Get task date
    }

    public void setDate(String date) {
        this.date = date; // Set task date
    }

    public double getPlanFrom() {
        return planFrom; // Get planned start time
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom; // Set planned start time
    }

    public double getPlanTo() {
        return planTo; // Get planned end time
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo; // Set planned end time
    }

    public String getAssignee() {
        return assignee; // Get assignee's name
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee; // Set assignee's name
    }

    public String getReviewer() {
        return reviewer; // Get reviewer's name
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer; // Set reviewer's name
    }
}
