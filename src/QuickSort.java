import java.util.Random;

public class QuickSort {
    private static final Random rnd = new Random();

    public static void sort(int[] a, Metrics m) {
        if (a == null || a.length < 2) return;
        m.start();
        sortRec(a, 0, a.length - 1, m);
        m.stop();
    }

    private static void sortRec(int[] a, int l, int r, Metrics m) {
        m.enter();
        while (l < r) {
            int pivot = a[l + rnd.nextInt(r - l + 1)];
            int i = l, j = r;
            while (i <= j) {
                while (a[i] < pivot) { i++; m.countCompare(); }
                while (a[j] > pivot) { j--; m.countCompare(); }
                if (i <= j) {
                    int t = a[i]; a[i] = a[j]; a[j] = t;
                    i++; j--; m.countSwap();
                }
            }
            if (j - l < r - i) {
                if (l < j) sortRec(a, l, j, m);
                l = i;
            } else {
                if (i < r) sortRec(a, i, r, m);
                r = j;
            }
        }
        m.exit();
    }
}