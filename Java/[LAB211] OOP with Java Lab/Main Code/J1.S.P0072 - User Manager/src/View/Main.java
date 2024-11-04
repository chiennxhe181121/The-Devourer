package View;

import Control.UserManager;
import Control.Validation;

public class Main {

    public static void main(String[] args) {
        Validation val = new Validation();
        UserManager um = new UserManager();
        while (true) {
            System.out.println("============ Login Program =========");
            System.out.println("1. Add User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = val.getInt("Please choice one option: ", 1, 3);
            System.out.println("");
            switch (choice) {
                case 1:
                    um.addUser();
                    break;
                case 2:
                    um.loginAccount();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

}
