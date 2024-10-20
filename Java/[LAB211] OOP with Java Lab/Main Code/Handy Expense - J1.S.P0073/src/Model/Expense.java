package Model;

public class Expense {
    private int ID;          // Expense ID
    private String date;     // Date of the expense
    private double number;    // Amount of the expense
    private String content;   // Description of the expense

    // Default constructor
    public Expense() {
    }

    // Constructor with parameters
    public Expense(int ID, String date, double number, String content) {
        this.ID = ID;
        this.date = date;
        this.number = number;
        this.content = content;
    }

    // Getters and setters for each attribute
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Override toString method for formatted output
    @Override
    public String toString() {
        return String.format("%-5d %-14s %-10.2f %s", ID, date, number, content);
    }
}
