// this solution is quite suboptimal
class Solution {
    public int solution(int[] A) {
        return maximumNumberOfBlocks(A);
    }

    private int maximumNumberOfBlocks(int[] heights) {
        for (int i = 2; i <= heights.length; ++i) {
            if (heights.length % i != 0) continue;
            if (canBeDivided(heights, i)) return heights.length / i;
        }

        return 0;
    }

    private boolean canBeDivided(int[] heights, int blockSize) {
        for (int i = 0; i < heights.length; i += blockSize) {
            if (!hasPeak(heights, i, i + blockSize)) return false;
        }

        return true;
    }

    private boolean hasPeak(int[] heights, int start, int end) {
        for (int i = start; i < end; ++i) if (isPeak(heights, i)) return true;
        return false;
    }

    private boolean isPeak(int[] heights, int i) {
        if (i == 0 || i == heights.length - 1) return false;
        return heights[i] > heights[i-1] && heights[i] > heights[i+1];
    }
}
