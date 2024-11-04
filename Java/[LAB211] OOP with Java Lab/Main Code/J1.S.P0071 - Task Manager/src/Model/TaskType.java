package Model;

public class TaskType {
    private int id; // ID của loại tác vụ
    private String name; // Tên của loại tác vụ

    // Constructor
    public TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter cho ID
    public int getId() {
        return id;
    }

    // Getter cho tên
    public String getName() {
        return name;
    }
}
