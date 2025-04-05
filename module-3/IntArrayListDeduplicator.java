// Megan Wheeler
// Assignment 3
// 5 April 2025

// 1. Fill an ArrayList with 50 random values from 1 to 20.
// 2. Return a new ArrayList that contains all original values and no duplicates
//     from the original ArrayList.
// 3. Use public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
import java.util.*;

public class IntArrayListDeduplicator {
    public static void main(String[] args) {

        // call method to remove duplicates using random int array method
        IntArrayListDeduplicator.<Integer>removeDuplicates(randomIntArrayList());
    }

    // build and populate ArrayList with 50 random int elements from 1-20
    public static ArrayList<Integer> randomIntArrayList(){

        // declare an int ArrayList with 50 elements
        ArrayList<Integer> randomIntArray = new ArrayList<>();

        // populate ArrayList with random int elements
        while (randomIntArray.size() < 50) {
            // generate random int from 1-20
            int i = (int)(Math.random() * 21);

            randomIntArray.add(i);
        }

        System.out.println("Original list length: " + randomIntArray.size());
        System.out.println(randomIntArray.toString());

        // return populated ArrayList
        return randomIntArray;
    }

    // remove duplicates and return updated ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {        
        // add random list to LinkedHashSet to remove duplicates.
        list = new ArrayList<>(new LinkedHashSet<>(list));
        
        System.out.println();
        System.out.println("Deduplicated list length: " + list.size());
        System.out.println(list.toString());
        // return deduplicated ArrayList
        return list;
    }
}