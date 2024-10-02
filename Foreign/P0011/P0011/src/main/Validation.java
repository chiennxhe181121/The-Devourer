/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author ThanhHo
 */
public class Validation {
    
    private static Scanner sc = new Scanner(System.in);
    public static String getBase(String msg, String msgErr, String regex){
        while(true){
            System.out.print(msg);
            String value = sc.nextLine();
            if(value.isEmpty()){
                System.err.println("Can't Empty!");
            }
            else{
                if(value.matches(regex)){
                    return value;
                }
                System.err.println(msgErr);
            }
        }
    }
    
    //method to input and validate valid positive number 
    public static int getInt(String msg, int min, int max){
        while(true){
            try{
                System.out.print(msg);
                int value = Integer.parseInt(sc.nextLine().trim());
                if(value >= min && value <= max){
                    return value;
                }
                System.err.println("PLEASE ENTER NUMBER IN RANGE " + min + " to " + max);
            }
            catch(NumberFormatException ex){
                System.err.println("WRONG FORMAT!!");
            }
        }
    }
    
    public static String checkYN(){
        while(true){
            System.out.print("Do you want to continue? ");
            String result = sc.nextLine();
            if(result.equalsIgnoreCase("Y") || result.equalsIgnoreCase("N")){
                return result;
            }
            System.err.println("Please enter only Y or N !");
        }
    }
}
