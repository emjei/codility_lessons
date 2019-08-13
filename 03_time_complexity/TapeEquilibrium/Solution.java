class Solution {
    public int solution(int[] A) {
        return minimalDifference(A);
    }

    private int minimalDifference(int[] integers) {
        int sum = 0;
        for (int integer : integers) sum += integer;

        int firstPart = integers[0];
        int minimalDifference = Math.abs(sum - 2 * firstPart);

        for (int i = 2; i < integers.length; i++) {
            firstPart += integers[i - 1];
            minimalDifference = Math.min(minimalDifference, Math.abs(sum - 2 * firstPart));
        }

        return minimalDifference;
    }
}
