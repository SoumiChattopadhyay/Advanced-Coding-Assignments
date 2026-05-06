import java.util.*;

public class Prog2_Array_Transformation_Cost_Minimization {
    public static long minOperations(int[] A, int K) {
        int n = A.length;

        // Step 1: Check feasibility
        int remainder = A[0] % K;
        for (int x : A) {
            if (x % K != remainder)
                return -1;
        }

        // Step 2: Normalize
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = (A[i] - remainder) / K;
        }

        // Step 3: Sort
        Arrays.sort(B);

        // Step 4: Median
        int median = B[n / 2];

        // Step 5: Calculate cost
        long operations = 0;
        for (int x : B) {
            operations += Math.abs(x - median);
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] A = { 2, 4, 6, 8, 10 };
        int K = 2;
        System.out.println(minOperations(A, K)); 
    }
}
