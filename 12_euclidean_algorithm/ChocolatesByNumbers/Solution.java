class Solution {
    public int solution(int N, int M) {
        return chocolateCount(N, M);
    }

    private int chocolateCount(int n, int m) {
        long mcd = (long) n * m / gcd(n, m);
        return (int) (mcd / m);
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
