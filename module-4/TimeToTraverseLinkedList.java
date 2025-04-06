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
import java.util.*;

public class TimeToTraverseLinkedList {

    public static void main(String[] args) {
        populateList(50_000);
        populateList(500_000);

        calculateTimeToIterate(populateList(50_000));
        calculateTimeToGetIndex(populateList(50_000));

        calculateTimeToIterate(populateList(500_000));
        calculateTimeToGetIndex(populateList(500_000));
    }

    public static LinkedList<Integer> populateList(int n) {
        int elementNumber = n;

        LinkedList<Integer> list = new LinkedList<>();

        while (list.size() < elementNumber) {
            int i = (int)(Math.random() * 1001);

            list.add(i);
        }
        
        System.out.println("List length: " + list.size());

        return list;
    }

    public static void calculateTimeToIterate(LinkedList<Integer> list) {
        long startTime = System.nanoTime();

        for (Iterator<Integer> myIterator = list.iterator(); myIterator.hasNext();) {
            myIterator.next();
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedMillisecondTime = (double) elapsedTime / 1_000_000.0;

        System.out.println("Time to iterate with Iterator: " + elapsedMillisecondTime + " milliseconds");
    }

    public static void calculateTimeToGetIndex(LinkedList<Integer> list) {
        long startTime = System.nanoTime();

        // Add get(index)
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedMillisecondTime = (double) elapsedTime / 1_000_000.0;

        System.out.println("Time to iterate with get(index): " + elapsedMillisecondTime + " milliseconds");
    }
}