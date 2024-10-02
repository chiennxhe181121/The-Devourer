package main;
/**
 *
 * @author ThanhHo
 */
public class Main {

    public static void main(String[] args) {

        Manager m = new Manager();
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    m.convertFromBinary();
                    break;
                case 2:
                    m.convertFromDecimal();
                    break;
                case 3:
                    m.convertFromHexa();
                    break;
                case 4:
                    return;
            }
        }
    }

}
