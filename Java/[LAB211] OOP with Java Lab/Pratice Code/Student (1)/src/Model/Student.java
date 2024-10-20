package Model;

public class Student {

    private String name;
    private String className;
    private double mathMark;
    private double physicalMark;
    private double chemistryMark;

    public Student() {
    }

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
        return (mathMark + chemistryMark + physicalMark) / 3;
    }

    // Method to determine the grade type based on average mark
    public String getType() {
        if (getAvg() > 7.5) {
            return "A";
        } else if (getAvg() >= 6 && getAvg() <= 7.5) {
            return "B";
        } else if (getAvg() >= 4 && getAvg() < 6) {
            return "C";
        } else {
            return "D";
        }
    }
}
