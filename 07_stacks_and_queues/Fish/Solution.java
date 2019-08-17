import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        return aliveFishes(A, B);
    }

    private int aliveFishes(int[] sizes, int[] directions) {
        Stack<Integer> herd = new Stack<>();
        herd.add(0);

        for (int i = 1; i < sizes.length; i++) {
            if (directions[i] == 1) {
                herd.add(i);
            } else {
                addUpstreamFish(herd, sizes, directions, i);
            }
        }

        return herd.size();
    }

    private void addUpstreamFish(
            Stack<Integer> herd,
            int[] sizes,
            int[] directions,
            int newFish
    ) {
        Integer survivor = null;
        while (survivor == null) {
            if (directions[herd.peek()] == 1) {
                int nearestFish = herd.pop();

                if (sizes[newFish] > sizes[nearestFish]) {
                    survivor = herd.isEmpty() ? newFish : null;
                } else {
                    survivor = nearestFish;
                }
            } else {
                survivor = newFish;
            }
        }

        herd.add(survivor);
    }
}
