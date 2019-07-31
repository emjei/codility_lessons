class Solution {
    public int solution(int[] A) {
        return maxSliceSum(A);
    }

    private int maxSliceSum(int[] integers) {
        int maxSum = integers[0];

        int sum = 0;
        for (int integer : integers) {
            int candidateSum = sum + integer;

            sum = Math.max(0, candidateSum);
            maxSum = Math.max(maxSum, candidateSum);
        }

        return maxSum;
    }
}
