package Model;

public class Student {

    private String name; // Student's name
    private String className; // Student's class
    private double mathMark; // Student's math mark
    private double physicalMark; // Student's physical mark
    private double chemistryMark; // Student's chemistry mark
    private String type;
    private double avg;

    public Student() {
    }

    public Student(String name, String className, double mathMark, double physicalMark, double chemistryMark) {
        this.name = name;
        this.className = className;
        this.mathMark = mathMark;
        this.physicalMark = physicalMark;
        this.chemistryMark = chemistryMark;
    }

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

    public String getType() {
        return type;
    }

    public void setType() {
        if (avg > 7.5) {
            this.type = "A";
        } else if (avg >= 6) {
            this.type = "B";
        } else if (avg >= 4) {
            this.type = "C";
        } else {
            this.type = "D";
        }
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg() {
        this.avg = (physicalMark + mathMark + chemistryMark) / 3;
    }

}
