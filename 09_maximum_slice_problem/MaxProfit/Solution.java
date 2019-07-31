class Solution {
    public int solution(int[] A) {
        if (A.length == 0 || A.length == 1) return 0;

        int[] diffs = diffs(A);
        return maximumSlice(diffs);
    }

    private int[] diffs(int[] A) {
        int[] diffs = new int[A.length - 1];
        for (int i = 1; i < A.length; ++i) {
            diffs[i - 1] = A[i] - A[i - 1];
        }

        return diffs;
    }

    private int maximumSlice(int[] integers) {
        int maxSum = 0;

        int sum = 0;
        for (int integer : integers) {
            sum = Math.max(0, sum + integer);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
