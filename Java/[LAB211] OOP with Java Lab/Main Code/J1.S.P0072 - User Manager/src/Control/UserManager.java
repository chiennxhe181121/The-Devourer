package Control;

import Model.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    // List to store all user objects
    List<User> list = new ArrayList<>();

    // Validation instance for input validation methods
    Validation val = new Validation();

    // Method to add a new user to the list
    public void addUser() {
        System.out.println("---------- Add User --------");

        while (true) {
            String acc = "";

            // Check if the list is empty for first account input
            if (list.isEmpty()) {
                acc = val.getString("Account: ");
            } else {
                boolean isUnique = false; // Flag to ensure account uniqueness
                while (!isUnique) {
                    acc = val.getStringRegex("Account: ", "^[a-zA-Z][a-zA-Z0-9._]{2,14}$", "Account must start with a letter and contain only letters, numbers, dots, or underscores, with a length of 3 to 15 characters.");
                    for (User user : list) {
                        // Check for existing accounts
                        if (user.getAcc().equals(acc)) {
                            System.err.println("This account already exists, please enter another");
                            isUnique = false; // Set flag to false if account exists
                            break;
                        } else {
                            isUnique = true;
                        }
                    }
                }
            }

            // Get user password and hash it
            String pass = val.getStringRegex("Password (8-31 characters): ", "^.{8,31}$", "Password must be between 8 and 31 characters.");
            pass = val.hashPassword(pass); // Hash the password

            // Get and validate other user details
            String name = val.getStringRegex("Name: ", "^[a-zA-Z\\s]+$", "Name must contain only letters and spaces");
            String phone = val.getStringRegex("Phone: ", "[0-9]{10,11}", "Phone number must be 10 or 11 digits");
            String email = val.getStringRegex("Email: ", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", "Email must be in format 'example@domain.com'");
            String address = val.getString("Address: ");
            String dOB = val.getDate("DOB: ");

            // Create a new User object and add it to the list
            User us = new User(acc, pass, name, phone, email, address, dOB);
            list.add(us);

            // Ask if the user wants to add more users
            String choice = val.getYesOrNo("Do you want to add more (Y/N): ");
            if (choice.equals("N")) {
                break; // Exit the loop if user chooses not to add more
            }
        }

        System.out.println("*** Add successful ***\n");
    }

    // Method to handle user login
    public void loginAccount() {
        if (list.isEmpty()) {
            System.out.println("*** No account has been created yet ***");
            return; // Exit if no accounts exist
        }

        System.out.println("------------- Login ----------------");
        boolean loggedIn = false;

        while (!loggedIn) {
            // Get account credentials for login
            String acc = val.getString("Account: ");
            String pass = val.getString("Password: ");
            pass = val.hashPassword(pass); // Hash the entered password

            boolean found = false; // Flag to check if account exists
            for (User user : list) {
                // Validate account and password
                if (user.getAcc().equals(acc) && user.getPass().equals(pass)) {
                    System.out.println("*** Login successful ***");
                    loggedIn = true; // Set loggedIn flag to true
                    found = true;

                    System.out.println("\n------------ Welcome -----------");
                    // Ask if the user wants to change the password after logging in
                    String choice = val.getYesOrNo("Hi " + user.getName() + ", do you want to change password now? Y/N: ");
                    if (choice.equals("N")) {
                        System.out.println("");
                        return; // Exit if the user does not want to change password
                    } else {
                        changePassword(user); // Call method to change password
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("*** Incorrect account or password. Try again ***");
            }
        }
    }

    // Method to change a user's password
    private void changePassword(User user) {
        boolean correctOldPass = false;
        String oldPass = "";

        // Prompt for the old password
        while (!correctOldPass) {
            oldPass = val.getString("Old password: ");
            oldPass = val.hashPassword(oldPass); // Hash the old password for comparison
            // Check if the entered old password matches
            if (oldPass.equals(user.getPass())) {
                correctOldPass = true; // Set flag to true if old password is correct
            } else {
                System.out.println("Old password is incorrect. Please try again.");
            }
        }

        // Prompt for the new password
        String newPass = val.getString("New password: ");
        newPass = val.hashPassword(newPass); // Hash the new password

        // Set the new password for the user
        user.setPass(newPass);
        System.out.println("*** Password changed successfully ***");
    }

}
