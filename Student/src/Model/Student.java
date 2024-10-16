package Model;

public class Student {

    private String name; // Student's name
    private String className; // Student's class
    private double mathMark; // Student's math mark
    private double physicalMark; // Student's physical mark
    private double chemistryMark; // Student's chemistry mark

    public Student() {
    }

    // Constructor to initialize Student object with values
    public Student(String name, String className, double mathMark, double physicalMark, double chemistryMark) {
        this.name = name;
        this.className = className;
        this.mathMark = mathMark;
        this.physicalMark = physicalMark;
        this.chemistryMark = chemistryMark;
    }

    // Getter and setter methods for student attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMathMark() {
        return mathMark;
    }

    public void setMathMark(double mathMark) {
        this.mathMark = mathMark;
    }

    public double getPhysicalMark() {
        return physicalMark;
    }

    public void setPhysicalMark(double physicalMark) {
        this.physicalMark = physicalMark;
    }

    public double getChemistryMark() {
        return chemistryMark;
    }

    public void setChemistryMark(double chemistryMark) {
        this.chemistryMark = chemistryMark;
    }

    // Method to calculate average mark of the student
    public double getAvg() {
        double avg = (mathMark + chemistryMark + physicalMark) / 3;
        return avg;
    }

    // Method to determine the grade type based on average mark
    public String getType() {
        if (getAvg() > 7.5) {
            return "A"; // Grade A
        } else if (getAvg() >= 6 && getAvg() <= 7.5) {
            return "B"; // Grade B
        } else if (getAvg() >= 4 && getAvg() < 6) {
            return "C"; // Grade C
        } else {
            return "D"; // Grade D
        }
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Classes: " + className);
        System.out.printf("AVG: %.1f\n", getAvg());
        System.out.println("Type: " + getType());
    }

}