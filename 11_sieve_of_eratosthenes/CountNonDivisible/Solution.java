class Solution {
    public int[] solution(int[] A) {
        return nonDivisibleCounts(A);
    }

    private int[] nonDivisibleCounts(int[] integers) {
        int[] counts = new int[2 * integers.length + 1];
        for (int integer : integers) counts[integer]++;

        int[] nonDivisibleCounts = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            int divisorCount = divisorCount(integers[i], counts);
            nonDivisibleCounts[i] = integers.length - divisorCount;
        }

        return nonDivisibleCounts;
    }

    private int divisorCount(int integer, int[] counts) {
        int count = 0;

        int i = 1;
        while (i * i < integer) {
            if (integer % i == 0) count += counts[i] + counts[integer / i];
            i++;
        }
        if (i * i == integer) count += counts[i];

        return count;
    }
}
