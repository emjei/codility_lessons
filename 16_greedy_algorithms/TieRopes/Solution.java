class Solution {
    public int solution(int K, int[] A) {
        return maximalNumberOfRopes(K, A);
    }

    private int maximalNumberOfRopes(int targetLength, int[] lengths) {
        int count = 0;
        int currentLength = 0;
        for (int length : lengths) {
            if (length >= targetLength || currentLength + length >= targetLength) {
                count += 1;
                currentLength = 0;
            } else {
                currentLength += length;
            }
        }

        return count;
    }
}
