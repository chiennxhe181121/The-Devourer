package Model;

public class Expense {
    private int id; // ID of the expense
    private String date; // Date of the expense
    private double amount; // Amount of the expense
    private String content; // Content/description of the expense

    // Default constructor
    public Expense() {
    }

    // Parameterized constructor
    public Expense(int id, String date, double amount, String content) {
        this.id = id; // Set expense ID
        this.date = date; // Set expense date
        this.amount = amount; // Set expense amount
        this.content = content; // Set expense content
    }

    // Getters and Setters
    public int getId() {
        return id; // Return expense ID
    }

    public void setId(int id) {
        this.id = id; // Set expense ID
    }

    public String getDate() {
        return date; // Return expense date
    }

    public void setDate(String date) {
        this.date = date; // Set expense date
    }

    public double getAmount() {
        return amount; // Return expense amount
    }

    public void setAmount(double amount) {
        this.amount = amount; // Set expense amount
    }

    public String getContent() {
        return content; // Return expense content
    }

    public void setContent(String content) {
        this.content = content; // Set expense content
    }

    @Override
    public String toString() {
        return String.format("%-6d%-15s%-11.2f%s", id, date, amount, content); // Format expense details for display
    }
}
