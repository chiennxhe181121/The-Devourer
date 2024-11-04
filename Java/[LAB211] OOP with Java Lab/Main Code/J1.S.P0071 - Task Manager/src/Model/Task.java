package Model;

public class Task {
    private int id; // ID tác vụ
    private String requirementName; // Tên yêu cầu của tác vụ
    private TaskType taskType; // Đối tượng TaskType
    private String date; // Ngày tác vụ
    private double planFrom; // Thời gian bắt đầu dự kiến
    private double planTo; // Thời gian kết thúc dự kiến
    private String assignee; // Tên người được giao nhiệm vụ
    private String reviewer; // Tên người xem xét

    public Task(int id, String requirementName, TaskType taskType, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskType = taskType; // Sử dụng đối tượng TaskType
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

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
        return taskType; // Trả về đối tượng TaskType
    }

    public String getTaskTypeName() {
        return taskType.getName(); // Trả về tên loại tác vụ
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
