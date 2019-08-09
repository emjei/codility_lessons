class Solution {
    public int solution(int K, int M, int[] A) {
        return minimalLargeSum(K, M, A);
    }

    private int minimalLargeSum(int blocks, int maxValue, int[] integers) {
        int beg = 0;
        int end = maxValue * integers.length;
        int result = 0;

        while (beg <= end) {
            int mid = (beg + end) / 2;

            if (largestSum(blocks, integers, mid) <= mid) {
                end = mid - 1;
                result = mid;
            } else {
                beg = mid + 1;
            }
        }

        return result;
    }

    private int largestSum(int blocks, int[] integers, int maxBlockSum) {
        int largestBlockSum = 0;
        int j = 0;

        for (int i = 0; i < blocks - 1; ++i) {
            int blockSum = 0;
            while (j < integers.length && blockSum + integers[j] <= maxBlockSum) {
                blockSum += integers[j];
                j++;
            }

            largestBlockSum = Math.max(blockSum, largestBlockSum);
        }

        if (j < integers.length) {
            int remainingSum = 0;
            for (; j < integers.length; j++) remainingSum += integers[j];
            largestBlockSum = Math.max(remainingSum, largestBlockSum);
        }

        return largestBlockSum;
    }
}
