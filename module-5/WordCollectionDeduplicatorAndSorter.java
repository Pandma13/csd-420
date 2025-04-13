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

    }

    public static HashSet<String> wordCollectionDeduplicator() {
        HashSet<String> wordHashSet = new HashSet<>();

        try {
            File myCollection = new File("collection_of_words.txt");
            try (Scanner myScanner = new Scanner(myCollection)) {
                while (myScanner.hasNextLine()) {
                    wordHashSet.add(myScanner.nextLine());
                    return wordHashSet;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.");
        }
        return wordHashSet;        
    }

    public static TreeSet<String> wordCollectionSorter() {

        TreeSet<String> wordTreeSet = new TreeSet<>();
        wordTreeSet.addAll(wordHashSet);
        
        return null;
        
    }
}
