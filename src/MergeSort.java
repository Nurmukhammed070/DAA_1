public class MergeSort {
    public static void sort(int[] a, Metrics m) {
        if (a == null || a.length < 2) return;
        int[] buf = new int[a.length];
        m.start();
        sortRec(a, buf, 0, a.length, m);
        m.stop();
    }

    private static void sortRec(int[] a, int[] buf, int l, int r, Metrics m) {
        m.enter();
        int n = r - l;
        if (n <= 16) { insertionSort(a, l, r, m); m.exit(); return; }
        int mid = (l + r) >>> 1;
        sortRec(a, buf, l, mid, m);
        sortRec(a, buf, mid, r, m);
        int i = l, j = mid, k = l;
        while (i < mid || j < r) {
            if (i < mid && (j == r || a[i] <= a[j])) { buf[k++] = a[i++]; m.countAlloc(); }
            else { buf[k++] = a[j++]; m.countAlloc(); }
            m.countCompare();
        }
        for (int p = l; p < r; p++) { a[p] = buf[p]; m.countAlloc(); }
        m.exit();
    }

    private static void insertionSort(int[] a, int l, int r, Metrics m) {
        for (int i = l + 1; i < r; i++) {
            int v = a[i]; int j = i;
            while (j > l && a[j - 1] > v) {
                m.countCompare();
                a[j] = a[j - 1]; j--; m.countSwap();
            }
            a[j] = v; m.countAlloc();
        }
    }
}