class Solution {
    public int solution(int[] A) {
        return isPermutation(A);
    }

    private int isPermutation(int[] integers) {
        int n = integers.length;
        int[] counts = new int[n];
        for (int integer : integers) {
            if (integer > n || counts[integer - 1] > 0) return 0;
            counts[integer - 1]++;
        }

        for (int count : counts) if (count != 1) return 0;

        return 1;
    }
}
