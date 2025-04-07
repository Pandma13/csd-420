// Megan Wheeler
// Assignment 4
// 5 April 2025

// Write a test program that stores 50,000 integers in LinkedList and test the time
// to traverse the list using an iterator vs. using the get(index) method. 

// 1.  Test your program storing first 50,000 and then 500,000 integers.
// 2.  After completing this program and having tested both values, in your comments,
//     explain the results and discuss the time taken using both values and their
//     difference with the get(index) approach.
// 3.  Write test code that ensures the code functions correctly.

// ------------ TEST RESULTS ------------
// Results of the test match what was expected. The time to iterate through a LinkedList
// using an Iterator is significantly faster than using get(index).

// The average time was taken from 5 separate times running the code.

// Average time to iterate through the list of 50_000 with Iterator was 2.7253 milliseconds.
// Average time to iterate through the list of 50_000 with get(index) was 1_111.96924 milliseconds.

// Average time to iterate through the list of 500_000 with Iterator was 5.285 milliseconds.
// Average time to iterate through the list of 50_000 with get(index) was 155_849.72748 milliseconds.


import java.util.Iterator;
import java.util.LinkedList;

public class TimeToTraverseLinkedList {

    public static void main(String[] args) {
        // call method to generate lists with random numbers
        populateList(50_000);
        populateList(500_000);

        // call methods to calculate the time to traverse the list of 50_000
        calculateTimeToIterate(populateList(50_000));
        calculateTimeToGetIndex(populateList(50_000));

        // call methods to calculate the time to traverse the list of 500_000
        calculateTimeToIterate(populateList(500_000));
        calculateTimeToGetIndex(populateList(500_000));
    }

    // method to populate a list of n number of elements
    public static LinkedList<Integer> populateList(int n) {
        int elementNumber = n; // declare variable to hold number of elements

        LinkedList<Integer> list = new LinkedList<>(); // create new list to populate

        // while loop to add random numbers to list
        while (list.size() < elementNumber) {
            // generate and add a number between 1 and 1_000
            int i = (int)(Math.random() * 1001);

            // add it to the list
            list.add(i);
        }

        // return the list for access by other methods
        return list;
    }

    // method to calculate the time to iterate trough list using Iterator
    public static void calculateTimeToIterate(LinkedList<Integer> list) {
        long startTime = System.nanoTime(); // start time

        // for loop to iterate through the list using Iterator
        for (Iterator<Integer> myIterator = list.iterator(); myIterator.hasNext();) {
            myIterator.next();
        }

        long endTime = System.nanoTime(); // end time
        long elapsedTime = endTime - startTime; // calculate time elapsed
        //convert time elapsed to milliseconds
        double elapsedMillisecondTime = (double) elapsedTime / 1_000_000.0;

        // print the result to the user
        System.out.println("Time to iterate through list of " + list.size() + " with Iterator is " + elapsedMillisecondTime + " milliseconds");
    }

    // method to calculate the time to iterate trough list using get(index)
    public static void calculateTimeToGetIndex(LinkedList<Integer> list) {
        long startTime = System.nanoTime();// start time

        // for loop to iterate through the list using get(index)
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long endTime = System.nanoTime();// end time
        long elapsedTime = endTime - startTime;// calculate time elapsed
        //convert time elapsed to milliseconds
        double elapsedMillisecondTime = (double) elapsedTime / 1_000_000.0;

        // print the result to the user
        System.out.println("Time to iterate through list of " + list.size() + " with get(index) is " + elapsedMillisecondTime + " milliseconds");
    }
}