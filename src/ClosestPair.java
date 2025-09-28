import java.util.*;

public class ClosestPair {
    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closestPair(Point[] pts) {
        Arrays.sort(pts, Comparator.comparingDouble(p -> p.x));
        return closestRec(pts, 0, pts.length);
    }

    private static double closestRec(Point[] pts, int l, int r) {
        int n = r - l;
        if (n <= 3) return brute(pts, l, r);
        int mid = l + n / 2;
        double midx = pts[mid].x;
        double d = Math.min(closestRec(pts, l, mid), closestRec(pts, mid, r));

        List<Point> strip = new ArrayList<>();
        for (int i = l; i < r; i++)
            if (Math.abs(pts[i].x - midx) < d) strip.add(pts[i]);
        strip.sort(Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < strip.size(); i++)
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < d; j++)
                d = Math.min(d, dist(strip.get(i), strip.get(j)));

        return d;
    }

    private static double brute(Point[] pts, int l, int r) {
        double d = Double.POSITIVE_INFINITY;
        for (int i = l; i < r; i++)
            for (int j = i + 1; j < r; j++)
                d = Math.min(d, dist(pts[i], pts[j]));
        return d;
    }

    private static double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}