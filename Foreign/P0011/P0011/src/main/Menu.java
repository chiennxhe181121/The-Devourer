/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author ThanhHo
 */
public class Menu {
    private static String[] ops = {
        "Convert From Binary",
        "Convert From Decimal",
        "Convert From Hexa",
        "Exit"
    };
    
    public static int getChoice(){
        for(int i = 0; i < ops.length ; i++){
            System.out.println((i+1) + ".  " + ops[i]);
        }
        int choice = Validation.getInt("Your choice: ", 1, ops.length);
        return choice;
    }
}