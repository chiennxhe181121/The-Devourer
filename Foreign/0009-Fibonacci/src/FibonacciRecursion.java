/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class FibonacciRecursion {

    public static void main(String[] args) {
        //Create array to find 45 sequence Fibonacci by recursion
        int[] array = findFibonacci(45);

        //Display to the fibonacci sequence
        displayArray(array);
    }

    //Write Method value fibonacci sequence in array by recursion
    private static void writeFibonacciByRecursion(int[] array, int countIndexInFibonacci) {
        //while loop when count Index inFibonacci less or equal 1
        while (countIndexInFibonacci <= 1) {
            array[countIndexInFibonacci] = countIndexInFibonacci;
            countIndexInFibonacci++;
        }

        //Block code if count index in Fibonacci greater than 1
        if (countIndexInFibonacci > 1) {
            array[countIndexInFibonacci] = array[countIndexInFibonacci - 1] + array[countIndexInFibonacci - 2];
            countIndexInFibonacci++;

            //Block code if count index in fibonacci less than size array, when keep going recursion
            if (countIndexInFibonacci < array.length) {
                writeFibonacciByRecursion(array, countIndexInFibonacci);
            }
        }

    }

    //Method to create array have size and start by reversion
    public static int[] findFibonacci(int sizeArray) {

        int[] array = new int[sizeArray];

        int countIndexInFibonacci = 0;  //Start for the 0th index

        //Start the recursion to fill the array
        writeFibonacciByRecursion(array, countIndexInFibonacci);

        return array;
    }

    //Display to the fibonacci sequence
    private static void displayArray(int[] array) {
        System.out.println("The " + array.length + " sequence fibonacci:");

        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }

}
