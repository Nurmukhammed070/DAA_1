public class Metrics {
    private int compares = 0;
    private int swaps = 0;
    private int allocs = 0;
    private int depth = 0;
    private int maxDepth = 0;
    private long startTime, endTime;

    public void start() { startTime = System.nanoTime(); }
    public void stop() { endTime = System.nanoTime(); }
    public double getTimeMs() { return (endTime - startTime) / 1_000_000.0; }

    public void countCompare() { compares++; }
    public void countSwap() { swaps++; }
    public void countAlloc() { allocs++; }

    public void enter() { depth++; if (depth > maxDepth) maxDepth = depth; }
    public void exit() { depth--; }
    public int getMaxDepth() { return maxDepth; }

    public void print() {
        System.out.println("Time: " + getTimeMs() + " ms");
        System.out.println("Compares: " + compares);
        System.out.println("Swaps: " + swaps);
        System.out.println("Allocs: " + allocs);
        System.out.println("Max depth: " + maxDepth);
    }
}