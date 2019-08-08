import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        return minimumNumberOfNails(A, B, C);
    }

    private int minimumNumberOfNails(int[] starts, int[] ends, int[] nails) {
        int beg = 1;
        int end = nails.length;
        int result = -1;

        while (beg <= end) {
            int mid = (beg + end) / 2;

            if (plankCount(starts, ends, nails, mid - 1) == starts.length) {
                end = mid - 1;
                result = mid;
            } else {
                beg = mid + 1;
            }
        }

        return result;
    }

    private int plankCount(int[] starts, int[] ends, int[] nails, int index) {
        int[] sortedNails = new int[index + 1];
        System.arraycopy(nails, 0, sortedNails, 0, index + 1);
        Arrays.sort(sortedNails);

        int plank = 0;
        while (plank < starts.length) {
            if (findNail(sortedNails, starts[plank], ends[plank]) == -1) break;
            plank++;
        };

        return plank;
    }

    private int findNail(int[] nails, int notLessThan, int notBiggerThan) {
        int beg = 1;
        int end = nails.length;
        int result = -1;

        while (beg <= end) {
            int mid = (beg + end) / 2;

            int nail = nails[mid - 1];
            if (nail >= notLessThan && nail <= notBiggerThan) {
                return mid - 1;
            } else if (nail > notBiggerThan) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }

        return result;
    }
}
