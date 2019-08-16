class Solution {
    public int solution(int[] A) {
        return smallestPossibleInt(A);
    }

    private static final int MAX_VALUE = 1_000_000;

    private int smallestPossibleInt(int[] integers) {
        boolean[] presence = new boolean[MAX_VALUE];
        for (int integer : integers) {
            if (integer > 0) presence[integer - 1] = true;
        }

        int smallestPossibleInt = MAX_VALUE + 1;
        for (int i = 0; i < presence.length; ++i) {
            if (!presence[i]) {
                smallestPossibleInt = i + 1;
                break;
            }
        }

        return smallestPossibleInt;
    }
}
