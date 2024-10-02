package main;

import java.math.BigInteger;
import java.util.Stack;

public class Manager {

    private final String binaryRegex = "-?[0-1]*";
//    private final String decimaRegex = "[0-9]*";
    private final String decimaRegex = "-?[0-9]*";
    private final String hexaRegex = "[0-9A-F]*";

    public int displayConvert(String from, String case1, String case2) {
        System.out.println("1. Convert from " + from + " to " + case1);
        System.out.println("2. Convert from " + from + " to " + case2);
        int choice = Validation.getInt("Your choice: ", 1, 2);
        return choice;
    }

    public void convertFromBinary() {
        while (true) {
            String bnr = Validation.getBase("Enter binary number: ", "WRONG FORMAT!", binaryRegex);
            int value = displayConvert("binary", "decimal", "hexa");
            switch (value) {
                case 1:
                    convertBinaryToAnother(bnr, 10);
                    break;
                case 2:
                    convertBinaryToAnother(bnr, 16);
                    break;
            }
            String check = Validation.checkYN();
            if (check.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void convertFromDecimal() {
        String decimal = Validation.getBase("Enter decimal number: ", "WRONG FORMAT!", decimaRegex);
        int value = displayConvert("decimal", "binary", "hexa");
        switch (value) {
            case 1:
                convertDecimalToAnother(decimal, 2);
                break;
            case 2:
                convertDecimalToAnother(decimal, 16);
                break;
        }
    }

    public void convertDecimalToBinary(String decimal) {
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        System.out.println(binary);
    }

    public void convertFromHexa() {
        String hexa = Validation.getBase("Enter hexa number: ", "WRONG FORMAT!", hexaRegex);
        int value = displayConvert("hexa", "binary", "decimal");
        switch (value) {
            case 1:
                convertHexaToAnother(hexa, 2);
                break;
            case 2:
                convertHexaToAnother(hexa, 10);
                break;
        }
    }

    public void convertHexaToAnother(String hexa, int base) {
        long dec = convertToDecimal(hexa, 16);
        if (base == 10) {
            System.out.println("Decimal = " + dec);
        } else {
            convertDecimalToAnother(dec + "", 2);
        }
    }

    public void convertDecimalToAnother(String decimal, int base) {
        Stack<Character> stack = new Stack<>();
        long dec = Long.valueOf(decimal);
        while (dec != 0) {
            long r = dec % base;
            if (r < 10) {
                stack.push((char) (r + 48));
            } else {
                stack.push((char) (r + 55));
            }
            dec /= base;
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        if (base == 16) {
            System.out.println("Hexa = " + result);
        } else {
            System.out.println("Binary = " + result);
        }
    }

    private void convertBinaryToAnother(String bnr, int base) {
        long dec = convertToDecimal(bnr, 2);

        if (base == 10) {
            System.out.println("Decimal = " + dec);
        } else {
            convertDecimalToAnother(dec + "", base);
        }
    }

    public long convertToDecimal(String value, int base) {
        long dec = 0;
        long k = 1;
        String tmp = value;
        if (value.charAt(0) == '-') {
            value = value.replaceFirst("-", "");
        }
        for (int i = value.length() - 1; i >= 0; i--) {
            if (Character.isDigit(value.charAt(i))) {
                dec += (value.charAt(i) - '0') * k;
            } else {
                dec += (int) (value.charAt(i) - 'A' + 10) * k;
            }
            k *= base;
        }
        if(tmp.charAt(0) == '-'){
            return (-1)*dec;
        }
        else return dec;
    }
}
