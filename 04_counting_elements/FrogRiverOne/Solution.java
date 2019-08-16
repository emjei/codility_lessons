class Solution {
    public int solution(int X, int[] A) {
        return minimumNumberOfSeconds(X, A);
    }

    private int minimumNumberOfSeconds(int lastLeavePosition, int[] leavePositions) {
        int distinctLeaveCount = 0;
        int[] leaveCounts = new int[lastLeavePosition];
        for (int i = 0; i < leavePositions.length; i++) {
            int position = leavePositions[i];
            if (leaveCounts[position - 1] == 0) distinctLeaveCount++;
            if (distinctLeaveCount == lastLeavePosition) return i;
            leaveCounts[position - 1]++;
        }

        return -1;
    }
}
