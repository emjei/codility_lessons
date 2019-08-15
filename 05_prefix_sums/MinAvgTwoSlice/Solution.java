class Solution {
    public int solution(int[] A) {
        return minimalSliceStart(A);
    }

    private int minimalSliceStart(int[] integers) {
        int[] sums = new int[integers.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + integers[i - 1];
        }

        int start = 0;
        double minimalAverage = ((double) integers[0] + integers[1]) / 2;

        /* There is no need to search for a minimal average withing more 3 consecutive elements.
         * This is because if you have 4 elements then you will have an average of averages (of
         * two element averages). Also, if the minimum average is within 3 consecutive elements
         * (which can happen only if you have the first element smaller than average, the second -
         * larger than average and the third - smaller than average), you won't have the minimum
         * within 4 consecutive elements (because the minimum will probably be between the third
         * and fourth element). */
        for (int i = 2; i <= 3; i++) {
            for (int j = 0; j <= integers.length - i; j++) {
                double average = ((double) sums[j + i] - sums[j]) / i;
                if (average < minimalAverage) {
                    minimalAverage = average;
                    start = j;
                }
            }
        }

        return start;
    }
}
