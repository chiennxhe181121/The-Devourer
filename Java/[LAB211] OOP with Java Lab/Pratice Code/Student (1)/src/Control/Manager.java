package Control;

import Model.*;
import View.StudentView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {

    private List<Student> studentList = new ArrayList<>(); // List to store students
    private StudentView view = new StudentView(); // View instance to display information

    // Method to input and manage student information
    public void studentInfo() {
        while (true) {
            // Get student's name
            String name = Validation.getStringRegex("Name: ", "^[a-zA-Z\\s]+$",
                    "Error: The name must consist of letters and space (Eg: Hoang Ngu)");
            // Get student's class name
            String className = Validation.getStringRegex("Classes: ", "^[a-zA-Z]{2}[0-9]{4}$",
                    "Error: The class name must consist of 2 letters followed by 4 digits (Eg: SE1920)");
            // Get student's marks in subjects
            double math = Validation.getDouble("Maths: ", 0, 10);
            double chemistry = Validation.getDouble("Chemistry: ", 0, 10);
            double physics = Validation.getDouble("Physics: ", 0, 10);
            // Add new student to the list
            studentList.add(new Student(name, className, math, physics, chemistry));
            // Ask user if they want to enter more student information
            String choice = Validation.getYOrN("Do you want to enter more student information?(Y/N): ");
            if (choice.equals("N")) {
                displayListStudentInfo();
                displayClassificationInfo();
                return; // Exit the loop
            }
        }
    }

    // Method to display information of all students
    private void displayListStudentInfo() {
        int countStudent = 1; // Counter for displaying student number
        for (Student student : studentList) {
            view.displayMessage("------ Student " + countStudent + " Info ------");
            view.displayStudentInfo(student); // Display each student's information
            countStudent++;
        }
    }

    // Method to display percentage of students by grade type
    private void displayClassificationInfo() {
        view.displayMessage("--------Classification Info --------");
        HashMap<String, Double> hashMap = getPercentTypeStudent();
        hashMap.forEach((key, value) -> System.out.printf("%s: %.1f%%\n", key, value));
    }

    // Method to calculate the percentage of students by grade type
    public HashMap<String, Double> getPercentTypeStudent() {
        HashMap<String, Double> hashMap = new HashMap<>();
        int cntA = 0, cntB = 0, cntC = 0, cntD = 0; // Counters for each grade type
        for (Student o : studentList) {
            double avg = o.getAvg();
            // Count the number of students in each grade category
            if (avg > 7.5) {
                cntA++;
            } else if (avg >= 6) {
                cntB++;
            } else if (avg >= 4) {
                cntC++;
            } else {
                cntD++;
            }
        }
        int totalStudent = studentList.size(); // Total number of students
        // Calculate and store the percentage of each grade type
        hashMap.put("A", (100.0 * cntA) / totalStudent);
        hashMap.put("B", (100.0 * cntB) / totalStudent);
        hashMap.put("C", (100.0 * cntC) / totalStudent);
        hashMap.put("D", (100.0 * cntD) / totalStudent);
        return hashMap; // Return the map of percentages
    }
}
