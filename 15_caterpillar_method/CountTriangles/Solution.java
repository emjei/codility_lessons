import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        return triangleCount(A);
    }

    private int triangleCount(int[] lengths) {
        Arrays.sort(lengths);

        int count = 0;
        for (int i = 0; i < lengths.length; i++) {
            int z = i + 2;

            for (int j = i + 1; j < lengths.length - 1; j++) {
                z = Math.max(z, j + 1);
                while (z < lengths.length && lengths[i] + lengths[j] > lengths[z]) z++;
                count += z - j - 1;
            }
        }

        return count;
    }
}
