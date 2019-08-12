import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] A) {
        return maximumPossibleSum(A);
    }

    private int maximumPossibleSum(int[] squareNumbers) {
        Queue<Integer> maxSumQueue = new LinkedList<>();
        for (int i = squareNumbers.length - 1; i > 0; i--) {
            int max = maxSumQueue.isEmpty() ? 0 : maxQueueElement(maxSumQueue);

            maxSumQueue.add(squareNumbers[i] + max);
            if (maxSumQueue.size() > 6) {
                maxSumQueue.remove();
            }
        }

        return squareNumbers[0] + maxQueueElement(maxSumQueue);
    }

    private int maxQueueElement(Queue<Integer> queue) {
        int max = queue.element();
        for (Integer element : queue) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }
}
