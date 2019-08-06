import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A, int[] B) {
        return samePrimeDivisorSets(A, B);
    }

    private int samePrimeDivisorSets(int[] a, int[] b) {
        int count = 0;

        for (int i = 0; i < a.length; ++i) {
            if (hasSameDivisorSets(a[i], b[i])) count++;
        }

        return count;
    }

    private boolean hasSameDivisorSets(int a, int b) {
        if (a == b) return true;

        int gcd = gcd(a, b);
        if (gcd == 1) return false;

        int minA = a / gcd;
        int minB = b / gcd;

        if (gcd > Math.max(minA, minB)) {
            int[] factorizationSieve = generateFactorizationSieve(Math.max(minA, minB));

            Set<Integer> aDivisors = primeDivisors(factorizationSieve, minA);
            for (Integer el : aDivisors) if (gcd % el != 0) return false;

            Set<Integer> bDivisors = primeDivisors(factorizationSieve, minB);
            for (Integer el : bDivisors) if (gcd % el != 0) return false;

            return true;
        } else {
            int[] factorizationSieve = generateFactorizationSieve(gcd);

            int resultA = minA;
            int resultB = minB;
            for (int divisor : primeDivisors(factorizationSieve, gcd)) {
                while (resultA % divisor == 0) resultA /= divisor;
                while (resultB % divisor == 0) resultB /= divisor;
            }

            return resultA == 1 && resultB == 1;
        }
    }

    private Set<Integer> primeDivisors(int[] factorizationSieve, int a) {
        Set<Integer> divisors = new HashSet<>();

        while (factorizationSieve[a] > 0) {
            divisors.add(factorizationSieve[a]);
            a /= factorizationSieve[a];
        }
        divisors.add(a);

        return divisors;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
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
