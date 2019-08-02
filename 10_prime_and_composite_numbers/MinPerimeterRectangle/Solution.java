class Solution {
    public int solution(int N) {
        return minimumPerimeter(N);
    }

    private int minimumPerimeter(int area) {
        int minimumPerimeter = 2 * (1 + area);

        int areaSqrtFloor = (int) Math.floor(Math.sqrt(area));
        for(int i = 2; i <= areaSqrtFloor; ++i) {
            if (area % i == 0) {
                int symmetricDivisor = area / i;
                minimumPerimeter = Math.min(minimumPerimeter, 2 * (i + symmetricDivisor));
            }
        }

        return minimumPerimeter;
    }
}
