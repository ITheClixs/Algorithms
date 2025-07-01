import java.util.*;

// A utility class to hold common algorithm methods
class AlgorithmUtils {

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Insertion Sort implementation
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    // Selection Sort implementation
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);  // Partition index
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot to correct position
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    // Merge Sort implementation
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l+i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m+1+j];

        // Merge the temp arrays back
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Linear Search implementation
    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    // Binary Search implementation (Array must be sorted)
    public static int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == x) return m;
            if (arr[m] < x) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    // Factorial using recursion
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

    // Fibonacci using recursion
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // Reverse a String
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Check if string is palindrome
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }

    // Swap two numbers
    public static void swapNums(int a, int b) {
        System.out.println("Before: a=" + a + ", b=" + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After: a=" + a + ", b=" + b);
    }

    // Print an array
    public static void printArray(int[] arr) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }
}

// Main class to test algorithms
public class AlgoPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Test Sorting algorithms
        int[] numbers = {5, 3, 8, 6, 2, 7, 4, 1};
        System.out.print("Original Array: ");
        AlgorithmUtils.printArray(numbers);

        AlgorithmUtils.bubbleSort(numbers);
        System.out.print("Bubble Sorted: ");
        AlgorithmUtils.printArray(numbers);

        int[] nums2 = {9, 7, 5, 3, 1, 2, 4, 6, 8};
        AlgorithmUtils.insertionSort(nums2);
        System.out.print("Insertion Sorted: ");
        AlgorithmUtils.printArray(nums2);

        int[] nums3 = {4, 2, 9, 1, 5, 6};
        AlgorithmUtils.selectionSort(nums3);
        System.out.print("Selection Sorted: ");
        AlgorithmUtils.printArray(nums3);

        int[] nums4 = {11, 5, 7, 9, 3, 2};
        AlgorithmUtils.quickSort(nums4, 0, nums4.length-1);
        System.out.print("Quick Sorted: ");
        AlgorithmUtils.printArray(nums4);

        int[] nums5 = {10, 8, 6, 4, 2};
        AlgorithmUtils.mergeSort(nums5, 0, nums5.length-1);
        System.out.print("Merge Sorted: ");
        AlgorithmUtils.printArray(nums5);

        // Search algorithms
        int searchVal = 7;
        int pos = AlgorithmUtils.linearSearch(numbers, searchVal);
        System.out.println("Linear Search for 7: " + pos);

        int binPos = AlgorithmUtils.binarySearch(numbers, 7);
        System.out.println("Binary Search for 7: " + binPos);

        // Recursion algorithms
        System.out.println("Factorial of 5: " + AlgorithmUtils.factorial(5));
        System.out.println("Fibonacci of 7: " + AlgorithmUtils.fibonacci(7));

        // String manipulation
        String word = "level";
        System.out.println("Is 'level' a palindrome? " + AlgorithmUtils.isPalindrome(word));

        // Swap numbers
        AlgorithmUtils.swapNums(10, 20);

        sc.close();
    }
}
