class Solution {
    public int solution(int N) {
        return longestGap(N);
    }

    private int longestGap(int n) {
        int longestGap = 0;
        int currentGap = 0;
        boolean started = false;
        while (n > 0) {
            if (n % 2 == 1) {
                started = true;

                if (currentGap > 0) {
                    longestGap = Math.max(currentGap, longestGap);
                    currentGap = 0;
                }
            } else if (started) {
                currentGap++;
            }

            n /= 2;
        }

        return longestGap;
    }
}
