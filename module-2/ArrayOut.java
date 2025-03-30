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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayOut {
    public static void main(String[] args) {
        String filePath = "wheeler_datafile.dat"; // File to read

        // try/catch with reader to read file
        try (BufferedReader myReader = new BufferedReader(new FileReader(filePath))){
            String readFile = myReader.readLine(); // read the file
            System.out.println(readFile); // print file data to console
        } catch (IOException e) {
            // print error message if exception is thrown
            System.err.println("An error occurred while reading the file.");
        }
    }
}
