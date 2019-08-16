class Solution {
    public int[] solution(int N, int[] A) {
        return counterValues(N, A);
    }

    private int[] counterValues(int n, int[] operations) {
        int maxValue = 0;
        int flushValue = 0;

        int[] counters = new int[n];
        for (int operation : operations) {
            if (operation == n + 1) {
                flushValue = maxValue;
            } else {
                int counterIndex = operation - 1;
                if (counters[counterIndex] < flushValue) {
                    counters[counterIndex] = flushValue;
                }

                counters[counterIndex]++;
                if (counters[counterIndex] > maxValue) {
                    maxValue = counters[counterIndex];
                }
            }
        }

        for (int i = 0; i < counters.length; ++i) {
            if (counters[i] < flushValue) counters[i] = flushValue;
        }

        return counters;
    }
}
