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

            // If list is empty, no need to check for duplicate accounts
            if (list.isEmpty()) {
                acc = val.getString("Account: ");
            } else {
                boolean isUnique = false;

                // Loop until a unique account name is provided
                while (!isUnique) {
                    acc = val.getString("Account: ");

                    // Check if the account already exists in the list
                    isUnique = true;
                    for (User user : list) {
                        if (user.getAcc().equals(acc)) {
                            System.err.println("This account already exists, please enter another");
                            isUnique = false;
                            break;
                        }
                    }
                }
            }

            // Gather user details, using validation methods for format checking
            String pass = val.getString("Password: ");
            String name = val.getStringRegex("Name: ", "^[a-zA-Z\\s]+$", "Name must contain only letters and spaces");
            String phone = val.getStringRegex("Phone: ", "[0-9]{10,11}", "Phone number must be 10 or 11 digits");
            String email = val.getStringRegex("Email: ", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", "Email must be in format 'example@domain.com'");
            String address = val.getStringRegex("Address: ", "^[a-zA-Z\\s]+$", "Address must contain only letters and spaces");
            String dOB = val.getDate("DOB: ");

            // Create a new User object with provided details and add to list
            User us = new User(acc, pass, name, phone, email, address, dOB);
            list.add(us);

            // Prompt to add another user or stop
            String choice = val.getYesOrNo("Do you want to add more (Y/N): ");
            if (choice.equals("N")) {
                break;
            }
        }

        System.out.println("*** Add successful ***\n");
    }

    // Method to handle user login
    public void loginAccount() {
        if (list.isEmpty()) {
            System.out.println("*** No account has been created yet ***");
            return;
        }

        System.out.println("------------- Login ----------------");
        boolean loggedIn = false;

        // Loop until a valid account/password is provided
        while (!loggedIn) {
            String acc = val.getString("Account: ");
            String pass = val.getString("Password: ");

            boolean found = false;

            // Check if input account and password match any user in the list
            for (User user : list) {
                if (user.getAcc().equals(acc) && user.getPass().equals(pass)) {
                    System.out.println("*** Login successful ***");
                    loggedIn = true;
                    found = true;

                    // Welcome message and option to change password
                    System.out.println("\n------------ Welcome -----------");
                    String choice = val.getYesOrNo("Hi " + user.getName() + ", do you want to change password now? Y/N: ");
                    if (choice.equals("N")) {
                        System.out.println("");
                        return;
                    } else {
                        changePassword(user);
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

        // Confirm the old password before allowing changes
        while (!correctOldPass) {
            oldPass = val.getString("Old password: ");
            if (oldPass.equals(user.getPass())) {
                correctOldPass = true;
            } else {
                System.err.println("Old password is incorrect.");
            }
        }

        boolean passwordChanged = false;

        // Loop to ensure new password is different from the old password and matches the retyped password
        while (!passwordChanged) {
            String newPass = val.getString("New password: ");
            if (newPass.equals(oldPass)) {
                System.err.println("New password cannot be the same as the old password");
                continue;
            }

            String renewPass = val.getString("Re-enter new password: ");
            if (renewPass.equals(newPass)) {
                user.setPass(newPass);
                System.out.println("*** Password changed successfully ***\n");
                passwordChanged = true;
            } else {
                System.err.println("Passwords do not match. Please try again.");
            }
        }
    }
}
