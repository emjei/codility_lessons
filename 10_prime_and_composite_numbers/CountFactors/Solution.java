class Solution {
    public int solution(int N) {
        return countFactors(N);
    }

    private int countFactors(int n) {
        int factors = 0;
        int i = 1;

        int nSqrtFloor = (int) Math.floor(Math.sqrt(n));
        while (i < nSqrtFloor) {
            if (n % i == 0) factors += 2;
            i++;
        }

        if (i * i == n) {
            factors++;
        } else if (n % i == 0) {
            factors += 2;
        }

        return factors;
    }
}
