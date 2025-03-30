// Megan Wheeler
// Assignment 2
// 25 March 2025

// Follow the directions below:
// 1. Write a program that stores:
//      a. An array of five random integers.
//      b. An array of five random double values.
// 2. Write the data in a file titled [yourname] datafile.dat.
// 3. If there is no file, the file will be created.
// 4. If there is a file, the data will be appended.
// 5. Write a second program that will read the file and display the data.
// 6. Test the code to ensure the code functions correctly.
import java.io.*;
import java.util.*;

public class ArrayIn {
    
    public static void main(String[] args) {
        writeToFile(); // call method to create or append file
    }

    // method to create and populate random int array
    public static int[] buildIntArray() {
        // declare array and random variables
        int[] myIntArray = new int[5];
        Random random = new Random();

        // loop through array to populate with random int
        for (int i = 0; i < 5; i++) {
            myIntArray[i] = random.nextInt() * 100;
        }

        return myIntArray;
    }

    // method to create and populate random double array
    public static double[] buildDoubleArray() {
        // declare array and random variables
        double[] myDoubleArray = new double[5];
        Random random = new Random();

        // loop through array to populate with random double
        for (int i = 0; i < 5; i++) {
            myDoubleArray[i] = random.nextDouble() * 100;
        }

        return myDoubleArray;
    }

    // method to create or append file with both arrays
    public static void writeToFile(){
        try (BufferedWriter myBuffWriter = new BufferedWriter(new FileWriter("wheeler_datafile.dat"))) {
            myBuffWriter.write(Arrays.toString(buildIntArray()));
            myBuffWriter.write(Arrays.toString(buildDoubleArray()));
            
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
        }
    }
}