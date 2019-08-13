class Solution {
    public int[] solution(int[] A, int K) {
        return shiftRight(A, K);
    }

    private int[] shiftRight(int[] integers, int k) {
        int[] shifted = new int[integers.length];
        for (int i = 0; i < integers.length; ++i) {
            shifted[(i + k) % integers.length] = integers[i];
        }

        return shifted;
    }
}
