/* This solution works faster (except for tests with random values) but it
 * does not seem like an optimal one (gcd value is basically not used) */
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

        int i = 2;
        int resultA = a;
        int resultB = b;
        while ((long) i * i <= resultA || (long) i * i <= resultB) {
            if (resultA % i == 0) {
                if (resultB % i != 0) return false;
                while (resultA % i == 0) resultA /= i;
                while (resultB % i == 0) resultB /= i;
            }

            i++;
        }

        return resultA == resultB;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
