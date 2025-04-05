// Megan Wheeler
// Assignment 3
// 5 April 2025

// 1. Fill an ArrayList with 50 random values from 1 to 20.
// 2. Return a new ArrayList that contains all original values and no duplicates
//     from the original ArrayList.
// 3. Use public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
import java.util.ArrayList;

public class IntArrayListDeduplicator {
    public static void main(String[] args) {
        // call method to remove duplicates using random int array method
        System.out.println(removeDuplicates(randomIntArrayList()).toString());
    }

    // build and populate ArrayList with 50 random int elements from 1-20
    public static ArrayList<Integer> randomIntArrayList(){
        // generate random int from 1-20
        int randomInt = (int)(Math.random() * 21);

        // declare an int ArrayList with 50 elements
        ArrayList<Integer> randomIntArray = new ArrayList<>(50);

        // populate ArrayList with random int elements
        for (Integer i : randomIntArray) {
            i = randomInt;
            randomIntArray.add(i);
        }

        System.out.println(randomIntArray);

        // return populated ArrayList
        return randomIntArray;
    }

    // pass random ArrayList to remove duplicates and return updated ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        for (E i : list) {
            if (list.contains(i));
            else {
                list.add(i);
            }
        }
        
        System.out.println(list);
        // return deduplicated ArrayList
        return list;
    }
}