package caculatorbmi_re;

/**
 *
 * @author ACER
 */
public class Caculation {

    Validation vali = new Validation();

    // Display menu
    public int menu() {
        System.out.println("========== Calculator Program ==========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = vali.getIntInRange(1, 3);
        return choice;
    }

    // Methor to us oparator " / " if use input the next number equal 0
    public double inputNonZero() {
        System.out.print("Enter next number: ");
        double num = vali.getDoubleNonZeroInRange(-Double.MAX_VALUE, Double.MAX_VALUE);

        return num;
    }

    // Methor accep all the number of Double 
    public double inputRealNumber() {
        System.out.print("Enter next number: ");
        return vali.getDoubleInRange(-Double.MAX_VALUE, Double.MAX_VALUE);
    }

    // Methor to caculation number
    public void normalCaculator() {
        double memory = 0;
        System.out.print("Enter number: ");
        memory = vali.getDoubleInRange(-Double.MAX_VALUE, Double.MAX_VALUE);
        while (true) {
            System.out.print("Choice oparator(+ - * / ^ = ):  ");
            String oparator = vali.getOparatorFormat();

            switch (oparator) {
                case "+":
                    memory += inputRealNumber();
                    break;
                case "-":
                    memory -= inputRealNumber();
                    break;
                case "*":
                    memory *= inputRealNumber();
                    break;
                case "/":
                    memory /= inputNonZero(); // Cannot division by 0
                    break;
                case "^":
                    memory = Math.pow(memory, inputRealNumber());
                    break;
                case "=":
                    System.out.printf("Final result: %.2f%n", memory);
                    return;
            }
            System.out.printf("Memory: %.2f%n", memory);
        }
    }
    // Display BMI status

    public String BMIStatus(double bmi) {
        if (bmi < 18.5) { 
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat - should lose weight.";
        } else {
            return "Very fat - should lose weight immediately.";
        }
    }

    public void BMICaculation() {
        System.out.print("Enter weight(kg): ");
        double weight = vali.getDoubleInRange(3, 400);

        System.out.print("Enter height(m): ");
        double height = vali.getDoubleInRange(0.5, 5);
        double bmi = (weight ) / (height * height);
        System.out.printf("BMI Number: %.2f" , bmi);
        System.out.println();
        System.out.println("BMI Satust: " + BMIStatus(bmi));

    }
}
