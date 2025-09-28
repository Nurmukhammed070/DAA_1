Report
Abdikarim Nurmukhammed, SE-2430

1. Implemented Algorithms
1. MergeSort – classic divide-and-conquer with:
   - Linear merge
   - Reusable buffer
   - Insertion sort for small subarrays (n ≤ 16)
2. **QuickSort** – randomized pivot, recursion on smaller partition to keep stack O(log n)
3. **Deterministic Select** – Median-of-Medians algorithm, O(n)
4. **Closest Pair of Points (2D)** – O(n log n) using strip check and neighbor scan


2. Metrics Collected
- Time (ms)
- Comparisons
- Swaps
- Allocations
- Max recursion depth


3. Sample Results
For an array of 20 random numbers:
Original: 30 77 27 4 13 71 68 24 67 40 8 46 66 60 56 3 45 23 87 34
MergeSort: 3 4 8 13 23 24 27 30 34 40 45 46 56 60 66 67 68 71 77 87
Time: 0.022 ms | Compares: 66 | Swaps: 46 | Allocs: 58 | Depth: 2

QuickSort:
Time: 0.014 ms | Compares: 61 | Swaps: 22 | Allocs: 0 | Depth: 3

5-th smallest element: 23
Closest pair distance: 1.41


4. Recurrence Analysis
- MergeSort: T(n) = 2T(n/2) + O(n) → Θ(n log n)
- QuickSort: Expected T(n) ≈ 2T(n/2) + O(n) → Θ(n log n), worst case Θ(n²)
- Deterministic Select: T(n) = T(n/5) + T(7n/10) + O(n) → Θ(n)
- Closest Pair: T(n) = 2T(n/2) + O(n) → Θ(n log n)


5. Observations
- Insertion sort improves performance on small subarrays.
- QuickSort was slightly faster on small inputs because it needs no extra buffer.
- MergeSort showed stable performance and predictable recursion depth ≈ log₂n.
- Measurements matched theoretical complexity for large inputs.


6. Project Structure
- `MergeSort.java`  
- `QuickSort.java`  
- `DeterministicSelect.java`  
- `ClosestPair.java`  
- `Metrics.java`  
- `Main.java`  
