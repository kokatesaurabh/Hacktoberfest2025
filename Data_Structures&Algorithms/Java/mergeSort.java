/**
 * Merge Sort Implementation in Java
 * 
 * Overview:
 * Merge Sort is a classic Divide and Conquer sorting algorithm.
 * 
 * How It Works:
 * 1. Divide: Split the array into two halves until sub-arrays contain 1 element (or 0 elements).
 * 2. Conquer: Recursively sort each half.
 * 3. Combine (Merge): Merge the two sorted halves back into a single sorted array.
 * 
 * Complexity:
 * - Time Complexity:
 *   - Best Case: O(n log n)
 *   - Average Case: O(n log n)
 *   - Worst Case: O(n log n)
 * - Space Complexity: O(n) - requires auxiliary storage for temporary sub-arrays during merging.
 * - Stability: Stable (preserves relative order of equal elements).
 */

public class mergeSort {

    /**
     * Merges two sorted sub-arrays of arr[].
     * First sub-array is arr[l..m]
     * Second sub-array is arr[m+1..r]
     * 
     * @param arr The array containing sub-arrays to be merged
     * @param l   The starting index of the left sub-array
     * @param m   The middle index separating the two sub-arrays
     * @param r   The ending index of the right sub-array
     */
    private static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays left[] and right[]
        for (int i = 0; i < n1; ++i) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = arr[m + 1 + j];
        }

        // Initial indices of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = l;

        // Merge the temporary arrays back into arr[l..r]
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[] if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[] if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * Main function that sorts arr[l..r] using merge()
     * 
     * @param arr Array to be sorted
     * @param l   Starting index
     * @param r   Ending index
     */
    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point to divide the array into two halves
            // Using l + (r - l) / 2 avoids potential integer overflow compared to (l + r) / 2
            int m = l + (r - l) / 2;

            // Sort first and second halves recursively
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /**
     * Utility helper method to print an array of size n
     * 
     * @param arr Array to print
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Driver program to test the Merge Sort algorithm
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7, 3, 1, 15, 9 };

        System.out.println("Original Array:");
        printArray(arr);

        // Perform Merge Sort on the entire array
        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }
}
