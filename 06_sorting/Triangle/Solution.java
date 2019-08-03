import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        return triangleExists(A);
    }

    private int triangleExists(int[] integers) {
        Arrays.sort(integers);

        for (int i = 0; i < integers.length - 2; ++i) {
            if ((long) integers[i] + integers[i+1] > integers[i+2]) return 1;
        }

        return 0;
    }
}
