class Solution {
    public int solution(int A, int B, int K) {
        return divisableNumbers(A, B, K);
    }

    private int divisableNumbers(int a, int b, int divisor) {
        int min = divisor * (a / divisor) + (a % divisor == 0 ? 0 : divisor);
        int max = divisor * (b / divisor);
        return max / divisor - min / divisor + 1;
    }
}
