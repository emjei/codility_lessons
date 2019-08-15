class Solution {
    public int solution(int[] A) {
        return passingCarsCount(A);
    }

    private int passingCarsCount(int[] directions) {
        int currentWestCars = westCarsCount(directions);
        int countOfPassingCars = 0;
        for (int direction : directions) {
            if (direction == 0) {
                countOfPassingCars += currentWestCars;
            } else {
                currentWestCars--;
            }

            if (countOfPassingCars > 1_000_000_000) {
                return -1;
            }
        }

        return countOfPassingCars;
    }

    private int westCarsCount(int[] directions) {
        int count = 0;
        for (int direction : directions) if (direction == 1) count++;

        return count;
    }
}
