import java.util.HashSet;
import java.util.Set;

/* This solution seems overly complex but seems like the optimal one. */
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
            for (int divisor : primeDivisors(minA)) if (gcd % divisor != 0) return false;
            for (int divisor : primeDivisors(minB)) if (gcd % divisor != 0) return false;

            return true;
        } else {
            int resultA = minA;
            int resultB = minB;
            for (int divisor : primeDivisors(gcd)) {
                while (resultA % divisor== 0) resultA /= divisor;
                while (resultB % divisor == 0) resultB /= divisor;
            }

            return resultA == 1 && resultB == 1;
        }
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    private Set<Integer> primeDivisors(int n) {
        Set<Integer> divisors = new HashSet<>();

        int i = 2;
        int result = n;
        while ((long) i * i <= result) {
            if (result % i == 0) divisors.add(i);
            while (result % i == 0) result /= i;

            i++;
        }
        if (result != 1) divisors.add(result);

        return divisors;
    }
}
