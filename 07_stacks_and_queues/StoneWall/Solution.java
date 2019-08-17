import java.util.Stack;

class Solution {
    public int solution(int[] H) {
        return minimumNumberOfBlocks(H);
    }

    private int minimumNumberOfBlocks(int[] heights) {
        Stack<Integer> helperStack = new Stack<>();

        int count = 0;
        for (int height : heights) {
            while (!helperStack.isEmpty() && helperStack.peek() > height) {
                helperStack.pop();
            }

            if (helperStack.isEmpty() || helperStack.peek() < height) {
                count++;
                helperStack.push(height);
            }
        }

        return count;
    }
}
