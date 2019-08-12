class Solution {
    public int solution(int M, int[] A) {
        return distinctSlices(M, A);
    }

    private static final int MAX_COUNT = 1_000_000_000;

    private int distinctSlices(int maxValue, int[] integers) {
        int count = 0;

        int[] sliceValues = new int[maxValue + 1];
        for (int i = 0; i < sliceValues.length; i++) sliceValues[i] = -1;

        int n = integers.length;
        int front = 0, back = 0;
        while (back < n) {
            if (front < n && sliceValues[integers[front]] < back) {
                sliceValues[integers[front]] = front;
                front++;
            } else {
                int next = front == n ? n : sliceValues[integers[front]] + 1;
                count += arithmeticSeries(front - back, front - next + 1, next - back);
                back = next;
            }

            if (count >= MAX_COUNT) return MAX_COUNT;
        }

        return count;
    }

    private int arithmeticSeries(int a1, int an, int n) {
        return (int) Math.min((long) (a1 + an) * n / 2, MAX_COUNT);
    }
}
