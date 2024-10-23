package View;

import Model.*;
import Control.*;

public class Main {

    public static void main(String[] args) {
        Validation valid = new Validation();
        Manager ma = new Manager();
        while (true) {
            System.out.println("========= Task program =========\n"
                    + "1.	Add Task\n"
                    + "2.	Delete task\n"
                    + "3.	Display Task\n"
                    + "4.	exit");
            int choice = valid.getInt("Enter your choice: ", 1, 4);
            System.out.println("");
            switch (choice) {
                case 1:
                    ma.addTask();
                    System.out.println("");
                    break;
                case 2:
                    ma.deleteTask();
                    System.out.println("");
                    break;
                case 3:
                    ma.displayTask();
                    System.out.println("");
                    break;
                case 4:
                    return;
            }
        }
    }

}
