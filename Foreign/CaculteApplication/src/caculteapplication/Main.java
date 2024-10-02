/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caculteapplication;

/**
 *
 * @author laptop
 */
public class Main {
    public static void main(String[] args) {
    CaculateApplication caculate = new CaculateApplication();
 
        boolean checkChoice = true;
        while (checkChoice) {
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");

            int choice = caculate.validateInputInt();
            switch (choice) {
                case 1:
                    caculate.calculateNormal();
                    break;
                case 2:
                    caculate.calculateBMI();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    checkChoice = false;
                    break;
                default:
                    System.out.println("Invalid choice, please select 1, 2, or 3.");
                    break;
            }
        }    
    }
}
