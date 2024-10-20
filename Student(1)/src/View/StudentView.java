package View;

import Model.Student;

public class StudentView {

    // Method to display student information
    public void displayStudentInfo(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Classes: " + student.getClassName());
        System.out.printf("AVG: %.1f\n", student.getAvg());
        System.out.println("Type: " + student.getType());
    }

    // Method to display message
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
