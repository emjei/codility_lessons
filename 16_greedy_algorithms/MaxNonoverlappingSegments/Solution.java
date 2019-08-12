class Solution {
    public int solution(int[] A, int[] B) {
        return maxNonOverlappingSegments(A, B);
    }

    private int maxNonOverlappingSegments(int[] starts, int[] ends) {
        if (starts.length == 0) return 0;

        int count = 1;
        int last = 0;
        for (int i = 1; i < starts.length; i++) {
            int start = starts[i];

            if (start > ends[last]) {
                last = i;
                count++;
            }
        }

        return count;
    }
}
