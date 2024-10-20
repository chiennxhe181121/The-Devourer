package View;

import Control.Manager;

public class Main {

    public static void main(String[] args) {
        // Display program title
        System.out.println("====== Management Student Program ======");
        Manager mn = new Manager();
        // Call method to input and manage student information
        mn.studentInfo();
    }
}
