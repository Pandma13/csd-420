// Megan Wheeler
// Assignment 6
// 17 April 2025

import java.util.Comparator;

public class Wheeler_Bubble_Sort {
    
    public static void main(String[] args) {
        // create a populated Integer list
        Integer[] intList = {15, 6, 4, 10, 7, 2, 9, 3};
        bubbleSort(intList);
        System.out.println("Sorted Integer list: ");
        for (int num : intList) {
            System.out.print(num + " ");
        }
        System.out.println();
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

            if (!listChanged) {
                break;
            }
        }
    }

    // Bubble sort method using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {

    }

}
