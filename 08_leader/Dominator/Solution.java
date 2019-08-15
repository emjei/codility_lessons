import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        return dominatorIndex(A);
    }

    private int dominatorIndex(int[] integers) {
        Integer dominator = dominator(integers);
        if (dominator == null) return -1;

        for (int i = 0; i < integers.length; i++) {
            if (integers[i] == dominator) return i;
        }

        return -1;
    }

    private Integer dominator(int[] integers) {
        if (integers.length == 0) return null;

        int[] sorted = new int[integers.length];
        System.arraycopy(integers, 0, sorted, 0, integers.length);
        Arrays.sort(sorted);

        int candidate = sorted[sorted.length / 2];
        int count = 0;
        for (int integer : sorted) if (integer == candidate) count++;

        return count > sorted.length / 2 ? candidate : null;
    }
}
