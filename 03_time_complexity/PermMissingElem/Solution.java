class Solution {
    public int solution(int[] A) {
        return missingElement(A);
    }

    private int missingElement(int[] integers) {
        int[] presence = new int[integers.length + 1];
        for (int integer : integers) presence[integer - 1] = 1;
        for (int i = 0; i < presence.length; i++) {
            if (presence[i] == 0) return i + 1;
        }

        throw new IllegalArgumentException();
    }
}
