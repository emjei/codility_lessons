class Solution {
    public int solution(int[] A) {
        return absoluteDistinctCount(A);
    }

    private int absoluteDistinctCount(int[] integers) {
        int[] minimums = absMinimums(integers);
        int left = minimums[0];
        int right = minimums[1];
        int count = 1;

        while (left > 0 && right < integers.length - 1) {
            right++;

            int value = integers[right];
            count++;

            while (right < integers.length - 1 && value == integers[right + 1]) right++;

            while (left > 0 && Math.abs(integers[left - 1]) < value) {
                if (integers[left - 1] != integers[left]) count++;
                left--;
            }

            while (left > 0 && value == Math.abs(integers[left - 1])) left--;
        }

        for (int i = left - 1; i >= 0; i--) {
            if (integers[i] != integers[i + 1]) count++;
        }

        for (int i = right + 1; i < integers.length; i++) {
            if (integers[i - 1] != integers[i]) count++;
        }

        return count;
    }

    private int[] absMinimums(int[] integers) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < integers.length; i++) {
            int compare = Long.compare(
                    Math.abs((long) integers[i]),
                    Math.abs((long) integers[left])
            );

            if (compare == -1) {
                left = right = i;
            } else if (compare == 0) {
                right = i;
            }
        }

        return new int[] { left, right };
    }
}
