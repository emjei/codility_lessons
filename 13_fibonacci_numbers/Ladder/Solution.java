class Solution {

    private static final int MAX_MODULO = 30;
    private static final int MAX_MODULO_COUNT = 50_000;

    public int[] solution(int[] A, int[] B) {
        int[] powers = calculatePowersOfTwoUpTo(MAX_MODULO);
        int[][] moduloCounts = new int[MAX_MODULO_COUNT][];
        for (int i = 0; i < moduloCounts.length; ++i) {
            moduloCounts[i] = new int[MAX_MODULO + 1];
        }

        for (int i = 1; i < MAX_MODULO + 1; ++i) {
            moduloCounts[0][i] = 1 % powers[i];
            moduloCounts[1][i] = 2 % powers[i];
        }

        for (int i = 2; i < moduloCounts.length; ++i) {
            for (int j = 1; j < MAX_MODULO + 1; ++j) {
                moduloCounts[i][j] = (moduloCounts[i - 2][j] + moduloCounts[i - 1][j]) % powers[j];
            }
        }

        int[] results = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            results[i] = moduloCounts[A[i] - 1][B[i]];
        }

        return results;
    }

    private int[] calculatePowersOfTwoUpTo(int n) {
        int elementCount = n + 1;
        int[] powers = new int[elementCount];

        int power = 1;
        for (int i = 0; i < elementCount; ++i) {
            powers[i] = power;
            power *= 2;
        }

        return powers;
    }
}
