package Model;

public class TaskType {

    private int id; // Unique identifier for the task type
    private String name; // Name of the task type

    // Default constructor
    public TaskType() {
    }

    // Constructor with parameters
    public TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters for task type properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
