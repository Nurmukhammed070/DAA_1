import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int n = 20;
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = rnd.nextInt(100);

        System.out.println("Original array:");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println();

        // MergeSort
        int[] arr2 = arr1.clone();
        Metrics m1 = new Metrics();
        MergeSort.sort(arr2, m1);
        System.out.println("MergeSort result:");
        for (int x : arr2) System.out.print(x + " ");
        System.out.println();
        m1.print();

        // QuickSort
        int[] arr3 = arr1.clone();
        Metrics m2 = new Metrics();
        QuickSort.sort(arr3, m2);
        System.out.println("QuickSort result:");
        for (int x : arr3) System.out.print(x + " ");
        System.out.println();
        m2.print();

        // DeterministicSelect
        int k = 5;
        int kth = DeterministicSelect.select(arr1.clone(), k);
        System.out.println(k + "-th smallest element: " + kth);

        // Closest Pair
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(5, 4),
                new ClosestPair.Point(3, 1),
                new ClosestPair.Point(1, 1)
        };
        double d = ClosestPair.closestPair(pts);
        System.out.println("Closest pair distance: " + d);
    }
}