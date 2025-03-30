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
        writeToFile();
    }

    public static int[] buildIntArray() {
        int[] myIntArray = new int[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            myIntArray[i] = random.nextInt() * 100;
        }

        return myIntArray;
    }

    public static double[] buildDoubleArray() {
        double[] myDoubleArray = new double[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            myDoubleArray[i] = random.nextDouble() * 100;
        }

        return myDoubleArray;
    }

    public static void writeToFile(){        
        try (BufferedWriter myBuffWriter = new BufferedWriter(new FileWriter("wheeler_datafile.dat"))) {
            myBuffWriter.write(Arrays.toString(buildIntArray()));
            myBuffWriter.write(Arrays.toString(buildDoubleArray()));
            
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
        }
    }
}