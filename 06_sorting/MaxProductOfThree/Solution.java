import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        return maxProductOfThree(A);
    }

    private int maxProductOfThree(int[] integers) {
        Arrays.sort(integers);

        int length = integers.length;
        int lastValue = integers[length-1];
        int maxLeft = integers[0] * integers[1] * lastValue;
        int maxRight = integers[length-3] * integers[length-2] * lastValue;

        return maxLeft > maxRight ? maxLeft : maxRight;
    }
}
