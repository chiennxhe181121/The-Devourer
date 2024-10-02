package linearsearch_practice;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validator {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= max && result >= min) {
                    return result;
                } 
                System.err.println("Your number must be from " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format. Please input an integer");
            }
        }
    }
}
