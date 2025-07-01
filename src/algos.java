package src;

// A utility class to hold common algorithm methods
class AlgorithmUtils {

    // ============================
    // Sorting Algorithms
    // ============================

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

    // ============================
    // Searching Algorithms
    // ============================

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

    // ============================
    // Number Theory Algorithms
    // ============================

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

    // ============================
    // String Algorithms
    // ============================

    // Reverse a String
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Check if string is palindrome
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }

    // ============================
    // Utility Methods
    // ============================

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

    // ============================
    // Graph Algorithms
    // ============================

    // BFS for unweighted graphs (adjacency list)
    public static void bfs(int start, java.util.List<java.util.List<Integer>> adj, boolean[] visited) {
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // DFS for unweighted graphs (adjacency list)
    public static void dfs(int node, java.util.List<java.util.List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    // ============================
    // Number Theory Algorithms (cont.)
    // ============================

    // GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Count set bits in integer (Brian Kernighan's algorithm)
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    // Check if a number is power of two
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // XOR of all elements in array
    public static int xorAll(int[] arr) {
        int xor = 0;
        for (int val : arr) xor ^= val;
        return xor;
    }

    // ============================
    // String Algorithms (cont.)
    // ============================

    // Naive String Match
    public static int naiveStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) j++;
            if (j == m) return i;
        }
        return -1;
    }

    // KMP String Search
    public static int kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            }
            if (j == m) return i - j;
            else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    private static int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0, i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else { lps[i] = 0; i++; }
            }
        }
        return lps;
    }

    // ============================
    // Tree Algorithms
    // ============================

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // Inorder Traversal
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // ============================
    // Disjoint Set (Union-Find)
    // ============================

    static class DisjointSet {
        int[] parent, rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) return;
            if (rank[xr] < rank[yr]) parent[xr] = yr;
            else if (rank[xr] > rank[yr]) parent[yr] = xr;
            else { parent[yr] = xr; rank[xr]++; }
        }
    }

    // ============================
    // Segment Tree (Range Sum, Point Update)
    // ============================

    static class SegmentTree {
        int[] tree;
        int n;
        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[2 * n];
            build(arr);
        }
        private void build(int[] arr) {
            System.arraycopy(arr, 0, tree, n, n);
            for (int i = n - 1; i > 0; --i)
                tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
        // Range sum query [l, r)
        public int query(int l, int r) {
            int res = 0;
            l += n; r += n;
            while (l < r) {
                if ((l & 1) == 1) res += tree[l++];
                if ((r & 1) == 1) res += tree[--r];
                l >>= 1; r >>= 1;
            }
            return res;
        }
        // Point update: set arr[pos] = value
        public void update(int pos, int value) {
            pos += n;
            tree[pos] = value;
            for (pos >>= 1; pos > 0; pos >>= 1)
                tree[pos] = tree[2 * pos] + tree[2 * pos + 1];
        }
    }
}
