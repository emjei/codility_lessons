import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] A) {
        return maximumNumberOfFlags(A);
    }

    private int maximumNumberOfFlags(int[] heights) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 0; i < heights.length; ++i) {
            if (isPeak(heights, i)) peaks.add(i);
        }

        for (int i = peaks.size(); i >= 1; i--) {
            if (canBeDistributed(peaks, i)) return i;
        }

        return 0;
    }

    private boolean isPeak(int[] heights, int i) {
        if (i == 0 || i == heights.length - 1) return false;
        return heights[i] > heights[i-1] && heights[i] > heights[i+1];
    }


    /* Do not use "lastPeak - lastFlaggedPeak < flagCount * remainingFlagCount"
     * since "flagCount * remainingFlagCount" might result in an integer overflow
     * ant the condition will be false instead of true. One could use
     * "(long) flagCount * remainingFlagCount" and everything will work fine but
     * this expression would be even longer than the one with division. */
    private boolean canBeDistributed(List<Integer> peaks, int flagCount) {
        int lastPeak = peaks.get(peaks.size() - 1);

        int lastFlaggedPeak = -1;
        int remainingFlagCount = flagCount;

        for (int i = 0; i < peaks.size(); ++i) {
            int peak = peaks.get(i);

            if (lastFlaggedPeak == -1 || peak - lastFlaggedPeak >= flagCount) {
                lastFlaggedPeak = peak;
                remainingFlagCount--;

                if (remainingFlagCount == 0) break;
                if ((lastPeak - lastFlaggedPeak) / remainingFlagCount < flagCount) return false;
            } else if (remainingFlagCount == peaks.size() - i) {
                return false;
            }
        }

        return true;
    }
}
