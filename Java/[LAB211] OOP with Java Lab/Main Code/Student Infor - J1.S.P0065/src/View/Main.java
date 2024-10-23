package View;
import Control.*;
import Model.Validation;

public class Main {

    public static void main(String[] args) {
        // Display program title
        System.out.println("====== Management Student Program ======");
        // Create an instance of Manager to manage student information
        Manager manager = new Manager();
        // Call method to input student information
        manager.studentManager();
    }
    
}
