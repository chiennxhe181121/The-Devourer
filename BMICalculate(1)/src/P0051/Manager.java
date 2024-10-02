package P0051;

public class Manager {

    public static int menu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        int choice = Validation.getInt("Please choice one option: ", 1, 3);
        return choice;
    }

    private static double memory = 0.0;

    public static void normalCalculate(double num, String ope) {
        switch (ope) {
            case "+":
                memory += num;
                break;
            case "-":
                memory -= num;
                break;
            case "*":
                memory *= num;
                break;
            case "/":
                if (num != 0) {
                    memory /= num;
                } else {
                    System.out.println("Cannot divide by 0. Please input another number");
                    num = Validation.getDouble("Enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, "Wrong format, please input a real number");
                    memory /= num;
                }
                break;
            case "^":
                memory = Math.pow(memory, num);
                break;
        }
    }

    public static void performNormalCalculate() {
        memory = Validation.getDouble("Enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, "Wrong format, please input a real number");
        while(true){
            String ope = Validation.getOperator("Enter Operator: ", "Please input (+, -, *, /, ^)");
            if(ope.equals("=")){
                System.out.println("Result: " + memory);
                break;
            }
            double 
        }
    }
}
