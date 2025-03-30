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
            
    }
    
    public static int[] buildIntArray() {
        int[] myIntArray = new int[5];

        int randomInt = (int)(Math.random() * 101);

        for (int i = 0; i < myIntArray.length; i++) {
            myIntArray[i] = randomInt;
            i++;
        }

        return myIntArray;
    }

    public static double[] buildDoubleArray() {
        double[] myDoubleArray = new double[5];

        double randomDouble = (double)(Math.random() * 101);

        for (int i = 0; i < myDoubleArray.length; i++) {
            myDoubleArray[i] = randomDouble;
            i++;
        }

        return myDoubleArray;
    }

    public static void writeToFile(){
        
        try (FileWriter myFileWriter = new FileWriter("wheeler_datafile.dat")) {
            myFileWriter.write(Arrays.toString(buildIntArray()));
            myFileWriter.write(Arrays.toString(buildDoubleArray()));
            
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}