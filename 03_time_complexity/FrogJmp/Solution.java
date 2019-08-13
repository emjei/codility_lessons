class Solution {
    public int solution(int X, int Y, int D) {
        return minimalNumberOfJumps(X, Y, D);
    }

    private int minimalNumberOfJumps(int start, int end, int d) {
        int distance = end - start;
        int minLeapDistance = d * (distance / d) + (distance % d == 0 ? 0 : d);
        return minLeapDistance / d;
    }
}
