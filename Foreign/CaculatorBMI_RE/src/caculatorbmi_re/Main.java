package caculatorbmi_re;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        runProgarm();
    }

    public static void runProgarm() {
        Caculation ca = new Caculation(); // Call class Caculation
        while (true) {
            int choice = ca.menu();

            switch (choice) {
                case 1:
                    ca.normalCaculator();
                    break;
                case 2:
                    ca.BMICaculation();
                    break;
                case 3:
                    System.out.println("Exit progarm , good bye");
                    return;
            }

        }
    }
}
