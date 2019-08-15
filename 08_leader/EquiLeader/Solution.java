import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        return equiLeaderCount(A);
    }

    private int equiLeaderCount(int[] integers) {
        int equiLeaderCount = 0;
        int leader = findLeader(integers);

        if (leader != -1) {
            int total = totalCount(integers, leader);
            int[] counts = leaderCounts(integers, leader);

            int n = integers.length;
            for (int i = 0; i < n - 1; ++i) {
                if (counts[i] > (i + 1) / 2 && (total - counts[i]) > (n - i - 1) / 2) {
                    equiLeaderCount++;
                }
            }
        }

        return equiLeaderCount;
    }

    private int findLeader(int[] integers) {
        int[] sorted = new int[integers.length];
        System.arraycopy(integers, 0, sorted, 0, integers.length);
        Arrays.sort(sorted);

        int candidate = sorted[sorted.length / 2];
        int count = 0;
        for (int el : sorted) if (el == candidate) count++;

        return (count > sorted.length / 2) ? candidate : -1;
    }

    private int totalCount(int[] integers, int leader) {
        int count = 0;
        for (int integer : integers) if (integer == leader) count++;

        return count;
    }

    private int[] leaderCounts(int[] integers, int leader) {
        int[] counts = new int[integers.length];

        int count = 0;
        for (int i = 0; i < integers.length; ++i) {
            if (integers[i] == leader) count++;
            counts[i] = count;
        }

        return counts;
    }
}
