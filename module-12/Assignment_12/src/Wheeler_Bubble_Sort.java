// Megan Wheeler
// Assignment 12
// 18 May 2025

import java.util.Arrays;
import java.util.Comparator;

public class Wheeler_Bubble_Sort {
    
    public static void main(String[] args) {
        // create a populated Integer list
        Integer[] intList = {15, 6, 4, 10, 7, 2, 9, 3};
        // call bubble sort with list
        bubbleSort(intList);

        System.out.println("Comparable sorted Integer list: " + Arrays.toString(intList));

        System.out.println();
        // create comparator
        Comparator<Integer> bubbleComparator = Integer::compareTo;
        // call bubble sort with list and comparator
        bubbleSort(intList, bubbleComparator);

        System.out.println("Comparator sorted Integer list: " + Arrays.toString(intList));

    }

    // Bubble sort method using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        // declare variables for list length and list changed
        int n = list.length;
        boolean listChanged;

        // loop through list
        for (int i = 0; i < n - 1; i++) {
            // declare value for list changed
            listChanged = false;
            // loop through list and compare elements
            for (int j = 0; j < n - i - 1; j++){
                // compare using compareTo on list
                if (list[j].compareTo(list[j + 1]) > 0) {
                    // change elements
                    E tempElement = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tempElement;
                    listChanged = true;
                }
            }
            // break loop if no changes were made in inner loop
            if (!listChanged) {
                break;
            }
        }
    }

    // Bubble sort method using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        // declare variables for list length and list changed
        int n = list.length;
        boolean listChanged;
        // loop through list
        for (int i = 0; i < n - 1; i ++) {
            // declare value for list changed
            listChanged = false;
            // loop through list and compare elements
            for (int j = 0; j < n - i - 1; j++) {
                // compare using comparator.compare
                if (comparator.compare(list[j], list[j + 1]) < 0) {
                    // change elements
                    E tempElement = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tempElement;
                    listChanged = true;
                }
            }
            // break loop if no changes were made in inner loop
            if (!listChanged) {
                break;
            }
        }
    }
}