class Solution {
    public int solution(int[] A) {
        return maximumNumberOfBlocks(A);
    }

    private int maximumNumberOfBlocks(int[] heights) {
        int[] peakCounts = countPeaks(heights);

        for (int i = minBlockSize(heights); i <= heights.length; ++i) {
            if (heights.length % i != 0) continue;
            if (canBeDivided(heights, i, peakCounts)) return heights.length / i;
        }

        return 0;
    }

    private boolean canBeDivided(int[] heights, int blockSize, int[] peakCounts) {
        int peakCount = 0;
        for (int i = blockSize - 1; i < heights.length; i += blockSize) {
            if (peakCount == peakCounts[i]) return false;
            peakCount = peakCounts[i];
        }

        return true;
    }

    private int[] countPeaks(int[] heights) {
        int[] counts = new int[heights.length];

        int currentCount = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (isPeak(heights, i)) currentCount++;
            counts[i] = currentCount;
        }

        return counts;
    }

    private int minBlockSize(int[] heights) {
        int size = 0;
        int lastPeak = -1;

        for (int i = 0; i < heights.length; ++i) {
            if (!isPeak(heights, i)) continue;

            if (lastPeak == -1) {
                size = i + 1;
            } else if ((i - lastPeak + 2) / 2 > size) {
                size = (i - lastPeak + 2) / 2;
            }

            lastPeak = i;
        }

        if (heights.length - lastPeak > size) {
            size = heights.length - lastPeak;
        }

        return size;
    }

    private boolean isPeak(int[] heights, int i) {
        if (i == 0 || i == heights.length - 1) return false;
        return heights[i] > heights[i-1] && heights[i] > heights[i+1];
    }
}
