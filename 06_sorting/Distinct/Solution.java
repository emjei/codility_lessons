import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        return distinctValues(A);
    }

    private int distinctValues(int[] integers) {
        Arrays.sort(integers);

        int distinctValues = 0;
        Integer previousValue = null;
        for (int integer : integers) {
            if (previousValue == null || integer != previousValue) {
                previousValue = integer;
                distinctValues++;
            }
        }

        return distinctValues;
    }
}
