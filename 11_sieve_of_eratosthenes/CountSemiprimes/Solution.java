class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        return countSemiprimes(N, P, Q);
    }

    private int[] countSemiprimes(int n, int[] starts, int[] ends) {
        int[] counts = new int[starts.length];

        int[] sieve = generateFactorizationSieve(n);
        int[] prefixCounts = generateSemiprimePrefixCounts(sieve, n);
        for (int i = 0; i < starts.length; i++) {
            counts[i] = prefixCounts[ends[i]] - prefixCounts[starts[i] - 1];
        }

        return counts;
    }

    private int[] generateSemiprimePrefixCounts(int[] factorizationSieve, int n) {
        int[] counts = new int[n + 1];

        int count = 0;
        for (int i = 4; i <= n; ++i) {
            if (isSemiprime(factorizationSieve, i)) count++;
            counts[i] = count;
        }

        return counts;
    }

    private boolean isSemiprime(int[] factorizationSieve, int x) {
        int factor = factorizationSieve[x];
        return factor != 0 && factorizationSieve[x / factor] == 0;
    }

    private int[] generateFactorizationSieve(int n) {
        int[] sieve = new int[n + 1];

        for (int i = 2; i * i <= n; i++) {
            if (sieve[i] != 0) continue;

            for (int k = i * i; k <= n; k += i) {
                if (sieve[k] == 0) sieve[k] = i;
            }
        }

        return sieve;
    }
}
