// Megan Wheeler
// Assignment 5

// Follow the directions below:

// 1. Write a test program that reads words from a text file and displays
//    all non-duplicate words in ascending order and then in descending
//    order.
// 2. The file is to be referenced in the program, not needing to be used
//    as a command line reference.
// 3. The word file is to be titled collection_of_words.txt and included
//    in your submission.
// 4. Write test code that ensures the code functions correctly.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCollectionDeduplicatorAndSorter {
    
    public static void main(String[] args) {
        // initialize HashSet to store and call deduplicator method
        HashSet<String> deduplicatedSet = wordCollectionDeduplicator();
        // initialize TreeSet to store and call sorter method and with deduplicator method
        TreeSet<String> sortedSet = wordCollectionSorter(deduplicatedSet);

        // print results to user
        System.out.println("---- Ascending Order Collection of Words ----");
        System.out.println(sortedSet.toString());
        System.out.println();
        System.out.println("---- Descending Order Collection of Words ----");
        System.out.println(sortedSet.descendingSet().toString());
    }

    // method to read text file and add words to a set, returns a HashSet
    public static HashSet<String> wordCollectionDeduplicator() {
        // initialize HashSet object
        HashSet<String> wordHashSet = new HashSet<>();

        // try-catch for locating text file
        try {
            // initialize variable for text file
            File myCollection = new File("collection_of_words.txt");
            // initialize scanner object to read text file
            try (Scanner myScanner = new Scanner(myCollection)) {
                // loop through text file
                while (myScanner.hasNextLine()) {
                    // use scanner object to add words to hashset
                    wordHashSet.add(myScanner.nextLine());
                }
                return wordHashSet;
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.");
        }

        return wordHashSet;        
    }

    // method to create sorted set from the deduplicated set
    public static TreeSet<String> wordCollectionSorter(HashSet<String> i) {
        // initialize TreeSet object
        TreeSet<String> wordTreeSet = new TreeSet<>();

        // try-catch for adding HashSet elements to TreeSet
        try {
            wordTreeSet.addAll(i);
        } catch (ClassCastException e) {
            System.out.println("The class could not be cast.");
        }

        return wordTreeSet;
        
    }
}
