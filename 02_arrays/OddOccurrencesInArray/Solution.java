import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] A) {
        return oddNumberedInteger(A);
    }

    private int oddNumberedInteger(int[] integers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int integer : integers) {
            int count = countMap.getOrDefault(integer, 0);
            countMap.put(integer, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 1) return entry.getKey();
        }

        throw new IllegalArgumentException();
    }
}
