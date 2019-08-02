class Solution {
    public int solution(int[] A) {
        return minimumJumps(A);
    }

    private int minimumJumps(int[] leaves) {
        int finalPosition = leaves.length;
        int[] jumps = new int[finalPosition + 1];

        for (int i = 0; i < finalPosition; ++i) {
            jumps[i] = leaves[i] == 0 ? -1 : minimumJumps(jumps, i + 1);
        }

        jumps[finalPosition] = minimumJumps(jumps, finalPosition + 1);
        return jumps[finalPosition];
    }

    private int minimumJumps(int[] jumps, int currentDistance) {
        int minimum = -1;

        int prevPrevDistance = 0;
        int prevDistance = 1;
        int distance = prevPrevDistance + prevDistance;
        while (currentDistance - distance >= 0) {
            if (currentDistance - distance == 0) {
                minimum = 1;
                break;
            } else if (jumps[currentDistance - distance - 1] != -1) {
                int previousMinimum = jumps[currentDistance - distance - 1] + 1;
                minimum = minimum == -1 ? previousMinimum : Math.min(minimum, previousMinimum);
            }

            prevPrevDistance = prevDistance;
            prevDistance = distance;
            distance = prevPrevDistance + prevDistance;
        }

        return minimum;
    }
}
