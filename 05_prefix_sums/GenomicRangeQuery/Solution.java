class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        return minimalImpactFactors(S, P, Q);
    }

    private int[] minimalImpactFactors(String sequence, int[] starts, int[] ends) {
        int[] A = new int[sequence.length() + 1];
        int[] C = new int[sequence.length() + 1];
        int[] G = new int[sequence.length() + 1];
        int[] T = new int[sequence.length() + 1];

        for (int i = 0; i < sequence.length(); i++) {
            A[i + 1] = A[i];
            C[i + 1] = C[i];
            G[i + 1] = G[i];
            T[i + 1] = T[i];

            switch (sequence.charAt(i)) {
                case 'A': A[i + 1]++; break;
                case 'C': C[i + 1]++; break;
                case 'G': G[i + 1]++; break;
                case 'T': T[i + 1]++; break;
            }
        }

        int[] minimalFactors = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            int start = starts[i];
            int end = ends[i];

            if (A[end + 1] - A[start] > 0) {
                minimalFactors[i] = 1;
            } else if (C[end + 1] - C[start] > 0) {
                minimalFactors[i] = 2;
            } else if (G[end + 1] - G[start] > 0) {
                minimalFactors[i] = 3;
            } else {
                minimalFactors[i] = 4;
            }
        }

        return minimalFactors;
    }
}
