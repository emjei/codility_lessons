import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        return maxDoubleSliceSum(A);
    }

    private int maxDoubleSliceSum(int[] values) {
        int[] valuesWithBorder = Arrays.copyOfRange(values, 1, values.length - 1);

        int maxSum = 0;
        int currentSum = 0;
        int sumBeforeSkip = 0;
        int skipValue = valuesWithBorder[0];
        for (int i = 1; i < valuesWithBorder.length; ++i) {
            int value = valuesWithBorder[i];

            int sumWithLastSkip = currentSum + value;
            int sumIfValueSkip = Math.max(0, sumBeforeSkip + skipValue) + currentSum - sumBeforeSkip;
            if (sumWithLastSkip <= 0 || sumIfValueSkip > sumWithLastSkip) {
                currentSum = sumIfValueSkip;
                sumBeforeSkip = currentSum;
                skipValue = value;
            } else {
                currentSum = sumWithLastSkip;
            }

            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
