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
        
    }

    // build and populate ArrayList with 50 random int elements from 1-20
    public static void randomIntArrayList(){
        // generate random int from 1-20
        int randomInt = (int)(Math.random() * 21);

        // declare an int ArrayList with 50 elements
        ArrayList<Integer> randomIntArray = new ArrayList<>(50);

        // populate ArrayList with random int elements
        for (int i = 0; i < randomIntArray.size(); i++) {
            randomIntArray.add(randomInt);
        }
    }

    // pass random ArrayList to remove duplicates and return updated ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        return list;
    }
}