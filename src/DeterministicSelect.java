import java.util.Arrays;

public class DeterministicSelect {
    public static int select(int[] a, int k) {
        if (k < 0 || k >= a.length) throw new IllegalArgumentException();
        return selectRec(a, 0, a.length - 1, k);
    }

    private static int selectRec(int[] a, int l, int r, int k) {
        if (l == r) return a[l];
        int pivot = medianOfMedians(a, l, r);
        int pivotIndex = partition(a, l, r, pivot);
        if (k == pivotIndex) return a[k];
        else if (k < pivotIndex) return selectRec(a, l, pivotIndex - 1, k);
        else return selectRec(a, pivotIndex + 1, r, k);
    }

    private static int partition(int[] a, int l, int r, int pivot) {
        while (l <= r) {
            while (a[l] < pivot) l++;
            while (a[r] > pivot) r--;
            if (l <= r) {
                int t = a[l]; a[l] = a[r]; a[r] = t; l++; r--;
            }
        }
        return l - 1;
    }

    private static int medianOfMedians(int[] a, int l, int r) {
        int n = r - l + 1;
        if (n < 5) {
            int[] tmp = Arrays.copyOfRange(a, l, r + 1);
            Arrays.sort(tmp);
            return tmp[n / 2];
        }
        int groups = (n + 4) / 5;
        int[] medians = new int[groups];
        for (int i = 0; i < groups; i++) {
            int start = l + i * 5;
            int end = Math.min(start + 4, r);
            int[] tmp = Arrays.copyOfRange(a, start, end + 1);
            Arrays.sort(tmp);
            medians[i] = tmp[tmp.length / 2];
        }
        return medianOfMedians(medians, 0, medians.length - 1);
    }
}