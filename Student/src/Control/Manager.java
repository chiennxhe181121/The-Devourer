package Control;

import Model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {

    List<Student> studentList = new ArrayList<>(); // List to store students
    Student student = new Student(); // Instance of Student class

    // Method to input and manage student information
    public void studentManager() {
//        studentList.add(new Student("hoang ngu", "SE1920", 5, 5, 5));
//        studentList.add(new Student("chien", "SE1920", 10, 10, 10));
//        studentList.add(new Student("thanh", "SE1920", 9, 9, 9));
//        studentList.add(new Student("quang", "SE1920", 2, 2, 2));
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
            String choice = Validation.getYorN("Do you want to enter more student information?(Y/N): ");
            if (choice.equals("N")) {
                // Display the list of students' information
                displayListStudentInfo();
                // Get and display percentage of each grade type
                System.out.println("--------Classification Info -----");
                HashMap<String, Double> hashMap = getPercentTypeStudent();
                hashMap.forEach((key, value) -> System.out.printf("%s: %.1f%%\n", key, value));
                return; // Exit the loop
            }
        }

    }

    

    // Method to display information of all students
    public void displayListStudentInfo() {
        int countStudent = 1;
        for (Student student : studentList) {
            System.out.println("------ Student " + countStudent + " Info ------");
            countStudent++;
            student.displayStudentInfo(); // Display each student's information
        }
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
