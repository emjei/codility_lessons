import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        return minAbsSumOfTwo(A);
    }

    private int minAbsSumOfTwo(int[] integers) {
        Arrays.sort(integers);

        int minSum = Math.abs(2 * integers[0]);
        int back = 0;
        int front = integers.length - 1;
        for (; back < integers.length && integers[back] < 0; back++) {
            int currentMinSum = Math.abs(integers[front] + integers[back]);
            for (; front > back; front--) {
                int laterSum = Math.abs(integers[front - 1] + integers[back]);
                if (currentMinSum <= laterSum) {
                    minSum = Math.min(minSum, currentMinSum);
                    break;
                }

                currentMinSum = laterSum;
            }

            if (back == front) {
                minSum = Math.min(minSum, currentMinSum);
                break;
            }
        }

        if (back < integers.length && integers[back] >= 0) {
            minSum = Math.min(minSum, 2 * integers[back]);
        }

        return minSum;
    }
}
